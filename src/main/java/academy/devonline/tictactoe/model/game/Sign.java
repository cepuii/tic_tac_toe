package academy.devonline.tictactoe.model.game;

public enum Sign {
  X,
  O,
  EMPTY;
  
  @Override
  public String toString() {
    return this != EMPTY ? name() : " ";
  }
}
