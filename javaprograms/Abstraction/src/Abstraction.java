  abstract class Mobile {
      abstract void whatsapp();
      
      public void camera(){
          System.out.println("it can take photos and videos");
      }
      public void contacts(){
          System.out.println("it can save contacts");
      }
     }
  class Newmobile extends Mobile{
      public void dualcamera(){
          System.out.println("it can take photos and videos");
      }
         public void quickpic(){
             System.out.println("it can save and backup our pics when lost");
      }

    @Override
    void whatsapp() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  }
 class Mobilefamily{
    public static void main(String[] args) {
       Newmobile m=new Newmobile();
      m.camera();
      m.contacts();
      m.whatsapp();
      m.dualcamera();
      m.quickpic();
    }
 }
  