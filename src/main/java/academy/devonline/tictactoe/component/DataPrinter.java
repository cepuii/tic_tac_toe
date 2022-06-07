package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.GameTable;

public interface DataPrinter {
  
  void printInstruction();
  
  void printInfoMessage(String message);
  
  void printErrorMessage(String message);
  
  void printGameTable(final GameTable gameTable);
}
