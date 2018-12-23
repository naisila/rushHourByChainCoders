package rushHour;

/**
 * __Main Menu Panel of the game.
 * @author __Kunduz
 * @version__ 20/11/2018
 */
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;

public class MainMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton play;
	private JButton cust;
	private JButton inst;
	private JButton quit;
	private JTextArea coinNum;
	private JLabel avatar;
	private JTextArea name;
	private FileManagementSystem fms;
	private User u;

	/**
	 * Create the panel.
	 */
	public MainMenu(FileManagementSystem fmsi) {
		fms = fmsi;
		u = fmsi.getUserData();
		setLayout(null);

		JLabel rush = new JLabel("");
		rush.setBounds(195, 11, 340, 60);
		rush.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/rushHour.png").getImage().getScaledInstance(340,
				60, Image.SCALE_DEFAULT)));
		add(rush);

		JLabel byCC = new JLabel("");
		byCC.setBounds(230, 58, 250, 60);
		byCC.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/byCC.png").getImage().getScaledInstance(250, 60,
				Image.SCALE_DEFAULT)));
		add(byCC);

		avatar = new JLabel("");
		avatar.setBounds(619, 11, 97, 89);
		avatar.setIcon(
				new ImageIcon(new ImageIcon(u.getAvatar()).getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));
		add(avatar);

		coinNum = new JTextArea();
		coinNum.setBackground(new Color(217, 102, 102));
		coinNum.setFont(new Font("Monospaced", Font.BOLD, 11));
		coinNum.setText(u.getCoins() + "");
		coinNum.setBounds(629, 111, 30, 20);
		coinNum.setEditable(false);
		add(coinNum);

		name = new JTextArea();
		name.setBackground(new Color(217, 102, 102));
		name.setFont(new Font("Monospaced", Font.BOLD, 11));
		name.setText(u.getName());
		name.setBounds(681, 111, 80, 20);
		name.setEditable(false);
		add(name);

		JLabel coin = new JLabel("");
		coin.setBounds(666, 118, 70, 60);
		coin.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/coin.png").getImage().getScaledInstance(30, 30,
				Image.SCALE_DEFAULT)));
		add(coin);

		JLabel car = new JLabel("");
		car.setBounds(414, 200, 263, 148);
		car.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/redCar.png").getImage().getScaledInstance(250, 170,
				Image.SCALE_DEFAULT)));
		add(car);

		JLabel lab = new JLabel("");
		lab.setBounds(458, 340, 263, 138);
		lab.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/lab.png").getImage().getScaledInstance(210, 140,
				Image.SCALE_DEFAULT)));
		add(lab);

		play = new JButton("");
		play.setFont(new Font("Tahoma", Font.BOLD, 15));
		play.setText("PLAY                      ");
		play.setBackground(new Color(217, 102, 102));
		play.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/play.png").getImage().getScaledInstance(45, 45,
				Image.SCALE_DEFAULT)));
		play.setBounds(95, 167, 219, 51);
		play.setHorizontalTextPosition(SwingConstants.LEFT);
		play.setHorizontalAlignment(SwingConstants.RIGHT);
		add(play);

		inst = new JButton("");
		inst.setFont(new Font("Tahoma", Font.BOLD, 15));
		inst.setText("INSTRUCTIONS   ");
		inst.setBackground(new Color(101, 140, 217));
		inst.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/info.png").getImage().getScaledInstance(45, 45,
				Image.SCALE_DEFAULT)));
		inst.setBounds(95, 229, 219, 51);
		inst.setHorizontalTextPosition(SwingConstants.LEFT);
		inst.setHorizontalAlignment(SwingConstants.RIGHT);
		add(inst);

		cust = new JButton("");
		cust.setFont(new Font("Tahoma", Font.BOLD, 15));
		cust.setText("CUSTOMIZE          ");
		cust.setBackground(new Color(217, 102, 102));
		cust.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/settings.png").getImage().getScaledInstance(45,
				45, Image.SCALE_DEFAULT)));
		cust.setBounds(95, 292, 219, 51);
		cust.setHorizontalTextPosition(SwingConstants.LEFT);
		cust.setHorizontalAlignment(SwingConstants.RIGHT);
		add(cust);

		quit = new JButton("");
		quit.setFont(new Font("Tahoma", Font.BOLD, 15));
		quit.setText("QUIT                       ");
		quit.setBackground(new Color(101, 140, 217));
		quit.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/quit.png").getImage().getScaledInstance(45, 45,
				Image.SCALE_DEFAULT)));
		quit.setBounds(95, 357, 219, 51);
		quit.setHorizontalTextPosition(SwingConstants.LEFT);
		quit.setHorizontalAlignment(SwingConstants.RIGHT);
		add(quit);

		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 778, 566);
		bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/poster.jpg").getImage().getScaledInstance(778, 566,
				Image.SCALE_DEFAULT)));
		add(bg);
	}

	public void setMLPlay(MouseAdapter madpt) {
		play.addMouseListener(madpt);
	}

	public void setMLCust(MouseAdapter madpt) {
		cust.addMouseListener(madpt);
	}

	public void setMLInst(MouseAdapter madpt) {
		inst.addMouseListener(madpt);
	}

	public void setMLQuit(MouseAdapter madpt) {
		quit.addMouseListener(madpt);
	}

	public void update() {
		u = fms.getUserData();
		coinNum.setText(u.getCoins() + "");
		avatar.setIcon(
				new ImageIcon(new ImageIcon(u.getAvatar()).getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));
		name.setText(u.getName());
	}
}
