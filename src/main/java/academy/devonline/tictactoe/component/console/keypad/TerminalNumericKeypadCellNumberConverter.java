package academy.devonline.tictactoe.component.console.keypad;

import academy.devonline.tictactoe.component.console.CellNumberConverter;
import academy.devonline.tictactoe.model.game.Cell;

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
  public Cell toCell(char number) {
    checkNumber(number);
    return new Cell(number / 3, number % 3);
  }
  
  private void checkNumber(char number) {
    if (number < '1' || number > '9') {
      throw new IllegalArgumentException(
          String.format("Out of range [1:9], number = %c", number));
    }
  }
  
  @Override
  public char toNumber(Cell cell) {
    char number = (char) ('0' + ((cell.getRow() * 3) + (cell.getCol() + 1)));
    checkNumber(number);
    return number;
  }
}
