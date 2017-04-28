package com.mr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.featuresfood.Featuresfood;
import com.mr.featuresfood.OperateFeaturesfood;

/**
 * Servlet implementation class FoodServlet
 */
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mylocal=null;
		//(119.779647,30.24369)
		mylocal=request.getParameter("mylocal");
		mylocal=mylocal.substring(1,mylocal.length()-1);
		String[] a=mylocal.split(",");
		List<Featuresfood> list=
				OperateFeaturesfood.selectFood(Double.parseDouble(a[0]),
						Double.parseDouble(a[1]));
		request.setAttribute("list", list);
	    request.getRequestDispatcher("foodlist.jsp").forward(request, response);
	}

}
