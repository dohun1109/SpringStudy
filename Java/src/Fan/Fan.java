package Fan;

public class Fan {
    // 객체를 구성할때는 항상 사용자가 객체에대해 어떻게 생각할지 , 어떤 메소드가 이러한 객체를 사용하기 쉽게 할지 고민해야된다.
    //즉, 비즈니스적으로 고민하고 코드를 작성해야한다 . -effective java
    //State
    // essential Member
    private String make;    //제조사
    private double radius;     //fan 지름

    //print the state
    @Override
    public String toString() {
        return "Fan{" +
                "make='" + make + '\'' +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                ", isOn=" + isOn +
                ", Speed=" + Speed +
                '}';
    }
    

    private String color;


    private boolean isOn;   //ON,OFF
    private byte Speed ; //0~5

    //사용자 정의 생성자
    public Fan(String make, double radius, String color) {
        this.make = make;
        this.radius = radius;
        this.color = color;
    }
    //isOn method
//    public void isOn(boolean isOn) {
//        this.isOn = isOn;   //매개변수로 true or false 를 넘겨주면 member save
//    }
    

    // 사용자 관점에서 메소드를 생성 해야 한다 . -clean Code 
    public void switchOn(){
        this.isOn = true;
    }
    public void switchOff() {
        this.isOn = false;
        setSpeed((byte)0);
    }

    public void setSpeed(byte speed) {
        this.Speed = speed;
    }


}
