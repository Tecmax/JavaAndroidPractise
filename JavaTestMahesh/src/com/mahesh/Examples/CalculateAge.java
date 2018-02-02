package com.mahesh.Examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalculateAge {
	public static void main(String[] args) {
		System.out.println("Enter The DOB In dd-mm-yyyy Ex: 20-1-1990");
		Scanner scanner = new Scanner(System.in);
		String dobEntered = scanner.nextLine();
		scanner.close();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date birthDate = sdf.parse(dobEntered);
			System.out.println("Date is " + birthDate);
		} catch (ParseException e) {
			// e.printStackTrace();
			System.out.println("Enter Vaild Date");
		} // Yeh !! It's my date of birth
			// :-)
	}
}
