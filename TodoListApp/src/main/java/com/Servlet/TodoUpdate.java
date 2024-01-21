package com.Servlet;

import java.io.IOException;

import com.DAO.TodoDao;
import com.DbConnect.DbConnect;
import com.Entity.Add_todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UpdateTodo")
public class TodoUpdate extends HttpServlet{
	private static final long serialVersionUID = -3436603143588968727L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String task = req.getParameter("task");
		String status = req.getParameter("status");
		
		TodoDao dao = new TodoDao(DbConnect.getConn());
		Add_todo todo = new Add_todo();
		
		todo.setId(id);
		todo.setName(username);
		todo.setTask(task);
		todo.setStatus(status);
		
		boolean flag = dao.UpdateTodo(todo);
		HttpSession session = req.getSession();
		
		if(flag) {
			session.setAttribute("SuccessMessage", "Task Updated Successfully !!!");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("FailedMessage", "No Task Updated !!!");
			resp.sendRedirect("index.jsp");
		}
	}
}
