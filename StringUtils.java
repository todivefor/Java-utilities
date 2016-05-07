package org.todivefor.string.utils;

import java.text.DecimalFormatSymbols;

public class StringUtils 
{
	
/**
 * Method determines if input string is an integer
 * Method is overloaded, accepts isInteger(String s)
 * 		or isInteger(String s, int radix)
 * @param s
 * @return
 */
	
	public static boolean isInteger(String s) 
	{
		return isInteger(s,10);
	}

	public static boolean isInteger(String s, int radix) 
	{
		if(s.isEmpty()) return false;
		for(int i = 0; i < s.length(); i++) 
		{
			if(i == 0 && s.charAt(i) == '-') 
			{
				if(s.length() == 1) return false;
				else continue;
			}
			if(Character.digit(s.charAt(i),radix) < 0) return false;
		}
		return true;
	}
	
/**
 * Method determines if a string is numeric
 * Method uses try/catch which can be CPU intensive
 * May want to consider: isStringNumeric( String str)
 * @param str
 * @return
 */

	public static boolean isNumeric(String str)  
	{  
		try  
		{  
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}
	
/**
 * Method determines if string is numeric without try/catch
 * Treats "" as valid
 * @param str
 * @return
 */

	public static boolean isStringNumeric( String str )
	{
		DecimalFormatSymbols currentLocaleSymbols = DecimalFormatSymbols.getInstance();
		char localeMinusSign = currentLocaleSymbols.getMinusSign();

		if ( !Character.isDigit( str.charAt( 0 ) ) && str.charAt( 0 ) != localeMinusSign ) return false;

		boolean isDecimalSeparatorFound = false;
		char localeDecimalSeparator = currentLocaleSymbols.getDecimalSeparator();

		for ( char c : str.substring( 1 ).toCharArray() )
		{
			if ( !Character.isDigit( c ) )
			{
				if ( c == localeDecimalSeparator && !isDecimalSeparatorFound )
				{
					isDecimalSeparatorFound = true;
					continue;
				}
				return false;
			}
		}
		return true;
	}
}
