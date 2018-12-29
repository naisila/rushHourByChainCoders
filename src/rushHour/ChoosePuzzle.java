package src.rushHour;

/**
 * __Choose Puzzle Panel of the game.
 * @author __Naisila and Talha
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
	private JTextField puzz1;
	private JTextField puzz2;
	private JTextField puzz3;
	private JTextField puzz4;
	private JTextField puzz5;
	private JTextField puzz6;
	private JTextField puzz7;
	private JTextField puzz8;
	private JTextField puzz9;
	private JTextField puzz10;
	private JLabel back;
	private JLabel lblStr;
	private JLabel lblStr_1;
	private JLabel lblStr_2;
	private JLabel lblStr_21;
	private JLabel lblStr_22;
	private JLabel lblStr_23;
	private JButton puzzle_1;
	private JButton puzzle_2;
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
	private JLabel lblStr_31;
	private JLabel lblStr_32;
	private JLabel lblStr_33;
	private JLabel lblStr_41;
	private JLabel lblStr_42;
	private JLabel lblStr_43;
	private JLabel lblStr_51;
	private JLabel lblStr_52;
	private JLabel lblStr_53;
	private JLabel lblStr_61;
	private JLabel lblStr_62;
	private JLabel lblStr_63;
	private JLabel lblStr_71;
	private JLabel lblStr_72;
	private JLabel lblStr_73;
	private JLabel lblStr_81;
	private JLabel lblStr_82;
	private JLabel lblStr_83;
	private JLabel lblStr_91;
	private JLabel lblStr_92;
	private JLabel lblStr_93;
	private JLabel lblStr_101;
	private JLabel lblStr_102;
	private JLabel lblStr_103;
	private String levLabel;
	private ImageIcon myIcon;
	private JLabel levelLabel;

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
		ImageIcon icone = new ImageIcon(new ImageIcon("src/rushHour/images/back.png")
				.getImage().getScaledInstance(120, 65, Image.SCALE_DEFAULT));

		back = new JLabel("");
		back.setBounds(0, 0, 156, 65);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setIcon(icone);
		add(back);
		// levLabel = "src/rushHour/images/intermediateLevel.png";

		// Image of Level
		if (diff == 0)
			levLabel = "src/rushHour/images/la.png";
		else if (diff == 1)
			levLabel = "src/rushHour/images/hk.png";
		else
			levLabel = "src/rushHour/images/p.png";

		myIcon = new ImageIcon(new ImageIcon(levLabel).getImage().getScaledInstance(460, 65, Image.SCALE_DEFAULT));
		levelLabel = new JLabel("");
		levelLabel.setBounds(185, 70, 460, 65);
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setIcon(myIcon);
		add(levelLabel);

		// Image of Star
		String starsImg = "src/rushHour/images/purpleStar.png";
		ImageIcon starsImgDisp = new ImageIcon(
				new ImageIcon(starsImg).getImage().getScaledInstance(80, 50, Image.SCALE_DEFAULT));

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
		puzz2.setBackground(new Color(147, 112, 219));
		puzz2.setText("1");
		puzz2.setColumns(10);

		// Stars for Puzzle 2

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
		if (diff == 0)
			bgIcn = "src/rushHour/images/labg.jpg";
		else if (diff == 1)
			bgIcn = "src/rushHour/images/chinabg.jpg";
		else
			bgIcn = "src/rushHour/images/parisbg.jpg";
		backGrIcon = new ImageIcon(new ImageIcon(bgIcn).getImage().getScaledInstance(819, 645, Image.SCALE_DEFAULT));
		contentBackGr = new ImageIcon(
				new ImageIcon(bgIcn).getImage().getScaledInstance(1000, 1000, Image.SCALE_DEFAULT));

		// Panel to be added to ScrollPanel
		JPanel scPanel = new JPanel();
		scPanel.setBounds(141, 212, 721, 439);
		scPanel.setPreferredSize(new Dimension(266, 730));

		// ScrollPane for Panel containing puzzles
		JScrollPane scrollPane = new JScrollPane();
		scPanel.setAutoscrolls(true);
		scrollPane.setBounds(89, 223, 621, 306);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scPanel.setLayout(null);
		scrollPane.setOpaque(false);
		scPanel.setOpaque(false);
		setOpaque(false);
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

		// Stars for Puzzle 1
		lblStr = new JLabel("str11");
		lblStr.setBounds(230, 35, 80, 50);
		lblStr.setIcon(starsImgDisp);
		lblStr.setVisible(false);
		scPanel.add(lblStr);

		lblStr_1 = new JLabel("str12");
		lblStr_1.setBounds(322, 34, 80, 50);
		lblStr_1.setIcon(starsImgDisp);
		lblStr_1.setVisible(false);
		scPanel.add(lblStr_1);

		lblStr_2 = new JLabel("str13");
		lblStr_2.setBounds(431, 34, 80, 50);
		lblStr_2.setIcon(starsImgDisp);
		lblStr_2.setVisible(false);
		scPanel.add(lblStr_2);

		// Stars for Puzzle 2
		lblStr_21 = new JLabel("str21");
		lblStr_21.setBounds(230, 98, 80, 50);
		lblStr_21.setIcon(starsImgDisp);
		lblStr_21.setVisible(false);
		scPanel.add(lblStr_21);

		lblStr_22 = new JLabel("str22");
		lblStr_22.setBounds(332, 98, 80, 50);
		lblStr_22.setIcon(starsImgDisp);
		lblStr_22.setVisible(false);
		scPanel.add(lblStr_22);

		lblStr_23 = new JLabel("str23");
		lblStr_23.setBounds(431, 98, 80, 50);
		lblStr_23.setIcon(starsImgDisp);
		lblStr_23.setVisible(false);
		scPanel.add(lblStr_23);

		puzz3 = new JTextField();
		puzz3.setText("10");
		puzz3.setHorizontalAlignment(SwingConstants.CENTER);
		puzz3.setFont(new Font("Tahoma", Font.BOLD, 14));
		puzz3.setEditable(false);
		puzz3.setColumns(10);
		puzz3.setBackground(new Color(217, 102, 102));
		puzz3.setBounds(230, 174, 281, 38);
		scPanel.add(puzz3);

		// Stars for Puzzle 3

		lblStr_31 = new JLabel("New label");
		lblStr_31.setBounds(230, 169, 80, 50);
		lblStr_31.setIcon(starsImgDisp);
		lblStr_31.setVisible(false);
		scPanel.add(lblStr_31);

		lblStr_32 = new JLabel("New label");
		lblStr_32.setBounds(342, 169, 80, 50);
		lblStr_32.setIcon(starsImgDisp);
		lblStr_32.setVisible(false);
		scPanel.add(lblStr_32);

		lblStr_33 = new JLabel("New label");
		lblStr_33.setBounds(431, 169, 80, 50);
		lblStr_33.setIcon(starsImgDisp);
		lblStr_33.setVisible(false);
		scPanel.add(lblStr_33);

		// Stars for Puzzle 4

		lblStr_41 = new JLabel("New label");
		lblStr_41.setBounds(230, 243, 81, 50);
		lblStr_41.setIcon(starsImgDisp);
		lblStr_41.setVisible(false);
		scPanel.add(lblStr_41);

		lblStr_42 = new JLabel("New label");
		lblStr_42.setBounds(342, 243, 81, 50);
		lblStr_42.setIcon(starsImgDisp);
		lblStr_42.setVisible(false);
		scPanel.add(lblStr_42);

		lblStr_43 = new JLabel("New label");
		lblStr_43.setBounds(431, 243, 81, 50);
		lblStr_43.setIcon(starsImgDisp);
		lblStr_43.setVisible(false);
		scPanel.add(lblStr_43);

		// Stars for Puzzle 5

		lblStr_51 = new JLabel("New label");
		lblStr_51.setBounds(230, 323, 80, 50);
		lblStr_51.setIcon(starsImgDisp);
		lblStr_51.setVisible(false);
		scPanel.add(lblStr_51);

		lblStr_52 = new JLabel("New label");
		lblStr_52.setBounds(332, 323, 80, 50);
		lblStr_52.setIcon(starsImgDisp);
		lblStr_52.setVisible(false);
		scPanel.add(lblStr_52);

		lblStr_53 = new JLabel("New label");
		lblStr_53.setBounds(431, 323, 80, 50);
		lblStr_53.setIcon(starsImgDisp);
		lblStr_53.setVisible(false);
		scPanel.add(lblStr_53);

		// Stars for Puzzle 6
		lblStr_61 = new JLabel("New label");
		lblStr_61.setBounds(230, 385, 80, 51);
		lblStr_61.setIcon(starsImgDisp);
		lblStr_61.setVisible(false);
		scPanel.add(lblStr_61);

		lblStr_62 = new JLabel("New label");
		lblStr_62.setBounds(332, 385, 80, 51);
		lblStr_62.setIcon(starsImgDisp);
		lblStr_62.setVisible(false);
		scPanel.add(lblStr_62);

		lblStr_63 = new JLabel("New label");
		lblStr_63.setBounds(431, 385, 80, 51);
		lblStr_63.setIcon(starsImgDisp);
		lblStr_63.setVisible(false);
		scPanel.add(lblStr_63);

		// Stars for Puzzle 7

		lblStr_71 = new JLabel("New label");
		lblStr_71.setBounds(230, 456, 80, 50);
		lblStr_71.setIcon(starsImgDisp);
		lblStr_71.setVisible(false);
		scPanel.add(lblStr_71);

		lblStr_72 = new JLabel("New label");
		lblStr_72.setBounds(332, 456, 80, 50);
		lblStr_72.setIcon(starsImgDisp);
		lblStr_72.setVisible(false);
		scPanel.add(lblStr_72);

		lblStr_73 = new JLabel("New label");
		lblStr_73.setBounds(431, 456, 80, 50);
		lblStr_73.setIcon(starsImgDisp);
		lblStr_73.setVisible(false);
		scPanel.add(lblStr_73);

		// Stars for Puzzle 8

		lblStr_81 = new JLabel("New label");
		lblStr_81.setBounds(230, 531, 80, 50);
		lblStr_81.setIcon(starsImgDisp);
		lblStr_81.setVisible(false);
		scPanel.add(lblStr_81);

		lblStr_82 = new JLabel("New label");
		lblStr_82.setBounds(332, 533, 80, 50);
		lblStr_82.setIcon(starsImgDisp);
		lblStr_82.setVisible(false);
		scPanel.add(lblStr_82);

		lblStr_83 = new JLabel("New label");
		lblStr_83.setBounds(431, 533, 80, 50);
		lblStr_83.setIcon(starsImgDisp);
		lblStr_83.setVisible(false);
		scPanel.add(lblStr_83);

		// Stars for Puzzle 9

		lblStr_91 = new JLabel("New label");
		lblStr_91.setBounds(230, 610, 80, 51);
		lblStr_91.setIcon(starsImgDisp);
		lblStr_91.setVisible(false);
		scPanel.add(lblStr_91);

		lblStr_92 = new JLabel("New label");
		lblStr_92.setBounds(322, 610, 80, 51);
		lblStr_92.setIcon(starsImgDisp);
		lblStr_92.setVisible(false);
		scPanel.add(lblStr_92);

		lblStr_93 = new JLabel("New label");
		lblStr_93.setBounds(431, 610, 80, 51);
		lblStr_93.setIcon(starsImgDisp);
		lblStr_93.setVisible(false);
		scPanel.add(lblStr_93);

		// Stars for Puzzle 10

		lblStr_101 = new JLabel("New label");
		lblStr_101.setBounds(230, 677, 80, 51);
		lblStr_101.setIcon(starsImgDisp);
		lblStr_101.setVisible(false);
		scPanel.add(lblStr_101);

		lblStr_102 = new JLabel("New label");
		lblStr_102.setBounds(332, 677, 80, 51);
		lblStr_102.setIcon(starsImgDisp);
		lblStr_102.setVisible(false);
		scPanel.add(lblStr_102);

		lblStr_103 = new JLabel("New label");
		lblStr_103.setBounds(431, 677, 80, 51);
		lblStr_103.setIcon(starsImgDisp);
		lblStr_103.setVisible(false);
		scPanel.add(lblStr_103);

		scrollPane.setBorder(null);
		// scPanel.setOpaque(false);

		bg = new JLabel("");
		bg.setBounds(0, 0, 778, 566);
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
			if (puzzle1.get(2) == 0) {
				puzz1.setText("SOLVED! BUT NO STARS :(");
				puzz1.setBackground(new Color(147, 112, 219));
			} else if (puzzle1.get(2) == 1) {
				puzz1.setVisible(false);
				lblStr.setVisible(true);
			} else if (puzzle1.get(2) == 2) {
				puzz1.setVisible(false);
				lblStr.setVisible(true);
				lblStr_1.setVisible(true);
			} else if (puzzle1.get(2) == 3) {
				puzz1.setVisible(false);
				lblStr.setVisible(true);
				lblStr_1.setVisible(true);
				lblStr_2.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle2 = fms.getPuzzleStats(diff, 1);
		if (puzzle2.get(1) == 0) {
			puzz2.setText("UNSOLVED");
			puzz2.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle2.get(2) == 0) {
				puzz2.setText("SOLVED! BUT NO STARS :(");
				puzz2.setBackground(new Color(147, 112, 219));
			} else if (puzzle2.get(2) == 1) {
				puzz2.setVisible(false);
				lblStr_21.setVisible(true);
			} else if (puzzle2.get(2) == 2) {
				puzz2.setVisible(false);
				lblStr_21.setVisible(true);
				lblStr_22.setVisible(true);
			} else if (puzzle2.get(2) == 3) {
				puzz2.setVisible(false);
				lblStr_21.setVisible(true);
				lblStr_22.setVisible(true);
				lblStr_23.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle3 = fms.getPuzzleStats(diff, 2);
		if (puzzle3.get(1) == 0) {
			puzz3.setText("UNSOLVED");
			puzz3.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle3.get(2) == 0) {
				puzz3.setText("SOLVED! BUT NO STARS :(");
				puzz3.setBackground(new Color(147, 112, 219));
			} else if (puzzle3.get(2) == 1) {
				puzz3.setVisible(false);
				lblStr_31.setVisible(true);
			} else if (puzzle3.get(2) == 2) {
				puzz3.setVisible(false);
				lblStr_31.setVisible(true);
				lblStr_32.setVisible(true);
			} else if (puzzle3.get(2) == 3) {
				puzz3.setVisible(false);
				lblStr_31.setVisible(true);
				lblStr_32.setVisible(true);
				lblStr_33.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle4 = fms.getPuzzleStats(diff, 3);
		if (puzzle4.get(1) == 0) {
			puzz4.setText("UNSOLVED");
			puzz4.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle4.get(2) == 0) {
				puzz4.setText("SOLVED! BUT NO STARS :(");
				puzz4.setBackground(new Color(147, 112, 219));
			} else if (puzzle4.get(2) == 1) {
				puzz4.setVisible(false);
				lblStr_41.setVisible(true);
			} else if (puzzle4.get(2) == 2) {
				puzz4.setVisible(false);
				lblStr_41.setVisible(true);
				lblStr_42.setVisible(true);
			} else if (puzzle4.get(2) == 3) {
				puzz4.setVisible(false);
				lblStr_41.setVisible(true);
				lblStr_42.setVisible(true);
				lblStr_43.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle5 = fms.getPuzzleStats(diff, 4);
		if (puzzle5.get(1) == 0) {
			puzz5.setText("UNSOLVED");
			puzz5.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle5.get(2) == 0) {
				puzz5.setText("SOLVED! BUT NO STARS :(");
				puzz5.setBackground(new Color(147, 112, 219));
			} else if (puzzle5.get(2) == 1) {
				puzz5.setVisible(false);
				lblStr_51.setVisible(true);
			} else if (puzzle5.get(2) == 2) {
				puzz5.setVisible(false);
				lblStr_51.setVisible(true);
				lblStr_52.setVisible(true);
			} else if (puzzle5.get(2) == 3) {
				puzz5.setVisible(false);
				lblStr_51.setVisible(true);
				lblStr_52.setVisible(true);
				lblStr_53.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle6 = fms.getPuzzleStats(diff, 5);
		if (puzzle6.get(1) == 0) {
			puzz6.setText("UNSOLVED");
			puzz6.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle6.get(2) == 0) {
				puzz6.setText("SOLVED! BUT NO STARS :(");
				puzz6.setBackground(new Color(147, 112, 219));
			} else if (puzzle6.get(2) == 1) {
				puzz6.setVisible(false);
				lblStr_61.setVisible(true);
			} else if (puzzle6.get(2) == 2) {
				puzz6.setVisible(false);
				lblStr_61.setVisible(true);
				lblStr_62.setVisible(true);
			} else if (puzzle6.get(2) == 3) {
				puzz6.setVisible(false);
				lblStr_61.setVisible(true);
				lblStr_62.setVisible(true);
				lblStr_63.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle7 = fms.getPuzzleStats(diff, 6);
		if (puzzle7.get(1) == 0) {
			puzz7.setText("UNSOLVED");
			puzz7.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle7.get(2) == 0) {
				puzz7.setText("SOLVED! BUT NO STARS :(");
				puzz7.setBackground(new Color(147, 112, 219));
			} else if (puzzle7.get(2) == 1) {
				puzz7.setVisible(false);
				lblStr_71.setVisible(true);
			} else if (puzzle7.get(2) == 2) {
				puzz7.setVisible(false);
				lblStr_71.setVisible(true);
				lblStr_72.setVisible(true);
			} else if (puzzle7.get(2) == 3) {
				puzz7.setVisible(false);
				lblStr_71.setVisible(true);
				lblStr_72.setVisible(true);
				lblStr_73.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle8 = fms.getPuzzleStats(diff, 7);
		if (puzzle8.get(1) == 0) {
			puzz8.setText("UNSOLVED");
			puzz8.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle8.get(2) == 0) {
				puzz8.setText("SOLVED! BUT NO STARS :(");
				puzz8.setBackground(new Color(147, 112, 219));
			} else if (puzzle8.get(2) == 1) {
				puzz8.setVisible(false);
				lblStr_81.setVisible(true);
			} else if (puzzle8.get(2) == 2) {
				puzz8.setVisible(false);
				lblStr_81.setVisible(true);
				lblStr_82.setVisible(true);
			} else if (puzzle8.get(2) == 3) {
				puzz8.setVisible(false);
				lblStr_81.setVisible(true);
				lblStr_82.setVisible(true);
				lblStr_83.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle9 = fms.getPuzzleStats(diff, 8);
		if (puzzle9.get(1) == 0) {
			puzz9.setText("UNSOLVED");
			puzz9.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle9.get(2) == 0) {
				puzz9.setText("SOLVED! BUT NO STARS :(");
				puzz9.setBackground(new Color(147, 112, 219));
			} else if (puzzle9.get(2) == 1) {
				puzz9.setVisible(false);
				lblStr_91.setVisible(true);
			} else if (puzzle9.get(2) == 2) {
				puzz9.setVisible(false);
				lblStr_91.setVisible(true);
				lblStr_92.setVisible(true);
			} else if (puzzle9.get(2) == 3) {
				puzz9.setVisible(false);
				lblStr_91.setVisible(true);
				lblStr_92.setVisible(true);
				lblStr_93.setVisible(true);
			}
		}
		ArrayList<Integer> puzzle10 = fms.getPuzzleStats(diff, 9);
		if (puzzle10.get(1) == 0) {
			puzz10.setText("UNSOLVED");
			puzz10.setBackground(new Color(217, 102, 102));
		} else {
			if (puzzle10.get(2) == 0) {
				puzz10.setText("SOLVED! BUT NO STARS :(");
				puzz10.setBackground(new Color(147, 112, 219));
			} else if (puzzle10.get(2) == 1) {
				puzz10.setVisible(false);
				lblStr_101.setVisible(true);
			} else if (puzzle10.get(2) == 2) {
				puzz10.setVisible(false);
				lblStr_101.setVisible(true);
				lblStr_102.setVisible(true);
			} else if (puzzle10.get(2) == 3) {
				puzz10.setVisible(false);
				lblStr_101.setVisible(true);
				lblStr_102.setVisible(true);
				lblStr_103.setVisible(true);
			}
		}

		if (diff == 0)
			bgIcn = "src/rushHour/images/labg.jpg";
		else if (diff == 1)
			bgIcn = "src/rushHour/images/chinabg.jpg";
		else
			bgIcn = "src/rushHour/images/parisbg.jpg";

		backGrIcon = new ImageIcon(new ImageIcon(bgIcn).getImage().getScaledInstance(778, 566, Image.SCALE_DEFAULT));

		bg.setIcon(backGrIcon);

		if (diff == 0) {
			levLabel = "src/rushHour/images/la.png";
			myIcon = new ImageIcon(new ImageIcon(levLabel).getImage().getScaledInstance(370, 65, Image.SCALE_DEFAULT));
		} else if (diff == 1) {
			levLabel = "src/rushHour/images/hk.png";
			myIcon = new ImageIcon(new ImageIcon(levLabel).getImage().getScaledInstance(370, 65, Image.SCALE_DEFAULT));
		} else {
			levLabel = "src/rushHour/images/p.png";
			myIcon = new ImageIcon(new ImageIcon(levLabel).getImage().getScaledInstance(250, 65, Image.SCALE_DEFAULT));
		}

		levelLabel.setIcon(myIcon);
	}
}
