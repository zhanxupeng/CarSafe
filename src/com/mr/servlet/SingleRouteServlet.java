package com.mr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.attractions.ForAttractions;
import com.mr.attractions.OperateAttractions;

/**
 * Servlet implementation class SingleRouteServlet
 */
public class SingleRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 单一景点查询
		 *
	 	返回满足条件的Forattractions
	 	("oldman","quiet","(300,400)","sunny");
	 	?myrenqun="+myrenqun+"&mypianhao="+mypianhao+"&mytianqi="+mytianqi;
		 */
		String myrenqun,mypianhao,mytianqi;
		myrenqun=request.getParameter("myrenqun").trim();
		mypianhao=request.getParameter("mypianhao").trim();
		mytianqi=request.getParameter("mytianqi").trim();
		List<ForAttractions> list=
				OperateAttractions.selectAttractions(myrenqun,mypianhao,"(300,400)",mytianqi);
		request.setAttribute("list", list);
	    request.getRequestDispatcher("singleroute.jsp").forward(request, response);
	}

}
