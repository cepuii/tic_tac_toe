package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import java.util.Random;

public class Game {
  
  private final academy.devonline.tictactoe.component.PrintData printData;
  private final academy.devonline.tictactoe.component.ComputerMove computerMove;
  private final academy.devonline.tictactoe.component.UserMove userMove;
  private final academy.devonline.tictactoe.component.WinnerVerifier winnerVerifier;
  private final academy.devonline.tictactoe.component.CellVerifier cellVerifier;
  
  public Game(final academy.devonline.tictactoe.component.PrintData printData,
      final academy.devonline.tictactoe.component.ComputerMove computerMove,
      final academy.devonline.tictactoe.component.UserMove userMove,
      final academy.devonline.tictactoe.component.WinnerVerifier winnerVerifier,
      final academy.devonline.tictactoe.component.CellVerifier cellVerifier) {
    this.printData = printData;
    this.computerMove = computerMove;
    this.userMove = userMove;
    this.winnerVerifier = winnerVerifier;
    this.cellVerifier = cellVerifier;
  }
  
  public void play() {
    System.out.println(
        "Use the following mapping table to specify a cell using numbers from 1 to 9:");
    printData.printMappingTable();
    final GameTable gameTable = new GameTable();
    if (new Random().nextBoolean()) {
      computerMove.make(gameTable);
      printData.printGameTable(gameTable);
    }
    Move[] array = {userMove, computerMove};
    int step = 0;
    while (true) {
      array[step].make(gameTable);
      printData.printGameTable(gameTable);
      String result = winnerVerifier.isUserWin(gameTable);
      if (!result.isEmpty()) {
        System.out.println(result);
        break;
      }
      if (cellVerifier.isCellsFilled(gameTable)) {
        System.out.println("Sorry, DRAW");
        break;
      }
      if (step == 0) {
        step = 1;
      } else {
        step = 0;
      }
    }
    System.out.println("GAME OVER.");
  }
  
}
