package com.nir.csv.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 	This class represents companies records from csv file.
 *</p>
 * @author nirbhay
 *
 */
public class Company{

	/**
	 * <p>This is name property of company</p>
	 */
	private String name;
	/**
	 * <p>this is shares property of compnay</p>
	 */
	private List<Share> shares=new ArrayList<Share>();
	/**
	 * get method of name;
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * <p> this is set property of name.</p>
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>this is get property method of shares</p>
	 * @return
	 */
	public List<Share> getShares() {
		return shares;
	}
	/**
	 * <p>get shares method of company</p>
	 * @param shares
	 */
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
	
	
}
