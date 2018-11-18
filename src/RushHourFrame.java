/**
 * __Main Frame of the game. From here you can navigate anywhere in our game.
 * @author __Naisila
 * @version__18/11/2018
 */
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.Point;
public class RushHourFrame extends JFrame {
  
  private JPanel contentPane;
  private Game game;
  private ChooseDifficulty chooseDiff;
  
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RushHourFrame frame = new RushHourFrame();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
  /**
   * Create the frame.
   */
  public RushHourFrame() {
    setTitle("<Rush Hour> by Chain Coders");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(200, 50, 614, 373);
    game = new Game();
    chooseDiff = new ChooseDifficulty();
    RushHourFrame.this.setContentPane(chooseDiff);
  }
}
