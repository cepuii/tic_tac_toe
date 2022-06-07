package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.CellNumberConverter;
import academy.devonline.tictactoe.component.Move;
import academy.devonline.tictactoe.component.UserInputReader;
import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;
import java.util.Scanner;

public class UserMove implements Move, UserInputReader {
  
  private final CellNumberConverter cellNumberConverter;
  
  public UserMove(CellNumberConverter cellNumberConverter) {
    this.cellNumberConverter = cellNumberConverter;
  }
  
  @Override
  public void make(final GameTable gameTable, final Sign sign) {
    while (true) {
      final Cell cell = getUserInput();
      if (gameTable.isEmpty(cell)) {
        gameTable.setSign(cell, sign);
        return;
      } else {
        System.out.println("Can't make a move, because the cell is not free! Try again");
      }
    }
  }
  
  public Cell getUserInput() {
    while (true) {
      System.out.println("Please type number between 1 and 9:");
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
