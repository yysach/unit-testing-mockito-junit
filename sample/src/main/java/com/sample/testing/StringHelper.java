package com.sample.testing;

public class StringHelper {

	public String truncateAFromFirstTwoPosition(String str) {
		if (str.length() <= 2) {
			return str.replace("A", "");
		}

		String first2Chars = str.substring(0, 2);
		String restString = str.substring(2);

		return first2Chars.replace("A", "") + restString;
	}
	
	public boolean checkFirstAndLastTwoCharactersAreSame(String str) {
		if(str.length() == 0) {
			return true;
		}else if(str.length() <=1) {
			return false;
		}else if(str.length() == 2) {
			return true;
		}
		
		String firstTwoChars = str.substring(0,2);
		String lastTwoChars = str.substring(str.length()-2);
		return firstTwoChars.equalsIgnoreCase(lastTwoChars);
	}

}
