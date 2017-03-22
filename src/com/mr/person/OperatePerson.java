package com.mr.person;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class OperatePerson {
	public boolean insertperson(int car_id, String usename,String password){
		boolean result=false;
		List<Person> persons=new ArrayList<Person>();
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Person person where car_id=?";
			Query q=session.createQuery(hql);
			q.setParameter(0, car_id);
			persons=q.list();
			if(persons.size()==1){
				result=false;
			}else{
				result=true;
			}
			System.out.println(persons.size());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		if(result){
			session=null;
			Person person=new Person();
			person.setCar_id(car_id);
			person.setUsename(usename);
			person.setPassword(password);
			try{
				session=HibernateUtil.getSession();
				session.beginTransaction();
				session.save(person);
				session.getTransaction().commit();
			}catch(Exception e){
				session.getTransaction().rollback();
				System.out.println("数据添加失败！");
				e.printStackTrace();
			}finally{
				HibernateUtil.closeSession();
			}
		}
		return result;
	}
	public String uselogin(int car_id,String password){
		String usename=null;
		List<Person> persons=new ArrayList<Person>();
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Person person where person.car_id=? and password=?";
			Query q=session.createQuery(hql);
			q.setParameter(0, car_id);
			q.setParameter(1, password);
			persons=q.list();
			if(persons.size()>0){
				usename=persons.get(0).getUsename();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return usename;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result=false;
		OperatePerson person=new OperatePerson();
		result=person.insertperson(2018,"占旭鹏","654321");
		if(result){
			System.out.println("数据添加成功！");
		}else{
			System.out.println("用户名已存在，请选择登录或者重新注册！");
		}
		String usename=person.uselogin(2010,"123456");
		System.out.println(usename);
	}

}
