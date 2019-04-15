package com.Strings;

public class Buff {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Hello ");
		sb.append("Java");// now original string is changed
		System.out.println(sb);// prints Hello Java
		
		StringBuilder sb1=new StringBuilder("Hello");
		sb1.insert(1, "java");
		System.out.println(sb1);
		
		StringBuffer s=new StringBuffer("Hello");
		s.replace(1, 1, "java");
		System.out.println(s);
		
		StringBuilder s1=new StringBuilder("Hello");
		s1.delete(1, 3);
		System.out.println(s1);
		
		StringBuffer s2=new StringBuffer("Hello");
		s2.reverse();
		System.out.println(s2);
		
		StringBuilder s3=new StringBuilder();
		System.out.println(s3.capacity());
		s3.append("java is my favourite language");
		System.out.println(s3.capacity());
		
		StringBuilder s4=new StringBuilder("Hello");
		System.out.println(s4.capacity());
		
		StringBuilder s5=new StringBuilder();
		System.out.println(s5.capacity());
		s5.append("Namskara guruuuuu");
		System.out.println(s5.capacity());
		
		s5.ensureCapacity(10);
		System.out.println(s5.capacity());
		
		s5.ensureCapacity(60);
		System.out.println(s5.capacity());
		
		
	}
}
