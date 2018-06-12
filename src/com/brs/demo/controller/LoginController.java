package com.brs.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brs.demo.service.ManagerService;

@Controller
public class LoginController {
	
	@Resource
	private ManagerService managerService;
	
	@RequestMapping(value = "managerLogin", method = RequestMethod.POST)
	public String login(HttpSession session, String manager, String password) throws Exception {
		session.setAttribute("manager", manager);
		return "redirect:list";
	}
	
	@RequestMapping(value = "managerLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping(value = "checkManager")
	@ResponseBody
	public Map<String,Object> checkManager(String manager, String password, HttpServletResponse response) throws Exception {
		System.out.println(manager);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", managerService.isPass(manager, password)?"true":"false");
		return map;
//		PrintWriter printWriter = response.getWriter();
//		printWriter.print(managerService.isPass(manager, password)?"true":"false");
//		printWriter.flush();
	}

}
