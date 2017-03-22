package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.person.OperatePerson;

/**
 * Servlet implementation class LoginsServlet
 */
public class LoginsServlet extends HttpServlet {
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
		String password;
		String usename;
		car_id=Integer.parseInt(request.getParameter("car_id").toString());
		password=request.getParameter("password").toString();
		OperatePerson person=new OperatePerson();
		usename=person.uselogin(car_id, password);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(usename);
		out.flush();
		out.close();
		
		
		
		
		
		
		
		
		
	}

}
