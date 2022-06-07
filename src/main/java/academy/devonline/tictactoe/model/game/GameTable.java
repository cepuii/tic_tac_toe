package academy.devonline.tictactoe.model.game;

import static academy.devonline.tictactoe.model.game.Sign.EMPTY;

import java.util.Arrays;

public class GameTable {
  
  private final Sign[][] table;
  
  public GameTable() {
    table = new Sign[][]{
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY}
    };
  }
  
  public GameTable(Sign[][] table) {
    this.table = table;
  }
  
  public boolean isEmpty(final Cell cell) {
    return table[cell.getRow()][cell.getCol()] == EMPTY;
  }
  
  public Sign[][] getTable() {
    return table;
  }
  
  public Sign getSign(final Cell cell) {
    return table[cell.getRow()][cell.getCol()];
  }
  
  public void setSign(final Cell cell, final Sign sign) {
    table[cell.getRow()][cell.getCol()] = sign;
  }
  
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Table=");
    for (Sign[] signs : table) {
      sb.append(Arrays.toString(signs));
    }
    sb.append('}');
    return sb.toString();
  }
  
  
}
