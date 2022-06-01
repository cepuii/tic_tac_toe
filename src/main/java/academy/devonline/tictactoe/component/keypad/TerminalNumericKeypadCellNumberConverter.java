package academy.devonline.tictactoe.component.keypad;

import academy.devonline.tictactoe.component.CellNumberConverter;
import academy.devonline.tictactoe.model.GameTable.Cell;

public class TerminalNumericKeypadCellNumberConverter implements CellNumberConverter {
  
  private static final char[][] mappingTable = {
      {'1', '2', '3'},
      {'4', '5', '6'},
      {'7', '8', '9'}
  };
  
  @Override
  public char[][] getMappingTable() {
    return mappingTable;
  }
  
  @Override
  public Cell convertToCell(int number) {
    return new Cell(number / 3, number % 3);
  }
}
