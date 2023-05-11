package inheritance;

public class marioGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("jump");
    }

    @Override
    public void down() {
        System.out.println("Goes in to a hole");
    }

    @Override
    public void left() {
        System.out.println("GO Fired");
    }

    @Override
    public void right() {

    }
}
