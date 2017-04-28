package com.mr.thehotel;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class OperateThehotel {
	public static List<Thehotel> selectByLocal(String local){
		List<Thehotel> results=new ArrayList<>();
		Session session=null;
		session=HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Thehotel> list=session.createCriteria(Thehotel.class).list();
		for(Thehotel hotel:list){
			String s=local.substring(1,local.length()-1);
			String[] a=s.split(",");
			String[] b=hotel.getLocal().split(",");
			double result=countroute(Double.parseDouble(a[0]), Double.parseDouble(a[1]),
					Double.parseDouble(b[0]),Double.parseDouble(b[1]));
			if(result<0.1)
			{
				results.add(hotel);
			}
		}
		System.out.println(results.size());
		return results;
	}
	public static double countroute(double x1,double y1,double x2,double y2){
		double result=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return result;
	}
	public static void main(String[] args){
		//(119.779647,30.24369)
		selectByLocal("(120.158307,30.230458)");
	}
}
