package academy.devonline.tictactoe;

import academy.devonline.tictactoe.component.CellVerifier;
import academy.devonline.tictactoe.component.ComputerMove;
import academy.devonline.tictactoe.component.Game;
import academy.devonline.tictactoe.component.PrintData;
import academy.devonline.tictactoe.component.UserMove;
import academy.devonline.tictactoe.component.WinnerVerifier;
import academy.devonline.tictactoe.component.keypad.DesktopNumericKeypad;
import academy.devonline.tictactoe.model.Player;
import academy.devonline.tictactoe.model.Sign;

public class Launcher {
  
  public static void main(String[] args) {
    DesktopNumericKeypad cellNumberConverter = new DesktopNumericKeypad();
    Game game = new Game(
        new PrintData(cellNumberConverter),
        new Player(Sign.X, new UserMove(cellNumberConverter)),
        new Player(Sign.O, new ComputerMove()),
        new WinnerVerifier(),
        new CellVerifier(),
        true);
    game.play();
  }
}
