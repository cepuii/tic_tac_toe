package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;

public interface CellNumberConverter {
  
  char[][] getMappingTable();
  
  Cell toCell(char number);
  
  char toNumber(Cell cell);
}
