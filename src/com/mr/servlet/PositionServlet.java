package com.mr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.nowcar.Nowcar;
import com.mr.nowcar.Nowlist;

/**
 * Servlet implementation class PositionServlet
 */
public class PositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Nowcar> nowcars=new ArrayList<Nowcar>();
		Nowlist list=new Nowlist();
		nowcars=list.listnow();
		//ÍøÒ³Ìø×ª
		request.setAttribute("nowcars", nowcars);
	    request.getRequestDispatcher("nowcars.jsp").forward(request, response);
	}

}
