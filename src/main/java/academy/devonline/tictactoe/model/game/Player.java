package academy.devonline.tictactoe.model.game;

import academy.devonline.tictactoe.component.Move;

public class Player {
  
  private final Sign sign;
  
  private final Move move;
  
  public Player(Sign sign, Move move) {
    this.sign = sign;
    this.move = move;
  }
  
  public Sign getSign() {
    return sign;
  }
  
  public void makeMove(GameTable gameTable) {
    System.out.printf("Player \"%S\" moves\n", sign.name());
    move.make(gameTable, sign);
  }
  
  @Override
  public String toString() {
    return "'" + sign + "'";
  }
}
