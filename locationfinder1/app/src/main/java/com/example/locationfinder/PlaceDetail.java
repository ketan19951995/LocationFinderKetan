package com.example.locationfinder;

public class PlaceDetail {
	String name="0";
	String vicinity="0";
	String address="0";
	String phonenumber="0";
	String rating="0";
	
	void setname(String name){
		this.name=name;
	}
	void setvicinity(String vicinity){
		this.vicinity=vicinity;
	}
	void setaddress(String address){
		this.address = address;
	}
	void setphone(String phonenumber){
		this.phonenumber=phonenumber;
	}
	void setrating(String rating){
		this.rating=rating;
	}
	
	
	String getname(){
		return name;
	}
	String getvicinity(){
		return vicinity;
	}
	String getaddress(){
		return address;
	}
	String getphone(){
		return phonenumber;
	}
	String getrating(){
		return rating;
	}
	
	

}
