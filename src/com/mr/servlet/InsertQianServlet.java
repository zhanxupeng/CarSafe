package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.integration.GetIntegration;

/**
 * Servlet implementation class InsertQianServlet
 */
public class InsertQianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int car_id,coin,member,flag=0;
		String myflag;
		myflag=request.getParameter("flag");
		if(myflag!=null){
			flag=Integer.parseInt(myflag);
		}
		car_id=Integer.parseInt(request.getParameter("car_id"));
		coin=Integer.parseInt(request.getParameter("coin"));
		member=Integer.parseInt(request.getParameter("member"));
		GetIntegration get=new GetIntegration();
		boolean result=get.InsertQianCoin(car_id, coin, member);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		if(flag==1){
			out.println("签到成功，获得200安行币");
		}else{
		out.println("意外收获，获得20安行币");
		}
		out.flush();
		out.close();
	}

}
