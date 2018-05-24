package com.brs.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.brs.demo.model.UserInfo;
import com.brs.demo.service.UserService;
import com.brs.demo.util.PageInfo;

@Controller
public class MainController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "xxrr", method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView("test");
		modelAndView.addObject("message", "hellomessage");
		return modelAndView;
	}
	
//	@RequestMapping(value = "toList")
//	public ModelAndView toList(HttpServletRequest request) {
//		ModelAndView modelAndView = new ModelAndView("list");
//		
//		return modelAndView;
//	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("list");
		int page = 1, count = 5;
		//从index进入无page
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		
		}
		int total = 0;
		int next = page + 1;
		int pre = page - 1;
		pre = pre < 1 ? 1 : pre;
		total = userService.getTotal();
		int last = total % count == 0 ? total / count : total / count + 1;
		next = next > last ? last : next;
		List<UserInfo> userInfos = userService.pageList((page-1)*count, count);
		PageInfo pageInfo = new PageInfo(total, page, next, pre, last);
		modelAndView.addObject("userInfos", userInfos);
		modelAndView.addObject("pageInfo", pageInfo);
		return modelAndView;
//		model.addFlashAttribute("userInfos", userInfos);
//		model.addFlashAttribute("pageInfo", pageInfo);
//		return "redirect:toList";
	}
	
	@RequestMapping(value = "search")
	public ModelAndView search(HttpServletRequest request) {
		String name = request.getParameter("searchByName");
		if (name == "") {
			return new ModelAndView("redirect:list");
		}
		ModelAndView modelAndView = new ModelAndView("search");
		int page = 1, count = 5;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
		
		}
		int total = 0;
		int next = page + 1;
		int pre = page - 1;
		pre = pre < 1 ? 1 : pre;
		total = userService.getUserByName(name).size();
		int last = total % count == 0 ? total / count : total / count + 1;
		next = next > last ? last : next;
		List<UserInfo> userInfos = userService.pageSearch(name, (page-1)*count, count);
		PageInfo pageInfo = new PageInfo(total, page, next, pre, last);
		modelAndView.addObject("searchByName", name);
		modelAndView.addObject("userInfos", userInfos);
		modelAndView.addObject("pageInfo", pageInfo);
		return modelAndView;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("add");
		return modelAndView;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(UserInfo userInfo) {
		userService.addUser(userInfo);
		return new ModelAndView("redirect:success");
	}
	
	@RequestMapping(value = "success")
	public ModelAndView success() {
		return new ModelAndView("success");
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		userService.delUserById(id);
		return new ModelAndView("redirect:success");
	}
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public ModelAndView view(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("view");
		int id = Integer.parseInt(request.getParameter("id"));
		UserInfo userInfo = userService.getUserById(id);
		modelAndView.addObject("userInfo", userInfo);
		return modelAndView;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(UserInfo userInfo) {
		userService.updateUser(userInfo);
		return new ModelAndView("redirect:success");
	}
	
	@RequestMapping(value = "login")
	public ModelAndView loginPage() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

}
