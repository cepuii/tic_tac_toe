package academy.devonline.tictactoe.model;

public class GameTable {
  
  private final char[][] table = {
      {' ', ' ', ' '},
      {' ', ' ', ' '},
      {' ', ' ', ' '}
  };
  
  public boolean isEmpty(final Cell cell){
    return table[cell.row()][cell.col()] == ' ';
  }
  
  public char getSign(final Cell cell){
    return table[cell.row()][cell.col()];
  }
  
  public void setSign(final Cell cell, final char sign){
    table[cell.row()][cell.col()] = sign;
  }
  record Cell(int row, int col){}
}
