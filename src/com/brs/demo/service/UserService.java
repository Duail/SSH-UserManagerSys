package com.brs.demo.service;

import java.util.List;

import com.brs.demo.dao.UserDao;
import com.brs.demo.model.UserInfo;

public class UserService implements IUserService {
	
	private UserDao userDao;
	//property need setter
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public int getTotal() {
		return userDao.getTotal();
	}
	
	@Override
	public void addUser(UserInfo userInfo) {
		userDao.addUser(userInfo);
	}

	@Override
	public void delUserById(int id) {
		userDao.delUserById(id);
	}

	@Override
	public void updateUser(UserInfo userInfo) {
		userDao.updateUser(userInfo);
	}
	
	@Override
	public UserInfo getUserById(int id){
		return userDao.getUserById(id);
	}
	
	@Override
	public List<UserInfo> pageSearch(String name, int start, int count){
		return userDao.pageSearch(name, start, count);
	}
	
	@Override
	public List<UserInfo> getUserByName(String name){
		return userDao.getUserByName(name);
	}
	
	@Override
	public List<UserInfo> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public List<UserInfo> pageList(int start, int count) {
		return userDao.pageList(start, count);
	}

}
