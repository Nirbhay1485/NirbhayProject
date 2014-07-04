package com.nir.csv.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

import com.csvreader.CsvReader;

public class CSVParser {

	private static Company[] complist;
	private static int noComp = 0;
	private static long noRecds = 0;

	/**
	 * This method parse csv File.
	 * @param csvPath
	 */
	public static void parseCSV(String csvPath) {

		boolean flag = true;

		try {
			CsvReader products = new CsvReader(csvPath);
			products.readHeaders();
			String[] headers = products.getHeaders();
			complist = new Company[headers.length - 2];
			noComp = headers.length - 2;
			
			Share share = null;
			for (int i = 2; i < headers.length; i++) {
				complist[i - 2] = new Company();
			}

			while (products.readRecord()) {
				noRecds++;
				for (int i = 2; i < headers.length; i++) {

					share = new Share();
					share.setMonth(products.get("Month"));
					share.setYear(products.get("Year"));
					share.setSharePrice(products.get(headers[i]));
					if (flag) {
						complist[i - 2].setName(headers[i]);
					}
					complist[i - 2].getShares().add(share);

				}

				flag = false;

			}

			products.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		

	}
	/**
	 * This method shows maximum share value of each company.
	 */
	public static String getMaxShare(){
		String data="";
		for (int i = 0; i < noComp; i++) {
			Company comp = complist[i];
			Collections.sort(comp.getShares());
			Share share = comp.getShares().get((int) noRecds - 1);

			data+= "CompanyName: " + comp.getName() + "  Year: "
					+ share.getYear() + "  Month: " + share.getMonth()
					+ "  ShareValue: " + share.getSharePrice()+",";
			
		}
		
		return data.substring(0, data.length()-1);
	}
}
