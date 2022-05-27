package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;

public class PrintData {
  
  public void printMappingTable() {
    String MAPPING_TABLE = """
        -------------
        | 7 | 8 | 9 |
        -------------
        | 4 | 5 | 6 |
        -------------
        | 1 | 2 | 3 |
        -------------""";
    System.out.println(MAPPING_TABLE);
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
