package ifloop;
public class Switch {
    public static void main(String[] args){
    int a=10,x=10,y=20;
    for(int i=1;i<5;i++){
    switch (i){  
  case 1:
 System.out.println("Enter the number one=" + (x+y));
 break;
  case 2:
  System.out.println("Enter the number two=" + (x-y));
  break;
  case 3:
  System.out.println("Enetr the number three="+ (x*y));
 continue;
  case 4:
  System.out.println("Enter the number four="+ (x/y));
  break;
  default:
  System.out.println("Invalid Entry!");
  }
  }
    }
}

