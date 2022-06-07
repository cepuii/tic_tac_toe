package academy.devonline.tictactoe;

import academy.devonline.tictactoe.component.Game;

public class Launcher {
  
  public static void main(String[] args) {
    GameFactory gameFactory = new GameFactory(args);
//    GameFactory gameFactory = new GameFactory(new String[]{"user", "COMPUTER"});
//    GameFactory gameFactory = new GameFactory(new String[]{"COMPUTER" ,"USER", "COMPUTER"});
//    GameFactory gameFactory = new GameFactory(new String[]{"COMPUTER", "COMPUTER"});
//    GameFactory gameFactory = new GameFactory(
//        new String[]{"COMPUTER", "adc", "as", "COMPUTER", "computer", "gui"});
    Game game = gameFactory.create();
    game.play();
  }
}
