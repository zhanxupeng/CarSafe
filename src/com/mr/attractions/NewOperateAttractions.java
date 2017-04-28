package com.mr.attractions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class NewOperateAttractions {
	public static void main(String[] args){
//		Attractions attractions=SelectAttractionsById(8);
//		if(attractions!=null){
//			System.out.println(attractions.getName());
//		}
		List<RouteResult> list=NewOperateAttractions.selectByRoute("(0,0)","(500,500)","oldman","quiet",8);
		if(list!=null){
			System.out.println(list.size());
			System.out.println(list.get(2).getMypicture());
		}else {
			System.out.println("当前没有记录");
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
	 * 上传qidian(x,y),终点(x,y),crowds=oldman,viewpreference=quiet,time=8h
	 */
	public static List<RouteResult> selectByRoute(String startlocal,String endlocal,
			String crowds,String viewpreference,double time){
		Session session=HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Attractions> list=session.createCriteria(Attractions.class).list();
		System.out.println("一共有的数据为："+list.size());
		HibernateUtil.closeSession();
		//先找出在这个圈之内的所有点
		List<Attractions> mylist=selectCircle(list, startlocal, endlocal);
		System.out.println("在圈里的数据为："+mylist.size());
		//对圈内的点进行筛选，找出符合要求的结果
		List<ForAttractions> forlist=shanxuanyou(mylist, startlocal, crowds, viewpreference);
		System.out.println("符合要求的数据为："+forlist.size());
		//对符合要求的结果按与起点的距离进行排序
		forlist=sort(forlist);
		//对排序的结果进行组合，并对组合的结果找出最短路径，返回结果
		List<RouteResult> resultlist=zuhe(forlist);
		System.out.println("组合的总情况为："+resultlist.size());
		return resultlist;
		
	}
	/*
	 * 组合算法，中间包含最短路线推优
	 */
	private static List<RouteResult> zuhe(List<ForAttractions> items){
		List<RouteResult> mylist=new ArrayList<>();
		if(items.size()<=3){
			System.out.println("当前size小于3");
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
			 * 给出一个景点的路线
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
			 * 给出两个景点的路线
			 */
			for(int i=0;i<items.size();i++){
				int flag=1;
				for(int j=i+1;j<items.size();j++){
						double mytime=items.get(i).getTime()+items.get(j).getTime();
						/*
						 * 这里暂且先没有考虑路上花费的时间
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
			 * 给出三个景点的路线
			 */
			//System.out.println("当前size大于3");
			for(int i=0;i<items.size();i++){
				int flag=1;
				for(int j=i+1;j<items.size();j++){
					for(int k=j+1;k<items.size();k++){
						double mytime=items.get(i).getTime()+items.get(j).getTime()+
								items.get(k).getTime();
						/*
						 * 这里暂且先没有考虑路上花费的时间
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
							if(theresult<0.181){
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
			 * 给出四个景点的路线
			 */
			for(int i=0;i<items.size();i++){
				int flag=0;
				for(int j=i+1;j<items.size();j++){
					for(int k=j+1;k<items.size();k++){
						for(int l=k+1;l<items.size();l++){
						double mytime=items.get(i).getTime()+items.get(j).getTime()+
								items.get(k).getTime()+items.get(l).getTime();
						/*
						 * 这里暂且先没有考虑路上花费的时间
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
							 * 把这里的路线再做一个更加合理的规划
							 */
							//*********************************************
							ForAttractions[] a=new ForAttractions[4];
							a[0]=items.get(i);
							a[1]=items.get(j);
							a[2]=items.get(k);
							a[3]=items.get(l);
							double mindistance=10000;
								for(int ii=0;ii<4;ii++){
									for(int jj=0;jj<4;jj++){
										if(ii==jj)
											jj++;
										if(jj==4)
											break;
										for(int kk=0;kk<4;kk++){
											while(kk==ii||kk==jj){
												kk++;
											}
											if(kk==4)
												break;
											for(int mm=0;mm<4;mm++){
												while(mm==kk||mm==ii|mm==jj){
													mm++;
												}
												if(mm==4)
													break;
												double result=selectDistance(a[ii],a[jj],a[kk],a[mm]);
												//System.out.println("result-4:"+result);
												if(result<mindistance){
													mindistance=result;
													route=items.get(i).getName()+"-->"+items.get(j).getName()
															+"-->"+items.get(k).getName()+"-->"+items.get(l).getName();
													routeid=items.get(i).getId()+","+items.get(j).getId()
															+","+items.get(k).getId()+","+items.get(l).getId();
													zhishu=items.get(i).getForcrowds()+items.get(i).getForviewpreference()+
															items.get(j).getForcrowds()+items.get(j).getForviewpreference()+
															items.get(k).getForcrowds()+items.get(k).getForviewpreference()+
															items.get(l).getForcrowds()+items.get(l).getForviewpreference();
													time1=items.get(i).getTime()+items.get(j).getTime()+items.get(k).getTime()
															+items.get(l).getTime();
													price=items.get(i).getPrice()+items.get(j).getPrice()+
															items.get(k).getPrice()+items.get(l).getPrice();
													mypicture=items.get(i).getExterior();
												}
												//System.out.println(ii+","+jj+","+kk+","+mm);
											}
										}
									}
							}
							
							//****************************************************
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
	 * 按距离排序算法
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
	 * 筛选函数，找出符合要求的结果
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
	 * 范围划分函数
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
		
		//中点坐标
		double mainx=(x1+x2)/2;
		double mainy=(y1+y2)/2;
		//求出半径
		double banjing=(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)))/2;
		for(Attractions attractions:list){
			String local3=attractions.getLocal();
			String s3=local3.substring(1,local3.length()-1);
			String[] t3=s3.split(",");
			double x3=Double.parseDouble(t3[0]);
			double y3=Double.parseDouble(t3[1]);
			//求出到中心点的距离
			double juli=Math.sqrt((x3-mainx)*(x3-mainx)+(y3-mainy)*(y3-mainy));
			if(juli<banjing){
				mylist.add(attractions);
			}
		}
		return mylist;
	}
	/*
	 * 返回满足条件的Forattractions
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
	 * 用于返回两个点之间的距离
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
	 * 返回多个点之间的距离
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
	 * 计算函数，供前面函数调用
	 */
	public static double jisuan(String local1,String local2,String local3,String local4){
		double num1=jisuandouble(local1,local2);
		double num2=jisuandouble(local2,local3);
		double num3=jisuandouble(local3,local4);
		return num1+num2+num3;
	}
	/*
	 * 计算两个点之间的距离，供前面的函数调用
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
