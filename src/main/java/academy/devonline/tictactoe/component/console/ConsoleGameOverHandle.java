package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.GameOverHandle;

public class ConsoleGameOverHandle implements GameOverHandle {
  
  private final DataPrinter printer;
  
  public ConsoleGameOverHandle(DataPrinter printer) {
    this.printer = printer;
  }
  
  @Override
  public void gameOver() {
    printer.printInfoMessage("GAME OVER!");
  }
}
