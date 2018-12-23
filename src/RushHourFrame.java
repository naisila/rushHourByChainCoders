package rushHour;

/**
 * __Main Frame of the game. From here you can navigate anywhere in our game.
 * @author __Naisila
 * @version__18/11/2018
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RushHourFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private JPanel contentPane;
	private JLayeredPane layers;
	private Game game;
	private ChooseDifficulty chooseDiff;
	private ChoosePuzzle choosePuzz;
	private GaragePanel garage;
	private MainMenu menu;
	private RegistrationPanel reg;
	private CustomizePanel cust;
	private Instructions inst;
	private FileManagementSystem fms;
	private int k;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RushHourFrame frame = new RushHourFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RushHourFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 566);
		setTitle("<Rush Hour> by Chain Coders");
		setResizable(false);

		layers = new JLayeredPane();
		setContentPane(layers);

		fms = new FileManagementSystem();
		//game = new Game(fms, 0, 0);
		garage = new GaragePanel();
		choosePuzz = new ChoosePuzzle(fms);
		chooseDiff = new ChooseDifficulty(fms);
		menu = new MainMenu(fms);
		reg = new RegistrationPanel(fms);
		cust = new CustomizePanel();
		inst = new Instructions();

		//layers.add(game, new Integer(1));
		layers.add(garage, new Integer(2));
		layers.add(cust, new Integer(3));
		layers.add(choosePuzz, new Integer(4));
		layers.add(chooseDiff, new Integer(5));
		layers.add(inst, new Integer(6));
		layers.add(menu, new Integer(7));
		if (!fms.userFileExists())
			layers.add(reg, new Integer(8));
		else
			layers.add(reg, new Integer(0));

		k = 8;

		//game.setBounds(0, 0, 778, 566);
		garage.setBounds(0, 0, 778, 566);
		choosePuzz.setBounds(0, 0, 778, 566);
		chooseDiff.setBounds(0, 0, 778, 566);
		menu.setBounds(0, 0, 778, 566);
		reg.setBounds(0, 0, 778, 566);
		cust.setBounds(0, 0, 778, 566);
		inst.setBounds(0, 0, 778, 566);

		reg.setMLCar(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(menu, RushHourFrame.this.getK());
			}
		});

		menu.setMLPlay(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				chooseDiff.update();
				layers.setLayer(chooseDiff, RushHourFrame.this.getK());
			}
		});

		chooseDiff.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menu.update();
				layers.setLayer(menu, RushHourFrame.this.getK());
			}
		});

		chooseDiff.setMLBeg(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choosePuzz.setDiff(chooseDiff.getDiff());
				choosePuzz.update();
				layers.setLayer(choosePuzz, RushHourFrame.this.getK());
			}
		});

		choosePuzz.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				chooseDiff.update();
				layers.setLayer(chooseDiff, RushHourFrame.this.getK());
			}
		});

		choosePuzz.setMLPuzz(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				game = new Game(fms, chooseDiff.getDiff(), choosePuzz.getPuzz());
				game.setBounds(0, 0, 778, 566);
				layers.add(game, new Integer(RushHourFrame.this.getK()));
				game.setMLBack(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					choosePuzz.update();
					layers.setLayer(choosePuzz, RushHourFrame.this.getK());
				}
			});
			}
		});

		menu.setMLCust(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(cust, RushHourFrame.this.getK());
			}
		});

		garage.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(cust, RushHourFrame.this.getK());
			}
		});

		cust.setGoGarage(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(garage, RushHourFrame.this.getK());
			}
		});

		cust.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menu.update();
				layers.setLayer(menu, RushHourFrame.this.getK());
			}
		});

		menu.setMLInst(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(inst, RushHourFrame.this.getK());
			}
		});

		inst.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menu.update();
				layers.setLayer(menu, RushHourFrame.this.getK());
			}
		});

		menu.setMLQuit(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

	}

	public int getK() {
		k++;
		return k;
	}
}