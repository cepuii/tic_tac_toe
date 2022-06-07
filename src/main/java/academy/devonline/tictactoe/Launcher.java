package academy.devonline.tictactoe;

import academy.devonline.tictactoe.component.Game;
import academy.devonline.tictactoe.component.GameFactory;

public class Launcher {
  
  public static void main(String[] args) {
//    GameFactory gameFactory = new GameFactory(args);
//    GameFactory gameFactory = new GameFactory(new String[]{"user", "COMPUTER"});
//    GameFactory gameFactory = new GameFactory(new String[]{"COMPUTER" ,"USER", "COMPUTER"});
//    GameFactory gameFactory = new GameFactory(new String[]{"COMPUTER", "COMPUTER"});
    GameFactory gameFactory = new GameFactory(
        new String[]{"COMPUTER", "adc", "as", "COMPUTER", "computer"});
    Game game = gameFactory.create();
    game.play();
  }
}
