package com.mr.nowcar;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class Nowupload {
	public boolean upload(int car_id,double xx,double yy,double speed,int flag,double direction){
		boolean result=false;
		List<Nowcar> nowcars=new ArrayList<Nowcar>();
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Nowcar nowcar where nowcar.car_id=?";
			Query q=session.createQuery(hql);
			q.setParameter(0,car_id);
			nowcars=q.list();
			if(nowcars.size()==1){
				result=true;
			}
			System.out.println(nowcars.size());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		//说明该车次已经存在了，需要的是修改数据
		session=null;
		if(result==true){
			result=false;
			try{
				session=HibernateUtil.getSession();
				session.beginTransaction();
				//String hql="update Ticket ticket set ticket_num=ticket_num-"+d+" 
				//where car_id="+a+" and origin_num>="+b+" and origin_num<="+c;
//				String hql="update Moneys moneys set money=money-"+prices+
//						" where money_name='"+money_name+"' and money_pass='"
//						+money_pass+"'";
				String hql="update Nowcar nowcar set xx="+xx
						+",yy="+yy+",speed="+speed+
						",flag="+flag+",direction="+direction+
						" where car_id="+car_id;
				Query queryupdate=session.createQuery(hql);
				int ret=queryupdate.executeUpdate();
				System.out.println(ret);
				session.getTransaction().commit();
				if(ret>0){
					result=true;
				}
			}catch(Exception e){
				session.getTransaction().rollback();
				e.printStackTrace();
			}finally{
				HibernateUtil.closeSession();
			}
			
			
			
		}else if(result==false){//该车次不存在，需要重新添加
			Nowcar cars=new Nowcar();
			cars.setCar_id(car_id);
			cars.setXx(xx);
			cars.setYy(yy);
			cars.setSpeed(speed);
			cars.setFlag(flag);
			cars.setDirection(direction);
			try{
			session=HibernateUtil.getSession();
			session.beginTransaction();
			session.save(cars);
			session.getTransaction().commit();
			result=true;
			}catch(Exception e){
				session.getTransaction().rollback();
				System.out.println("数据添加失败!");
				e.printStackTrace();
			}finally{
				HibernateUtil.closeSession();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nowupload a=new Nowupload();
		a.upload(2017, 500, 500, 5, 0, 2);
	}

}
