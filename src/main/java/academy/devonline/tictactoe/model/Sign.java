package academy.devonline.tictactoe.model;

public enum Sign {
  X,
  O,
  EMPTY;
  
  @Override
  public String toString() {
    return this != EMPTY ? name() : " ";
  }
}
