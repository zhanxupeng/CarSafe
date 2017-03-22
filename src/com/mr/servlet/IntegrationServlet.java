package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.integration.GetIntegration;
import com.mr.integration.Integration;

/**
 * Servlet implementation class IntegrationServlet
 */
public class IntegrationServlet extends HttpServlet {
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
		car_id=Integer.parseInt(request.getParameter("car_id"));
		GetIntegration get=new GetIntegration();
		Integration inte=null;
		inte=get.getIntegration(car_id);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println("<car_id>"+inte.getCar_id()+"</car_id>");
		out.println("<coin>"+inte.getCoin()+"</coin>");
		out.println("<member>"+inte.getMember()+"</member>");
		out.println("<mydate>"+inte.getMydate()+"</mydate>");
		out.flush();
		out.close();
	}

}
