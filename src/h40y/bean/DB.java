package h40y.bean;

import java.sql.*;

public class DB {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/web_demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static final String USER = "web_admin";
	private static final String PASS = "DbPswd";
	private ResultSet rst = null;
	private Connection con;
	private Statement smt;
	
	public DB(){
		getStatement();
	}
	
	public void getDriver(){
		try {
			Class.forName(JDBC_DRIVER);
		}catch(ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	
	public void getConnection() {
		try {
			getDriver();
			con = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(Exception e) {
			System.out.println("Á¬½ÓÊ§°Ü£¡");
		}
	}
	
	public void getStatement() {
		try {
			getConnection();
			smt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e) {}
	}
	
	public ResultSet getResultSet(String sql) {
		try {
			rst = smt.executeQuery(sql);
		}catch(Exception e) {}
		return rst;
	}
	
	public ResultSet getResultSet(String sql, String name) {
		try {
			 PreparedStatement preState = con.prepareStatement(sql);
			 preState.setString(1, name);
		     rst = preState.executeQuery();
		}catch(Exception e) {}
		return rst;
	}
	
	public ResultSet getResultSet(String sql, String[] parameter) {  // ·ÀÖ¹SQL×¢Èë¹¥»÷
		try {
			 PreparedStatement preState = con.prepareStatement(sql);
			 preState.setString(1, parameter[0]);
		     preState.setString(2, parameter[1]);
		     rst = preState.executeQuery();
		}catch(Exception e) {}
		return rst;
	}
	
	/*
	public List<Object> queryToList(String sql, Object obj, String[] parameter) throws SQLException{
		if(obj == null) return null;
		rst = getResultSet(sql, parameter);
		List lst = new ArrayList();
		ResultSetMetaData md = rst.getMetaData();
		int columnCount = md.getColumnCount();
		while(rst.next()) {
			Map rowData = new HashMap();
			for (int i = 0; i <columnCount; i++) {
				rowData.put(md.getColumnName(i), rst.getObject(i));
			}
			lst.add(rowData);
		}
		this.closed();
		return lst;
	}
	
	public <T> List<T> queryToListObject(String sql, T obj, String[] parameter) throws SQLException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(obj == null) return null;
		rst = getResultSet(sql, parameter);
		Class<?> classType = obj.getClass();
		ArrayList<T> lst = new ArrayList<T>();
		Field[] fields = classType.getDeclaredFields();
		ResultSetMetaData md = rst.getMetaData();
		int columnCount = md.getColumnCount();
		while(rst.next()) {
			T objectCopy = (T)classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
			for (int i = 0; i <columnCount; i++) {
				Field field = null;
				String fieldName = md.getColumnName(i);
				String firstLetter = fieldName.substring(0, 1).toUpperCase();
				String setMethodName = "set" + firstLetter + fieldName.substring(1);
				for (int j=0; j<fields.length; j++) {
					if(fields[j].getName().equals(fieldName)) {
						field = fields[j];
						break;
					}
				}
				Method setMethod = classType.getMethod(setMethodName, new Class[] {
						field.getType()});
				setMethod.invoke(objectCopy, new Object[] { rst.getObject(i)});
				}
				lst.add(objectCopy);
			}
			this.closed();
			return lst;
		}
	*/
	
	public int update(String sql) {
		int ret = 0;
		try {
			ret = smt.executeUpdate(sql);
		}catch(Exception e) {}
		return ret;
	}
	
	public int update(String sql, String[] parameter) {  // ·ÀÖ¹SQL×¢Èë¹¥»÷
		int ret = 0;
		try {
			PreparedStatement preState = con.prepareStatement(sql);
			preState.setString(1, parameter[0]);
		    preState.setString(2, parameter[1]);
			ret = preState.executeUpdate();
		}catch(Exception e) {}
		return ret;
	}
	
	public void closed() {
		try {
			if(rst != null) rst.close();
			if(smt != null) smt.close();
			if(con != null) con.close();
		}catch(Exception e) {}
	}
	
	/*
	public static void main(String[] args) {
		DB db = new DB();
		//String[] data = {"Admin", "620831"};
		String[] data = {"Test1", "123321"};
		// String sql = "SELECT * FROM user WHERE name = ? and password = ?";
		String sql = "INSERT INTO user VALUES(4, ?, NULL, ?)";
		// ResultSet rs = db.getResultSet(sql, data);
		int rst = db.update(sql, data);
		System.out.println(rst);
		try {
			if(rs.next()) {
				int id = rs.getInt("uid");
				System.out.printf("µÇÂ½³É¹¦£¬ÄúµÄuidÊÇ£º%d\n", id);
			}else {
				System.out.println("µÇÂ½Ê§°Ü£¬ÃÜÂë´íÎó£¡");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
}
