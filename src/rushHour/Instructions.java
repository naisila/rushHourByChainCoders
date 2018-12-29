package src.rushHour;
/**
 * __Instructions Panel of the game.
 * @author __Kunduz
 * @version__ 19/12/2018
 */

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class Instructions extends JPanel {

	private JTextArea ins;
	private JLabel back;
	private JLabel instr;
	private Color color;
	private JLabel bg;
	private JLabel gif;
	private JScrollPane scrollPane;
	private JButton play;

	Font font = new Font("Verdana", Font.BOLD, 12);

	private String content = " In Rush Hour, you are stuck in traffic and your goal is to escape."
			+ " To do this, you can move any cars         forwards and backwards.  Your car is the red one."
			+ "  To win, move the red car out past the   \"EXIT\" label on the right side of the grid. "
			+ " To move any car, just  grab hold of it with the mouse and drag it around. "
			+ "  Cars can   move forwards  and backwards, but can't move sideways. If you get completely stuck,"
			+ " you     can press the \"RESET\" button. For   each solved puzzle you get stars, coins and crowns according   to    your performance."
			+ " For instance, if puzle has been    solved under minimum number of moves and under  limited time, you get maximum possible amount of "
			+ "  stars, crowns and coins."
			+ " Puzzles of same level are   free to choose, but in order to unlock new level you will need certain amount of stars. "
			+ "Do not forget to   visit \"My Garage\" to unlock new cars with coins and manage your cars. Change your name, avatar,       mouse sensitivity and background music from          "
			+ "Settings menu.";
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Instructions() {
		setLayout(null);

		ImageIcon iconBack = new ImageIcon(new ImageIcon("src/rushHour/images/back.png").getImage()
				.getScaledInstance(120, 65, Image.SCALE_DEFAULT));
		back = new JLabel("");
		back.setBounds(0, 0, 156, 65);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setIcon(iconBack);
		add(back);

		gif = new JLabel("");
		gif.setIcon(new ImageIcon("src/rushHour/images/giphy.gif"));
		gif.setBounds(170, 220, 400, 300);
		gif.setHorizontalAlignment(SwingConstants.CENTER);
		add(gif);

		ImageIcon iconInstr = new ImageIcon(new ImageIcon("src/rushHour/images/instructions.png").getImage()
				.getScaledInstance(300, 60, Image.SCALE_DEFAULT));
		instr = new JLabel("");
		instr.setBounds(235, 22, 291, 41);
		instr.setHorizontalAlignment(SwingConstants.CENTER);
		instr.setIcon(iconInstr);
		add(instr);

		/*
		 * car = new JLabel(""); car.setIcon(new ImageIcon(new
		 * ImageIcon("src/rushHour/images/redRed.png").getImage().getScaledInstance(200,
		 * 105, Image.SCALE_DEFAULT))); car.setBounds(530, 0, 220, 140); add(car);
		 * 
		 * car1 = new JLabel(""); car1.setIcon(new ImageIcon(new
		 * ImageIcon("src/rushHour/images/regBlue.png").getImage().getScaledInstance(
		 * 230, 110, Image.SCALE_DEFAULT))); car1.setBounds(0, 375, 260, 165);
		 * add(car1);
		 */
		ins = new JTextArea(content);
		ins.setEditable(false);
		ins.setLineWrap(true);
		color = new Color(255, 218, 185);
		Color color1 = new Color(12, 36, 97);
		ins.setBackground(color);
		ins.setFont(font);
		ins.setForeground(color1);
		scrollPane = new JScrollPane(ins);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(200, 85, 80, 80);
		scrollPane.setSize(364, 180);
		scrollPane.getViewport().setBackground(Color.RED);
		add(scrollPane);

		play = new JButton("");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://www.youtube.com/watch?v=mbmSakJnnts"));
				} catch (IOException e) {
				} catch (URISyntaxException e) {

				}
			}
		});
		play.setFont(new Font("Tahoma", Font.BOLD, 9));
		play.setText("LINK TO TUTORIAL VIDEO ON YOUTUBE");
		play.setBackground(new Color(217, 102, 102));
		play.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/video.png").getImage().getScaledInstance(45, 45,
				Image.SCALE_DEFAULT)));
		play.setBounds(225, 480, 300, 31);
		play.setHorizontalTextPosition(SwingConstants.LEFT);
		play.setHorizontalAlignment(SwingConstants.RIGHT);
		add(play);

		String bgIcn = "src/rushHour/images/poster.jpg";
		ImageIcon backGrIcon = new ImageIcon(
				new ImageIcon(bgIcn).getImage().getScaledInstance(778, 566, Image.SCALE_DEFAULT));
		bg = new JLabel("");
		bg.setBounds(0, 0, 778, 566);
		bg.setIcon(backGrIcon);
		add(bg);
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}
}
