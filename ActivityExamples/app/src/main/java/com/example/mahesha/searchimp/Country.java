package com.example.mahesha.searchimp;

import com.example.mahesha.activityexamples.R;

/** Country details are stored in this class and is used to populate the table countries
	 * in CountryDb.java
	 */
	public class Country {
		 // Array of strings storing country names
	    static String[] countries = new String[] {
	            "India",
	            "Pakistan",
	            "Sri Lanka",
	            "China",
	            "Bangladesh",
	            "Nepal",
	            "Afghanistan",
	            "North Korea",
	            "South Korea",
	            "Japan"
	    };
	    
	    // Array of integers points to images stored in /res/drawable
	    static int[] flags = new int[]{
	                R.drawable.india,
	                R.drawable.pakistan,
	                R.drawable.srilanka,
	                R.drawable.china,
	                R.drawable.bangladesh,
	                R.drawable.nepal,
	                R.drawable.afghanistan,
	                R.drawable.nkorea,
	                R.drawable.skorea,
	                R.drawable.japan
	    };
	    
	    // Array of strings to store currencies
	    static String[] currency = new String[]{
	        "Indian Rupee",
	        "Pakistani Rupee",
	        "Sri Lankan Rupee",
	        "Renminbi",
	        "Bangladeshi Taka",
	        "Nepalese Rupee",
	        "Afghani",
	        "North Korean Won",
	        "South Korean Won",
	        "Japanese Yen"
	    };
}