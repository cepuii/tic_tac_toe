package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;

public class WinnerVerifier {
  
  public String isUserWin(GameTable gameTable) {
    String USER_WIN = "XXX";
    return isWin(gameTable, USER_WIN) ? "YOU WIN!!!" : "";
  }
  
  public String isComputerWin(GameTable gameTable) {
    String COMPUTER_WIN = "OOO";
    return isWin(gameTable, COMPUTER_WIN) ? "COMPUTER WIN!!!" : "";
  }
  
  private boolean isWin(GameTable gameTable, String sign) {
    Sign[][] table = gameTable.getTable();
    StringBuilder sbDiagonal = new StringBuilder();
    StringBuilder sbAnDiagonal = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      StringBuilder sbVertical = new StringBuilder();
      StringBuilder sbHorizontal = new StringBuilder();
      for (int j = 0; j < 3; j++) {
        sbVertical.append(table[j][i]);
        sbHorizontal.append(table[i][j]);
        if (i == j) {
          sbDiagonal.append(table[i][j]);
        }
        if (i == 0 && j == 2 || i == 1 && j == 1 || i == 2 && j == 0) {
          sbAnDiagonal.append(table[i][j]);
        }
      }
      if (sign.contains(sbVertical) || sign.contains(sbHorizontal)) {
        return true;
      }
    }
    return sign.contains(sbDiagonal) || sign.contains(sbAnDiagonal);
  }
}
