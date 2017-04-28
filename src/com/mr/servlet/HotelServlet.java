package com.mr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.thehotel.OperateThehotel;
import com.mr.thehotel.Thehotel;

/**
 * Servlet implementation class HotelServlet
 */
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Thehotel> list=OperateThehotel.selectByLocal("(120.158307,30.230458)");
		request.setAttribute("list", list);
	    request.getRequestDispatcher("hotellist.jsp").forward(request, response);
	}

}
