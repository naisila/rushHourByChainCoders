package rushHour;

import javax.print.DocFlavor.URL;
/**
 * __Game Panel of the game.
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
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChoosePuzzle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField puzz2;
	private JTextField puzz4;
	private JTextField puzz5;
	private JTextField puzz6;
	private JTextField puzz7;
	private JTextField puzz8;
	private JTextField puzz9;
	private JTextField puzz10;
	private JTextField puzz1;
	private JTextField puzz3;
	private JLabel back;
	private JButton puzzle_2;
	private JButton puzzle_1;
	private JButton puzzle_3;
	private JButton puzzle_4;
	private JButton puzzle_5;
	private JButton puzzle_6;
	private JButton puzzle_7;
	private JButton puzzle_8;
	private JButton puzzle_9;
	private JButton puzzle_10;
	private FileManagementSystem fms;
	private int puzz;
	private int diff;
	private String bgIcn;
	private ImageIcon backGrIcon;
	private ImageIcon contentBackGr;
	private JLabel bg;

	/**
	 * Create the frame.
	 */
	public ChoosePuzzle(FileManagementSystem fmsi) {
		fms = fmsi;
		diff = 0;
		puzz = 0;
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

		puzzle_1 = new JButton("Puzzle 1");
		puzzle_1.setBounds(93, 42, 97, 35);
		puzzle_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 0;
			}
		});

		puzzle_2 = new JButton("Puzzle 2");
		puzzle_2.setBounds(93, 104, 97, 38);
		puzzle_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 1;
			}
		});

		puzzle_3 = new JButton("Puzzle 3");
		puzzle_3.setBounds(93, 174, 97, 40);
		puzzle_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 2;
			}
		});

		puzzle_4 = new JButton("Puzzle 4");
		puzzle_4.setBounds(93, 248, 97, 40);
		puzzle_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 3;
			}
		});

		puzz2 = new JTextField();
		puzz2.setBounds(230, 104, 281, 38);
		puzz2.setEditable(false);
		puzz2.setHorizontalAlignment(SwingConstants.CENTER);
		puzz2.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz2.setBackground(new Color(217, 102, 102));
		puzz2.setText("1");
		puzz2.setColumns(10);

		puzz4 = new JTextField();
		puzz4.setBounds(230, 249, 281, 38);
		puzz4.setEditable(false);
		puzz4.setText("2");
		puzz4.setHorizontalAlignment(SwingConstants.CENTER);
		puzz4.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz4.setColumns(10);
		puzz4.setBackground(new Color(217, 102, 102));
		
		
		// BackGround
		// Image of Crown
		if(diff == 0)
			bgIcn = "src/rushHour/images/labg.jpg";
		else if(diff == 1)
			bgIcn = "src/rushHour/images/chinabg.jpg";
		else
			bgIcn = "src/rushHour/images/parisbg.jpg";
		backGrIcon = new ImageIcon(
				new ImageIcon(bgIcn).getImage().getScaledInstance(819, 645, Image.SCALE_DEFAULT));
		contentBackGr = new ImageIcon(
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
		scPanel.add(puzzle_1);
		scPanel.add(puzzle_2);
		scPanel.add(puzzle_3);
		scPanel.add(puzzle_4);

		// Add Unsolved Lables
		scPanel.add(puzz2);
		scPanel.add(puzz4);

		puzzle_5 = new JButton("Puzzle 5");
		puzzle_5.setBounds(93, 320, 97, 40);
		scPanel.add(puzzle_5);
		puzzle_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 4;
			}
		});

		puzzle_6 = new JButton("Puzzle 6");
		puzzle_6.setBounds(93, 390, 97, 40);
		scPanel.add(puzzle_6);
		puzzle_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 5;
			}
		});

		puzzle_7 = new JButton("Puzzle 7");
		puzzle_7.setBounds(93, 461, 97, 40);
		scPanel.add(puzzle_7);
		puzzle_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 6;
			}
		});

		puzzle_8 = new JButton("Puzzle 8");
		puzzle_8.setBounds(93, 538, 97, 40);
		scPanel.add(puzzle_8);
		puzzle_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 7;
			}
		});

		puzzle_9 = new JButton("Puzzle 9");
		puzzle_9.setBounds(93, 610, 97, 40);
		scPanel.add(puzzle_9);
		puzzle_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 8;
			}
		});

		puzzle_10 = new JButton("Puzzle 10");
		puzzle_10.setBounds(93, 677, 97, 40);
		scPanel.add(puzzle_10);
		puzzle_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				puzz = 9;
			}
		});

		puzz5 = new JTextField();
		puzz5.setText("3");
		puzz5.setHorizontalAlignment(SwingConstants.CENTER);
		puzz5.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz5.setEditable(false);
		puzz5.setColumns(10);
		puzz5.setBackground(new Color(217, 102, 102));
		puzz5.setBounds(230, 329, 281, 38);
		scPanel.add(puzz5);

		puzz6 = new JTextField();
		puzz6.setText("4");
		puzz6.setHorizontalAlignment(SwingConstants.CENTER);
		puzz6.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz6.setEditable(false);
		puzz6.setColumns(10);
		puzz6.setBackground(new Color(217, 102, 102));
		puzz6.setBounds(230, 391, 281, 38);
		scPanel.add(puzz6);

		puzz7 = new JTextField();
		puzz7.setText("5");
		puzz7.setHorizontalAlignment(SwingConstants.CENTER);
		puzz7.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz7.setEditable(false);
		puzz7.setColumns(10);
		puzz7.setBackground(new Color(217, 102, 102));
		puzz7.setBounds(230, 461, 281, 38);
		scPanel.add(puzz7);

		puzz8 = new JTextField();
		puzz8.setText("6");
		puzz8.setHorizontalAlignment(SwingConstants.CENTER);
		puzz8.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz8.setEditable(false);
		puzz8.setColumns(10);
		puzz8.setBackground(new Color(217, 102, 102));
		puzz8.setBounds(230, 540, 281, 38);
		scPanel.add(puzz8);

		puzz9 = new JTextField();
		puzz9.setText("7");
		puzz9.setHorizontalAlignment(SwingConstants.CENTER);
		puzz9.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz9.setEditable(false);
		puzz9.setColumns(10);
		puzz9.setBackground(new Color(217, 102, 102));
		puzz9.setBounds(230, 619, 281, 38);
		scPanel.add(puzz9);

		puzz10 = new JTextField();
		puzz10.setText("8");
		puzz10.setHorizontalAlignment(SwingConstants.CENTER);
		puzz10.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz10.setEditable(false);
		puzz10.setColumns(10);
		puzz10.setBackground(new Color(217, 102, 102));
		puzz10.setBounds(230, 679, 281, 38);
		scPanel.add(puzz10);
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

		puzz1 = new JTextField();
		puzz1.setText("9");
		puzz1.setHorizontalAlignment(SwingConstants.CENTER);
		puzz1.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz1.setEditable(false);
		puzz1.setColumns(10);
		puzz1.setBackground(new Color(217, 102, 102));
		puzz1.setBounds(230, 42, 281, 38);
		scPanel.add(puzz1);

		puzz3 = new JTextField();
		puzz3.setText("10");
		puzz3.setHorizontalAlignment(SwingConstants.CENTER);
		puzz3.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz3.setEditable(false);
		puzz3.setColumns(10);
		puzz3.setBackground(new Color(217, 102, 102));
		puzz3.setBounds(230, 174, 281, 38);
		scPanel.add(puzz3);
		scrollPane.setBorder(null);
		// scPanel.setOpaque(false);

		bg = new JLabel("");
		bg.setBounds(0, 0, 801, 598);
		bg.setIcon(backGrIcon);
		add(bg);
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}

	public void setMLPuzz(MouseAdapter madpt) {
		puzzle_1.addMouseListener(madpt);
		puzzle_2.addMouseListener(madpt);
		puzzle_3.addMouseListener(madpt);
		puzzle_4.addMouseListener(madpt);
		puzzle_5.addMouseListener(madpt);
		puzzle_6.addMouseListener(madpt);
		puzzle_7.addMouseListener(madpt);
		puzzle_8.addMouseListener(madpt);
		puzzle_9.addMouseListener(madpt);
		puzzle_10.addMouseListener(madpt);
	}

	public int getPuzz() {
		return puzz;
	}

	public void setDiff(int difficulty) {
		diff = difficulty;
	}

	public void update() {
		ArrayList<Integer> puzzle1 = fms.getPuzzleStats(diff, 0);
		if (puzzle1.get(1) == 0) {
			puzz1.setText("UNSOLVED");
			puzz1.setBackground(new Color(217, 102, 102));
		} else {
			puzz1.setText("SOLVED! " + puzzle1.get(2) + " stars");
			puzz1.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle2 = fms.getPuzzleStats(diff, 1);
		if (puzzle2.get(1) == 0) {
			puzz2.setText("UNSOLVED");
			puzz2.setBackground(new Color(217, 102, 102));
		} else {
			puzz2.setText("SOLVED! " + puzzle2.get(2) + " stars");
			puzz2.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle3 = fms.getPuzzleStats(diff, 2);
		if (puzzle3.get(1) == 0) {
			puzz3.setText("UNSOLVED");
			puzz3.setBackground(new Color(217, 102, 102));
		} else {
			puzz3.setText("SOLVED! " + puzzle3.get(2) + " stars");
			puzz3.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle4 = fms.getPuzzleStats(diff, 3);
		if (puzzle4.get(1) == 0) {
			puzz4.setText("UNSOLVED");
			puzz4.setBackground(new Color(217, 102, 102));
		} else {
			puzz4.setText("SOLVED! " + puzzle4.get(2) + " stars");
			puzz4.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle5 = fms.getPuzzleStats(diff, 4);
		if (puzzle5.get(1) == 0) {
			puzz5.setText("UNSOLVED");
			puzz5.setBackground(new Color(217, 102, 102));
		} else {
			puzz5.setText("SOLVED! " + puzzle5.get(2) + " stars");
			puzz5.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle6 = fms.getPuzzleStats(diff, 5);
		if (puzzle6.get(1) == 0) {
			puzz6.setText("UNSOLVED");
			puzz6.setBackground(new Color(217, 102, 102));
		} else {
			puzz6.setText("SOLVED! " + puzzle6.get(2) + " stars");
			puzz6.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle7 = fms.getPuzzleStats(diff, 6);
		if (puzzle7.get(1) == 0) {
			puzz7.setText("UNSOLVED");
			puzz7.setBackground(new Color(217, 102, 102));
		} else {
			puzz7.setText("SOLVED! " + puzzle7.get(2) + " stars");
			puzz7.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle8 = fms.getPuzzleStats(diff, 7);
		if (puzzle8.get(1) == 0) {
			puzz8.setText("UNSOLVED");
			puzz8.setBackground(new Color(217, 102, 102));
		} else {
			puzz8.setText("SOLVED! " + puzzle8.get(2) + " stars");
			puzz8.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle9 = fms.getPuzzleStats(diff, 8);
		if (puzzle9.get(1) == 0) {
			puzz9.setText("UNSOLVED");
			puzz9.setBackground(new Color(217, 102, 102));
		} else {
			puzz9.setText("SOLVED! " + puzzle9.get(2) + " stars");
			puzz9.setBackground(new Color(50, 205, 50));
		}
		ArrayList<Integer> puzzle10 = fms.getPuzzleStats(diff, 9);
		if (puzzle10.get(1) == 0) {
			puzz10.setText("UNSOLVED");
			puzz10.setBackground(new Color(217, 102, 102));
		} else {
			puzz10.setText("SOLVED! " + puzzle10.get(2) + " stars");
			puzz10.setBackground(new Color(50, 205, 50));
		}
		
		if(diff == 0)
			bgIcn = "src/rushHour/images/labg.jpg";
		else if(diff == 1)
			bgIcn = "src/rushHour/images/chinabg.jpg";
		else
			bgIcn = "src/rushHour/images/parisbg.jpg";
		backGrIcon = new ImageIcon(
				new ImageIcon(bgIcn).getImage().getScaledInstance(819, 645, Image.SCALE_DEFAULT));
		contentBackGr = new ImageIcon(
				new ImageIcon(bgIcn).getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT));
		bg.setIcon(backGrIcon);
	}
}
