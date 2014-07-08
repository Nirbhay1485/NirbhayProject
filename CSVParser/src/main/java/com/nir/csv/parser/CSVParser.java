package com.nir.csv.parser;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

import com.csvreader.CsvReader;

/**
 * <p>
 * CSV Parser parser parses any csv file but it store data in java object in
 * specific format. To understand the object model you can refer Company.java
 * and Share.java classes that show the csv object model.
 * </p>
 * 
 * @author nirbhay
 * 
 */
public class CSVParser {

	/**
	 * <p>
	 * This method parse csv File and return list of companies with there list
	 * of shares.
	 * </p>
	 * 
	 * @param csvPath
	 * @return
	 * @throws Exception
	 */
	public static Company[] parseCSV(String csvPath) throws Exception {
		Company[] complist = null;
		boolean flag = true;
		try {
			CsvReader csvData = new CsvReader(csvPath);
			csvData.readHeaders();
			String[] headers = csvData.getHeaders();
			complist = new Company[headers.length - 2];

			Share share = null;
			for (int i = 2; i < headers.length; i++) {
				complist[i - 2] = new Company();
			}
			// read record from CsvReader Object
			while (csvData.readRecord()) {

				for (int i = 2; i < headers.length; i++) {

					share = new Share();
					share.setMonth(csvData.get("Month"));
					share.setYear(csvData.get("Year"));
					share.setSharePrice(csvData.get(headers[i]));
					if (flag) {
						complist[i - 2].setName(headers[i]);
					}
					complist[i - 2].getShares().add(share);

				}

				flag = false;

			}

			csvData.close();

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found");
		}

		return complist;

	}

	/**
	 * This method shows maximum share value of each company.
	 */
	public static String getMaxShare(Company[] complist) {
		String data = "";
		for (int i = 0; i < complist.length; i++) {
			Company comp = complist[i];
			List<Share> shares = comp.getShares();
			Collections.sort(shares);
			Share share = comp.getShares().get((int) shares.size() - 1);

			data += "CompanyName: " + comp.getName() + "  Year: "
					+ share.getYear() + "  Month: " + share.getMonth()
					+ "  ShareValue: " + share.getSharePrice() + ",";

		}

		return data.substring(0, data.length() - 1);
	}
}
