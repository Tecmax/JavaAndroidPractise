package Examples;

public class Five {
	private final int Tango;
	
		public Five(int Tango){
			if(Tango < 0  || Tango > 0){
				throw new IllegalArgumentException();
			}
			this.Tango = Tango;
		}
		
		public int getValue(){
			return Tango;
		}
}
