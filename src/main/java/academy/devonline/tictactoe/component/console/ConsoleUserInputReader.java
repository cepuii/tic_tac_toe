package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.UserInputReader;
import academy.devonline.tictactoe.model.game.Cell;
import java.util.Scanner;

public class ConsoleUserInputReader implements UserInputReader {
  
  private final CellNumberConverter cellNumberConverter;
  private final DataPrinter printer;
  
  public ConsoleUserInputReader(final CellNumberConverter cellNumberConverter,
      final DataPrinter printer) {
    this.cellNumberConverter = cellNumberConverter;
    this.printer = printer;
  }
  
  @Override
  public Cell getUserInput() {
    while (true) {
      printer.printInfoMessage("Please type number between 1 and 9:");
      final String userInput = new Scanner(System.in).nextLine();
      if (userInput.length() == 1) {
        final char ch = userInput.charAt(0);
        if (ch >= '1' && ch <= '9') {
          return cellNumberConverter.toCell(ch);
        }
      }
    }
  }
}
