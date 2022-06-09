package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;

public class CellVerifier {
  
  public boolean isCellsFilled(GameTable gameTable) {
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
