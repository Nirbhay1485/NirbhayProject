package com.nir.csv.parser;

import java.util.ArrayList;
import java.util.List;

public class Company{

	private String name;
	private List<Share> shares=new ArrayList<Share>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Share> getShares() {
		return shares;
	}
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	
	
	
}
