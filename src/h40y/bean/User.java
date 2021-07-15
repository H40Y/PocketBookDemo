package h40y.bean;

import java.sql.*;

public class User implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4642697102885381974L;
	int uid;
	String name;
	String phone;
	String password;
	
	public User() {
		
	}
	
	public User(String name) {
		this.name=name;
		DB db = new DB();
		String sql = String.format("SELECT uid FROM `user` WHERE name =\"%s\"",  this.name);
		ResultSet rst = db.getResultSet(sql);
		try {
			if(rst.next()) {
				this.uid = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closed();
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean login(String name, String password) {
		String[] data = {name, password};
		
		boolean isValid = false;
		DB db = new DB();
		String sql = "SELECT * FROM user WHERE name = ? and password = ?";
		ResultSet rst = db.getResultSet(sql, data);
		try {
			if(rst.next()) {
				isValid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closed();
		return isValid;
	}
	
	public boolean isExist(String name) {
		boolean isExist = false;
		DB db = new DB();
		String sql = "SELECT * FROM user WHERE name = ?";
		ResultSet rst = db.getResultSet(sql, name);
		try {
			if(rst.next()) isExist = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closed();
		return isExist;
	}
	
	public int generateUid() {
		int currentId = -1;
		DB db = new DB();
		String sql = "select COUNT(uid) FROM user";
		ResultSet rst = db.getResultSet(sql);
		try {
			if(rst.next()) currentId = rst.getInt(1);
			// System.out.printf("Generate successfully, id is %d\n", currentId+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentId+1;
	}
	
	public int regist(String name, String password) {
		if (isExist(name)) return -1;
		
		int id = generateUid();
		if (id == 0) return -1;  // …˙≥…“Ï≥£
		
		DB db = new DB();
		String sql = String.format("INSERT INTO user VALUES(%d, ?, NULL, ?)", id);
		// System.out.println(sql);
		String[] data = {name, password};
		int rst = db.update(sql, data);
		// System.out.println(rst);
		db.closed();
		return rst;
	}
	/*
	public static void main(String[] args) {
		User test = new User();
		test.setName("Admin");
		int res =test. getUid();
		System.out.println(res);
	}
	*/
}
