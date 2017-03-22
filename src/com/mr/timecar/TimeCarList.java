package com.mr.timecar;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class TimeCarList {
	public List<Timecar> selectcar(int car_id){
		List<Timecar> listtime=new ArrayList<Timecar>();
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Timecar times where times.car_id=?";
			Query q=session.createQuery(hql);
			q.setParameter(0,car_id);
			listtime=q.list();
			System.out.println(listtime.size());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return listtime;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Timecar> listtime=new ArrayList<Timecar>();
		TimeCarList a=new TimeCarList();
		listtime=a.selectcar(2017);
		for(Timecar time:listtime){
			System.out.println(time.getCar_id()+","+time.getSpeed()+","+time.getTime());
		}
	}

}
