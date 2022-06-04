package academy.devonline.tictactoe.model;

import java.util.Arrays;

public class GameTable {
  
  private final char[][] table;
  
  public GameTable() {
    table = new char[][]{
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
  }
  
  public GameTable(char[][] table) {
    this.table = table;
  }
  
  public boolean isEmpty(final Cell cell) {
    return table[cell.getRow()][cell.getCol()] == ' ';
  }
  
  public char[][] getTable() {
    return table;
  }
  
  public char getSign(final Cell cell) {
    return table[cell.getRow()][cell.getCol()];
  }
  
  public void setSign(final Cell cell, final char sign) {
    table[cell.getRow()][cell.getCol()] = sign;
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
  
  
}
