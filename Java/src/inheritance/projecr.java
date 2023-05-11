package inheritance;

public class projecr {

    interface Test{
        void Nothing();
        default void Nothing1(){    //default 
            
        };

    }
    interface Test2{
        void Nothing();

        default void Nothing1() {
            System.out.println("Test2");
        }
    }

    class Class1 implements Test,Test2{

        @Override
        public void Nothing() {
            System.out.println("hello");
        }

        @Override
        public void Nothing1() {
            Test2.super.Nothing1();
        }


    }

    class Class2 implements Test{

        @Override
        public void Nothing() {

        }
    }

    public static void main(String[] args) {
        ComplexAlgorithm algorithm = new DummyAlgorithm();

        System.out.println(algorithm.complexAlgorithm(10, 20));

        
    }
}
