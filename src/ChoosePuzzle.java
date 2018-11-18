/**
 * __Choose Puzzle Panel of the game.
 * @author __Talha
 * @version__18/11/2018
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Scrollbar;

public class ChoosePuzzle extends JPanel { 
  private JTextField txtUnsolved;
  private JTextField textField;
  /**
   * Create the frame.
   */
  public ChoosePuzzle() {
    setLayout(null);
    
    //Image of Choose Puzzle
    String bLabel = "images/back.png";
    ImageIcon icone = new ImageIcon( new ImageIcon(bLabel).getImage().getScaledInstance(120, 65, Image.SCALE_DEFAULT));
    
    JLabel label = new JLabel("");
    label.setBounds(12, 13, 156, 65);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setIcon(icone);
    add(label);
    
    //Image of Level
    String levLabel = "images/intermediateLevel.png";
    ImageIcon myIcon = new ImageIcon( new ImageIcon(levLabel).getImage().getScaledInstance(460, 65, Image.SCALE_DEFAULT));
    JLabel levelLabel = new JLabel("");
    levelLabel.setBounds(141, 71, 460, 65);
    levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
    levelLabel.setIcon(myIcon);
    add(levelLabel);
    
    //Image of Choose Puzzle
    String cLbl = "images/choosePuzzle.png";
    ImageIcon chooseIcon = new ImageIcon( new ImageIcon(cLbl).getImage().getScaledInstance(284, 56, Image.SCALE_DEFAULT));
    JLabel lblChooselbl = new JLabel("\r\n");
    lblChooselbl.setBounds(225, 149, 292, 56);
    lblChooselbl.setHorizontalAlignment(SwingConstants.CENTER);
    lblChooselbl.setIcon(chooseIcon);
    add(lblChooselbl);
    
    JButton btnPuzzle = new JButton("Puzzle 1");
    btnPuzzle.setBounds(195, 250, 97, 35);
    add(btnPuzzle);
    
    JButton btnPuzzle_1 = new JButton("Puzzle 2");
    btnPuzzle_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnPuzzle_1.setBounds(195, 313, 97, 38);
    add(btnPuzzle_1);
    
    JButton btnPuzzle_2 = new JButton("Puzzle 3");
    btnPuzzle_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnPuzzle_2.setBounds(195, 378, 97, 40);
    add(btnPuzzle_2);
    
    JButton button = new JButton("Puzzle 4");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
      }
    });
    button.setBounds(195, 436, 97, 40);
    add(button); 
    
    //Image of Star
    String strIcon= "images/star.png";
    ImageIcon starIcon = new ImageIcon( new ImageIcon(strIcon).getImage().getScaledInstance(63, 35, Image.SCALE_DEFAULT));
    
    
    JLabel lblstr = new JLabel("str");
    lblstr.setIcon(starIcon);
    lblstr.setBounds(352, 250, 63, 35);
    add(lblstr);
    
    JLabel label_2 = new JLabel("str");
    label_2.setIcon(starIcon);
    label_2.setBounds(352, 381, 63, 35);
    add(label_2);
    
    // Crown Label and Image
    
    //Image of Crown
    String crwIc = "images/crown.png";
    ImageIcon crwIcon = new ImageIcon( new ImageIcon(crwIc).getImage().getScaledInstance(63, 35, Image.SCALE_DEFAULT));
    
    JLabel lblCrw = new JLabel("crw");
    lblCrw.setIcon(crwIcon);
    lblCrw.setBounds(468, 250, 63, 35);
    add(lblCrw);
    
    JLabel label_5 = new JLabel("crw");
    label_5.setIcon(crwIcon);
    label_5.setBounds(468, 381, 63, 35);
    add(label_5);    
    
    txtUnsolved = new JTextField();
    txtUnsolved.setHorizontalAlignment(SwingConstants.CENTER);
    txtUnsolved.setFont(new Font("Tahoma", Font.BOLD, 14));
    txtUnsolved.setBackground(Color.RED);
    txtUnsolved.setText("UNSOLVED");
    txtUnsolved.setBounds(344, 313, 187, 38);
    add(txtUnsolved);
    txtUnsolved.setColumns(10);
    
    textField = new JTextField();
    textField.setText("UNSOLVED");
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    textField.setFont(new Font("Tahoma", Font.BOLD, 14));
    textField.setColumns(10);
    textField.setBackground(Color.RED);
    textField.setBounds(338, 437, 193, 38);
    add(textField);
    
    Scrollbar scrollbar = new Scrollbar();
    scrollbar.setBounds(616, 250, 33, 226);
    add(scrollbar);
    
    JLabel bg = new JLabel("");
    bg.setIcon(new ImageIcon(new ImageIcon("images/bg.jpg").getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT)));
    bg.setBounds(0, 0, 614, 370);
    add(bg);
  }
}
