package Abstraction;

abstract class MobileOs {
	abstract int version();
	abstract String ver_name();
	void String(){
		System.out.println("This class is about android versions");
	}
}
public class Android extends MobileOs{
	public static void main(String[] args) {
		Android mob = new Android();
		mob.String();		
		mob.ver_name();
		mob.version();
	}

	@Override
	String ver_name() {
		System.out.println("name of the version");
		return null;
	}

	@Override
	int version() {
		System.out.println("number of the version");
		return 0;
	}
}