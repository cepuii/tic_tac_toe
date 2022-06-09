package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;
import java.util.Random;

public class ComputerMove implements Move {
  
  @Override
  public void make(final GameTable gameTable, final Sign sign) {
    final Cell[] emptyCells = new Cell[9];
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        final Cell cell = new Cell(i, j);
        if (gameTable.isEmpty(cell)) {
          emptyCells[count++] = cell;
        }
      }
    }
    if (count > 0) {
      final Cell randomCell = emptyCells[new Random().nextInt(count)];
      gameTable.setSign(randomCell, sign);
    } else {
      throw new IllegalArgumentException("Game table does not contain any empty cell!");
    }
  }
}
