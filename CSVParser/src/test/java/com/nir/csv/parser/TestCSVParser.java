package com.nir.csv.parser;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

/**
 * <P>
 * Test class of CSVParser class.
 * </p>
 * 
 * @author nirbhay
 * 
 */
public class TestCSVParser {

	
	/**
	 * <p>
	 * This unit test method doesn't expect any error. 
	 * this runs when everything is fine, 
	 * parseCSV() expects one valid csv file path.
	 * </p>
	 */
	@Test
	public void test1CSVParser() throws Exception {
		Company[] list = CSVParser.parseCSV("./src/test/resources/shares.csv");
		Assert.assertNotNull(CSVParser.getMaxShare(list));

	}
	
	
	/**
	 * <p>
	 * This unit test method does expect FileNotFoundException. 
	 * this runs when file not found at provided path, 
	 * parseCSV() expects one invalid csv file path.
	 * </p>
	 */
	@Test(expected = FileNotFoundException.class)
	public void test2CSVParser() throws Exception {

		Company[] list = CSVParser.parseCSV("./src/test/resources/share.csv");
		Assert.assertNotNull(CSVParser.getMaxShare(list));

	}


	/**
	 * <p>
	 * This unit test method does expect NullPointerException. 
	 * This runs when Company object null, 
	 * parseCSV() expects one valid csv file path.
	 * </p>
	 */
	@Test(expected = NullPointerException.class)
	public void test3CSVParser() throws NullPointerException {
		Company[] list = null;
		Assert.assertNotNull(CSVParser.getMaxShare(list));

	}
	
	/**
	 * <p>
	 * This unit test method does expect ArrayIndexOutOfBoundsException. 
	 * This runs when csv file has no records, 
	 * parseCSV() expects one valid csv file path.
	 * </p>
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test4CSVParser() throws ArrayIndexOutOfBoundsException {
		Company[] list = {new Company()};
		Assert.assertNotNull(CSVParser.getMaxShare(list));

	}
}
