package h40y.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Bill  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7091262555610207175L;
	int bid;
	int uid;
	int tid;  // TypeID 对应category表，表示该条记录的钟离
	float value;
	int type;  // 表示收支
	String date;
	String note;
	
	public Bill() {
		
	}
	
	public Bill(String username, int type, float money, String date, int gac) {
		this.tid = type;
		this.value = money;
		this.type = gac;
		this.date = date;
		
		User currUser = new User(username);
		int uid =currUser. getUid();
		this.uid = uid;
		
		this.bid = generateBid();
	}
	
 	public Bill(int bid, int uid, int tid, float value, int type, String date, String note) {
		this.bid = bid;
		this.uid = uid;
		this.tid = tid;
		this.value = value;
		this.type = type;
		this.date = date;
		this.note = note;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public int generateBid() {
		int currentId = -1;
		DB db = new DB();
		String sql = String.format("SELECT count(*) FROM `bill` WHERE uid = %d", uid);
		ResultSet rst = db.getResultSet(sql);
		try {
			if(rst.next()) currentId = rst.getInt(1);
			// System.out.printf("Generate successfully, id is %d\n", currentId+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return currentId+1;
	}
	
	public int uploadBill() {
		int result = -1;
		DB db = new DB();
		String sql = String.format("INSERT INTO bill VALUES(%d, %d, %d, %f, %d, \"%s\", NULL)", this.bid, this.uid, this.tid, this.value, this.type,this.date);
		result = db.update(sql);
		db.closed();
		return result;
	}
	
	public List<Bill> getBillsByName(String name){
		List<Bill> bills = new ArrayList<>();
		User currUser = new User(name);
		int uid =currUser. getUid();
		DB db = new DB();
		String sql = String.format("SELECT * FROM `bill` WHERE uid = %d", uid);
		ResultSet rst = db.getResultSet(sql);
		try {
			while(rst.next()) {
				int bid_t = rst.getInt(1);
				int uid_t = rst.getInt(2);
				int tid_t = rst.getInt(3);
				float value_t = rst.getFloat(4);
				int type_t = rst.getInt(5);
				String date_t = rst.getString(6);
				String note_t = rst.getString(7);
				Bill bill_t = new Bill(bid_t, uid_t, tid_t, value_t, type_t, date_t, note_t);
				bills.add(bill_t);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return bills;
	}
	/*
	public static void main(String[] args){
		String s = "2021-01-05 "; 
		Bill bill = new Bill("Admin", 7, (float)3.5, s, 0);
		bill.uploadBill();
	}
	*/
}
