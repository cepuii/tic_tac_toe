package academy.devonline.tictactoe.model;

import java.util.Arrays;

public class GameTable {
  
  private final char[][] table = {
      {' ', ' ', ' '},
      {' ', ' ', ' '},
      {' ', ' ', ' '}
  };
  
  public boolean isEmpty(final Cell cell) {
    return table[cell.row()][cell.col()] == ' ';
  }
  
  public char[][] getTable() {
    return table;
  }
  
  public char getSign(final Cell cell) {
    return table[cell.row()][cell.col()];
  }
  
  public void setSign(final Cell cell, final char sign) {
    table[cell.row()][cell.col()] = sign;
  }
  
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Table=");
    for (char[] chars : table) {
      sb.append(Arrays.toString(chars));
    }
    sb.append('}');
    return sb.toString();
  }
  
  public record Cell(int row, int col) {
  
    @Override
    public String toString() {
      return "Cell{" +
          "row=" + row +
          ", col=" + col +
          '}';
    }
  }
}
