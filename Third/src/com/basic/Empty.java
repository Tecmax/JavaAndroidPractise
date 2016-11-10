package com.basic;

class Bb {
static synchronized public void main(String... args) {
	System.out.println(5);
}

public static void main(int args[]){
	System.out.println("5");
}

public int main(){
	return 0;
}
}

public class Empty extends Bb{
public final static void main(String[] args) {
	System.out.println(9);
}	
	
@Override
public int main() {
	// TODO Auto-generated method stub
	return super.main();
}	
}
