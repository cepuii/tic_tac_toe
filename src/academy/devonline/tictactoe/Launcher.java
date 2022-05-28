package academy.devonline.tictactoe;

import academy.devonline.tictactoe.component.CellVerifier;
import academy.devonline.tictactoe.component.ComputerMove;
import academy.devonline.tictactoe.component.Game;
import academy.devonline.tictactoe.component.PrintData;
import academy.devonline.tictactoe.component.UserMove;
import academy.devonline.tictactoe.component.WinnerVerifier;
import academy.devonline.tictactoe.component.keypad.DesktopNumericKeypad;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game(new PrintData(new DesktopNumericKeypad()), new ComputerMove(),
            new UserMove(new DesktopNumericKeypad()), new WinnerVerifier(), new CellVerifier());
        game.play();
    }
}
