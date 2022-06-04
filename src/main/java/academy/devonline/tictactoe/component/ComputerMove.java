package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;
import java.util.Random;

public class ComputerMove {
  
  public void make(final GameTable gameTable) {
    while (true) {
      int number = new Random().nextInt(9);
      int row = number / 3;
      int col = number % 3;
      Cell cell = new Cell(row, col);
      if (gameTable.isEmpty(cell)) {
        gameTable.setSign(cell, Sign.O);
        return;
      }
    }
  }
}
