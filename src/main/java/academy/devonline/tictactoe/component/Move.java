package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

public interface Move {
  
  void make(GameTable gameTable, Sign sign);
}
