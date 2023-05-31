package com.tmf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tmf.ims.dao.ProductDAO;
import com.tmf.ims.dao.ProductsDBDAO;
import com.tmf.ims.models.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveProduct extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.print("Welcome to Save Product Servlet");
		
		String id = req.getParameter("pid");
		String name = req.getParameter("pname");
		String category = req.getParameter("cat");
		String cost = req.getParameter("pcost");
		
		long pid = Long.parseLong(id);
		double pcost = Double.parseDouble(cost);
		
		Product pro = new Product(pid,name,pcost,category);
		ProductsDBDAO dao = new ProductsDBDAO();
		dao.addProduct(pro);
		out.println("Product details has been saved...");
		
		List<Product> pros = dao.displayAllProducts();
		out.println("<table>");
		out.println("<tr><th>Product Id</th>");
		out.println("<th>Product Name</th>");
		out.println("<th>Category</th>");
		out.println("<th>Product Cost</th></tr>");
		for(Product p : pros) {
			out.println("<tr>");
			out.println("<td>"+p.getProductId()+"</td>");
			out.println("<td>"+p.getProductName()+"</td>");
			out.println("<td>"+p.getCategory()+"</td>");
			out.println("<td>"+p.getProductCost()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
	}
}
