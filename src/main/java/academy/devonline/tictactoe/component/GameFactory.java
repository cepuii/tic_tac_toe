package academy.devonline.tictactoe.component;

import static academy.devonline.tictactoe.model.PlayerType.USER;
import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

import academy.devonline.tictactoe.component.keypad.DesktopNumericKeypad;
import academy.devonline.tictactoe.model.Player;
import academy.devonline.tictactoe.model.PlayerType;
import java.util.Arrays;

public class GameFactory {
  
  private final PlayerType player1Type;
  private final PlayerType player2Type;
  
  public GameFactory(String[] args) {
    PlayerType[] playerTypes = new PlayerType[2];
    if (args.length == 0) {
      playerTypes[0] = USER;
      playerTypes[1] = PlayerType.COMPUTER;
    } else if (args.length == 1) {
      playerTypes[0] = USER;
      if (checkCommandLineArgument(args[0])) {
        playerTypes[1] = PlayerType.valueOf(args[0].toUpperCase());
      } else {
        System.err.printf("Unsupported command line argument: %s\n", args[0]);
        playerTypes[1] = PlayerType.COMPUTER;
      }
    } else {
      for (String arg : args) {
        if (checkCommandLineArgument(arg) && playerTypes[1] == null) {
          if (playerTypes[0] == null) {
            playerTypes[0] = PlayerType.valueOf(arg.toUpperCase());
          } else {
            playerTypes[1] = PlayerType.valueOf(arg.toUpperCase());
          }
        } else {
          System.err.printf("Unsupported command line argument: %s\n", arg);
        }
      }
    }
    player1Type = playerTypes[0];
    player2Type = playerTypes[1];
  }
  
  
  private boolean checkCommandLineArgument(String arg) {
    return Arrays.stream(PlayerType.values())
        .anyMatch(playerType -> playerType.name().equalsIgnoreCase(arg));
  }
  
  
  public Game create() {
    final CellNumberConverter cellNumberConverter = new DesktopNumericKeypad();
    final Player player1;
    if (player1Type == USER) {
      player1 = new Player(X, new UserMove(cellNumberConverter));
    } else {
      player1 = new Player(X, new ComputerMove());
    }
    final Player player2;
    if (player2Type == USER) {
      player2 = new Player(O, new UserMove(cellNumberConverter));
    } else {
      player2 = new Player(O, new ComputerMove());
    }
    final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
    return new Game(
        new PrintData(cellNumberConverter),
        player1,
        player2,
        new WinnerVerifier(),
        new CellVerifier(),
        canSecondPlayerMakeFirstMove
    );
  }
  
}
