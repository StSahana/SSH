package edu.sdu.video.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import edu.sdu.video.bean.User;

@Service
public class UserService {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<User> getUser(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();  
		String hql="FROM student";
		Query query = session.createQuery(hql);
		List<User> list=query.list();
		System.out.println(JSON.toJSONString(list));
//		session.getTransaction().commit();
//		session.close();
		return list;
	}
}
