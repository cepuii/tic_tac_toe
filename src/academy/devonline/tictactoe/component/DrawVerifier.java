package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.GameTable.Cell;

public class DrawVerifier {
  
  public boolean isDraw(GameTable gameTable) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (gameTable.isEmpty(new Cell(i, j))) {
          return false;
        }
      }
    }
    return true;
  }
}
