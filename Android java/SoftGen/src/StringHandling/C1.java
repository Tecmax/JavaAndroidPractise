package StringHandling;

import java.util.*;

public class C1 {
	public static void main(String[] args) {
		String string,sub;
		int i,c,length;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string to print all it's substrings");
		string = in.nextLine();
		
		length = string.length();
		System.out.println("substring of \""+string+"\" are :-");
		for(c = 0;c < length;c++){
			for(i = 1;i <= length-c;i++){
				sub= string.substring(c,c+i);
				System.out.println(sub);
			}
		}
	}
}
