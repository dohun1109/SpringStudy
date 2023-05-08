package abstractEx;

public abstract class AbstractRecipe {

    public void execute() { //실행하다
        getReady();
        doTheDish();
        cleanup();
    }
    abstract void getReady();
    abstract void doTheDish();
    abstract void cleanup();

    //prepare -> 준비과정

    //recipe -> 조리과정

    //cleanup -> 청소
}
