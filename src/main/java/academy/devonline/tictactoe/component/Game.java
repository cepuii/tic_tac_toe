package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Player;
import academy.devonline.tictactoe.model.Sign;

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
//    if (new Random().nextBoolean()) {
//      computerMove.make(gameTable, );
//      printData.printGameTable(gameTable);
//    }
    Player[] players = {new Player(Sign.X, userMove), new Player(Sign.O, computerMove)};
  
    while (true) {
      for (Player player : players) {
        player.makeMove(gameTable);
        printData.printGameTable(gameTable);
        if (winnerVerifier.isWinner(gameTable, player)) {
          System.out.println(player + " WIN!!!");
          printGameOver();
          return;
        }
        if (cellVerifier.isCellsFilled(gameTable)) {
          System.out.println("Sorry, DRAW");
          printGameOver();
          return;
        }
      }
    }
    
  }
  
  private void printGameOver() {
    System.out.println("GAME OVER.");
  }
  
}
