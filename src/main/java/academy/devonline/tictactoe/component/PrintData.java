package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;

public class PrintData {
  
  final academy.devonline.tictactoe.component.CellNumberConverter cellNumberConverter;
  
  public PrintData(academy.devonline.tictactoe.component.CellNumberConverter cellNumberConverter) {
    this.cellNumberConverter = cellNumberConverter;
  }
  
  public void printMappingTable() {
    char[][] table = cellNumberConverter.getMappingTable();
    StringBuilder stringBuilder = new StringBuilder("-------------\n");
    for (char[] chars : table) {
      stringBuilder.append("| ").append(chars[0]).append(" | ")
          .append(chars[1]).append(" | ")
          .append(chars[2]).append(" |\n");
      stringBuilder.append("-------------\n");
    }
    System.out.println(stringBuilder);
    
  }
  
  public void printGameTable(final GameTable gameTable) {
    Sign[][] table = gameTable.getTable();
    StringBuilder stringBuilder = new StringBuilder("-------------\n");
    for (Sign[] signs : table) {
      stringBuilder.append("| ").append(signs[0]).append(" | ")
          .append(signs[1]).append(" | ")
          .append(signs[2]).append(" |\n");
      stringBuilder.append("-------------\n");
    }
    System.out.println(stringBuilder);
  }
}
