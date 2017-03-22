package com.mr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.timecar.TimeCarList;
import com.mr.timecar.Timecar;

/**
 * Servlet implementation class TimecarServlet
 */
public class TimecarServlet extends HttpServlet {
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
		TimeCarList cars=new TimeCarList();
		List<Timecar> times=new ArrayList<Timecar>();
		times=cars.selectcar(car_id);
		System.out.println(times.size());
	    request.setAttribute("times", times);
	    request.getRequestDispatcher("times.jsp").forward(request, response);
	}

}
