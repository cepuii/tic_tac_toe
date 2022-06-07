package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;

public class ConsoleDataPrinter implements DataPrinter {
  
  final CellNumberConverter cellNumberConverter;
  
  public ConsoleDataPrinter(CellNumberConverter cellNumberConverter) {
    this.cellNumberConverter = cellNumberConverter;
  }
  
  @Override
  public void printInstruction() {
    printInfoMessage(
        "Use the following mapping table to specify a cell using numbers from 1 to 9:");
    print(((i, j) ->
        String.valueOf(cellNumberConverter.toNumber(new Cell(i, j)))));
  }
  
  @Override
  public void printInfoMessage(String message) {
    System.out.println(message);
  }
  
  @Override
  public void printErrorMessage(String message) {
    System.err.println(message);
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
