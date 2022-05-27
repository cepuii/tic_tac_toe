package academy.devonline.tictactoe;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game(new PrintData(), new ComputerMove(),
            new UserMove(), new WinnerVerifier(), new DrawVerifier());
        game.play();
    }
}
