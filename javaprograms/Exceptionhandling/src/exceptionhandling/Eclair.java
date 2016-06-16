package exceptionhandling;
public class Eclair {
   private final int value;

	public Eclair(int value) {
		if (value < 0 || value > 100) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
