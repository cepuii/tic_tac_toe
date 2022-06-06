package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Player;
import java.util.Random;

public class Game {
  
  private final PrintData printData;
  private final Player player1;
  private final Player player2;
  private final WinnerVerifier winnerVerifier;
  private final CellVerifier cellVerifier;
  
  private final boolean canSecondPlayerMoveFirst;
  
  public Game(PrintData printData, Player player1, Player player2, WinnerVerifier winnerVerifier,
      CellVerifier cellVerifier, boolean canSecondPlayerMoveFirst) {
    this.printData = printData;
    this.player1 = player1;
    this.player2 = player2;
    this.winnerVerifier = winnerVerifier;
    this.cellVerifier = cellVerifier;
    this.canSecondPlayerMoveFirst = canSecondPlayerMoveFirst;
  }
  
  public void play() {
    System.out.println(
        "Use the following mapping table to specify a cell using numbers from 1 to 9:");
    printData.printMappingTable();
    final GameTable gameTable = new GameTable();
    if (canSecondPlayerMoveFirst && new Random().nextBoolean()) {
      player2.makeMove(gameTable);
      printData.printGameTable(gameTable);
    }
    Player[] players = {player1, player2};
    
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
