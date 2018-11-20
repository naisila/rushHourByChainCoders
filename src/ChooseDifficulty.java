package rushHour;

/**
 * __ChooseDifficulty
 * @author __Masna
 * @version__18/11/2018
 */
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;

public class ChooseDifficulty extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel back;
	private JButton beg;

	/**
	 * Create the panel.
	 */
	public ChooseDifficulty() {
		setLayout(null);

		Image img = new ImageIcon("src/rushHour/images/back.png").getImage().getScaledInstance(120, 45,
				Image.SCALE_DEFAULT);
		Image img2 = new ImageIcon("src/rushHour/images/chooseLevel.png").getImage().getScaledInstance(452, 62,
				Image.SCALE_DEFAULT);
		Image img3 = new ImageIcon("src/rushHour/images/star.png").getImage().getScaledInstance(65, 65,
				Image.SCALE_DEFAULT);

		back = new JLabel("");
		back.setIcon(new ImageIcon(img));
		back.setBounds(10, 11, 120, 45);
		add(back);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(150, 52, 519, 70);
		add(lblNewLabel);

		beg = new JButton("");
		beg.setText("Beginner");
		beg.setFont(new Font("Calibri", Font.PLAIN, 18));
		beg.setBackground(Color.LIGHT_GRAY);
		beg.setIcon(new ImageIcon("src/rushHour/images/rightIcon.png"));
		beg.setBounds(270, 133, 183, 45);
		add(beg);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setText("Intermediate");
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage()
				.getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		btnNewButton_1.setBounds(270, 215, 183, 45);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setText("Hard");
		btnNewButton_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage()
				.getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		btnNewButton_2.setBounds(270, 298, 183, 50);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setText("Expert");
		btnNewButton_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnNewButton_3.setBackground(Color.PINK);
		btnNewButton_3.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/locked.png").getImage()
				.getScaledInstance(25, 25, Image.SCALE_DEFAULT)));
		btnNewButton_3.setBounds(270, 387, 183, 45);
		add(btnNewButton_3);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(img3));
		label_1.setBounds(90, 152, 65, 65);
		add(label_1);

		JTextPane textPane = new JTextPane();
		textPane.setText("0"); // here a method will be used to get the user's number of stars
		textPane.setOpaque(false);
		textPane.setBounds(63, 165, 22, 20);
		add(textPane);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("20 stars needed to unlock next level"); // a method will be used to calculate this
		textPane_1.setOpaque(false);
		textPane_1.setBounds(90, 228, 65, 70);
		add(textPane_1);

		JLabel bg = new JLabel("");
		bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/bg.jpg").getImage().getScaledInstance(778, 566,
				Image.SCALE_DEFAULT)));
		bg.setBounds(0, 0, 778, 566);
		add(bg);
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}

	public void setMLBeg(MouseAdapter madpt) {
		beg.addMouseListener(madpt);
	}
}
