package com.nir.csv.parser;

import junit.framework.Assert;

import org.junit.Test;


/**
 * <P></p>
 * @author nirbhay
 *
 */
public class TestCSVParser {

	/**
	 * 
	 */
	@Test
	public void testCSVParser()
	{
		CSVParser.parseCSV("./src/test/resources/shares.csv");
		Assert.assertNotNull(CSVParser.getMaxShare());
		
		
	}
}
