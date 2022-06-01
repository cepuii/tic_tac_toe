package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable.Cell;

public interface CellNumberConverter {
  
  char[][] getMappingTable();
  
  Cell convertToCell(int number);
}
