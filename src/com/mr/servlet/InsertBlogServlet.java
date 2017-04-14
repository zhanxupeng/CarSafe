package com.mr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.blog.Blog;
import com.mr.blog.OperateBlog;

/**
 * Servlet implementation class InsertBlogServlet
 */
public class InsertBlogServlet extends HttpServlet {
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
		String username,mysign;
		car_id=Integer.parseInt(request.getParameter("car_id"));
		username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		mysign=new String(request.getParameter("mysign").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(username);
		//��������
		OperateBlog blogs=new OperateBlog();
		Blog blog=new Blog(car_id,username,mysign);
		blogs.insertBlog(blog);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println("发布成功");
		out.flush();
		out.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
