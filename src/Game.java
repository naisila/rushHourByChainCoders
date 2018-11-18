/**
 * __Game Panel of the game.
 * @author __Naisila
 * @version__18/11/2018
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Box;
import java.applet.*;
import java.awt.*;

public class Game extends JPanel {
  /**
   * Create the panel.
   */
  public Game() {
    setBackground(new Color(255, 250, 205));
    setLayout(null);
    
    JLabel rushhour = new JLabel("");
    rushhour.setIcon(new ImageIcon(new ImageIcon("images/rushHour.png").getImage().getScaledInstance(200, 60, Image.SCALE_DEFAULT)));
    rushhour.setBounds(238, 0, 197, 53);
    add(rushhour);
    
    JLabel avatar = new JLabel("");
    avatar.setIcon(new ImageIcon(new ImageIcon("images/Avatar.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
    avatar.setBounds(526, 0, 88, 73);
    add(avatar);
    
    JLabel reset = new JLabel("");
    reset.setIcon(new ImageIcon(new ImageIcon("images/reset.png").getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT)));
    reset.setBounds(50, 264, 69, 53);
    add(reset);
    
    JLabel instr = new JLabel("");
    instr.setIcon(new ImageIcon(new ImageIcon("images/instructions.png").getImage().getScaledInstance(160, 50, Image.SCALE_DEFAULT)));
    instr.setBounds(10, 317, 183, 31);
    add(instr);
    
    JLabel timer = new JLabel("");
    timer.setIcon(new ImageIcon(new ImageIcon("images/timer.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
    timer.setBounds(10, 196, 88, 94);
    add(timer);
    
    JLabel secs = new JLabel("");
    secs.setIcon(new ImageIcon(new ImageIcon("images/secs.png").getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT)));
    secs.setBounds(65, 225, 139, 40);
    add(secs);
    
    JLabel moves = new JLabel("");
    moves.setIcon(new ImageIcon(new ImageIcon("images/moves.png").getImage().getScaledInstance(130, 50, Image.SCALE_DEFAULT)));
    moves.setBounds(21, 174, 143, 40);
    add(moves);
    
    JLabel level = new JLabel("");
    level.setIcon(new ImageIcon(new ImageIcon("images/intermediateLevel.png").getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT)));
    level.setBounds(0, 47, 228, 73);
    add(level);
    
    JLabel puzzle = new JLabel("");
    puzzle.setIcon(new ImageIcon(new ImageIcon("images/puzzle2.png").getImage().getScaledInstance(150, 70, Image.SCALE_DEFAULT)));
    puzzle.setBounds(10, 110, 161, 53);
    add(puzzle);
    
    JLabel back = new JLabel("");
    back.setIcon(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(120, 70, Image.SCALE_DEFAULT)));
    back.setBounds(0, 0, 119, 47);
    add(back);
    
    JLabel car1 = new JLabel("");
    car1.setIcon(new ImageIcon(new ImageIcon("images/greenCar.png").getImage().getScaledInstance(50, 150, Image.SCALE_DEFAULT)));
    car1.setBounds(456, 59, 46, 144);
    add(car1);
    
    JLabel car2 = new JLabel("");
    car2.setIcon(new ImageIcon(new ImageIcon("images/blueCar.png").getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT)));
    car2.setBounds(298, 59, 161, 47);
    add(car2);
    
    JLabel car3 = new JLabel("");
    car3.setIcon(new ImageIcon(new ImageIcon("images/yellowCar.png").getImage().getScaledInstance(50, 100, Image.SCALE_DEFAULT)));
    car3.setBounds(298, 105, 50, 104);
    add(car3);
    
    JLabel car4 = new JLabel("");
    car4.setIcon(new ImageIcon(new ImageIcon("images/whiteCar.png").getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT)));
    car4.setBounds(298, 260, 106, 53);
    add(car4);
    
    JLabel car5 = new JLabel("");
    car5.setIcon(new ImageIcon(new ImageIcon("images/grayCar.png").getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT)));
    car5.setBounds(402, 260, 100, 53);
    add(car5);
    
    JLabel mainCar = new JLabel("");
    mainCar.setIcon(new ImageIcon(new ImageIcon("images/redCar.png").getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT)));
    mainCar.setBounds(202, 157, 100, 53);
    add(mainCar);
    
    JLabel jam = new JLabel("");
    jam.setIcon(new ImageIcon(new ImageIcon("images/jam.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
    jam.setBounds(202, 59, 300, 301);
    add(jam);
    
    JLabel exit = new JLabel("");
    exit.setIcon(new ImageIcon(new ImageIcon("images/exit.png").getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT)));
    exit.setBounds(492, 157, 40, 47);
    add(exit);
    
    JLabel bg = new JLabel("");
    bg.setIcon(new ImageIcon(new ImageIcon("images/bg.jpg").getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT)));
    bg.setBounds(0, 0, 614, 370);
    add(bg);
  }
}
