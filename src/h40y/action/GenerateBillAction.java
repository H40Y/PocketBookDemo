package h40y.action;

import java.util.*;
import h40y.bean.*;

public class GenerateBillAction {
	
	public List<BillToUser> generateBill(String name){
		Bill rawBill = new Bill();
		List<Bill> rawData= rawBill.getBillsByName(name);
		List<BillToUser> data= new ArrayList<>();
		for(Bill b:rawData) {
			BillToUser btu = new BillToUser();
			btu.date = b.getDate();  // 获取日期
			btu.value = b.getValue();  // 获取金额
			
			switch (b.getType()) {  // 获取收支
			case(0):
				btu.gac = "IMCOME";
				break;
			case(1):
				btu.gac = "PAYOUT";
			}
			
			Category type = new Category();
			btu.type = type.getCategory(b.getTid());  // 获取种类
			
			data.add(btu);
		}
		
		Collections.sort(data);
		
		return data;
	}
	
}
