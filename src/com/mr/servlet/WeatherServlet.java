package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.weather.ReadWeather;
import com.mr.weather.Weather;

/**
 * Servlet implementation class WeatherServlet
 */
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id;
		id=Integer.parseInt(request.getParameter("id"));
		Weather weather=ReadWeather.read(1);
		System.out.println("servlet:"+weather.getRank());
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(weather.getRank());
		out.flush();
		out.close();
	}

}
