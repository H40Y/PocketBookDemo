package h40y.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillToUser implements Comparable<BillToUser>{
	public String date;
	public String gac;
	public String type;
	public float value;
	// String note;‘›≤ª µœ÷
	
	public BillToUser() {}
	
	public BillToUser(String date) {
		this.date = date;
	}
	
	public Date transDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date tmpDate = null;
		try {
			tmpDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tmpDate;
	}
	
	@Override
	public int compareTo(BillToUser o) {
		return transDate().compareTo(o.transDate());
	}
}
