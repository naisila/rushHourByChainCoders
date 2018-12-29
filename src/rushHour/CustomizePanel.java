package src.rushHour;

/**
 * __Customize Panel of the game.
 * @author __Naisila and Kunduz
 * @version__ 19/12/2018
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class CustomizePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel back;
	private JButton garage;
	private Sound audio;
	private JSlider volumeSlider;
	private Settings s;
	private FileManagementSystem fms;
	private User u;
	private JComboBox<String> musicList;
	private String[] music = { "Rush Hour Theme", "The Matrix Theme" };
	private ImageIcon[] themes = {
			new ImageIcon(new ImageIcon("src/rushHour/images/mud_bg.jpg").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)),
			new ImageIcon(new ImageIcon("src/rushHour/images/jam.jpg").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)) };
	private JComboBox<ImageIcon> themeBox;
	private ImageIcon[] avatars = {
			new ImageIcon(new ImageIcon("src/rushHour/images/boy.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)),
			new ImageIcon(new ImageIcon("src/rushHour/images/blondeGirl.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)),
			new ImageIcon(new ImageIcon("src/rushHour/images/brunetteGirl.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)),
			new ImageIcon(new ImageIcon("src/rushHour/images/Avatar.png").getImage().getScaledInstance(60, 60,
					Image.SCALE_DEFAULT)) };
	private JComboBox<ImageIcon> avatarBox;
	private JTextArea enterName;

	/**
	 * Create the panel.
	 * 
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws FileNotFoundException
	 */
	public CustomizePanel(FileManagementSystem fmsi)
			throws FileNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		fms = fmsi;
		u = fms.getUserData();
		s = fms.getUserSettings();
		setLayout(null);
		setBounds(0, 0, 778, 566);
		JLabel cust = new JLabel("");
		cust.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/customize.png").getImage().getScaledInstance(300,
				60, Image.SCALE_DEFAULT)));
		cust.setBounds(220, 10, 291, 41);
		add(cust);

		ImageIcon icone = new ImageIcon(new ImageIcon("src/rushHour/images/back.png").getImage().getScaledInstance(120,
				65, Image.SCALE_DEFAULT));

		back = new JLabel("");
		back.setBounds(0, 0, 156, 65);
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setIcon(icone);
		add(back);

		garage = new JButton("GO TO MY GARAGE");
		garage.setFont(new Font("Tahoma", Font.BOLD, 20));
		garage.setBackground(new Color(101, 140, 217));
		garage.setForeground(Color.BLACK);
		garage.setBounds(209, 58, 320, 51);
		garage.setHorizontalTextPosition(SwingConstants.LEFT);
		garage.setHorizontalAlignment(SwingConstants.RIGHT);
		garage.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/regBlue.png").getImage().getScaledInstance(68,
				44, Image.SCALE_DEFAULT)));
		add(garage);

		// slider
		volumeSlider = new JSlider();
		volumeSlider.setLocation(220, 178);
		volumeSlider.setSize(120, 30);
		volumeSlider.setPaintTrack(true);
		volumeSlider.setPaintTicks(true);
		volumeSlider.setPaintLabels(true);

		add(volumeSlider);

		volumeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					int value = source.getValue();
					audio.setVolume(value);

				}
			}
		});

		add(volumeSlider);

		JTextArea mouseSens = new JTextArea("Mouse Sensitivity");
		mouseSens.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		mouseSens.setBackground(new Color(217, 102, 102));
		mouseSens.setEditable(false);
		mouseSens.setForeground(Color.WHITE);
		mouseSens.setBounds(6, 128, 202, 30);
		add(mouseSens);

		JLabel lt = new JLabel("");
		lt.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/leftPointingTriangle.png").getImage()
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
		rt.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/rightPointingTriangle.png").getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		rt.setBounds(273, 128, 30, 30);
		add(rt);

		JTextArea vol = new JTextArea("Volume");
		vol.setForeground(Color.WHITE);
		vol.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		vol.setEditable(false);
		vol.setBackground(new Color(217, 102, 102));
		vol.setBounds(116, 178, 92, 30);
		add(vol);

		JTextArea bgmusic = new JTextArea("BG Music");
		bgmusic.setForeground(Color.WHITE);
		bgmusic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		bgmusic.setEditable(false);
		bgmusic.setBackground(new Color(217, 102, 102));
		bgmusic.setBounds(98, 229, 110, 30);
		add(bgmusic);

		// Create the combo box, select item at index 4.
		// Indices start at 0, so 4 specifies the pig.
		musicList = new JComboBox(music);
		audio = new Sound("src/rushHour/sound/musicc.wav");
		audio.playSound();

		if (s.getThemeMusic().equals(music[0]))
			musicList.setSelectedIndex(0);
		else
			musicList.setSelectedIndex(1);
		musicList.setBounds(209, 233, 176, 30);
		musicList.setFont(new Font("Tahoma", Font.ITALIC, 10));
		add(musicList);

		musicList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> combo = (JComboBox<String>) event.getSource();
				String selectedBook = (String) combo.getSelectedItem();

				if (selectedBook.equals("The Matrix Theme")) {
					try {
						audio.stop();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					audio = new Sound("src/rushHour/sound/matrix.wav");
					try {
						audio.playSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {

						e1.printStackTrace();
					}

					fms.updateThemeMusic("The Matrix Theme");

				}
				if (selectedBook.equals("Rush Hour Theme")) {
					try {
						audio.stop();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					audio = new Sound("src/rushHour/sound/musicc.wav");
					try {
						audio.playSound();
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {

						e1.printStackTrace();
					}
					fms.updateThemeMusic("Rush Hour Theme");

				}
			}
		});

		JTextArea name = new JTextArea("Name");
		name.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		name.setBackground(new Color(217, 102, 102));
		name.setForeground(Color.WHITE);
		name.setEditable(false);
		name.setBounds(394, 128, 73, 29);
		add(name);

		JTextArea avatar = new JTextArea("Avatar");
		avatar.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		avatar.setBackground(new Color(217, 102, 102));
		avatar.setEditable(false);
		avatar.setForeground(Color.WHITE);
		avatar.setBounds(381, 178, 86, 28);
		add(avatar);

		enterName = new JTextArea();
		enterName.setFont(new Font("Monospaced", Font.BOLD, 22));
		enterName.setText("John");
		enterName.setBounds(469, 129, 80, 31);
		add(enterName);

		JTextArea theme = new JTextArea("Theme");
		theme.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		theme.setBackground(new Color(217, 102, 102));
		theme.setEditable(false);
		theme.setForeground(Color.WHITE);
		theme.setBounds(599, 128, 80, 29);
		add(theme);

		themeBox = new JComboBox(themes);
		themeBox.setBounds(692, 120, 80, 63);
		add(themeBox);
		themeBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> combo = (JComboBox<String>) event.getSource();
				int selectedBook = combo.getSelectedIndex();

				if (selectedBook == 0) {

					fms.updateGameTheme("mud_bg.jpg");

				} else {
					fms.updateGameTheme("jam.jpg");

				}
			}
		});

		avatarBox = new JComboBox(avatars);
		avatarBox.setBounds(469, 169, 80, 63);
		avatarBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> combo = (JComboBox<String>) event.getSource();
				int selectedBook = combo.getSelectedIndex();

				if (selectedBook == 0) {

					fms.updateAvatar("boy.png");

				} else if (selectedBook == 1) {
					fms.updateAvatar("blondeGirl.png");

				} else if (selectedBook == 2) {
					fms.updateAvatar("brunetteGirl.png");
				} else {
					fms.updateAvatar("Avatar.png");
				}
			}
		});
		add(avatarBox);

		JTextArea report = new JTextArea("Report Bug");
		report.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 22));
		report.setBackground(new Color(217, 102, 102));
		report.setForeground(Color.WHITE);
		report.setBounds(555, 229, 133, 30);
		add(report);

		JLabel email = new JLabel("");
		email.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/email.png").getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT)));
		email.setBounds(696, 221, 50, 50);
		add(email);

		JTextArea about = new JTextArea(" About Us ");
		about.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 30));
		about.setBackground(new Color(217, 102, 102));
		about.setEditable(false);
		about.setForeground(Color.WHITE);
		about.setBounds(248, 291, 156, 41);
		add(about);

		JTextArea naisi = new JTextArea();
		naisi.setBounds(6, 362, 120, 160);
		naisi.setEditable(false);
		naisi.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		naisi.setText(" Naisila Puka \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		add(naisi);

		JTextArea kunduz = new JTextArea();
		kunduz.setText(
				" Kunduz Efronova \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		kunduz.setBounds(138, 362, 120, 160);
		kunduz.setEditable(false);
		kunduz.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		add(kunduz);

		JTextArea masna = new JTextArea();
		masna.setText(" Masna Ahmed \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		masna.setBounds(270, 362, 120, 160);
		masna.setEditable(false);
		masna.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		add(masna);

		JTextArea talha = new JTextArea();
		talha.setText(" Talha Zeeshan \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		talha.setBounds(402, 362, 120, 160);
		talha.setEditable(false);
		talha.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		add(talha);

		JTextArea bardhi = new JTextArea();
		bardhi.setText(" Fatbardh Feta \n Hi, I am a junior \n computer science \n student at \n Bilkent University.");
		bardhi.setBounds(534, 362, 120, 160);
		bardhi.setEditable(false);
		bardhi.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 12));
		add(bardhi);

		JTextArea reset = new JTextArea();
		reset.setText(" RESET \n GAME ");
		reset.setBounds(660, 372, 120, 82);
		reset.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 30));
		reset.setOpaque(false);
		reset.setEditable(false);
		reset.setBackground(Color.RED);
		reset.setForeground(Color.RED);
		add(reset);

		JLabel beware = new JLabel("");
		beware.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/exclMark.png").getImage().getScaledInstance(60,
				60, Image.SCALE_DEFAULT)));
		beware.setBounds(692, 451, 60, 60);
		add(beware);

		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 778, 566);
		bg.setIcon(new ImageIcon("src/rushHour/images/poster.jpg"));
		add(bg);
	}

	public void setGoGarage(MouseAdapter madpt) {
		garage.addMouseListener(madpt);
	}

	public void setMLBack(MouseAdapter madpt) {
		back.addMouseListener(madpt);

	}

	public class Sound implements Runnable {

		private static final int MAX_VOLUME = 100;
		private String filename;
		private AudioInputStream audioStream = null;
		private AudioFormat audioFormat = null;
		private SourceDataLine sourceLine = null;
		private Clip clip;
		private volatile boolean stopFlag = false;
		private volatile boolean pauseFlag = false;
		private volatile float volume_dB = 0.0f;

		public Sound() {
		}

		public Sound(String filename) {
			this.filename = filename;
		}

		public void playSound()
				throws FileNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException {

			try {

				audioStream = AudioSystem.getAudioInputStream(new File(filename));
				audioFormat = audioStream.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(audioStream);
				clip.start();
			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

		}

		public void stop() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
			clip.stop();
			System.out.println("stop");

		}

		@Override
		public void run() {
			stopFlag = false;
			pauseFlag = false;

			try {
				playSound();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void setVolume(int volume) {
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue((float) (Math.log(volume / 100d) / Math.log(10.0) * 20.0));
		}
	}

	public void update() {
//		s = fms.getUserSettings();
//		if(s.getThemeMusic().equals(music[0]))
//			musicList.setSelectedIndex(0);
//		else
//			musicList.setSelectedIndex(1);
//		
//		if(s.getGameTheme().equals("mud_bg.jpg"))
//			themeBox.setSelectedIndex(0);
//		else
//			themeBox.setSelectedIndex(1);

		u = fms.getUserData();
		if (u.getAvatar().equals("boy.png"))
			avatarBox.setSelectedIndex(0);
		else if (u.getAvatar().equals("blondeGirl.png"))
			avatarBox.setSelectedIndex(1);
		else if (u.getAvatar().equals("brunetteGirl.png"))
			avatarBox.setSelectedIndex(2);
		else
			avatarBox.setSelectedIndex(3);

		enterName.setText(u.getName());

	}

	public String getName() {
		return enterName.getText();
	}

//	public String getName()
//	{
//		u = fms.getUserData();
//		return enterName.getText();
//	}
}