package com.Strings;

import java.util.Locale;

public class StringFormatting {
public static void main(String[] args) {
	double e=Math.E;
	System.out.format("%f%n", e);
	System.out.format(Locale.GERMANY, "%-10.4f%n%n", e);
}
}
