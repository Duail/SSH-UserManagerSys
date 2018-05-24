package com.brs.demo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.brs.demo.model.ManagerInfo;

public class ManagerDao {
	
	private SessionFactory sessionFactory;
	//property need setter
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public boolean isPass(String manager, String password) {
		String hql = "from ManagerInfo where manager = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, manager);
		ManagerInfo managerInfo = (ManagerInfo) query.uniqueResult();
		if (managerInfo != null){
			if (password.equals(managerInfo.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
