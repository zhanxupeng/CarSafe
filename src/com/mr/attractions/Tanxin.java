package com.mr.attractions;

import java.util.ArrayList;
import java.util.List;

public class Tanxin {
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
	public static List<Integer> selectId(List<ForAttractions> list,int i){
		List<Integer> result=new ArrayList<>();
		int num=i;
		ForAttractions attraction=list.get(num);
		List<Boolean> bianli=new ArrayList<>();
		for(int j=0;j<list.size();j++){
			bianli.add(false);
		}
		bianli.set(num, true);
		result.add(attraction.getId());
		while(true){
			ForAttractions attrMin=new ForAttractions();
			for(int j=0;j<list.size();j++){
				if(bianli.get(j)==false){
					ForAttractions attr=list.get(j);
					if(selectdistance(attr.getLocal(),attraction.getLocal())
							<selectdistance(attrMin.getLocal(),attraction.getLocal() ))
					{
						attrMin=attr;
						num=j;
					}
				}
			}
			attraction=attrMin;
			bianli.set(num, true);
			int thenum=0;
			for(int j=0;j<bianli.size();j++){
				if(bianli.get(j)){
					thenum++;
				}
			}
			result.add(attraction.getId());
			if(thenum==bianli.size()){
				break;
			}
		}
		return result;
	}
	public static void main(String[] args){
		ForAttractions a=new ForAttractions("(0,0)");
		List<ForAttractions> list=new ArrayList<>();
		list.add(a);
		a=new ForAttractions("(100,200)");
		list.add(a);
		a=new ForAttractions("(100,100)");
		list.add(a);
		List<Integer> s=selectId(list,0);
		for(Integer t:s){
			System.out.print(t+"  ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
