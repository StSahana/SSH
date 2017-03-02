package edu.sdu.video;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import edu.sdu.video.bean.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:spring.xml")
public class UserTest {
	@Autowired
	SessionFactory SessionFactory;

	@Test
	@Transactional
	public void testSave(){
		Session session = SessionFactory.getCurrentSession();
		session.beginTransaction();  
		User user=new User();
		user.setId("2");
		user.setName("ll");
		user.setAge(12);
		session.save(user);
		session.getTransaction().commit();
	}
	
	@Test
	@Transactional
	public void testSearch(){
		Session session = SessionFactory.getCurrentSession();
		session.beginTransaction();  
		String hql="FROM student";
		Query query = session.createQuery(hql);
		List<User> list=query.list();
		System.out.println(JSON.toJSONString(list));
		session.getTransaction().commit();
	}
}
