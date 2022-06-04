package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;

public interface Move {
  
  void make(GameTable gameTable, Sign sign);
}
