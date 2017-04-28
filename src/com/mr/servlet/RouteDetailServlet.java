package com.mr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.attractions.Attractions;
import com.mr.attractions.ForAttractions;
import com.mr.attractions.OperateAttractions;

/**
 * Servlet implementation class RouteDetailServlet
 */
public class RouteDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myids=null,myrenqun=null,mypianhao=null;
		myids=request.getParameter("myids");
		myrenqun=request.getParameter("myrenqun");
		mypianhao=request.getParameter("mypianhao");
		List<ForAttractions> list=new ArrayList<>();
		String[] ids=myids.split(",");
		for(int i=0;i<ids.length;i++){
			Attractions attractions=
					OperateAttractions.SelectAttractionsById(Integer.parseInt(ids[i]));
			int crowds=attractions.getCrowds().selectCrowds(myrenqun);
			int views=attractions.getViewPreference().selectView(mypianhao);
			ForAttractions forAttractions=
					new ForAttractions(attractions,crowds,views,5,0);
			list.add(forAttractions);
		}
		request.setAttribute("list", list);
	    request.getRequestDispatcher("singleroute.jsp").forward(request, response);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
