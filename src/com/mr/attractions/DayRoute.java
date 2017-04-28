package com.mr.attractions;

import java.util.ArrayList;
import java.util.List;

public class DayRoute {
	public static List<RouteResult> selectByDay(String startlocal,String endlocal,
			String crowds,String viewpreference,double time){
		List<RouteResult> mylist=new ArrayList<>();
		List<RouteResult> list=NewOperateAttractions.selectByRoute(startlocal,endlocal,
				crowds,viewpreference,8);
		if(time==8){
			mylist.addAll(list);
		}else if(time==16){
			for(int i=0;i<list.size()/2+1;i++){
			for(int j=list.size()-1;j>list.size()/2;--j){
				boolean flag=false;
				String[] a=list.get(i).getRouteid().split(",");
				String[] b=list.get(j).getRouteid().split(",");
				for(String aa:a)
				{
					for(String bb:b){
						if(aa.equals(bb))
						{
							flag=true;
						}
					}
				}
				if(flag==false){
					RouteResult result=
							new RouteResult(list.get(i).getMypicture(),
									list.get(i).getRoute()+"~"+list.get(j).getRoute(),
									list.get(i).getRouteid()+","+list.get(j).getRouteid(),
									(list.get(i).getZhishu()+list.get(j).getZhishu())/2,
									list.get(i).getTime()+list.get(j).getTime(),
									list.get(i).getPrice()+list.get(j).getPrice());
					mylist.add(result);
					break;		
				}
			}
		}
		}else if(time==24){
			boolean myflag=false;
			for(int i=0;i<list.size()/3+1;i++){
				for(int j=list.size()/3+1;j<list.size()/3*2+1;j++)
				{
					for(int k=list.size()-1;k>list.size()/3*2+1;--k)
					{
						boolean flag=false;
						myflag=false;
						RouteResult route1=list.get(i);
						RouteResult route2=list.get(j);
						RouteResult route3=list.get(k);
						String[] str1=route1.getRouteid().split(",");
						String[] str2=route2.getRouteid().split(",");
						String[] str3=route3.getRouteid().split(",");
						for(String aa:str1){
							for(String bb:str2){
								for(String cc:str3){
									if(aa.equals(bb)||aa.equals(cc)||bb.equals(cc))
										flag=true;
								}
							}
						}
						if(flag==false){
							RouteResult result=new RouteResult
								(route1.getMypicture(),
									route1.getRoute()+"~"+route2.getRoute()+"~"+route3.getRoute(), 
									route1.getRouteid()+","+route2.getRouteid()+","+route3.getRouteid(),
									(route1.getZhishu()+route2.getZhishu()+route3.getZhishu())/3, 
									(route1.getTime()+route2.getTime()+route3.getTime()),
									(route1.getPrice()+route2.getPrice()+route3.getPrice()));
							mylist.add(result);
							myflag=true;
						}
						if(myflag==true)
							break;
					}
					if(myflag==true)
						break;
				}
			}
		}
		return mylist;
	}
	public static void main(String[] args) {
		List<RouteResult> mylist=selectByDay("(0,0)","(500,500)","oldman","quiet",24);
		for(RouteResult route:mylist){
			System.out.println(route.getRoute());
		}
		// TODO Auto-generated method stub
//		List<RouteResult> mylist=new ArrayList<RouteResult>();
//		List<RouteResult> list=NewOperateAttractions.selectByRoute("(0,0)","(500,500)","oldman","quiet",8);
//		if(list!=null){
//			System.out.println(list.size());
//			System.out.println(list.get(2).getMypicture());
//		}else {
//			System.out.println("��ǰû�м�¼");
//		}
//		for(RouteResult route:list){
//			System.out.println(route.getRoute());
//		}
		//������������list��ѡ�����飬Ҫ�����е����ݲ������ظ���
		//���㰴�������������ģ�Ȼ��һ����ǰ���������һ���Ӻ���ǰ������
		//��Ϊ���ÿͻ�ÿ����ľ�������������һ�£�����ѹ������Ҫ̫�ۡ�
//		for(int i=0;i<list.size()/2+1;i++){
//			for(int j=list.size()-1;j>list.size()/2;--j){
//				boolean flag=false;
//				String[] a=list.get(i).getRouteid().split(",");
//				String[] b=list.get(j).getRouteid().split(",");
//				for(String aa:a)
//				{
//					for(String bb:b){
//						if(aa.equals(bb))
//						{
//							flag=true;
//						}
//					}
//				}
//				if(flag==false){
//					RouteResult result=
//							new RouteResult(list.get(i).getMypicture(),
//									list.get(i).getRoute()+"-"+list.get(j).getRoute(),
//									list.get(i).getRouteid()+"-"+list.get(j).getRouteid(),
//									(list.get(i).getZhishu()+list.get(j).getZhishu())/2,
//									list.get(i).getTime()+list.get(j).getTime(),
//									list.get(i).getPrice()+list.get(j).getPrice());
//					mylist.add(result);
//					break;		
//				}
//			}
//		}
//		for(RouteResult result:mylist){
//			System.out.println(result.getRoute());
//		}
		/*
		 * ȡ������������
		 */
//		boolean myflag=false;
//		for(int i=0;i<list.size()/3+1;i++){
//			for(int j=list.size()/3+1;j<list.size()/3*2+1;j++)
//			{
//				for(int k=list.size()-1;k>list.size()/3*2+1;--k)
//				{
//					boolean flag=false;
//					myflag=false;
//					RouteResult route1=list.get(i);
//					RouteResult route2=list.get(j);
//					RouteResult route3=list.get(k);
//					String[] str1=route1.getRouteid().split(",");
//					String[] str2=route2.getRouteid().split(",");
//					String[] str3=route3.getRouteid().split(",");
//					for(String aa:str1){
//						for(String bb:str2){
//							for(String cc:str3){
//								if(aa.equals(bb)||aa.equals(cc)||bb.equals(cc))
//									flag=true;
//							}
//						}
//					}
//					if(flag==false){
//						RouteResult result=new RouteResult
//							(route1.getMypicture(),
//								route1.getRoute()+"-"+route2.getRoute()+"-"+route3.getRoute(), 
//								route1.getRouteid()+"-"+route1.getRouteid()+"-"+route1.getRouteid(),
//								(route1.getZhishu()+route2.getZhishu()+route3.getZhishu())/3, 
//								(route1.getTime()+route2.getTime()+route3.getTime()),
//								(route1.getPrice()+route2.getPrice()+route3.getPrice()));
//						mylist.add(result);
//						myflag=true;
//					}
//					if(myflag==true)
//						break;
//				}
//				if(myflag==true)
//					break;
//			}
//		}
//		for(RouteResult result:mylist){
//			System.out.println(result.getRoute());
//		}
	}

}
