package Rectangle;

public class Rectangle {
    //state
    private int length;
    private int width;

    //creation
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    //operations 
    public int area() {
        return length * width;
    }
    public int perimeter() {
        return 2 * (length + width); 
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", area="+ area()+
                ", perimeter="+ perimeter()+
                '}';
    }
}
