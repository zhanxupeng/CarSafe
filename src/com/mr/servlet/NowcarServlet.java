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
import com.mr.nowcar.Nowupload;

/**
 * Servlet implementation class NowcarServlet
 */
public class NowcarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int car_id,flag;
		double xx,yy,speed,direction;
		boolean result=false;
		car_id=Integer.parseInt(request.getParameter("car_id"));
		flag=Integer.parseInt(request.getParameter("flag"));
		xx=Double.parseDouble(request.getParameter("xx"));
		yy=Double.parseDouble(request.getParameter("yy"));
		speed=Double.parseDouble(request.getParameter("speed"));
		direction=Double.parseDouble(request.getParameter("direction"));
		Nowupload up=new Nowupload();
		result=up.upload(car_id, xx, yy, speed, flag, direction);
		if(result==true){
			List<Nowcar> nowcars=new ArrayList<Nowcar>();
			Nowlist list=new Nowlist();
			nowcars=list.listnow();
			//ÍøÒ³Ìø×ª
			request.setAttribute("nowcars", nowcars);
		    request.getRequestDispatcher("nowcars.jsp").forward(request, response);
		}else{
			//´íÎóÒ³Ãæ
			request.getRequestDispatcher("nowerror.jsp").forward(request,response);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
