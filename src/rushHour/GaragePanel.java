package src.rushHour;

/**
 * __Garage Panel of the game.
 * @author __Masna and Naisila
 * @version__18/11/2018
 */
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GaragePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel back;
	private JLabel coinsLabel;
	private int coins;
	private FileManagementSystem fileSystem;

	/**
	 * Create the panel.
	 */
	public GaragePanel(FileManagementSystem fileSystem) {
		setLayout(null);
		setOpaque(false);
		this.fileSystem = fileSystem;
		coins = this.fileSystem.getUserData().getCoins();

		Image img = new ImageIcon("src/rushHour/images/back.png").getImage().getScaledInstance(120, 65,
				Image.SCALE_DEFAULT);
		Image img1 = new ImageIcon("src/rushHour/images/my garage.png").getImage().getScaledInstance(250, 50,
				Image.SCALE_DEFAULT);

		back = new JLabel("");
		back.setIcon(new ImageIcon(img));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setBounds(0, 0, 156, 65);
		add(back);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(257, 11, 250, 50);
		add(lblNewLabel_1);
		UIManager.put("TabbedPane.contentOpaque", false);
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(68, 66, 654, 407);
		// tabbedPane.setOpaque(false);

		JComponent panel1 = makeCarsPanel("Panel #1");
		tabbedPane.addTab("My Cars", null, panel1, "Does nothing");
		add(tabbedPane);
		panel1.setOpaque(false);

//		JComponent panel2 = makeAchievementsPanel();
//		tabbedPane.addTab("My Achievements", null, panel2, "Gets Achievements");

		coinsLabel = new JLabel(String.valueOf(coins)); // Need to obtain this value from the text file
		coinsLabel.setBounds(629, 31, 100, 50);
		coinsLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		coinsLabel.setForeground(Color.WHITE);
		add(coinsLabel);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(594, 40, 25, 25);
		label_1.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/coin.png").getImage().getScaledInstance(25, 25,
				Image.SCALE_DEFAULT)));
		add(label_1);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/garage.jpg").getImage().getScaledInstance(800, 800,
				Image.SCALE_DEFAULT)));
		bg.setBounds(0, 0, 975, 571);
		add(bg);
	}

