package main.java;

public class DeliveryStaff {
	private String deliveryStaffName;
	private String deliveryStaffNum;
	
	public DeliveryStaff (String deliveryStaffName, String deliveryStaffNum) {
		this.deliveryStaffName = deliveryStaffName;
		this.deliveryStaffNum = deliveryStaffNum;
	}
	
	public String getDeliveryStaffName() {
		return deliveryStaffName;
	}
	
	public void setDeliveryStaffName(String name) {
		deliveryStaffName = name;
	} 
	
	public String getDeliveryStaffNum() {
		return deliveryStaffNum;
	}
	
	public void setDeliveryStaffNum(String num) {
		deliveryStaffNum = num;
	}
}
