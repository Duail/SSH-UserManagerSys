package com.brs.demo.service;

import com.brs.demo.dao.ManagerDao;

public class ManagerService implements IManagerService {
	
	private ManagerDao ManagerDao;
	
	public void setManagerDao(ManagerDao managerDao) {
		ManagerDao = managerDao;
	}

	@Override
	public boolean isPass(String manager, String password) {
		return ManagerDao.isPass(manager, password);
	}
	
	

}
