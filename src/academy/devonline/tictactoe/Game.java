package academy.devonline.tictactoe;

import java.util.Random;

public class Game {
  
  private final PrintData printData;
  private final ComputerMove computerMove;
  private final UserMove userMove;
  private final WinnerVerifier winnerVerifier;
  private final DrawVerifier drawVerifier;
  
  public Game(final PrintData printData,
      final ComputerMove computerMove,
      final UserMove userMove,
      final WinnerVerifier winnerVerifier,
      final DrawVerifier drawVerifier) {
    this.printData = printData;
    this.computerMove = computerMove;
    this.userMove = userMove;
    this.winnerVerifier = winnerVerifier;
    this.drawVerifier = drawVerifier;
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
    while (true) {
      userMove.make(gameTable);
      printData.printGameTable(gameTable);
      if (winnerVerifier.isUserWin()) {
        System.out.println("YOU WIN!!!");
        break;
      }
      if (drawVerifier.isDraw()) {
        System.out.println("Sorry, DRAW");
        break;
      }
      computerMove.make(gameTable);
      printData.printGameTable(gameTable);
      if (winnerVerifier.isComputerWin()) {
        System.out.println("COMPUTER WIN!!!");
        break;
      }
      if (drawVerifier.isDraw()) {
        System.out.println("Sorry, DRAW");
        break;
      }
    }
    System.out.println("GAME OVER.");
  }
  
}
