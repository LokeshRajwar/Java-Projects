package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Add_todo;

public class TodoDao {
	private Connection conn;
	public TodoDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addTodo(String name, String task, String status) {
		boolean f = false;
		
		try {
			String sql = "insert into todoapp(name, task, status) value(?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, task);
			ps.setString(3, status);
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Add_todo> getTodo(){
		List<Add_todo> list = new ArrayList<Add_todo>();
		Add_todo obj = null;
		try {
			String sql = "select * from todoapp";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				obj = new Add_todo();
				obj.setId(res.getInt(1));
				obj.setName(res.getString(2));
				obj.setTask(res.getString(3));
				obj.setStatus(res.getString(4));
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Add_todo getTodoById(int id) {
		Add_todo todo = null;
			try {
				String sql = "select * from todoapp where id=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet res = ps.executeQuery();
				
				while(res.next()) {
					todo = new Add_todo();
					todo.setId(res.getInt(1));
					todo.setName(res.getString(2));
					todo.setTask(res.getString(3));
					todo.setStatus(res.getString(4));
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}		
		return todo;
	}
	
	public boolean UpdateTodo(Add_todo todo) {
		boolean flag = false;
		try {
			String  sql = "update todoapp set name=?,task=?,status=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, todo.getName());
			ps.setString(2, todo.getTask());
			ps.setString(3, todo.getStatus());
			ps.setInt(4, todo.getId());
			
			int i = ps.executeUpdate();
			if(i==1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean DeleteTodo(int id) {
		boolean flag = false;
		try {
			String sql = "delete from todoapp where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if(i==1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
