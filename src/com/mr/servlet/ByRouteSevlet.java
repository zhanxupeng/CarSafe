package com.mr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.attractions.DayRoute;
import com.mr.attractions.NewOperateAttractions;
import com.mr.attractions.OperateAttractions;
import com.mr.attractions.RouteResult;

/**
 * Servlet implementation class ByRouteSevlet
 */
public class ByRouteSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 接收上传qidian(x,y),终点(x,y),crowds=oldman,viewpreference=quiet,time=8h
		 */
		String myrenqun,mypianhao,myshijian;
		myrenqun=request.getParameter("myrenqun");
		mypianhao=request.getParameter("mypianhao");
		myshijian=request.getParameter("myshijian");
		int time=Integer.parseInt(myshijian);
		List<RouteResult> list=DayRoute.selectByDay("(0,0)","(500,500)",myrenqun,mypianhao,time);
		request.setAttribute("list", list);
	    request.getRequestDispatcher("timeroute.jsp").forward(request, response);
	}

}
