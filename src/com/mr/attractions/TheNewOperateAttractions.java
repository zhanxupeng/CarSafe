package com.mr.attractions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class TheNewOperateAttractions {
	public static void main(String[] args){
//		Attractions attractions=SelectAttractionsById(8);
//		if(attractions!=null){
//			System.out.println(attractions.getName());
//		}
		List<RouteResult> list=TheNewOperateAttractions.selectByRoute("(0,0)","(500,500)","oldman","quiet",8);
		if(list!=null){
			System.out.println(list.size());
			System.out.println(list.get(2).getMypicture());
		}else {
			System.out.println("��ǰû�м�¼");
		}
		for(RouteResult route:list){
			System.out.println(route.getRoute());
		}
	}
	public static Attractions SelectAttractionsById(int id){
		Attractions attractions=null;
		try{
		Session session=HibernateUtil.getSession();
		attractions=(Attractions)session.get(Attractions.class,id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return attractions;
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
		//��Ȧ�ڵĵ����ɸѡ���ҳ�����Ҫ��Ľ��
		List<ForAttractions> forlist=shanxuanyou(mylist, startlocal, crowds, viewpreference);
		System.out.println("����Ҫ�������Ϊ��"+forlist.size());
		//�Է���Ҫ��Ľ���������ľ����������
		forlist=sort(forlist);
		//������Ľ��������ϣ�������ϵĽ���ҳ����·�������ؽ��
		List<RouteResult> resultlist=zuhe(forlist);
		System.out.println("��ϵ������Ϊ��"+resultlist.size());
		return resultlist;
		
	}
	/*
	 * ����㷨���м�������·������
	 */
	private static List<RouteResult> zuhe(List<ForAttractions> items){
		List<RouteResult> mylist=new ArrayList<>();
		if(items.size()<=3){
			System.out.println("��ǰsizeС��3");
			String route="";
			String routeid="";
			int zhishu=0;
			double time1=0;
			double price=0;
			int mysize=items.size();
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
			RouteResult result=new RouteResult(mypicture,route,routeid,zhishu/(mysize*2),time1,price);
			mylist.add(result);
		}
		if(items.size()>3){
			/*
			 * ����һ�������·��
			 */
			for(int i=0;i<items.size();i++){
				double mytime=items.get(i).getTime();
				if(mytime>=7&&mytime<=9){
					ForAttractions attr=items.get(i);
					String s=String.format("%d",attr.getId());
				RouteResult result=new RouteResult(attr.getExterior(),attr.getName(),
								s, (attr.getForcrowds()+attr.getForviewpreference())/2,
								attr.getTime(),attr.getPrice());
				mylist.add(result);
				}
			}
			/*
			 * �������������·��
			 */
			for(int i=0;i<items.size();i++){
				int flag=1;
				for(int j=i+1;j<items.size();j++){
						double mytime=items.get(i).getTime()+items.get(j).getTime();
						/*
						 * ����������û�п���·�ϻ��ѵ�ʱ��
						 */
						/*
						 * 
						 */
						if(mytime>=7&&mytime<=9){
							String route="";
							String routeid="";
							int zhishu=0;
							double time1=0;
							double price=0;
							double theresult=selectDistance(items.get(i),items.get(j),items.get(j),items.get(j));
							//System.out.println("theresult:"+theresult);
							if(theresult<0.181){
							route=items.get(i).getName()+"-->"+items.get(j).getName();
							routeid=items.get(i).getId()+","+items.get(j).getId();
							zhishu=items.get(i).getForcrowds()+items.get(i).getForviewpreference()+
									items.get(j).getForcrowds()+items.get(j).getForviewpreference();
							time1=items.get(i).getTime()+items.get(j).getTime();
							price=items.get(i).getPrice()+items.get(j).getPrice();
							String mypicture=items.get(i).getExterior();
							RouteResult result=new RouteResult(mypicture,route, routeid, zhishu/4, time1,price);
							mylist.add(result);
							flag=0;
						}
					}
					if(flag==0)
						break;
				}
			}
			/*
			 * �������������·��
			 */
			//System.out.println("��ǰsize����3");
			for(int i=0;i<items.size();i++){
				int flag=1;
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
						if(mytime>=7&&mytime<=9){
							String route="";
							String routeid="";
							int zhishu=0;
							double time1=0;
							double price=0;
							double theresult=selectDistance(items.get(i),items.get(j),items.get(k),items.get(k));
							//System.out.println("theresult:"+theresult);
							List<ForAttractions> thelist=new ArrayList<>();
							thelist.add(items.get(i));
							thelist.add(items.get(j));
							thelist.add(items.get(k));
							List<Integer> myids=Tanxin.selectId(thelist, 0);
							//System.out.println(myids);
							List<Integer> myidss=new ArrayList<>();
							for(int p=0;p<items.size();p++){
								for(Integer s:myids){
									if(items.get(p).getId()==s){
										myidss.add(p);
									}
								}
							}
							int ii=myidss.get(0);
							int jj=myidss.get(1);
							int kk=myidss.get(2);
							//System.out.println("��������������"+myids);
							if(theresult<0.181){
							route=items.get(ii).getName()+"-->"+items.get(jj).getName()
									+"-->"+items.get(kk).getName();
							routeid=items.get(ii).getId()+","+items.get(jj).getId()
									+","+items.get(kk).getId();
							zhishu=items.get(ii).getForcrowds()+items.get(ii).getForviewpreference()+
									items.get(jj).getForcrowds()+items.get(jj).getForviewpreference()+
									items.get(kk).getForcrowds()+items.get(kk).getForviewpreference();
							time1=items.get(ii).getTime()+items.get(jj).getTime()+items.get(kk).getTime();
							price=items.get(ii).getPrice()+items.get(jj).getPrice()+
									items.get(kk).getPrice();
							String mypicture=items.get(ii).getExterior();
							RouteResult result=new RouteResult(mypicture,route, routeid, zhishu/6, time1,price);
							mylist.add(result);
							flag=0;
							}
						}
						if(flag==0)
							break;
					}
					if(flag==0)
						break;
				}
			}
			/*
			 * �����ĸ������·��
			 */
			for(int i=0;i<items.size();i++){
				int flag=0;
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
						if(mytime>=7&&mytime<=9){
							String route="";
							String routeid="";
							int zhishu=0;
							double time1=0;
							double price=0;
							String mypicture=null;
							/*
							 * �������·������һ�����Ӻ���Ĺ滮
							 */
							
							//*********************************************
//							ForAttractions[] a=new ForAttractions[4];
//							a[0]=items.get(i);
//							a[1]=items.get(j);
//							a[2]=items.get(k);
//							a[3]=items.get(l);
							double mindistance=10000;
							List<ForAttractions> lists=new ArrayList<>();
							lists.add(items.get(i));
							lists.add(items.get(j));
							lists.add(items.get(k));
							lists.add(items.get(l));
							List<Integer> myidss=Tanxin.selectId(lists, 0);
							//System.out.println(myidss);
							List<Integer> myids=new ArrayList<>();
							for(int p=0;p<items.size();p++){
								for(Integer s:myidss){
									if(items.get(p).getId()==s){
										myids.add(p);
									}
								}
							}
							mindistance=0;
							//mindistance=selectDistance(items.get(myids.get(0)),items.get(myids.get(1)),
									//items.get(myids.get(2)),items.get(myids.get(3)));
							mypicture=items.get(myids.get(0)).getExterior();
							route=items.get(myids.get(0)).getName()+"-->"+items.get(myids.get(1)).getName()+"-->"
									+items.get(myids.get(2)).getName()+"-->"+items.get(myids.get(3)).getName();
							routeid=items.get(myids.get(0)).getId()+","+items.get(myids.get(1)).getId()+","+
									items.get(myids.get(2)).getId()+","+items.get(myids.get(3)).getId();
							zhishu=items.get(myids.get(0)).getForcrowds()+items.get(myids.get(0)).getForviewpreference()+
									items.get(myids.get(1)).getForcrowds()+items.get(myids.get(1)).getForviewpreference()+
									items.get(myids.get(2)).getForcrowds()+items.get(myids.get(2)).getForviewpreference()+
									items.get(myids.get(3)).getForcrowds()+items.get(myids.get(3)).getForviewpreference();
							time1=items.get(myids.get(0)).getTime()+
									items.get(myids.get(1)).getTime()+
									items.get(myids.get(2)).getTime()+
									items.get(myids.get(3)).getTime();
							price=items.get(myids.get(0)).getPrice()+
									items.get(myids.get(1)).getPrice()+
									items.get(myids.get(2)).getPrice()+
									items.get(myids.get(3)).getPrice();
							//****************************************************
							System.out.println(mindistance);
							if(mindistance<0.181){	
							RouteResult result=new RouteResult(mypicture,route, routeid, zhishu/8, time1,price);
							mylist.add(result);
							flag=0;
							}
						}
						if(flag==0)
							break;
					}
						if(flag==0)
							break;
					}
					if(flag==0)
						break;
				}
			}
		}
		return mylist;
	}
	/*
	 * �����������㷨
	 */
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
	 * ɸѡ�������ҳ�����Ҫ��Ľ��
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
	/*
	 * ��Χ���ֺ���
	 */
	private static List<Attractions> selectCircle(List<Attractions> list,String local1,String local2){
		List<Attractions> mylist=new ArrayList<>();
		String s=local1.substring(1,local1.length()-1);
		String[] t=s.split(",");
		double x1=Double.parseDouble(t[0]);
		double y1=Double.parseDouble(t[1]);
		
		String s1=local2.substring(1,local2.length()-1);
		String[] t1=s1.split(",");
		double x2=Double.parseDouble(t1[0]);
		double y2=Double.parseDouble(t1[1]);
		
		//�е�����
		double mainx=(x1+x2)/2;
		double mainy=(y1+y2)/2;
		//����뾶
		double banjing=(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)))/2;
		for(Attractions attractions:list){
			String local3=attractions.getLocal();
			String s3=local3.substring(1,local3.length()-1);
			String[] t3=s3.split(",");
			double x3=Double.parseDouble(t3[0]);
			double y3=Double.parseDouble(t3[1]);
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
	/*
	 * ���ڷ���������֮��ľ���
	 */
	public static double selectdistance(String local1,String local2){
		String s=local1.substring(1,local1.length()-1);
		String[] t=s.split(",");
		double x1=Double.parseDouble(t[0]);
		double y1=Double.parseDouble(t[1]);
		
		String s1=local2.substring(1,local2.length()-1);
		String[] t1=s1.split(",");
		double x2=Double.parseDouble(t1[0]);
		double y2=Double.parseDouble(t1[1]);
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	/*
	 * ���ض����֮��ľ���
	 */
	public static double selectDistance(ForAttractions att1,ForAttractions att2,
			ForAttractions att3,ForAttractions att4){
		double num=0;
		String local1=att1.getLocal();
		String local2=att2.getLocal();
		String local3=att3.getLocal();
		String local4=att4.getLocal();
		num=jisuan(local1,local2,local3,local4);
		return num;
	}
	/*
	 * ���㺯������ǰ�溯������
	 */
	public static double jisuan(String local1,String local2,String local3,String local4){
		double num1=jisuandouble(local1,local2);
		double num2=jisuandouble(local2,local3);
		double num3=jisuandouble(local3,local4);
		return num1+num2+num3;
	}
	/*
	 * ����������֮��ľ��룬��ǰ��ĺ�������
	 */
	public static double jisuandouble(String local1,String local2){
		String s=local1.substring(1,local1.length()-1);
		String[] t=s.split(",");
		double x1=Double.parseDouble(t[0]);
		double y1=Double.parseDouble(t[1]);
		
		String s2=local2.substring(1,local2.length()-1);
		String[] t2=s2.split(",");
		double x2=Double.parseDouble(t2[0]);
		double y2=Double.parseDouble(t2[1]);
		double num=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return num;
	}
}
