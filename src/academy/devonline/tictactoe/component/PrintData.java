package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;

public class PrintData {
  
  CellNumberConverter cellNumberConverter;
  
  public PrintData(CellNumberConverter cellNumberConverter) {
    this.cellNumberConverter = cellNumberConverter;
  }
  
  public void printMappingTable() {
    char[][] table = cellNumberConverter.getMappingTable();
    printGameTable(new GameTable(table));
  }
  
  public void printGameTable(final GameTable gameTable) {
    char[][] table = gameTable.getTable();
    StringBuilder stringBuilder = new StringBuilder("-------------\n");
    for (char[] chars : table) {
      stringBuilder.append("| ").append(chars[0]).append(" | ")
          .append(chars[1]).append(" | ")
          .append(chars[2]).append(" |\n");
      stringBuilder.append("-------------\n");
    }
    System.out.println(stringBuilder);
  }
}
