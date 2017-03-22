package com.mr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.mycrowded.Crowded;
import com.mr.mycrowded.Mycrowded;

/**
 * Servlet implementation class CrowdedServlet
 */
public class CrowdedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//根据得到的myflag处理
		int myflag=1;
		myflag=Integer.parseInt(request.getParameter("myflag"));
		List<Mycrowded> crowdeds=null;
		Crowded crowded=new Crowded();
		crowdeds=crowded.check(myflag);
		System.out.println(crowdeds.size());
		request.setAttribute("crowdeds",crowdeds);
		request.getRequestDispatcher("mycrowded.jsp").forward(request, response);
	}

}
