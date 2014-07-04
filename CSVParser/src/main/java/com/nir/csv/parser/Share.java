package com.nir.csv.parser;

public class Share implements Comparable<Share>{
	private String year;
	private String month;
	private String sharePrice;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(String sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	
	@Override
	public int compareTo(Share share) {
		// TODO Auto-generated method stub
		return (int) (Integer.valueOf(this.getSharePrice())-Integer.valueOf(share.getSharePrice()));
	}
	
	
}
