package com.Servlet;

import java.io.IOException;

import com.DAO.TodoDao;
import com.DbConnect.DbConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Delete")
public class TodoDelete extends HttpServlet{
	private static final long serialVersionUID = 3429834663115955973L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		TodoDao todo = new TodoDao(DbConnect.getConn());
		boolean flag = todo.DeleteTodo(id);
		HttpSession session = req.getSession();
		
		if(flag) {
			session.setAttribute("SuccessMessage", "Task Deleted Successfully !!!");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("FailedMessage", "No Task Deleted !!!");
			resp.sendRedirect("index.jsp");
		}
	}
}
