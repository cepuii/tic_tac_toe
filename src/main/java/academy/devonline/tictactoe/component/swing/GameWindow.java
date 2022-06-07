package academy.devonline.tictactoe.component.swing;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.UserInputReader;
import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GameWindow extends JFrame implements DataPrinter, UserInputReader {
  
  private static final int GAME_TABLE_SIZE = 3;
  
  private static final int FONT_SIZE = 35;
  
  private static final int CELL_SIZE = 150;
  
  private final JLabel[][] cells = new JLabel[GAME_TABLE_SIZE][GAME_TABLE_SIZE];
  
  private Cell clickedCell;
  
  public GameWindow() throws HeadlessException {
    super("Tic Tac Toe");
    setSystemLookAndFeel();
    //setDefaultLookAndFeelDecorated();
    setLayout(new GridLayout(GAME_TABLE_SIZE, GAME_TABLE_SIZE));
    createGameTable();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    pack();
    displayInTheMiddleOfScreen();
  }
  
  private void displayInTheMiddleOfScreen() {
    final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
    setVisible(true);
  }
  
  private void createGameTable() {
    for (int i = 0; i < GAME_TABLE_SIZE; i++) {
      for (int j = 0; j < GAME_TABLE_SIZE; j++) {
        final JLabel jLabel = new JLabel();
        cells[i][j] = jLabel;
        jLabel.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        jLabel.setFont(new Font(Font.SERIF, Font.PLAIN, FONT_SIZE));
        jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(jLabel);
        final Cell cell = new Cell(i, j);
        jLabel.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            synchronized (GameWindow.this) {
              clickedCell = cell;
              GameWindow.this.notifyAll();
            }
          }
        });
      }
    }
  }
  
  private void setSystemLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (final ClassNotFoundException | UnsupportedLookAndFeelException |
                   IllegalAccessException | InstantiationException ex) {
      ex.printStackTrace();
    }
  }
  
  @Override
  public void printInfoMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
  }
  
  @Override
  public void printErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
  }
  
  @Override
  public void printMappingTable() {
    //do nothing;
  }
  
  @Override
  public void printGameTable(GameTable gameTable) {
    for (int i = 0; i < GAME_TABLE_SIZE; i++) {
      for (int j = 0; j < GAME_TABLE_SIZE; j++) {
        cells[i][j].setText(gameTable.getSign(new Cell(i, j)).name());
      }
    }
  }
  
  @Override
  public Cell getUserInput() {
    synchronized (this) {
      try {
        wait();
      } catch (final InterruptedException exception) {
        exception.printStackTrace();
        System.exit(2);
      }
    }
    return clickedCell;
  }
}
