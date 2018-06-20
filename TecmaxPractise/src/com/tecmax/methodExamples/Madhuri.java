package com.tecmax.methodExamples;

public class Madhuri {
	public static void main(String[] args) {
		Madhuri madhuri = new Madhuri();
		madhuri.getFriendsList("Nandini");
		 int count =getAllFriendsCount();
		 System.out.println(count);
	}

	public static int getAllFriendsCount() {
		return 10;
	}

	private void getFriendsList(String string) {
		System.out.println(string +" is Madhuri Friend");
	}
}
