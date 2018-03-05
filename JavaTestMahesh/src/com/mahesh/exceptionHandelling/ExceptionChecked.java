package com.mahesh.exceptionHandelling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionChecked {
	public static void main(String args[]){
		String content = "Hello Harsha";
		String path = "C:/Tecmax/harsha.txt";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println("no File Found");
		}
		int k;
		try {
			File file = new File(path);
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");
			
//			if (fis!=null) {
				while ((k = fis.read()) != -1) {
					System.out.print((char) k);
				}
				fis.close();
//			}else {
//				System.out.println("Reinitilize");
//			}
			
		} catch (IOException ioe) {
			System.out.println("I/O error occurred: ");
			ioe.printStackTrace();

		}catch (NullPointerException e) {
System.out.println("Please Re Initilize");		}
	}
}
