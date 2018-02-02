package com.mahesh.exceptionHandelling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionChecked {
	public static void main(String args[]) {
		String content = "Hello Mahesh";
		String path ="C:/Tecmax/mahesh.txt";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException y) {
			System.out.println("The specified file is not "
					+ "present at the given path " +y);
//			y.printStackTrace();
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
			while ((k = fis.read()) != -1) {
				System.out.print((char) k);
			}
			fis.close();
		} catch (IOException ioe) {
			System.out.println("I/O error occurred: " );
			ioe.printStackTrace();
			
		}
	}
	private void name() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("C:/Softgen/mahesh.txt");
	}
}
