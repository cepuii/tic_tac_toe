package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.Cell;

public interface CellNumberConverter {
  
  char[][] getMappingTable();
  
  Cell convertToCell(int number);
  
  int toNumber(Cell cell);
}