//	protected JComponent makeAchievementsPanel() {
//		JPanel panel = new JPanel(false);
//		panel.setBackground(new Color(101, 140, 217));
//		panel.setLayout(null);
//
//		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/star.png").getImage().getScaledInstance(40, 40,
//				Image.SCALE_DEFAULT)));
//		label.setBounds(220, 165, 40, 40);
//		panel.add(label);
//
//		JLabel label_1 = new JLabel("");
//		label_1.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/crown.png").getImage().getScaledInstance(60,
//				60, Image.SCALE_DEFAULT)));
//		label_1.setBounds(369, 153, 60, 60);
//		panel.add(label_1);
//
//		JLabel label_2 = new JLabel("");
//		label_2.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/coin.png").getImage().getScaledInstance(40, 40,
//				Image.SCALE_DEFAULT)));
//		label_2.setBounds(300, 230, 40, 40);
//		panel.add(label_2);
//
//		JLabel label_3 = new JLabel("");
//		label_3.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/Avatar.png").getImage().getScaledInstance(50,
//				50, Image.SCALE_DEFAULT)));
//		label_3.setBounds(300, 73, 50, 50);
//		panel.add(label_3);
//
//		JLabel lblUsername = new JLabel(fileSystem.getUserData().getName());
//		lblUsername.setBounds(295, 134, 69, 14);
//		panel.add(lblUsername);
//
//		JLabel label_4 = new JLabel("0");
//		label_4.setBounds(200, 183, 46, 14);
//		panel.add(label_4);
//
//		JLabel label_5 = new JLabel("0");
//		label_5.setBounds(439, 183, 46, 14);
//		panel.add(label_5);
//
//		JLabel label_6 = new JLabel("0");
//		label_6.setBounds(350, 246, 46, 14);
//		panel.add(label_6);
//		return panel;
//	}

	protected JComponent makeCarsPanel(String text) {
		JPanel panel = new JPanel(false);
		panel.setLayout(null);
		// panel.setBackground(new Color(101, 140, 217));
		setOpaque(false);
		panel.setOpaque(false);
		JButton unlockCar0 = new JButton("Default");
		JButton unlockCar1 = new JButton("Unlock for 10000");
		JButton unlockCar2 = new JButton("Unlock for 12000");
		JButton unlockCar3 = new JButton("Unlock for 20000");
		JButton unlockCar4 = new JButton("Unlock for 22000");
		JButton unlockCar5 = new JButton("Unlock for 25000");
		JButton unlockCar6 = new JButton("Unlock for 30000");
		JButton unlockCar7 = new JButton("Unlock for 32000");
		JButton unlockCar8 = new JButton("Unlock for 35000");
		JButton unlockCar9 = new JButton("Unlock for 40000");

		ArrayList<JButton> buttonList = new ArrayList<>();
		buttonList.add(unlockCar0);
		buttonList.add(unlockCar1);
		buttonList.add(unlockCar2);
		buttonList.add(unlockCar3);
		buttonList.add(unlockCar4);
		buttonList.add(unlockCar5);
		buttonList.add(unlockCar6);
		buttonList.add(unlockCar7);
		buttonList.add(unlockCar8);
		buttonList.add(unlockCar9);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 629, 368);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);

		JPanel content = new JPanel();
		content.setBounds(10, 11, 679, 572);
		content.setPreferredSize(new Dimension(610, 715));
		// content.setBackground(new Color(101, 140, 217));
		content.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
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

		unlockCar0.setBounds(10, 141, 169, 23);
		unlockCar0.setHorizontalTextPosition(SwingConstants.CENTER);
		unlockCar0.setHorizontalAlignment(SwingConstants.CENTER);
		if (fileSystem.getUserData().getCar().equals("red car.png"))
			unlockCar0.setEnabled(false);
		else
			unlockCar0.setEnabled(true);
		unlockCar0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				GaragePanel.this.fileSystem.updateCar("red car.png");
				unlockCar0.setEnabled(false);
				String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
				unUnEnable(buttonList, userCar);
			}
		});
		content.add(unlockCar0);

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

		unlockCar1.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar1.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar1.setIcon(new ImageIcon(coin));
		unlockCar1.setBounds(202, 141, 169, 23);
		unlockCar1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar1.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("white car.png");
					unlockCar1.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 10000 && !unlockCar1.getText().equals("Select Car")) {
					unlockCar1.setText("Select Car");
					unlockCar1.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar1.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar1.setIcon(null);
					label_2.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 10000));
					GaragePanel.this.fileSystem.unlockCar("white car.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});

		if (fileSystem.isUnlocked("white car.png")) {
			unlockCar1.setText("Select Car");
			unlockCar1.setIcon(null);
			label_2.setVisible(false);
			unlockCar1.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("white car.png")) {
			unlockCar1.setEnabled(false);
		}

		content.add(unlockCar1);

		JLabel lblNewLabel_2 = new JLabel("");
		Image img3 = new ImageIcon("src/rushHour/images/yellow car.png").getImage().getScaledInstance(165, 80,
				Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		lblNewLabel_2.setBounds(417, 31, 141, 114);
		content.add(lblNewLabel_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(locked));
		label_3.setBounds(533, 31, 25, 25);
		content.add(label_3);

		unlockCar2.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar2.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar2.setIcon(new ImageIcon(coin));
		unlockCar2.setBounds(410, 141, 169, 23);
		unlockCar2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar2.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("yellow car.png");
					unlockCar2.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 12000 && !unlockCar2.getText().equals("Select Car")) {
					unlockCar2.setText("Select Car");
					unlockCar2.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar2.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar2.setIcon(null);
					label_3.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 12000));
					GaragePanel.this.fileSystem.unlockCar("yellow car.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});

		if (fileSystem.isUnlocked("yellow car.png")) {
			unlockCar2.setText("Select Car");
			unlockCar2.setIcon(null);
			label_3.setVisible(false);
			unlockCar2.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("yellow car.png")) {
			unlockCar2.setEnabled(false);
		}

		content.add(unlockCar2);

		JLabel label_4 = new JLabel("");
		Image img4 = new ImageIcon("src/rushHour/images/green car.png").getImage().getScaledInstance(140, 60,
				Image.SCALE_DEFAULT);
		label_4.setIcon(new ImageIcon(img4));
		label_4.setBounds(21, 198, 141, 114);
		content.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(locked));
		label_5.setBounds(132, 200, 25, 25);
		content.add(label_5);

		unlockCar3.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar3.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar3.setIcon(new ImageIcon(coin));
		unlockCar3.setBounds(10, 323, 169, 23);
		unlockCar3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar3.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("green car.png");
					unlockCar3.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 20000 && !unlockCar3.getText().equals("Select Car")) {
					// coins = GaragePanel.this.fileSystem.getUserData().getCoins();
					unlockCar3.setText("Select Car");
					unlockCar3.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar3.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar3.setIcon(null);
					label_5.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 20000));
					GaragePanel.this.fileSystem.unlockCar("green car.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});

		if (fileSystem.isUnlocked("green car.png")) {
			unlockCar3.setText("Select Car");
			unlockCar3.setIcon(null);
			label_5.setVisible(false);
			unlockCar3.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("green car.png")) {
			unlockCar3.setEnabled(false);
		}

		content.add(unlockCar3);

		JLabel label_6 = new JLabel("");
		Image img5 = new ImageIcon("src/rushHour/images/white car2.png").getImage().getScaledInstance(190, 70,
				Image.SCALE_DEFAULT);
		label_6.setIcon(new ImageIcon(img5));
		label_6.setBounds(202, 198, 169, 114);
		content.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(locked));
		label_7.setBounds(325, 195, 25, 25);
		content.add(label_7);

		unlockCar4.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar4.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar4.setIcon(new ImageIcon(coin));
		unlockCar4.setBounds(202, 323, 169, 23);
		unlockCar4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar4.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("white car2.png");
					unlockCar4.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 22000 && !unlockCar4.getText().equals("Select Car")) {
					unlockCar4.setText("Select Car");
					unlockCar4.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar4.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar4.setIcon(null);
					label_7.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 22000));
					GaragePanel.this.fileSystem.unlockCar("white car2.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});

		if (fileSystem.isUnlocked("white car2.png")) {
			unlockCar4.setText("Select Car");
			unlockCar4.setIcon(null);
			label_7.setVisible(false);
			unlockCar4.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar4.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("white car2.png")) {
			unlockCar4.setEnabled(false);
		}

		content.add(unlockCar4);

		JLabel label_8 = new JLabel("");
		Image img6 = new ImageIcon("src/rushHour/images/blue car.png").getImage().getScaledInstance(135, 85,
				Image.SCALE_DEFAULT);
		label_8.setIcon(new ImageIcon(img6));
		label_8.setBounds(417, 200, 141, 114);
		content.add(label_8);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(locked));
		label_10.setBounds(530, 190, 25, 25);
		content.add(label_10);

		unlockCar5.setBounds(417, 323, 169, 23);
		unlockCar5.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar5.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar5.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("blue car.png");
					unlockCar5.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 25000 && !unlockCar5.getText().equals("Select Car")) {
					unlockCar5.setText("Select Car");
					unlockCar5.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar5.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar5.setIcon(null);
					label_10.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 25000));
					GaragePanel.this.fileSystem.unlockCar("blue car.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});
		unlockCar5.setIcon(new ImageIcon(coin));

		if (fileSystem.isUnlocked("blue car.png")) {
			unlockCar5.setText("Select Car");
			unlockCar5.setIcon(null);
			label_10.setVisible(false);
			unlockCar5.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("blue car.png")) {
			unlockCar5.setEnabled(false);
		}

		content.add(unlockCar5);

		JLabel label_9 = new JLabel("");
		Image img7 = new ImageIcon("src/rushHour/images/purple car.png").getImage().getScaledInstance(200, 80,
				Image.SCALE_DEFAULT);
		label_9.setIcon(new ImageIcon(img7));
		label_9.setBounds(0, 375, 169, 114);
		content.add(label_9);

		JLabel label_12 = new JLabel("");
		label_12.setBounds(132, 375, 25, 25);
		label_12.setIcon(new ImageIcon(locked));
		content.add(label_12);

		unlockCar6.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar6.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar6.setIcon(new ImageIcon(coin));
		unlockCar6.setBounds(10, 500, 169, 23);
		unlockCar6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar6.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("purple car.png");
					unlockCar6.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 30000 && !unlockCar6.getText().equals("Select Car")) {
					unlockCar6.setText("Select Car");
					unlockCar6.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar6.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar6.setIcon(null);
					label_12.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 30000));
					GaragePanel.this.fileSystem.unlockCar("purple car.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});

		if (fileSystem.isUnlocked("purple car.png")) {
			unlockCar6.setText("Select Car");
			unlockCar6.setIcon(null);
			label_12.setVisible(false);
			unlockCar6.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar6.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("purple car.png")) {
			unlockCar1.setEnabled(false);
		}

		content.add(unlockCar6);

		JLabel lblNewLabel_3 = new JLabel("");
		Image img8 = new ImageIcon("src/rushHour/images/black car.png").getImage().getScaledInstance(135, 50,
				Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(img8));
		lblNewLabel_3.setBounds(223, 387, 141, 114);
		content.add(lblNewLabel_3);

		JLabel label_13 = new JLabel("");
		label_13.setBounds(311, 373, 25, 25);
		label_13.setIcon(new ImageIcon(locked));
		content.add(label_13);

		unlockCar7.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar7.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar7.setIcon(new ImageIcon(coin));
		unlockCar7.setBounds(202, 500, 169, 23);
		unlockCar7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar7.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("black car.png");
					unlockCar7.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 32000 && !unlockCar7.getText().equals("Select Car")) {
					unlockCar7.setText("Select Car");
					unlockCar7.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar7.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar7.setIcon(null);
					label_13.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 32000));
					GaragePanel.this.fileSystem.unlockCar("black car.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});

		if (fileSystem.isUnlocked("black car.png")) {
			unlockCar7.setText("Select Car");
			unlockCar7.setIcon(null);
			label_13.setVisible(false);
			unlockCar7.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar7.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("black car.png")) {
			unlockCar7.setEnabled(false);
		}

		content.add(unlockCar7);

		JLabel label_11 = new JLabel("");
		Image img9 = new ImageIcon("src/rushHour/images/pink car.png").getImage().getScaledInstance(150, 75,
				Image.SCALE_DEFAULT);
		label_11.setIcon(new ImageIcon(img9));
		label_11.setBounds(427, 387, 141, 114);
		content.add(label_11);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(533, 375, 25, 25);
		lblNewLabel_5.setIcon(new ImageIcon(locked));
		content.add(lblNewLabel_5);

		unlockCar8.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar8.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar8.setIcon(new ImageIcon(coin));
		unlockCar8.setBounds(417, 500, 169, 23);
		unlockCar8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar8.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("pink car.png");
					unlockCar8.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 35000 && !unlockCar8.getText().equals("Select Car")) {
					unlockCar8.setText("Select Car");
					unlockCar8.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar8.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar8.setIcon(null);
					lblNewLabel_5.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 35000));
					GaragePanel.this.fileSystem.unlockCar("pink car.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});

		if (fileSystem.isUnlocked("pink car.png")) {
			unlockCar8.setText("Select Car");
			unlockCar8.setIcon(null);
			lblNewLabel_5.setVisible(false);
			unlockCar8.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar8.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("pink car.png")) {
			unlockCar8.setEnabled(false);
		}

		content.add(unlockCar8);

		JLabel lblNewLabel_4 = new JLabel("");
		Image img10 = new ImageIcon("src/rushHour/images/silver car.png").getImage().getScaledInstance(130, 56,
				Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(img10));
		lblNewLabel_4.setBounds(36, 555, 141, 114);
		content.add(lblNewLabel_4);

		JLabel label_14 = new JLabel("");
		label_14.setBounds(131, 555, 25, 25);
		label_14.setIcon(new ImageIcon(locked));
		content.add(label_14);
		panel.add(scrollPane);

		unlockCar9.setHorizontalTextPosition(SwingConstants.LEFT);
		unlockCar9.setHorizontalAlignment(SwingConstants.RIGHT);
		unlockCar9.setIcon(new ImageIcon(coin));
		unlockCar9.setBounds(10, 680, 169, 23);
		unlockCar9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coins = GaragePanel.this.fileSystem.getUserData().getCoins();

				if (unlockCar9.getText().equals("Select Car")) {
					GaragePanel.this.fileSystem.updateCar("silver car.png");
					unlockCar9.setEnabled(false);
					String userCar = GaragePanel.this.fileSystem.getUserData().getCar();
					unUnEnable(buttonList, userCar);
				}

				if (coins >= 40000 && !unlockCar9.getText().equals("Select Car")) {
					unlockCar9.setText("Select Car");
					unlockCar9.setHorizontalTextPosition(SwingConstants.CENTER);
					unlockCar9.setHorizontalAlignment(SwingConstants.CENTER);
					unlockCar9.setIcon(null);
					label_14.setVisible(false);
					GaragePanel.this.fileSystem.updateCoins(String.valueOf(coins - 40000));
					GaragePanel.this.fileSystem.unlockCar("silver car.png");
					coinsLabel.setText(String.valueOf(GaragePanel.this.fileSystem.getUserData().getCoins()));
				}
			}
		});

		if (fileSystem.isUnlocked("silver car.png")) {
			unlockCar9.setText("Select Car");
			unlockCar9.setIcon(null);
			label_14.setVisible(false);
			unlockCar9.setHorizontalTextPosition(SwingConstants.CENTER);
			unlockCar9.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (fileSystem.getUserData().getCar().equals("silver car.png")) {
			unlockCar9.setEnabled(false);
		}

		content.add(unlockCar9);
		return panel;
	}

	private void unUnEnable(ArrayList<JButton> buttonList, String userCar) {
		for (int i = 0; i <= 9; i++) {
			buttonList.get(i).setEnabled(true);
		}
		System.out.println(userCar);
		if (userCar.equals("red car.png")) {
			System.out.println(userCar);
			buttonList.get(0).setEnabled(false);
		}
		if (userCar.equals("white car.png")) {
			System.out.println(userCar);
			buttonList.get(1).setEnabled(false);
		}
		if (userCar.equals("yellow car.png")) {
			System.out.println(userCar);
			buttonList.get(2).setEnabled(false);
		}
		if (userCar.equals("green car.png")) {
			System.out.println(userCar);
			buttonList.get(3).setEnabled(false);
		}
		if (userCar.equals("white car2.png")) {
			System.out.println(userCar);
			buttonList.get(4).setEnabled(false);
		}
		if (userCar.equals("blue car.png")) {
			System.out.println(userCar);
			buttonList.get(5).setEnabled(false);
		}
		if (userCar.equals("purple car.png")) {
			System.out.println(userCar);
			buttonList.get(6).setEnabled(false);
		}
		if (userCar.equals("black car.png")) {
			System.out.println(userCar);
			buttonList.get(7).setEnabled(false);
		}
		if (userCar.equals("pink car.png")) {
			System.out.println(userCar);
			buttonList.get(8).setEnabled(false);
		}
		if (userCar.equals("silver car.png")) {
			System.out.println(userCar);
			buttonList.get(9).setEnabled(false);
		}
	}

	public void update() {
		coins = this.fileSystem.getUserData().getCoins();
		coinsLabel.setText(String.valueOf(coins));
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}
}
