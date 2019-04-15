package com.Strings;

public class StringRegionMatch {
public static void main(String[] args) {
	String fs="I work in microsoft! and accenture";
	String sc="I sleep in microsoft! and infosys";
	boolean match=fs.regionMatches(7,sc, 8,12);
	System.out.println(match);
	
}
}
