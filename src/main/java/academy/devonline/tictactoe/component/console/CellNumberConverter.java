package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.model.game.Cell;

public interface CellNumberConverter {
  
  char[][] getMappingTable();
  
  Cell toCell(char number);
  
  char toNumber(Cell cell);
}
