package StringHandling;

import java.io.*;

public class ReverseSentence {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a sentence : ");
		String str = br.readLine();
		
		String words[] = str.split(" ");
		System.out.println("Reverse Sentence : ");
		String stringd = " ";
		for(int i=words.length-1;i>=0;i--){
			stringd = words[i]+" ";
			System.out.println(stringd);
		}		
	}
}