package rushHour;

/**
 * __Game Panel of the game.
 * @author __Kunduz and Naisila
 * @version__18/11/2018
 */
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RegistrationPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel car;

	public RegistrationPanel() {
		setLayout(null);

		ImageIcon[] items = {
				new ImageIcon(new ImageIcon("src/rushHour/images/boy.png").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)),
				new ImageIcon(new ImageIcon("src/rushHour/images/blondeGirl.png").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)),
				new ImageIcon(new ImageIcon("src/rushHour/images/brunetteGirl.png").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)),
				new ImageIcon(new ImageIcon("src/rushHour/images/Avatar.png").getImage().getScaledInstance(60, 60,
						Image.SCALE_DEFAULT)) };
		JComboBox<ImageIcon> comboBox;
		comboBox = new JComboBox<ImageIcon>(items);
		comboBox.setBounds(367, 216, 80, 63);
		add(comboBox);

		JLabel reg = new JLabel("");
		reg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/registration.png").getImage()
				.getScaledInstance(300, 60, Image.SCALE_DEFAULT)));
		reg.setBounds(220, 22, 291, 41);
		add(reg);

		JLabel wel = new JLabel("");
		wel.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/welcome.png").getImage().getScaledInstance(400, 60,
				Image.SCALE_DEFAULT)));
		wel.setBounds(170, 74, 400, 60);
		add(wel);

		JLabel name = new JLabel("CLICK THE CAR AND GO!");
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		name.setForeground(Color.RED);
		name.setBackground(Color.RED);
		name.setBounds(470, 340, 200, 35);
		add(name);

		car = new JLabel("");
		car.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/redRed.png").getImage().getScaledInstance(260, 140,
				Image.SCALE_DEFAULT)));
		car.setBounds(470, 370, 260, 140);
		add(car);

		JLabel car1 = new JLabel("");
		car1.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/regBlue.png").getImage().getScaledInstance(260,
				165, Image.SCALE_DEFAULT)));
		car1.setBounds(0, 360, 260, 165);
		add(car1);

		JLabel go = new JLabel("NAME");
		go.setFont(new Font("Tahoma", Font.BOLD, 15));
		go.setForeground(Color.RED);
		go.setBackground(Color.RED);
		go.setBounds(302, 165, 62, 35);
		add(go);

		JLabel avatar = new JLabel("AVATAR");
		avatar.setFont(new Font("Tahoma", Font.BOLD, 16));
		avatar.setForeground(Color.RED);
		avatar.setBackground(new Color(255, 0, 0));
		avatar.setBounds(281, 211, 76, 28);
		add(avatar);

		JTextArea txtrJohn = new JTextArea();
		txtrJohn.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrJohn.setText("JOHN");
		txtrJohn.setBounds(367, 174, 80, 31);
		add(txtrJohn);

		JLabel bg = new JLabel("");
		bg.setBounds(0, 0, 778, 566);
		bg.setIcon(new ImageIcon(new ImageIcon("src/rushHour/images/bg.jpg").getImage().getScaledInstance(778, 566,
				Image.SCALE_DEFAULT)));
		add(bg);
	}

	public void setMLCar(MouseAdapter madpt) {
		car.addMouseListener(madpt);
	}
}
