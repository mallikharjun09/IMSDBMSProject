package com.tmf.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet{
	public void doGet(HttpServletRequest request,
			HttpServletResponse resp) throws IOException,ServletException{
		PrintWriter out = resp.getWriter();
		out.println("Welcome to Servlet...");
	}
}
