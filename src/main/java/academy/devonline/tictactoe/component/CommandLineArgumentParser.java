package academy.devonline.tictactoe.component;

import static academy.devonline.tictactoe.model.PlayerType.USER;

import academy.devonline.tictactoe.model.PlayerType;
import java.util.Arrays;

public class CommandLineArgumentParser {
  
  private final String[] args;
  
  public CommandLineArgumentParser(String[] args) {
    this.args = args;
  }
  
  public PlayerTypes parse() {
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
    return new PlayerTypes(playerTypes[0], playerTypes[1]);
  }
  
  private boolean checkCommandLineArgument(String arg) {
    return Arrays.stream(PlayerType.values())
        .anyMatch(playerType -> playerType.name().equalsIgnoreCase(arg));
  }
  
  static class PlayerTypes {
    
    private final PlayerType player1Type;
    private final PlayerType player2Type;
    
    private PlayerTypes(PlayerType player1Type, PlayerType player2Type) {
      this.player1Type = player1Type;
      this.player2Type = player2Type;
    }
    
    public PlayerType getPlayer1Type() {
      return player1Type;
    }
    
    public PlayerType getPlayer2Type() {
      return player2Type;
    }
  }
}
