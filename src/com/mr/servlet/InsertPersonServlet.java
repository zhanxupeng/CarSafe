package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.person.OperatePerson;

/**
 * Servlet implementation class InsertPersonServlet
 */
public class InsertPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int car_id;
		String usename=null,password=null;
		car_id=Integer.parseInt(request.getParameter("car_id").toString());
		usename=request.getParameter("usename");
		password=request.getParameter("password");
		OperatePerson person=new OperatePerson();
		boolean result=person.insertperson(car_id, usename, password);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
		out.close();
				
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
