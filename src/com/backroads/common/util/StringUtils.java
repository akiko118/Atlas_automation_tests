package com.backroads.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
	
	public static Date toStringMMddyyyWithSlash(String slashedMMddyyyy) {

	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {
			return formatter.parse(slashedMMddyyyy);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	

	public static String [] increasedNumValues(double increaseBy, String [] values) {
		String [] changedValues = new String[values.length];
		try {
			for (int i = 0; i < values.length; i++) {
				if (!values[i].equals("0")) {
					changedValues[i] = String.valueOf(Double.parseDouble(values[i]) + increaseBy);
				} else {
					changedValues[i] = values[i];
				}
			}
		} catch (Exception e) {
		    System.out.println("Non numeric value may be included in the array.");
			return null;
		}
		return changedValues;
	}
	
	
}
