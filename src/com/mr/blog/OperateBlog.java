package com.mr.blog;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class OperateBlog {
	//��ѯ
	public List<Blog> selectBlog(){
		List<Blog> emplist=null;
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Blog blog";
			Query q=session.createQuery(hql);
			emplist=q.list();
			if(emplist!=null){
			System.out.println(emplist.size());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return emplist;
	}
	//����
	public void insertBlog(Blog blog){
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			session.beginTransaction();
			session.save(blog);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			System.out.println("�������ʧ��");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperateBlog blogs=new OperateBlog();
		//blogs.selectBlog();
		Blog blog=new Blog(2017,"ղ��˧","��������������");
		blogs.insertBlog(blog);
	}

}
