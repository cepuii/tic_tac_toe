package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;

public class UserMove implements Move {
  
  private final UserInputReader reader;
  private final DataPrinter printer;
  
  public UserMove(UserInputReader reader, DataPrinter printer) {
    this.reader = reader;
    this.printer = printer;
  }
  
  
  @Override
  public void make(final GameTable gameTable, final Sign sign) {
    while (true) {
      final Cell cell = reader.getUserInput();
      if (gameTable.isEmpty(cell)) {
        gameTable.setSign(cell, sign);
        return;
      } else {
        printer.printErrorMessage("Can't make a move, because the cell is not free! Try again");
      }
    }
  }
}
