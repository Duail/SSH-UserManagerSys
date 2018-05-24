package com.brs.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.brs.demo.model.UserInfo;

public class UserDao {
	
	private SessionFactory sessionFactory;
	//property need setter
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public int getTotal() {
		return getAllUser().size();
	}
	
	public void addUser(UserInfo userInfo) {
		getSession().save(userInfo);
	}
	
	public void delUserById(int id) {
		String hql = "delete UserInfo where id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		query.executeUpdate();
	}
	
	public void updateUser(UserInfo userInfo) {
		//TODO ??
//		getSession().update(userInfo);
		String hql = "update UserInfo set name=?,email=?,telephone=? where id=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, userInfo.getName());
		query.setString(1, userInfo.getEmail());
		query.setString(2, userInfo.getTelephone());
		query.setInteger(3, userInfo.getId());
		query.executeUpdate();
		
	}
	
	public UserInfo getUserById(int id) {
		String hql = "from UserInfo where id = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, id);
		return (UserInfo) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> pageSearch(String name, int start, int count) {
		String sql = "select * from userinfo where name=? limit ?,?";
		Query query = getSession().createSQLQuery(sql).addEntity(UserInfo.class);
		query.setParameter(0, name);
		query.setInteger(1, start);
		query.setInteger(2, count);
		List<UserInfo> userInfos = query.list();
		return userInfos;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getUserByName(String name) {
		String hql = "from UserInfo where name = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, name);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getAllUser() {
		return getSession().createCriteria(UserInfo.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> pageList(int start, int count) {
		Criteria criteria = getSession().createCriteria(UserInfo.class);
		criteria.setFirstResult(start);
		criteria.setMaxResults(count);
		return criteria.list();
	}

}
