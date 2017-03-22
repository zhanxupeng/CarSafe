package com.mr.weather;

import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class ReadWeather {
	public static Weather read(int id){
		Weather weather=new Weather();
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			weather=(Weather)session.get(Weather.class,new Integer("1"));
			System.out.println(weather.getName());
		}catch(Exception e){
			System.out.println("对象装载失败~");
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		
		return weather;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Weather weather=read(1);
			System.out.println("main函数："+weather.getRank());
	}

}
