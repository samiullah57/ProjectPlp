package com.philips.generic;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Snippet {

	static boolean isRenamed = false;
	public static void main(String[] args) throws Exception 
	{
		//SOQLQuerys.getProductID("US ValuePM Service Plan");

		FileRenameUtility(AutomationConstants.DownloadsFolder, "Smax_Partner_Report");
	}
	
	public static void FileRenameUtility(String path, String fileName){
		File file = new File(path);
	    System.out.println("Reading this "+file.toString());
		 if(file.isDirectory())
		    {
			 	File[] files = file.listFiles();
		        List<File> filelist = Arrays.asList(files);
		        filelist.forEach(f->{
		        	System.out.println("------------------");
		           if(!f.isDirectory() && f.getName().startsWith("report")){
		        	   System.out.println("------------------");
		        	   System.out.println("getAbsolutePath" +f.getAbsolutePath());
		               String temp = f.getName();
		               String newName = f.getAbsolutePath().replace(temp,fileName+".xlsx");
		               try
		               {
		            	   f.renameTo(new File(newName));
		            	    isRenamed = true;
		               }
		               catch(Exception e)
		               {
		            	   System.out.println("Unable to rename file");
		               }

//		               if(isRenamed)
//		                   System.out.println(String.format("Renamed this file %s to  %s",f.getName(),newName));
//		               else
//		                   System.out.println(String.format("%s file is not renamed to %s",f.getName(),newName));

		           }

	           }
		        );
	
		    }
		 }
}

