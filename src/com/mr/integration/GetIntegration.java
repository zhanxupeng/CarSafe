package com.mr.integration;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class GetIntegration {
	public Integration getIntegration(int id){
		Integration integration=null;
		List<Integration> emplist=null;
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Integration inte where inte.car_id=?";
			Query q=session.createQuery(hql);
			q.setParameter(0, id);
			emplist=q.list();
			System.out.println(emplist.size());
			if(emplist!=null){
			integration=emplist.get(0);
			}
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return integration;
	}
	public boolean InsertCoin(int car_id,int coin,int mydate){
		boolean result=false;	
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			session.getTransaction().begin();
			String hql="update Integration inte set coin="+coin+", mydate="+mydate+
					" where car_id="+car_id;
			Query query=session.createQuery(hql);
			int ret=query.executeUpdate();
			System.out.println(ret);
			if(ret>0){
				result=true;
			}
			session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		return result;
	}
	public boolean InsertQianCoin(int car_id,int coin,int member){
		boolean result=false;	
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			session.getTransaction().begin();
			String hqls="update Integration intes set intes.coin="+coin+", intes.member="+member+
					" where intes.car_id="+car_id;
			Query querys=session.createQuery(hqls);
			int ret=querys.executeUpdate();
			System.out.println(ret);
			if(ret>0){
				result=true;
			}
			session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integration integration=null;
		GetIntegration get=new GetIntegration();
		//integration=get.getIntegration(2017);
		boolean result=get.InsertQianCoin(2017,200, 305);
		System.out.println(result);
	}

}
