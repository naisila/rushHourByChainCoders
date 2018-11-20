package rushHour;

import javax.print.DocFlavor.URL;
/**
 * __ChoosePuzzle
 * @author __Talha
 * @version__18/11/2018
 */
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;

public class ChoosePuzzle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUnsolved;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel back;
	private JButton puzzle_2;

	/**
	 * Create the frame.
	 */
	public ChoosePuzzle() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		// Image of Choose Puzzle
		// URL bLabel = ChoosePuzzle.class.getResource("src/rushHour/images/back.png");
		ImageIcon icone = new ImageIcon(new ImageIcon(ChoosePuzzle.class.getResource("/rushHour/images/back.png"))
				.getImage().getScaledInstance(120, 65, Image.SCALE_DEFAULT));

		back = new JLabel("");
		back.setBounds(0, 0, 156, 65);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setIcon(icone);
		add(back);

		// Image of Level
		String levLabel = "src/rushHour/images/intermediateLevel.png";
		ImageIcon myIcon = new ImageIcon(
				new ImageIcon(levLabel).getImage().getScaledInstance(460, 65, Image.SCALE_DEFAULT));
		JLabel levelLabel = new JLabel("difflvl");
		levelLabel.setBounds(185, 70, 460, 65);
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setIcon(myIcon);
		add(levelLabel);

		// Image of Choose Puzzle
		String cLbl = "src/rushHour/images/choosePuzzle.png";
		ImageIcon chooseIcon = new ImageIcon(
				new ImageIcon(cLbl).getImage().getScaledInstance(284, 56, Image.SCALE_DEFAULT));
		JLabel lblChooselbl = new JLabel("cpzzl");
		lblChooselbl.setBounds(267, 148, 292, 56);
		lblChooselbl.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooselbl.setIcon(chooseIcon);
		add(lblChooselbl);

		// Add Buttons to select Puzzle

		JButton btnPuzzle = new JButton("Puzzle 1");
		btnPuzzle.setBounds(93, 42, 97, 35);

		puzzle_2 = new JButton("Puzzle 2");
		puzzle_2.setBounds(93, 104, 97, 38);

		JButton btnPuzzle_2 = new JButton("Puzzle 3");
		btnPuzzle_2.setBounds(93, 174, 97, 40);

		JButton button = new JButton("Puzzle 4");
		button.setBounds(93, 248, 97, 40);
		txtUnsolved = new JTextField();
		txtUnsolved.setBounds(230, 104, 281, 38);
		txtUnsolved.setEditable(false);
		txtUnsolved.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnsolved.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUnsolved.setBackground(new Color(217, 102, 102));
		txtUnsolved.setText("UNSOLVED");
		txtUnsolved.setColumns(10);

		textField = new JTextField();
		textField.setBounds(230, 249, 281, 38);
		textField.setEditable(false);
		textField.setText("UNSOLVED");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBackground(new Color(217, 102, 102));

		// BackGround
		// Image of Crown
		String bgIcn = "src/rushHour/images/bg.jpg";
		ImageIcon backGrIcon = new ImageIcon(
				new ImageIcon(bgIcn).getImage().getScaledInstance(819, 645, Image.SCALE_DEFAULT));
		ImageIcon contentBackGr = new ImageIcon(
				new ImageIcon(bgIcn).getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT));

		// Panel to be added to ScrollPanel
		JPanel scPanel = new JPanel();
		scPanel.setBounds(141, 212, 721, 439);
		scPanel.setPreferredSize(new Dimension(266, 730));

		// ScrollPane for Panel containing puzzles
		JScrollPane scrollPane = new JScrollPane();
		scPanel.setAutoscrolls(true);
		scrollPane.setBounds(89, 223, 621, 246);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scPanel.setLayout(null);

		// Buttons
		scPanel.add(btnPuzzle);
		scPanel.add(puzzle_2);
		scPanel.add(btnPuzzle_2);
		scPanel.add(button);

		// Add Unsolved Lables
		scPanel.add(txtUnsolved);
		scPanel.add(textField);

		JButton btnPuzzle_3 = new JButton("Puzzle 5");
		btnPuzzle_3.setBounds(93, 320, 97, 40);
		scPanel.add(btnPuzzle_3);

		JButton btnPuzzle_4 = new JButton("Puzzle 6");
		btnPuzzle_4.setBounds(93, 390, 97, 40);
		scPanel.add(btnPuzzle_4);

		JButton btnPuzzle_5 = new JButton("Puzzle 7");
		btnPuzzle_5.setBounds(93, 461, 97, 40);
		scPanel.add(btnPuzzle_5);

		JButton btnPuzzle_6 = new JButton("Puzzle 8");
		btnPuzzle_6.setBounds(93, 538, 97, 40);
		scPanel.add(btnPuzzle_6);

		JButton btnPuzzle_7 = new JButton("Puzzle 9\r\n");
		btnPuzzle_7.setBounds(93, 610, 97, 40);
		scPanel.add(btnPuzzle_7);

		JButton btnPuzzle_8 = new JButton("Puzzle 10");
		btnPuzzle_8.setBounds(93, 677, 97, 40);
		scPanel.add(btnPuzzle_8);

		textField_5 = new JTextField();
		textField_5.setText("UNSOLVED");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(217, 102, 102));
		textField_5.setBounds(230, 329, 281, 38);
		scPanel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setText("UNSOLVED");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(217, 102, 102));
		textField_6.setBounds(230, 391, 281, 38);
		scPanel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setText("UNSOLVED");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(217, 102, 102));
		textField_7.setBounds(230, 461, 281, 38);
		scPanel.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setText("UNSOLVED");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(217, 102, 102));
		textField_8.setBounds(230, 540, 281, 38);
		scPanel.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setText("UNSOLVED");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(217, 102, 102));
		textField_9.setBounds(230, 619, 281, 38);
		scPanel.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setText("UNSOLVED");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(217, 102, 102));
		textField_10.setBounds(230, 679, 281, 38);
		scPanel.add(textField_10);
		add(scrollPane);

		JLabel contentBg = new JLabel("");
		contentBg.setBounds(-50, 0, 700, 1000);
		contentBg.setIcon(contentBackGr);
		// contentBg.setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		// scPanel.add(contentBg);
		scPanel.setBackground(new Color(101, 140, 217));
		scrollPane.setViewportView(scPanel);
		contentBg.setBorder(null);
		scPanel.setBorder(null);

		textField_1 = new JTextField();
		textField_1.setText("UNSOLVED");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(217, 102, 102));
		textField_1.setBounds(230, 42, 281, 38);
		scPanel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText("UNSOLVED");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(217, 102, 102));
		textField_2.setBounds(230, 174, 281, 38);
		scPanel.add(textField_2);
		scrollPane.setBorder(null);
		// scPanel.setOpaque(false);

		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 801, 598);
		bg.setIcon(backGrIcon);
		add(bg);
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}

	public void setMLPuzz(MouseAdapter madpt) {
		puzzle_2.addMouseListener(madpt);
	}
}
