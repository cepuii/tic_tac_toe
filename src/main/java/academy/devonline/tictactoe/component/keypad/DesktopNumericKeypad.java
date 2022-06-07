package academy.devonline.tictactoe.component.keypad;

import academy.devonline.tictactoe.component.CellNumberConverter;
import academy.devonline.tictactoe.model.Cell;

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
    return null;
  }
  
  @Override
  public char toNumber(Cell cell) {
    return mappingTable[cell.getRow()][cell.getCol()];
  }
}
