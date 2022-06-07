package academy.devonline.tictactoe.component;

import static academy.devonline.tictactoe.model.PlayerType.USER;
import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

import academy.devonline.tictactoe.component.CommandLineArgumentParser.GameConfiguration;
import academy.devonline.tictactoe.component.console.ConsoleDataPrinter;
import academy.devonline.tictactoe.component.console.ConsoleUserInputReader;
import academy.devonline.tictactoe.component.keypad.DesktopNumericKeypad;
import academy.devonline.tictactoe.component.swing.GameWindow;
import academy.devonline.tictactoe.model.Player;
import academy.devonline.tictactoe.model.PlayerType;
import academy.devonline.tictactoe.model.UserInterface;

public class GameFactory {
  
  private final PlayerType player1Type;
  private final PlayerType player2Type;
  private final UserInterface userInterface;
  
  public GameFactory(String[] args) {
    GameConfiguration gameConfiguration =
        new CommandLineArgumentParser(args).parse();
    player1Type = gameConfiguration.getPlayer1Type();
    player2Type = gameConfiguration.getPlayer2Type();
    userInterface = gameConfiguration.getUserInterface();
  }
  
  
  public Game create() {
    final DataPrinter printer;
    final UserInputReader inputReader;
    if (userInterface.ordinal() == 0) {
      GameWindow gameWindow = new GameWindow();
      printer = gameWindow;
      inputReader = gameWindow;
    } else {
      final CellNumberConverter cellNumberConverter = new DesktopNumericKeypad();
      printer = new ConsoleDataPrinter(cellNumberConverter);
      inputReader = new ConsoleUserInputReader(cellNumberConverter, printer);
    }
    final Player player1;
    if (player1Type == USER) {
      player1 = new Player(X, new UserMove(inputReader, printer));
    } else {
      player1 = new Player(X, new ComputerMove());
    }
    final Player player2;
    if (player2Type == USER) {
      player2 = new Player(O, new UserMove(inputReader, printer));
    } else {
      player2 = new Player(O, new ComputerMove());
    }
    final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
    return new Game(
        printer,
        player1,
        player2,
        new WinnerVerifier(),
        new CellVerifier(),
        canSecondPlayerMakeFirstMove
    );
  }
  
}
