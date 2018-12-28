package rushHour;

/**
 * __Choose Difficulty Panel of the game.
 * @author __Naisila and Masna
 * @version__18/11/2018
 */

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChooseDifficulty extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel back;
	private JButton beg;
	private int diff;
	private JButton inter;
	private JButton hard;
	private JButton expert;
	private User u;
	private JTextPane stars;
	private FileManagementSystem fms;
	private JTextPane moreStars;

	/**
	 * Create the panel.
	 */
	public ChooseDifficulty(FileManagementSystem fmsi) {
		fms = fmsi;
		u = fms.getUserData();
		setLayout(null);
		diff = 0;

		Image img = new ImageIcon("src/rushHour/images/back.png").getImage().getScaledInstance(120, 65,
				Image.SCALE_DEFAULT);
		Image img2 = new ImageIcon("src/rushHour/images/chooseLevel.png").getImage().getScaledInstance(452, 62,
				Image.SCALE_DEFAULT);
		Image img3 = new ImageIcon("src/rushHour/images/star.png").getImage().getScaledInstance(65, 65,
				Image.SCALE_DEFAULT);

		back = new JLabel("");
		back.setIcon(new ImageIcon(img));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setBounds(0, 0, 156, 65);
		add(back);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(150, 52, 519, 70);
		add(lblNewLabel);

		moreStars = new JTextPane();
		// moreStars.setText("20 stars needed to unlock next level"); // a method will
		// be used to calculate this
		moreStars.setOpaque(false);
		moreStars.setBounds(90, 228, 100, 70);
		moreStars.setFont(new Font("Monospaced", Font.BOLD, 14));
		add(moreStars);

		beg = new JButton("");
		beg.setText("Los Angeles");
		beg.setFont(new Font("Calibri", Font.PLAIN, 18));
		beg.setBackground(Color.LIGHT_GRAY);
		beg.setIcon(new ImageIcon("src/rushHour/images/rightIcon.png"));
		beg.setBounds(270, 133, 183, 45);
		beg.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				diff = 0;
			}
		});
		beg.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Clip clipNameClip;
				try {
					AudioInputStream clipNameAIS = AudioSystem
							.getAudioInputStream(getClass().getResourceAsStream("/rushHour/sound/button.wav"));
					// System.out.println("4");
					clipNameClip = AudioSystem.getClip();
					// System.out.println("1");
					clipNameClip.open(clipNameAIS);
					// System.out.println("3");
					clipNameClip.setFramePosition(0);
					// System.out.println("2");
					clipNameClip.start();

				} catch (Exception e1) {
					System.out.println("Failure to load sound");
				}
			}
		});
		add(beg);

		inter = new JButton("");
		inter.setText("Hong Kong");
		inter.setFont(new Font("Calibri", Font.PLAIN, 18));
		inter.setBackground(Color.PINK);
		if (u.getStars() < 15) {
			inter.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage().getScaledInstance(25,
					25, Image.SCALE_DEFAULT)));
			inter.setEnabled(false);
			moreStars.setText((15 - u.getStars()) + " stars needed to unlock next level");
		} else {
			inter.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					diff = 1;
				}
			});
		}
		inter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Clip clipNameClip;
				try {
					AudioInputStream clipNameAIS = AudioSystem
							.getAudioInputStream(getClass().getResourceAsStream("/rushHour/sound/button.wav"));
					// System.out.println("4");
					clipNameClip = AudioSystem.getClip();
					// System.out.println("1");
					clipNameClip.open(clipNameAIS);
					// System.out.println("3");
					clipNameClip.setFramePosition(0);
					// System.out.println("2");
					clipNameClip.start();

				} catch (Exception e1) {
					System.out.println("Failure to load sound");
				}
			}
		});
		inter.setBounds(270, 215, 183, 45);

		add(inter);

		hard = new JButton("");
		hard.setText("Paris");
		hard.setFont(new Font("Calibri", Font.PLAIN, 18));
		hard.setBackground(Color.PINK);
		if (u.getStars() < 30) {
			hard.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage().getScaledInstance(25,
					25, Image.SCALE_DEFAULT)));
			hard.setEnabled(false);
			if (u.getStars() >= 15)
				moreStars.setText((30 - u.getStars()) + " stars needed to unlock next level");
		} else {
			hard.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					diff = 2;
				}
			});
		}
		hard.setBounds(270, 298, 183, 50);
		hard.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Clip clipNameClip;
				try {
					AudioInputStream clipNameAIS = AudioSystem
							.getAudioInputStream(getClass().getResourceAsStream("/rushHour/sound/button.wav"));
					// System.out.println("4");
					clipNameClip = AudioSystem.getClip();
					// System.out.println("1");
					clipNameClip.open(clipNameAIS);
					// System.out.println("3");
					clipNameClip.setFramePosition(0);
					// System.out.println("2");
					clipNameClip.start();

				} catch (Exception e1) {
					System.out.println("Failure to load sound");
				}
			}
		});
		add(hard);

		expert = new JButton("");
		expert.setText("Shkoder");
		expert.setFont(new Font("Calibri", Font.PLAIN, 18));
		expert.setBackground(Color.PINK);
		if (u.getStars() < 45) {
			expert.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage()
					.getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			expert.setEnabled(false);
			if (u.getStars() >= 30)
				moreStars.setText((45 - u.getStars()) + " stars needed to unlock next level");
		} else {
			expert.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					diff = 3;
				}
			});
		}
		expert.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Clip clipNameClip;
				try {
					AudioInputStream clipNameAIS = AudioSystem
							.getAudioInputStream(getClass().getResourceAsStream("/rushHour/sound/button.wav"));
					// System.out.println("4");
					clipNameClip = AudioSystem.getClip();
					// System.out.println("1");
					clipNameClip.open(clipNameAIS);
					// System.out.println("3");
					clipNameClip.setFramePosition(0);
					// System.out.println("2");
					clipNameClip.start();

				} catch (Exception e1) {
					System.out.println("Failure to load sound");
				}
			}
		});
		expert.setBounds(270, 387, 183, 45);

		add(expert);

		stars = new JTextPane();
		stars.setText(u.getStars() + ""); // here a method will be used to get the user's number of stars
		stars.setFont(new Font("Monospaced", Font.BOLD, 20));
		stars.setOpaque(false);
		stars.setBounds(55, 175, 30, 40);
		add(stars);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(img3));
		label_1.setBounds(90, 152, 65, 65);
		add(label_1);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/poster.jpg").getImage().getScaledInstance(778, 566,
				Image.SCALE_DEFAULT)));
		bg.setBounds(0, 0, 778, 566);
		add(bg);
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}

	public void setMLBeg(ActionListener madpt) {
		beg.addActionListener(madpt);
		inter.addActionListener(madpt);
		hard.addActionListener(madpt);
		expert.addActionListener(madpt);
	}

	public void update() {
		u = fms.getUserData();
		stars.setText(u.getStars() + "");
		if (u.getStars() < 15) {
			inter.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage().getScaledInstance(25,
					25, Image.SCALE_DEFAULT)));
			inter.setEnabled(false);
			moreStars.setText((15 - u.getStars()) + " stars needed to unlock next level");
		} else {
			inter.setBackground(Color.LIGHT_GRAY);
			inter.setIcon(new ImageIcon("src/rushHour/images/rightIcon.png"));
			inter.setEnabled(true);
			inter.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					diff = 1;
				}
			});
		}
		if (u.getStars() < 30) {
			hard.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage().getScaledInstance(25,
					25, Image.SCALE_DEFAULT)));
			hard.setEnabled(false);
			if (u.getStars() >= 15)
				moreStars.setText((30 - u.getStars()) + " stars needed to unlock next level");
		} else {
			hard.setBackground(Color.LIGHT_GRAY);
			hard.setIcon(new ImageIcon("src/rushHour/images/rightIcon.png"));
			hard.setEnabled(true);
			hard.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					diff = 2;
				}
			});
		}
		if (u.getStars() < 45) {
			expert.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage()
					.getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
			expert.setEnabled(false);
			if (u.getStars() >= 30)
				moreStars.setText((45 - u.getStars()) + " stars needed to unlock next level");
		} else {
			expert.setBackground(Color.LIGHT_GRAY);
			expert.setIcon(new ImageIcon("src/rushHour/images/rightIcon.png"));
			expert.setEnabled(true);
			expert.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					diff = 3;
				}
			});
		}
	}

	public int getDiff() {
		return diff;
	}
}
