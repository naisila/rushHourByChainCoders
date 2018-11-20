package rushHour;

/**
 * __Garage Panel of the game.
 * @author __Masna
 * @version__18/11/2018
 */
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;

public class GaragePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel back;

	/**
	 * Create the panel.
	 */
	public GaragePanel() {
		setLayout(null);

		Image img = new ImageIcon("src/rushHour/images/back.png").getImage().getScaledInstance(120, 45,
				Image.SCALE_DEFAULT);
		Image img1 = new ImageIcon("src/rushHour/images/my garage.png").getImage().getScaledInstance(250, 50,
				Image.SCALE_DEFAULT);

		back = new JLabel("");
		back.setIcon(new ImageIcon(img));
		back.setBounds(10, 11, 120, 45);
		add(back);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(257, 11, 250, 50);
		add(lblNewLabel_1);

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(68, 66, 654, 407);

		JComponent panel1 = makeCarsPanel("Panel #1");
		tabbedPane.addTab("My Cars", null, panel1, "Does nothing");
		add(tabbedPane);

		JComponent panel2 = makeAchievementsPanel();
		tabbedPane.addTab("My Achievements", null, panel2, "Gets Achievements");

		JLabel label = new JLabel("0"); // Need to obtain this value from the text file
		label.setBounds(629, 31, 24, 14);
		add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(594, 26, 25, 25);
		label_1.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/coin.png").getImage().getScaledInstance(25, 25,
				Image.SCALE_DEFAULT)));
		add(label_1);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/bg.jpg").getImage().getScaledInstance(800, 800,
				Image.SCALE_DEFAULT)));
		bg.setBounds(0, 0, 975, 571);
		add(bg);
	}

	protected JComponent makeAchievementsPanel() {
		JPanel panel = new JPanel(false);
		panel.setBackground(new Color(101, 140, 217));
		panel.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/star.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_DEFAULT)));
		label.setBounds(220, 165, 40, 40);
		panel.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/crown.png").getImage().getScaledInstance(60,
				60, Image.SCALE_DEFAULT)));
		label_1.setBounds(369, 153, 60, 60);
		panel.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/coin.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_DEFAULT)));
		label_2.setBounds(300, 230, 40, 40);
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/Avatar.png").getImage().getScaledInstance(50,
				50, Image.SCALE_DEFAULT)));
		label_3.setBounds(300, 73, 50, 50);
		panel.add(label_3);

		JLabel lblUsername = new JLabel("John");
		lblUsername.setBounds(295, 134, 69, 14);
		panel.add(lblUsername);

		JLabel label_4 = new JLabel("0");
		label_4.setBounds(200, 183, 46, 14);
		panel.add(label_4);

		JLabel label_5 = new JLabel("0");
		label_5.setBounds(439, 183, 46, 14);
		panel.add(label_5);

		JLabel label_6 = new JLabel("0");
		label_6.setBounds(350, 246, 46, 14);
		panel.add(label_6);
		return panel;
	}

	protected JComponent makeCarsPanel(String text) {
		JPanel panel = new JPanel(false);
		panel.setLayout(null);
		panel.setBackground(new Color(101, 140, 217));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 629, 368);
		scrollPane.setBorder(null);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);

		JPanel content = new JPanel();
		content.setBounds(10, 11, 679, 572);
		content.setPreferredSize(new Dimension(610, 715));
		content.setBackground(new Color(101, 140, 217));

		scrollPane.setViewportView(content);
		content.setLayout(null);
		// content.setAutoscrolls(true);

		Image coin = new ImageIcon("src/rushHour/images/coin.png").getImage().getScaledInstance(25, 25,
				Image.SCALE_DEFAULT);
		Image locked = new ImageIcon("src/rushHour/images/locked.png").getImage().getScaledInstance(25, 25,
				Image.SCALE_DEFAULT);

		JLabel label = new JLabel("");
		Image img = new ImageIcon("src/rushHour/images/red car.png").getImage().getScaledInstance(120, 45,
				Image.SCALE_DEFAULT);
		label.setIcon(new ImageIcon(img));
		label.setBounds(36, 31, 141, 114);
		content.add(label);

		JLabel lblDefualt = new JLabel("Default");
		lblDefualt.setBounds(84, 145, 46, 14);
		content.add(lblDefualt);

		JLabel label_1 = new JLabel("");
		Image img2 = new ImageIcon("src/rushHour/images/white car.png").getImage().getScaledInstance(165, 80,
				Image.SCALE_DEFAULT);
		label_1.setIcon(new ImageIcon(img2));
		label_1.setBounds(223, 25, 163, 114);
		content.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(locked));
		label_2.setBounds(326, 31, 25, 25);
		content.add(label_2);

		JButton btnUnlockFor = new JButton("Unlock for 10000");
		btnUnlockFor.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUnlockFor.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUnlockFor.setIcon(new ImageIcon(coin));
		btnUnlockFor.setBounds(202, 141, 169, 23);
		content.add(btnUnlockFor);

		JLabel lblNewLabel_2 = new JLabel("");
		Image img3 = new ImageIcon("src/rushHour/images/yellow car.png").getImage().getScaledInstance(165, 80,
				Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		lblNewLabel_2.setBounds(417, 31, 141, 114);
		content.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Unlock for 12000");
		btnNewButton.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setIcon(new ImageIcon(coin));
		btnNewButton.setBounds(410, 141, 169, 23);
		content.add(btnNewButton);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(locked));
		label_3.setBounds(533, 31, 25, 25);
		content.add(label_3);

		JLabel label_4 = new JLabel("");
		Image img4 = new ImageIcon("src/rushHour/images/green car.png").getImage().getScaledInstance(140, 60,
				Image.SCALE_DEFAULT);
		label_4.setIcon(new ImageIcon(img4));
		label_4.setBounds(21, 198, 141, 114);
		content.add(label_4);

		JButton btnUnlockFor_1 = new JButton("Unlock for 20000 ");
		btnUnlockFor_1.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUnlockFor_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUnlockFor_1.setIcon(new ImageIcon(coin));
		btnUnlockFor_1.setBounds(10, 323, 169, 23);
		content.add(btnUnlockFor_1);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(locked));
		label_5.setBounds(132, 200, 25, 25);
		content.add(label_5);

		JLabel label_6 = new JLabel("");
		Image img5 = new ImageIcon("src/rushHour/images/white car2.png").getImage().getScaledInstance(190, 70,
				Image.SCALE_DEFAULT);
		label_6.setIcon(new ImageIcon(img5));
		label_6.setBounds(202, 198, 169, 114);
		content.add(label_6);

		JButton btnUnlockFor_2 = new JButton("Unlock for 22000");
		btnUnlockFor_2.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUnlockFor_2.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUnlockFor_2.setIcon(new ImageIcon(coin));
		btnUnlockFor_2.setBounds(202, 323, 169, 23);
		content.add(btnUnlockFor_2);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(locked));
		label_7.setBounds(325, 195, 25, 25);
		content.add(label_7);

		JLabel label_8 = new JLabel("");
		Image img6 = new ImageIcon("src/rushHour/images/blue car.png").getImage().getScaledInstance(135, 85,
				Image.SCALE_DEFAULT);
		label_8.setIcon(new ImageIcon(img6));
		label_8.setBounds(417, 200, 141, 114);
		content.add(label_8);

		JButton btnUnlockFor_3 = new JButton("Unlock for 25000");

		btnUnlockFor_3.setBounds(417, 323, 169, 23);
		content.add(btnUnlockFor_3);
		btnUnlockFor_3.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUnlockFor_3.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUnlockFor_3.setIcon(new ImageIcon(coin));

		JLabel label_9 = new JLabel("");
		Image img7 = new ImageIcon("src/rushHour/images/purple car.png").getImage().getScaledInstance(200, 80,
				Image.SCALE_DEFAULT);
		label_9.setIcon(new ImageIcon(img7));
		label_9.setBounds(0, 375, 169, 114);
		content.add(label_9);

		JButton btnUnlockFor_4 = new JButton("Unlock for 30000");
		btnUnlockFor_4.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUnlockFor_4.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUnlockFor_4.setIcon(new ImageIcon(coin));
		btnUnlockFor_4.setBounds(10, 500, 169, 23);
		content.add(btnUnlockFor_4);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(locked));
		label_10.setBounds(530, 190, 25, 25);
		content.add(label_10);

		JLabel lblNewLabel_3 = new JLabel("");
		Image img8 = new ImageIcon("src/rushHour/images/black car.png").getImage().getScaledInstance(135, 50,
				Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(img8));
		lblNewLabel_3.setBounds(223, 387, 141, 114);
		content.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Unlock for 32000");
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1.setIcon(new ImageIcon(coin));
		btnNewButton_1.setBounds(202, 500, 169, 23);
		content.add(btnNewButton_1);

		JLabel label_11 = new JLabel("");
		Image img9 = new ImageIcon("src/rushHour/images/pink car.png").getImage().getScaledInstance(150, 75,
				Image.SCALE_DEFAULT);
		label_11.setIcon(new ImageIcon(img9));
		label_11.setBounds(427, 387, 141, 114);
		content.add(label_11);

		JButton btnUnlockFor_5 = new JButton("Unlock for 35000");
		btnUnlockFor_5.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUnlockFor_5.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUnlockFor_5.setIcon(new ImageIcon(coin));
		btnUnlockFor_5.setBounds(417, 500, 169, 23);
		content.add(btnUnlockFor_5);

		JLabel lblNewLabel_4 = new JLabel("");
		Image img10 = new ImageIcon("src/rushHour/images/silver car.png").getImage().getScaledInstance(130, 56,
				Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(img10));
		lblNewLabel_4.setBounds(36, 555, 141, 114);
		content.add(lblNewLabel_4);

		JButton btnUnlockFor_6 = new JButton("Unlock for 40000");
		btnUnlockFor_6.setHorizontalTextPosition(SwingConstants.LEFT);
		btnUnlockFor_6.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUnlockFor_6.setIcon(new ImageIcon(coin));
		btnUnlockFor_6.setBounds(10, 680, 169, 23);
		content.add(btnUnlockFor_6);

		JLabel label_12 = new JLabel("");
		label_12.setBounds(132, 375, 25, 25);
		label_12.setIcon(new ImageIcon(locked));
		content.add(label_12);

		JLabel label_13 = new JLabel("");
		label_13.setBounds(311, 373, 25, 25);
		label_13.setIcon(new ImageIcon(locked));
		content.add(label_13);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(533, 375, 25, 25);
		lblNewLabel_5.setIcon(new ImageIcon(locked));
		content.add(lblNewLabel_5);

		JLabel label_14 = new JLabel("");
		label_14.setBounds(131, 555, 25, 25);
		label_14.setIcon(new ImageIcon(locked));
		content.add(label_14);
		panel.add(scrollPane);

		return panel;
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}
}
