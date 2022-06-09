package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.GameOverHandle;
import java.util.Scanner;

public class ConsoleGameOverHandle implements GameOverHandle {
  
  private final DataPrinter printer;
  
  public ConsoleGameOverHandle(DataPrinter printer) {
    this.printer = printer;
  }
  
  @Override
  public void gameOver() {
    printer.printInfoMessage("GAME OVER!");
    printer.printInfoMessage("Press any key...");
    new Scanner(System.in).nextLine();
  }
}
