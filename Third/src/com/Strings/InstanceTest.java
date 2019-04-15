package com.Strings;

public class InstanceTest {
	public static void main(String args[]) {
		System.out.println("Hashcode test of String:");
		String str = "java";
		System.out.println(str.hashCode());
		str = str + "tpoint";
		System.out.println(str.hashCode());
		str=str+"f";
		System.out.println(str.hashCode());

		System.out.println("Hashcode test of StringBuffer:");
		StringBuffer sb = new StringBuffer("java");
		System.out.println(sb.hashCode());
		sb.append("tpoint");
		System.out.println(sb.hashCode());
		
		System.out.println("Hashcode test of StringBuffer:");
		StringBuilder sb1 = new StringBuilder("java");
		System.out.println(sb1.hashCode());
		sb1.append("tpoint");
		System.out.println(sb1.hashCode());
		
	}
}
