package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;
import java.util.Random;

public class ComputerMove implements Move {
  
  @Override
  public void make(final GameTable gameTable, Sign sign) {
    while (true) {
      int number = new Random().nextInt(9);
      int row = number / 3;
      int col = number % 3;
      Cell cell = new Cell(row, col);
      if (gameTable.isEmpty(cell)) {
        gameTable.setSign(cell, sign);
        return;
      }
    }
  }
}
