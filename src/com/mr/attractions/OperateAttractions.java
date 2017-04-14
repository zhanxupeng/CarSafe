package com.mr.attractions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class OperateAttractions {
	public static void main(String args[]){
		List<RouteResult> list=OperateAttractions.selectByRoute("(0,0)","(500,500)","oldman","quiet",8);
		if(list!=null){
			System.out.println(list.size());
			System.out.println(list.get(2).getMypicture());
		}else {
			System.out.println("��ǰû�м�¼");
		}
	}
	/*
	 * �ϴ�qidian(x,y),�յ�(x,y),crowds=oldman,viewpreference=quiet,time=8h
	 */
	public static List<RouteResult> selectByRoute(String startlocal,String endlocal,
			String crowds,String viewpreference,double time){
		Session session=HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Attractions> list=session.createCriteria(Attractions.class).list();
		System.out.println("һ���е�����Ϊ��"+list.size());
		HibernateUtil.closeSession();
		//���ҳ������Ȧ֮�ڵ����е�
		List<Attractions> mylist=selectCircle(list, startlocal, endlocal);
		System.out.println("��Ȧ�������Ϊ��"+mylist.size());
		//��Ȧ�ڵĵ����ɸѡ���ҳ�����Ҫ���
		List<ForAttractions> forlist=shanxuanyou(mylist, startlocal, crowds, viewpreference);
		System.out.println("����Ҫ�������Ϊ��"+forlist.size());
		//���ŵĽ��а������ľ����������
		forlist=sort(forlist);
		//������Ľ��������ϣ���Ͻ�����ڷ���
		List<RouteResult> resultlist=zuhe(forlist, time);
		System.out.println("��ϵ������Ϊ��"+resultlist.size());
		return resultlist;
		
	}
	private static List<RouteResult> zuhe(List<ForAttractions> items,double time){
		List<RouteResult> mylist=new ArrayList<>();
		if(items.size()<=3){
			System.out.println("��ǰsizeС��3");
			String route="";
			String routeid="";
			int zhishu=0;
			double time1=0;
			double price=0;
			for(ForAttractions myroute:items){
				if("".equals(route)){
					route=myroute.getName();
					routeid=routeid+myroute.getId();
				}else{
				route="-->"+route+myroute.getName();
				routeid=","+routeid+myroute.getId();
				}
				price=price+myroute.getPrice();
				zhishu=zhishu+myroute.getForcrowds()+myroute.getForviewpreference();
				time1=time1+myroute.getTime();
			}
			String mypicture=items.get(0).getExterior();
			RouteResult result=new RouteResult(mypicture,route,routeid,zhishu,time1,price);
			mylist.add(result);
		}
		if(items.size()>3){
			/*
			 * �������������·��
			 */
			System.out.println("��ǰsize����3");
			for(int i=0;i<items.size();i++){
				for(int j=i+1;j<items.size();j++){
					for(int k=j+1;k<items.size();k++){
						double mytime=items.get(i).getTime()+items.get(j).getTime()+
								items.get(k).getTime();
						/*
						 * ����������û�п���·�ϻ��ѵ�ʱ��
						 */
						/*
						 * 
						 */
						if(mytime<time*1.2){
							String route="";
							String routeid="";
							int zhishu=0;
							double time1=0;
							double price=0;
							route=items.get(i).getName()+"-->"+items.get(j).getName()
									+"-->"+items.get(k).getName();
							routeid=items.get(i).getId()+","+items.get(j).getId()
									+","+items.get(k).getId();
							zhishu=items.get(i).getForcrowds()+items.get(i).getForviewpreference()+
									items.get(j).getForcrowds()+items.get(j).getForviewpreference()+
									items.get(k).getForcrowds()+items.get(k).getForviewpreference();
							time1=items.get(i).getTime()+items.get(j).getTime()+items.get(k).getTime();
							price=items.get(i).getPrice()+items.get(j).getPrice()+
									items.get(k).getPrice();
							String mypicture=items.get(i).getExterior();
							RouteResult result=new RouteResult(mypicture,route, routeid, zhishu, time1,price);
							mylist.add(result);
						}
					}
				}
			}
			/*
			 * �����ĸ������·��
			 */
			for(int i=0;i<items.size();i++){
				for(int j=i+1;j<items.size();j++){
					for(int k=j+1;k<items.size();k++){
						for(int l=k+1;l<items.size();l++){
						double mytime=items.get(i).getTime()+items.get(j).getTime()+
								items.get(k).getTime()+items.get(l).getTime();
						/*
						 * ����������û�п���·�ϻ��ѵ�ʱ��
						 */
						/*
						 * 
						 */
						if(mytime<time*1.2){
							String route="";
							String routeid="";
							int zhishu=0;
							double time1=0;
							double price=0;
							route=items.get(i).getName()+"-->"+items.get(j).getName()
									+","+items.get(k).getName()+items.get(l).getName();
							routeid=items.get(i).getId()+","+items.get(j).getId()
									+","+items.get(k).getId()+items.get(l).getName();
							zhishu=items.get(i).getForcrowds()+items.get(i).getForviewpreference()+
									items.get(j).getForcrowds()+items.get(j).getForviewpreference()+
									items.get(k).getForcrowds()+items.get(k).getForviewpreference()+
									items.get(l).getForcrowds()+items.get(l).getForviewpreference();
							time1=items.get(i).getTime()+items.get(j).getTime()+items.get(k).getTime()
									+items.get(l).getTime();
							price=items.get(i).getPrice()+items.get(j).getPrice()+
									items.get(k).getPrice()+items.get(l).getPrice();
							String mypicture=items.get(i).getExterior();
							RouteResult result=new RouteResult(mypicture,route, routeid, zhishu, time1,price);
							mylist.add(result);
						}
					}
					}
				}
			}
		}
		return mylist;
	}
	private static List<ForAttractions> sort(List<ForAttractions> items){
	        if(items.size()>1){
	            List<ForAttractions> smaller=new ArrayList<>();
	            List<ForAttractions> same=new ArrayList<>();
	            List<ForAttractions> larger=new ArrayList<>();
	            ForAttractions chosenItem=items.get(items.size()/2);
	            for(ForAttractions i:items){
	                if(i.getDistance()<chosenItem.getDistance())
	                    smaller.add(i);
	                else if(i.getDistance()>chosenItem.getDistance())
	                    larger.add(i);
	                else
	                    same.add(i);
	            }
	            sort(smaller);
	            sort(larger);
	            items.clear();
	            if(smaller.size()>0){
	            items.addAll(smaller);
	            }
	            if(same.size()>0){
	            items.addAll(same);
	            }
	            if(larger.size()>0){
	            items.addAll(larger);
	            }
	        }
	        return items;
	    }
	/*
	 * ɸѡ����
	 */
	private static List<ForAttractions> shanxuanyou(List<Attractions> list,String local,String crowds,String viewpreference)
	{
		List<ForAttractions> forlist=new ArrayList<>();
		for(Attractions attraction:list){
			int mycrowds=attraction.getCrowds().selectCrowds(crowds);
			int myviewpreference=attraction.getViewPreference().selectView(viewpreference);
			if(mycrowds>2&&myviewpreference>2){
					double mydistance=selectdistance(local,attraction.getLocal());
					ForAttractions forattractions=new ForAttractions(attraction, mycrowds,
							myviewpreference, 5, mydistance);
					forlist.add(forattractions);
			}
		}
		return forlist;
	}
	private static List<Attractions> selectCircle(List<Attractions> list,String local1,String local2){
		List<Attractions> mylist=new ArrayList<>();
		String s=local1.substring(1,local1.length()-1);
		String[] t=s.split(",");
		double x1=Integer.parseInt(t[0]);
		double y1=Integer.parseInt(t[1]);
		
		String s1=local2.substring(1,local2.length()-1);
		String[] t1=s1.split(",");
		double x2=Integer.parseInt(t1[0]);
		double y2=Integer.parseInt(t1[1]);
		
		//�е�����
		double mainx=(x1+x2)/2;
		double mainy=(y1+y2)/2;
		//����뾶
		double banjing=(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)))/2;
		for(Attractions attractions:list){
			String local3=attractions.getLocal();
			String s3=local3.substring(1,local3.length()-1);
			String[] t3=s3.split(",");
			double x3=Integer.parseInt(t3[0]);
			double y3=Integer.parseInt(t3[1]);
			//��������ĵ�ľ���
			double juli=Math.sqrt((x3-mainx)*(x3-mainx)+(y3-mainy)*(y3-mainy));
			if(juli<banjing){
				mylist.add(attractions);
			}
		}
		return mylist;
	}
	/*
	 * ��������������Forattractions
	 * ("oldman","quiet","(300,400)","sunny");
	 */
	public static List<ForAttractions> selectAttractions(String crowds,String viewpreference,String local
			,String weather){
		List<ForAttractions> forlist=new ArrayList<>();
		Session session=HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Attractions> list=session.createCriteria(Attractions.class).list();
		System.out.println(list.size());
		HibernateUtil.closeSession();
		for(Attractions attraction:list){
			int mycrowds=attraction.getCrowds().selectCrowds(crowds);
			int myviewpreference=attraction.getViewPreference().selectView(viewpreference);
			int myweatherindex=attraction.getWeatherIndex().selectWeather(weather);
			if(mycrowds>2&&myviewpreference>2&&myweatherindex>2){
					double mydistance=selectdistance(local,attraction.getLocal());
					ForAttractions forattractions=new ForAttractions(attraction, mycrowds,
							myviewpreference, myweatherindex, mydistance);
					forlist.add(forattractions);
			}
		}
		return forlist;
	}
	public static double selectdistance(String local1,String local2){
		String s=local1.substring(1,local1.length()-1);
		String[] t=s.split(",");
		double x1=Integer.parseInt(t[0]);
		double y1=Integer.parseInt(t[1]);
		
		String s1=local2.substring(1,local2.length()-1);
		String[] t1=s1.split(",");
		double x2=Integer.parseInt(t1[0]);
		double y2=Integer.parseInt(t1[1]);
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
}
