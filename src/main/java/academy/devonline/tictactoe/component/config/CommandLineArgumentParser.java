package academy.devonline.tictactoe.component.config;

import static academy.devonline.tictactoe.model.config.PlayerType.COMPUTER;
import static academy.devonline.tictactoe.model.config.PlayerType.USER;

import academy.devonline.tictactoe.model.config.PlayerType;
import academy.devonline.tictactoe.model.config.UserInterface;
import java.util.Arrays;

public class CommandLineArgumentParser {
  
  private final String[] args;
  
  public CommandLineArgumentParser(String[] args) {
    this.args = args;
  }
  
  
  public GameConfiguration parse() {
    PlayerType firstPlayerType = null;
    PlayerType secondPlayerType = null;
    UserInterface userInterface = null;
    for (String arg : args) {
      if (checkArgumentOfPlayerTypes(arg) && secondPlayerType == null) {
        if (firstPlayerType == null) {
          firstPlayerType = PlayerType.valueOf(arg.toUpperCase());
        } else {
          secondPlayerType = PlayerType.valueOf(arg.toUpperCase());
        }
      } else if (checkArgumentOfUserInterface(arg) && userInterface == null) {
        userInterface = UserInterface.valueOf(arg.toUpperCase());
      } else {
        System.err.printf("Excessive argument all options filled: %s\n", arg);
      }
    }
    if (firstPlayerType == null) {
      firstPlayerType = USER;
      secondPlayerType = COMPUTER;
    } else if (secondPlayerType == null) {
      secondPlayerType = firstPlayerType;
      firstPlayerType = USER;
    }
    if (userInterface == null) {
      userInterface = UserInterface.CONSOLE;
    }
    return new GameConfiguration(firstPlayerType, secondPlayerType, userInterface);
  }
  
  private boolean checkArgumentOfUserInterface(String arg) {
    return Arrays.stream(UserInterface.values())
        .anyMatch(userInterface -> userInterface.name().equalsIgnoreCase(arg));
  }
  
  private boolean checkArgumentOfPlayerTypes(String arg) {
    return Arrays.stream(PlayerType.values())
        .anyMatch(playerType -> playerType.name().equalsIgnoreCase(arg));
  }
  
  public static class GameConfiguration {
    
    private final PlayerType player1Type;
    private final PlayerType player2Type;
    
    private final UserInterface userInterface;
    
    private GameConfiguration(PlayerType player1Type, PlayerType player2Type,
        UserInterface userInterface) {
      this.player1Type = player1Type;
      this.player2Type = player2Type;
      this.userInterface = userInterface;
    }
    
    public UserInterface getUserInterface() {
      return userInterface;
    }
    
    public PlayerType getPlayer1Type() {
      return player1Type;
    }
    
    public PlayerType getPlayer2Type() {
      return player2Type;
    }
  }
}
