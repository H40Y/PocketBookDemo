package h40y.bean;

public class Category implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 579062129666514947L;
	int tid;
	String tname;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public String getCategory(int tid) {
		//本来应该用访问数据库的方式获取，但是前期网站只设定了固定种类，于是便直接用switch获取具体名称。
		String Category = "";
		switch(tid){
		case(1):
			Category = "CLOTH";
			break;
		case(2):
			Category = "FOOD";
			break;
		case(3):
			Category = "LIVE";
			break;
		case(4):
			Category = "TRAVEL";
			break;
		case(5):
			Category = "STUDY";
			break;
		case(6):
			Category = "COMMUTE";
			break;
		case(7):
			Category = "OTHER";
			break;
		}
		return Category;
	}
}
