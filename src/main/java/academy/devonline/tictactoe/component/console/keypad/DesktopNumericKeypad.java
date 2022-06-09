package academy.devonline.tictactoe.component.console.keypad;

import academy.devonline.tictactoe.component.console.CellNumberConverter;
import academy.devonline.tictactoe.model.game.Cell;

public class DesktopNumericKeypad implements CellNumberConverter {
  
  private static final char[][] mappingTable = {
      {'7', '8', '9'},
      {'4', '5', '6'},
      {'1', '2', '3'}
  };
  
  public char[][] getMappingTable() {
    return mappingTable;
  }
  
  @Override
  public Cell toCell(final char number) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (mappingTable[i][j] == number) {
          return new Cell(i, j);
        }
      }
    }
    throw new IllegalArgumentException(
        String.format("Something wrong Cell with %c isn't exist", number));
  }
  
  @Override
  public char toNumber(Cell cell) {
    try {
      return mappingTable[cell.getRow()][cell.getCol()];
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException(String.
          format("Wrong row or col number %d, %d, bounds is from  [1;3]",
              cell.getRow(), cell.getCol()));
    }
  }
}
