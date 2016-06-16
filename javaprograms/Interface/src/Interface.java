interface MyInterface {
    public void teacher();
    public void student();
}
class School implements MyInterface{
   public void teacher(){
            System.out.println("can teach");
        }
    @Override
        public void student(){
            System.out.println("can listen and learn");
        }
  public static void main(String[] args) {
     MyInterface A=new School();
     A.student();
     A.teacher();
    }

}
