package com.mr.forecast;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class SelectForecast {
	public Forecast timeselect(String route,int time){
		Forecast forecast=null;
		List<Forecast> list=null;
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Forecast cast where cast.route=? and time=?";
			Query q=session.createQuery(hql);
			q.setParameter(0, route);
			q.setParameter(1,time);
			list=q.list();
			if(list.size()>0){
				forecast=list.get(0);
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return forecast;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectForecast cast=new SelectForecast();
		Forecast ca=null;
		ca=cast.timeselect("qianwang",9);
		System.out.println(ca.getRoute()+","+ca.getTime()+","+ca.getHrank());
	}

}
