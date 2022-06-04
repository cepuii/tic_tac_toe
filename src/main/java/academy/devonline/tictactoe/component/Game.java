package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Player;
import academy.devonline.tictactoe.model.Sign;
import java.util.Random;

public class Game {
  
  private final PrintData printData;
  private final ComputerMove computerMove;
  private final UserMove userMove;
  private final WinnerVerifier winnerVerifier;
  private final CellVerifier cellVerifier;
  
  public Game(final PrintData printData,
      final ComputerMove computerMove,
      final UserMove userMove,
      final WinnerVerifier winnerVerifier,
      final CellVerifier cellVerifier) {
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
    Player[] players = {new Player(Sign.X, userMove), new Player(Sign.O, computerMove)};
    int step = 0;
    while (true) {
      players[step].makeMove(gameTable);
      printData.printGameTable(gameTable);
      if (winnerVerifier.isWinner(gameTable, players[step])) {
        System.out.println(players[step] + " WIN!!!");
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
