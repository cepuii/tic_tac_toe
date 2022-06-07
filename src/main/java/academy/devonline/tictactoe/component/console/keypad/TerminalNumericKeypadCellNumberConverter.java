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
    return new Cell(number / 3, number % 3);
  }
  
  @Override
  public char toNumber(Cell cell) {
    return (char) ('0' + ((cell.getRow() * 3) + (cell.getCol() + 1)));
  }
}
