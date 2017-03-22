package com.mr.cardata;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class SelectCarData {

	public static Cardata selectByRoute(String route){
		Cardata data=null;
		List<Cardata> list=null;
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Cardata cast where cast.route=?";
			Query q=session.createQuery(hql);
			q.setParameter(0, route);
			list=q.list();
			if(list.size()>0){
				data=list.get(0);
				System.out.println(data.getSpeed());
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return data;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectByRoute("qianwang");
	}

}
