package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.CellNumberConverter;
import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;

public class ConsoleDataPrinter implements DataPrinter {
  
  final CellNumberConverter cellNumberConverter;
  
  public ConsoleDataPrinter(CellNumberConverter cellNumberConverter) {
    this.cellNumberConverter = cellNumberConverter;
  }
  
  @Override
  public void printInfoMessage(String message) {
    System.out.println(message);
  }
  
  @Override
  public void printErrorMessage(String message) {
    System.err.println(message);
  }
  
  public void printMappingTable() {
    print(((i, j) -> String.valueOf(cellNumberConverter.toNumber(new Cell(i, j)))));
  }
  
  public void printGameTable(final GameTable gameTable) {
    print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));
  }
  
  private void print(final Lambda lambda) {
    StringBuilder stringBuilder = new StringBuilder("-------------\n");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        stringBuilder.append("| ").append(lambda.getValue(i, j)).append(" ");
      }
      stringBuilder.append("|\n");
      stringBuilder.append("-------------\n");
    }
    System.out.println(stringBuilder);
  }
  
  @FunctionalInterface
  private interface Lambda {
    
    String getValue(int i, int j);
  }
}
