package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.GameTable.Cell;
import java.util.Scanner;

public class UserMove {
  
  public void make(GameTable gameTable) {
    int number;
    while (true) {
      System.out.println("Please type number between 1 and 9:");
      String line = new Scanner(System.in).nextLine();
      if (line.length() != 1 || !Character.isDigit(line.charAt(0))) {
        continue;
      }
      number = Integer.parseInt(line);
      if (number < 1 || number > 9) {
        continue;
      }
      Cell cell = CellNumberConverter.convertToCell(number);
      if (!gameTable.isEmpty(cell)) {
        System.out.println("Can't make a move, because the cell is not free! Try again!");
      } else {
        gameTable.setSign(cell, 'X');
        return;
      }
    }
  }
}
