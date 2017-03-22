package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.integration.GetIntegration;

/**
 * Servlet implementation class UpdateCoinServlet
 */
public class UpdateCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int car_id,coin,mydate;
		car_id=Integer.parseInt(request.getParameter("car_id"));
		coin=Integer.parseInt(request.getParameter("coin"));
		mydate=Integer.parseInt(request.getParameter("mydate"));
		GetIntegration get=new GetIntegration();
		boolean result=get.InsertCoin(car_id, coin, mydate);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}

}
