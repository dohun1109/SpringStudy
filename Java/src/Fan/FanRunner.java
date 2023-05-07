package Fan;

public class FanRunner {
    public static void main(String[] args) {
        Fan fan = new Fan("manufacturer1", 0.34567, "GREEN");
        System.out.println(fan);

        fan.switchOn();
        fan.setSpeed((byte)5);
        System.out.println(fan);

        fan.switchOff();
        System.out.println(fan);


    }
}
