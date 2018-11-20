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

		game = new Game();
		garage = new GaragePanel();
		choosePuzz = new ChoosePuzzle();
		chooseDiff = new ChooseDifficulty();
		menu = new MainMenu();
		reg = new RegistrationPanel();

		layers.add(game, new Integer(0));
		layers.add(garage, new Integer(1));
		layers.add(choosePuzz, new Integer(2));
		layers.add(chooseDiff, new Integer(3));
		layers.add(menu, new Integer(4));
		layers.add(reg, new Integer(5));

		k = 5;

		game.setBounds(0, 0, 778, 566);
		garage.setBounds(0, 0, 778, 566);
		choosePuzz.setBounds(0, 0, 778, 566);
		chooseDiff.setBounds(0, 0, 778, 566);
		menu.setBounds(0, 0, 778, 566);
		reg.setBounds(0, 0, 778, 566);

		reg.setMLCar(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(menu, RushHourFrame.this.getK());
			}
		});

		menu.setMLPlay(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(chooseDiff, RushHourFrame.this.getK());
			}
		});

		chooseDiff.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(menu, RushHourFrame.this.getK());
			}
		});

		chooseDiff.setMLBeg(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(choosePuzz, RushHourFrame.this.getK());
			}
		});

		choosePuzz.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(chooseDiff, RushHourFrame.this.getK());
			}
		});

		choosePuzz.setMLPuzz(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(game, RushHourFrame.this.getK());
			}
		});

		game.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(choosePuzz, RushHourFrame.this.getK());
			}
		});

		menu.setMLCust(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(garage, RushHourFrame.this.getK());
			}
		});

		garage.setMLBack(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				layers.setLayer(menu, RushHourFrame.this.getK());
			}
		});
	}

	public int getK() {
		k++;
		return k;
	}
}