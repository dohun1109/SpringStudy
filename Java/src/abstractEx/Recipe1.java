package abstractEx;

public class Recipe1 extends AbstractRecipe{

    @Override
    void getReady() {
        System.out.println("Recipe1");
        System.out.println("Get the raw materials");
        System.out.println("Get the utensils");

    }

    @Override
    void doTheDish() {
        System.out.println("do the dish");

    }

    @Override
    void cleanup() {
        System.out.println("CleanUp the utensils");
    }
}
