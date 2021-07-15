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
			btu.date = b.getDate();  // ��ȡ����
			btu.value = b.getValue();  // ��ȡ���
			
			switch (b.getType()) {  // ��ȡ��֧
			case(0):
				btu.gac = "IMCOME";
				break;
			case(1):
				btu.gac = "PAYOUT";
			}
			
			Category type = new Category();
			btu.type = type.getCategory(b.getTid());  // ��ȡ����
			
			data.add(btu);
		}
		
		Collections.sort(data);
		
		return data;
	}
	
}
