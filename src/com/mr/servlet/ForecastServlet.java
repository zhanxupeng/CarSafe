package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.forecast.Forecast;
import com.mr.forecast.SelectForecast;

/**
 * Servlet implementation class ForecastServlet
 */
public class ForecastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String route=null;
		int time=0;
		route=request.getParameter("route");
		if(request.getParameter("time")!=null){
			time=Integer.parseInt(request.getParameter("time"));
		}
		SelectForecast fore=new SelectForecast();
		Forecast cast=null;
		cast=fore.timeselect(route, time);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println("<id>"+cast.getId()+"</id>");
		out.println("<route>"+cast.getRoute()+"</route>");
		out.println("<time>"+cast.getTime()+"</time>");
		out.println("<rrank>"+cast.getRrank()+"</rrank>");
		out.println("<trank>"+cast.getTrank()+"</trank>");
		out.println("<hrank>"+cast.getHrank()+"</hrank>");
		out.flush();
		out.close();
	}

}
