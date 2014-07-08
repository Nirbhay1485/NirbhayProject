package com.nir.csv.parser;

/**
 * <p> This represents Shares of comapnay.</p>
 * @author nirbhay
 *
 */
public class Share implements Comparable<Share>{
	/**
	 * <p>Year of the share of the company that
	 * represents year header of the csv file.
	 * </p>
	 */
	private String year;
	/**
	 * <p>month of the share of the company that
	 * represents month header of the csv file.
	 * </p>
	 */
	private String month;
	/**
	 * <p>share price of the share of the company that
	 * represents company share price header of the csv file.
	 * </p>
	 */
	private String sharePrice;
	
	/**
	* get method of year.
	*/
	public String getYear() {
		return year;
	}
	/**
	*set method fo year.
	*/
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	* get method of month.
	*/
	public String getMonth() {
		return month;
	}
	/**
	*set method fo month.
	*/
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	* get method of share price.
	*/
	public String getSharePrice() {
		return sharePrice;
	}
	/**
	* set method of share price.
	*/
	public void setSharePrice(String sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	
	@Override
	public int compareTo(Share share) {
		// TODO Auto-generated method stub
		return (int) (Integer.valueOf(this.getSharePrice())-Integer.valueOf(share.getSharePrice()));
	}
	
	
}
