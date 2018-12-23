package rushHour;

/**
 * __Customize Panel of the game.
 * @author __Naisila
 * @version__ 19/12/2018
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CustomizePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel back;
	private JButton garage;

	/**
	 * Create the panel.
	 */
	public CustomizePanel() {
		setLayout(null);
		setBounds(0, 0, 778, 566);
		JLabel cust = new JLabel("");
		cust.setIcon(new ImageIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/customize.png").getImage()
				.getScaledInstance(300, 60, Image.SCALE_DEFAULT)));
		cust.setBounds(220, 10, 291, 41);
		add(cust);

		ImageIcon icone = new ImageIcon(
				new ImageIcon(ChoosePuzzle.class.getResource("/rushHour/images/back.png")).getImage().getScaledInstance(120, 65, Image.SCALE_DEFAULT));

		back = new JLabel("");
		back.setBounds(0, 0, 156, 65);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setIcon(icone);
		add(back);
		
		garage = new JButton("GO TO MY GARAGE   ");
		garage.setFont(new Font("Tahoma", Font.BOLD, 22));
		garage.setBackground(new Color(101, 140, 217));
		garage.setForeground(new Color(101, 140, 217));
		garage.setBounds(209, 58, 320, 51);
		garage.setHorizontalTextPosition(SwingConstants.LEFT);
		garage.setHorizontalAlignment(SwingConstants.RIGHT);
		garage.setIcon(new ImageIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/regBlue.png").getImage().getScaledInstance(68, 44, Image.SCALE_DEFAULT)));
		add(garage);
		
		JTextArea mouseSens = new JTextArea("Mouse Sensitivity");
		mouseSens.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		mouseSens.setBackground(new Color(217, 102, 102));
		mouseSens.setForeground(Color.WHITE);
		mouseSens.setBounds(6, 128, 202, 30);
		add(mouseSens);
		
		JLabel lt = new JLabel("");
		lt.setIcon(new ImageIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/leftPointingTriangle.png").getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		lt.setBounds(209, 128, 30, 30);
		add(lt);
		
		JLabel msVal = new JLabel("2");
		msVal.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		msVal.setBackground(Color.RED);
		msVal.setForeground(Color.WHITE);
		msVal.setBounds(248, 126, 35, 35);
		add(msVal);
		
		JLabel rt = new JLabel("");
		rt.setIcon(new ImageIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/rightPointingTriangle.png").getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		rt.setBounds(273, 128, 30, 30);
		add(rt);
		
		JTextArea vol = new JTextArea("Volume");
		vol.setForeground(Color.WHITE);
		vol.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		vol.setBackground(new Color(217, 102, 102));
		vol.setBounds(116, 178, 92, 30);
		add(vol);

		JLabel vlt = new JLabel("");
		vlt.setIcon(new ImageIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/leftPointingTriangle.png").getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		vlt.setBounds(209, 178, 30, 30);
		add(vlt);
		
		JLabel volVal = new JLabel("4");
		volVal.setForeground(Color.WHITE);
		volVal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		volVal.setBackground(Color.RED);
		volVal.setBounds(248, 173, 35, 35);
		add(volVal);
		
		JLabel vrt = new JLabel("");
		vrt.setIcon(new ImageIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/rightPointingTriangle.png").getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		vrt.setBounds(273, 178, 30, 30);
		add(vrt);
		
		JTextArea bgmusic = new JTextArea("BG Music");
		bgmusic.setForeground(Color.WHITE);
		bgmusic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		bgmusic.setBackground(new Color(217, 102, 102));
		bgmusic.setBounds(98, 229, 110, 30);
		add(bgmusic);
		
		String[] music = { "Rush Hour What is it good for", "Eminem - Till I Collapse", "They See Me Rollin'"};

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox<String> musicList = new JComboBox(music);
		musicList.setSelectedIndex(0);
		musicList.setBounds(209, 233, 176, 30);
		musicList.setFont(new Font("Tahoma", Font.ITALIC, 10));
		add(musicList);
		
		ImageIcon[] avatars = {
				new ImageIcon(new ImageIcon("src/rushHour/images/boy.png").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)),
				new ImageIcon(new ImageIcon("src/rushHour/images/blondeGirl.png").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)),
				new ImageIcon(new ImageIcon("src/rushHour/images/brunetteGirl.png").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)),
				new ImageIcon(new ImageIcon("src/rushHour/images/Avatar.png").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)) };
		
		JTextArea name = new JTextArea("Name");
		name.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		name.setBackground(new Color(217, 102, 102));
		name.setForeground(Color.WHITE);
		name.setBounds(394, 128, 73, 29);
		add(name);

		JTextArea avatar = new JTextArea("Avatar");
		avatar.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		avatar.setBackground(new Color(217, 102, 102));
		avatar.setForeground(Color.WHITE);
		avatar.setBounds(381, 178, 86, 28);
		add(avatar);

		JTextArea enterName = new JTextArea();
		enterName.setFont(new Font("Monospaced", Font.BOLD, 22));
		enterName.setText("John");
		enterName.setBounds(469, 129, 80, 31);
		add(enterName);
		
		JTextArea theme = new JTextArea("Theme");
		theme.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		theme.setBackground(new Color(217, 102, 102));
		theme.setForeground(Color.WHITE);
		theme.setBounds(599, 128, 80, 29);
		add(theme);
		
		ImageIcon[] themes = {
				new ImageIcon(new ImageIcon("src/rushHour/images/mud_bg.jpg").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)),
				new ImageIcon(new ImageIcon("src/rushHour/images/jam.jpg").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT))
				};
		
		JComboBox<ImageIcon> themeBox = new JComboBox(themes);
		themeBox.setBounds(692, 120, 80, 63);
		add(themeBox);
		
		JComboBox<ImageIcon> avatarBox = new JComboBox(avatars);
		avatarBox.setBounds(469, 169, 80, 63);
		add(avatarBox);
		
		JTextArea report = new JTextArea("Report Bug");
		report.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		report.setBackground(new Color(217, 102, 102));
		report.setForeground(Color.WHITE);
		report.setBounds(555, 229, 133, 30);
		add(report);
		
		JLabel email = new JLabel("");
		email.setIcon(new ImageIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/email.png").getImage()
				.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
		email.setBounds(696, 221, 50, 50);
		add(email);
		
		JTextArea about = new JTextArea(" About Us ");
		about.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 30));
		about.setBackground(new Color(217, 102, 102));
		about.setForeground(Color.WHITE);
		about.setBounds(248, 291, 156, 41);
		add(about);
		
		JTextArea naisi = new JTextArea();
		naisi.setBounds(6, 362, 120, 160);
		naisi.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		naisi.setText(" Naisila Puka \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		add(naisi);
		
		JTextArea kunduz = new JTextArea();
		kunduz.setText(" Kunduz Efronova \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		kunduz.setBounds(138, 362, 120, 160);
		kunduz.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		add(kunduz);
		
		JTextArea masna = new JTextArea();
		masna.setText(" Masna Ahmed \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		masna.setBounds(270, 362, 120, 160);
		masna.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		add(masna);
		
		JTextArea talha = new JTextArea();
		talha.setText(" Talha Zeeshan \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		talha.setBounds(402, 362, 120, 160);
		talha.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		add(talha);
		
		JTextArea bardhi = new JTextArea();
		bardhi.setText(" Fatbardh Feta \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		bardhi.setBounds(534, 362, 120, 160);
		bardhi.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		add(bardhi);
		
		JTextArea reset = new JTextArea();
		reset.setText(" RESET \n GAME ");
		reset.setBounds(660, 372, 120, 82);
		reset.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 30));
		reset.setOpaque(false);
		reset.setBackground(Color.RED);
		reset.setForeground(Color.RED);
		add(reset);
		
		JLabel beware = new JLabel("");
		beware.setIcon(new ImageIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/exclMark.png").getImage()
				.getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		beware.setBounds(692, 451, 60, 60);
		add(beware);
		
		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 778, 566);
		bg.setIcon(new ImageIcon("/Users/naisilapuka/Downloads/rushHour/src/rushHour/images/bg.jpg"));
		add(bg);		
	}
	
	public void setGoGarage(MouseAdapter madpt) {
		garage.addMouseListener(madpt);
	}
	
	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);
	}
}
