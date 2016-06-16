    class BaseClass {
    public static void main(String[] args){
     
    class DecorationClass1 extends BaseClass {
        private final BaseClass delegate;
        DecorationClass1(BaseClass d) {
            delegate = d;
        }
        
    }
     
    class DecorationClass2 extends BaseClass {
        private final BaseClass delegate;
        DecorationClass2(BaseClass d) {
            delegate = d;
        }
        
    }
    
    }
    }
    