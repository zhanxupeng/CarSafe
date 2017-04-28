package com.mr.featuresfood;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class OperateFeaturesfood {
	public static List<Featuresfood> selectFood(double longitude,double latitude){
		List<Featuresfood> result=new ArrayList<>();
		Session session=null;
		session=HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Featuresfood> list=session.createCriteria(Featuresfood.class).list();
		for(Featuresfood food:list){
			if(countroute(longitude, latitude, food.getLongitude(), food.getLatitude())<0.1){
				result.add(food);
			}
		}
		System.out.println(result.size());
		return result;
	}
	public static double countroute(double x1,double y1,double x2,double y2){
		double result=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return result;
	}
	public static void main(String[] args){
		selectFood(120.130417,30.248336);
	}
}
