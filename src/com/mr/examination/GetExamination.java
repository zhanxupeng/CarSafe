package com.mr.examination;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mr.hibernate.HibernateUtil;

public class GetExamination {
	@SuppressWarnings("unchecked")
	public Examination getOneExam(){
		int result=(int) (Math.random()*2+1);
		Examination exam=null;
		List<Examination> emplist=null;
		Session session=null;
		try{
			session=HibernateUtil.getSession();
			String hql="from Examination exam where exam.id=?";
			Query q=session.createQuery(hql);
			q.setParameter(0,result);
			emplist=q.list();
			exam=emplist.get(0);
			System.out.println(emplist.size());
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return exam;
	}
	public static void main(String[] args) {
		Examination exam=null;
		GetExamination exams=new GetExamination();
		exam=exams.getOneExam();
		if(exam!=null){
		System.out.println(exam.getQuestion());
		}
	}

}
