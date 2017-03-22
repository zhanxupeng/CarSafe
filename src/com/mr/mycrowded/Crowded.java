package com.mr.mycrowded;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class Crowded {
	@SuppressWarnings("unchecked")
	public List<Mycrowded> check(int myflag){
		//输入myflag，找出所有myflag=myflag的数据返回
		List<Mycrowded> emplist=new ArrayList<Mycrowded>();
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Mycrowded crowded where crowded.myflag=?";
			Query q=session.createQuery(hql);
			q.setParameter(0, myflag);
			emplist=q.list();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return emplist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Crowded crowded=new Crowded();
		List<Mycrowded> emplist=crowded.check(1);
		for(Mycrowded s:emplist){
			System.out.println(s.getMyflag()+","+s.getNextflag()+","+s.getSpeed());
		}
	}

}
