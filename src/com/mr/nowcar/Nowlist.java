package com.mr.nowcar;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class Nowlist {
	public List<Nowcar> listnow(){
		List<Nowcar> nowcars=new ArrayList<Nowcar>();
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Nowcar nowcar";
			Query q=session.createQuery(hql);
			nowcars=q.list();
			System.out.println(nowcars.size());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return nowcars;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nowlist nowcars=new Nowlist();
		nowcars.listnow();
	}

}
