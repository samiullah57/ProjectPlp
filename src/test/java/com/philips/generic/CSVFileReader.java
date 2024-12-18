package com.philips.generic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

/**
 * For reading csv file contents
 * @author M1048601
 *
 */
public class CSVFileReader {

	// Java code to illustrate reading a 
	// CSV file line by line 
	public static List<String[]> readDataLineByLine(String file) 
	{ 

		try { 

			// Create an object of filereader 
			// class with CSV file as a parameter. 
			FileReader filereader = new FileReader(file); 
			List<String[]> data = new ArrayList<String[]>(); 
			// create csvReader object passing 
			// file reader as a parameter 
			CSVReader csvReader = new CSVReader(filereader); 
			String[] nextRecord; 

			// we are going to read data line by line 
			while ((nextRecord = csvReader.readNext()) != null) { 
				data.add(nextRecord);
				for (String cell : nextRecord) { 
					System.out.print(cell + ":Data"); 
				} 
			} 
			return data;
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return null;
	} 
	// Java code to illustrate reading a 
	// all data at once 
	public static List<String[]> readAllDataAtOnce(String file) 
	{ 
		try { 
			List<String[]> allData;
			FileReader filereader = new FileReader(file); 

			// create csvReader object and skip first Line 
			CSVReader csvReader = new CSVReaderBuilder(filereader) 
					.withSkipLines(1) 
					.build(); 
			allData = csvReader.readAll(); 

			// print Data 
			for (String[] row : allData) { 
				for (String cell : row) { 
					System.out.print(cell + ":TAN"); 
				} 
				System.out.println(); 
			} 
			return allData;
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		}
		return null; 

	} 

	public static void writeDataLineByLine(String filePath) 
	{ 
		// first create file object for file placed at location 
		// specified by filepath 
		File file = new File(filePath); 
		try { 
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 
			CSVWriter writer = new CSVWriter(outputfile); 

			// adding header to csv 
			String[] header = { "Name", "Class", "Marks" }; 
			writer.writeNext(header); 

			// add data to csv 
			String[] data1 = { "Aman", "10", "620" }; 
			writer.writeNext(data1); 
			String[] data2 = { "Suraj", "10", "630" }; 
			writer.writeNext(data2); 

			// closing writer connection 
			writer.close(); 
		} 
		catch (IOException e) {  
			e.printStackTrace(); 
		} 
	} 
	public static void writeDataAtOnce(String filePath,List<String[]> csvData) 
	{ 

		// first create file object for file placed at location 
		// specified by filepath 
		File file = new File(filePath); 

		try { 
			// create FileWriter object with file as parameter 
			FileWriter outputfile = new FileWriter(file); 

			// create CSVWriter object filewriter object as parameter 
			CSVWriter writer = new CSVWriter(outputfile); 

			//List<String[]> data = new ArrayList<String[]>(); 
		//	data.add(new String[] { "Name", "Class", "Marks" }); 
		//	data.add(new String[] { "Aman", "10", "620" }); 
		//	data.add(new String[] { "Suraj", "10", "630" }); 
			writer.writeAll(csvData); 

			// closing writer connection 
			writer.close(); 
		} 
		catch (IOException e) {  
			e.printStackTrace(); 
		} 
	} 

}
