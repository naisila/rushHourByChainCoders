/**
 * __Game Panel of the game.
 * @author __Masna
 * @version__18/11/2018
 */
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class ChooseDifficulty extends JPanel {
  
  /**
   * Create the panel.
   */
  public ChooseDifficulty() {
    setLayout(null);
    
    Image img = new ImageIcon("images/back.png").getImage().getScaledInstance(120, 45, Image.SCALE_DEFAULT);
    Image img2 = new ImageIcon("images/chooseLevel.png").getImage().getScaledInstance(400, 45, Image.SCALE_DEFAULT);
    Image img3 = new ImageIcon("images/star.png").getImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT);
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon(img));
    label.setBounds(10, 11, 120, 45);
    add(label);
    
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(new ImageIcon(img2));
    lblNewLabel.setBounds(103, 50, 400, 45);
    add(lblNewLabel);
    
    JButton btnNewButton = new JButton("");
    btnNewButton.setText("Beginner");
    btnNewButton.setBackground(Color.LIGHT_GRAY);
    btnNewButton.setIcon(new ImageIcon("images/rightIcon.png"));
    btnNewButton.setBounds(266, 123, 147, 34);
    add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("");
    btnNewButton_1.setText("Intermediate");
    btnNewButton_1.setBackground(Color.PINK);
    btnNewButton_1.setIcon(new ImageIcon(new ImageIcon("images/locked.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
    btnNewButton_1.setBounds(266, 183, 147, 34);
    add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("");
    btnNewButton_2.setText("Hard");
    btnNewButton_2.setBackground(Color.PINK);
    btnNewButton_2.setIcon(new ImageIcon(new ImageIcon("images/locked.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
    btnNewButton_2.setBounds(266, 243, 147, 34);
    add(btnNewButton_2);
    
    JButton btnNewButton_3 = new JButton("");
    btnNewButton_3.setText("Expert");
    btnNewButton_3.setBackground(Color.PINK);
    btnNewButton_3.setIcon(new ImageIcon(new ImageIcon("images/locked.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
    btnNewButton_3.setBounds(266, 303, 147, 34);
    add(btnNewButton_3);
    
    JLabel label_1 = new JLabel("");
    label_1.setIcon(new ImageIcon(img3));
    label_1.setBounds(90, 152, 65, 65);
    add(label_1);
    
    JTextPane textPane = new JTextPane();
    textPane.setText("0");  // here a method will be used to get the user's number of stars
    textPane.setOpaque(false);
    textPane.setBounds(63, 165, 22, 20);
    add(textPane);
    
    JTextPane textPane_1 = new JTextPane();
    textPane_1.setText("20 stars needed to unlock next level");  // a method will be used to calculate this
    textPane_1.setOpaque(false);
    textPane_1.setBounds(90, 228, 65, 70);
    add(textPane_1);
    
    JLabel bg = new JLabel("");
    bg.setIcon(new ImageIcon(new ImageIcon("images/bg.jpg").getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT)));
    bg.setBounds(0, 0, 614, 371);
    add(bg);
  }
}
