class Methodoveloadin {
   void marks(int a,int b){
       int result;
       result=a+b;
        System.out.println("sum is"+result);
       }
    void marks(double a,int b,int c){
      double result;
       result=a+b+c;
        System.out.println("different datatypes"+result);
    }
 void marks(int a){
        System.out.println("value is"+a);
}
public static void main(String[] args) {
    Methodoveloadin obj=new Methodoveloadin();
    obj.marks(10,20);
    obj.marks(10.23,20,30);
    obj.marks(30,40);
}
}
       
    