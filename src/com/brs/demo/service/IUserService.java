package com.brs.demo.service;

import java.util.List;

import com.brs.demo.model.UserInfo;

public interface IUserService {
	
	public int getTotal();
	
	public void addUser(UserInfo userInfo);
	
	public void delUserById(int id);
	
	public void updateUser(UserInfo userInfo);
	
	public UserInfo getUserById(int id);
	
	public List<UserInfo> pageSearch(String name, int start, int count);
	
	public List<UserInfo> getUserByName(String name);
	
	public List<UserInfo> getAllUser();
	
	public List<UserInfo> pageList(int start, int count);

}
