package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Player;
import java.util.Random;

public class Game {
  
  private final DataPrinter dataPrinter;
  private final Player player1;
  private final Player player2;
  private final WinnerVerifier winnerVerifier;
  private final CellVerifier cellVerifier;
  private final GameOverHandle gameOverHandle;
  private final boolean canSecondPlayerMoveFirst;
  
  public Game(DataPrinter printData,
      Player player1, Player player2,
      WinnerVerifier winnerVerifier,
      CellVerifier cellVerifier,
      GameOverHandle gameOverHandle, boolean canSecondPlayerMoveFirst) {
    
    this.dataPrinter = printData;
    this.player1 = player1;
    this.player2 = player2;
    this.winnerVerifier = winnerVerifier;
    this.cellVerifier = cellVerifier;
    this.gameOverHandle = gameOverHandle;
    this.canSecondPlayerMoveFirst = canSecondPlayerMoveFirst;
  }
  
  public void play() {
  
    dataPrinter.printInstruction();
    final GameTable gameTable = new GameTable();
    
    if (canSecondPlayerMoveFirst && new Random().nextBoolean()) {
      player2.makeMove(gameTable);
      dataPrinter.printGameTable(gameTable);
    }
    
    Player[] players = {player1, player2};
    
    while (true) {
      for (Player player : players) {
        player.makeMove(gameTable);
        dataPrinter.printGameTable(gameTable);
        if (winnerVerifier.isWinner(gameTable, player)) {
          dataPrinter.printInfoMessage(player + " WIN!!!");
          gameOverHandle.gameOver();
          return;
        }
        if (cellVerifier.isCellsFilled(gameTable)) {
          dataPrinter.printInfoMessage("Sorry, DRAW");
          gameOverHandle.gameOver();
          return;
        }
      }
    }
  }
}
