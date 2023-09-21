package JavaInterfaceEx;

interface FlyAble{
    void fly();
}
class Bird implements FlyAble{

    @Override
    public void fly() {
        System.out.println("with wings"); 
    }
}
class Aeroplane implements FlyAble{

    @Override
    public void fly() {
        System.out.println("with fuel");
    }
}

public class FlyableRunner {
    public static void main(String[] args) {
        FlyAble[] flyingObject = {new Bird(),new Aeroplane()};
        for (FlyAble object : flyingObject) {
             object.fly();  
        }
    }
}
