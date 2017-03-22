package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.examination.Examination;
import com.mr.examination.GetExamination;

/**
 * Servlet implementation class ExamServlet
 */
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Examination exam=null;
		GetExamination  exams=new GetExamination();
		exam=exams.getOneExam();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println("<id>"+exam.getId()+"</id>");
		out.println("<question>"+exam.getQuestion()+"</question>");
		out.println("<answera>"+exam.getAnswera()+"</answera>");
		out.println("<answerb>"+exam.getAnswerb()+"</answerb>");
		out.println("<answerc>"+exam.getAnswerc()+"</answerc>");
		out.println("<answerd>"+exam.getAnswerd()+"</answerd>");
		out.println("<answer>"+exam.getAnswer()+"</answer>");
		out.flush();
		out.close();
	}
	
	
	
	
	
	
	
	
	
	

}
