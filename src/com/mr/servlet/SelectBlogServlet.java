package com.mr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.blog.Blog;
import com.mr.blog.OperateBlog;

/**
 * Servlet implementation class SelectBlogServlet
 */
public class SelectBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OperateBlog blog=new OperateBlog();
		List<Blog> blogs=blog.selectBlog();
		request.setAttribute("blogs",blogs);
		request.getRequestDispatcher("selectblog.jsp").forward(request, response);
	}

}
