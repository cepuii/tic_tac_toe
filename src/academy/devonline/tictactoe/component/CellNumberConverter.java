package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable.Cell;

public class CellNumberConverter {
  
  private static final char[][] mappingTable = {
      {'7', '8', '9'},
      {'4', '5', '6'},
      {'1', '2', '3'}
  };
  
  public static char[][] getMappingTable() {
    return mappingTable;
  }
  
  public static Cell convertToCell(int number) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (mappingTable[i][j] == Character.forDigit(number, 10)) {
          return new Cell(i, j);
        }
      }
    }
    return new Cell(0, 0);
  }
}
