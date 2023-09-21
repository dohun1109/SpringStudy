package inheritance;

public class GameRunner {
    public static void main(String[] args) {
        GamingConsole[] games = {new marioGame(), new ChessGame()};


        for (GamingConsole game : games) {
            game.up();
            game.down();
            game.left();
            game.right();
        }

//        marioGame game  =new marioGame();
//        game.up();
//        game.down();
//        game.left();
//        game.right();
//
//        ChessGame Cgame = new ChessGame();
//        Cgame.up();
//        Cgame.down();
//        Cgame.left();
//        Cgame.right();
    }
}
