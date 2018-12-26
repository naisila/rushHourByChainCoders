package rushHour;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MyButton extends JButton implements MouseListener {
	private boolean selected;
	private GradientPaint gradient;
	private String file;
	private Boolean enabled;
	private JLabel reward;

	public MyButton(String file, String text) {
		super("          " + text);
		this.file = file;

		selected = false;
		// setIcon(new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(45,
		// 45, Image.SCALE_DEFAULT)));

		this.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.setBorder(new LineBorder(Color.LIGHT_GRAY, 0, true));
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.addMouseListener(this);
		this.setVisible(true);
		repaint();
	}

	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		selected = true;
		repaint();

	}

	@Override
	public void mouseExited(MouseEvent e) {
		selected = false;

		repaint();
	}

	@Override
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Clip clipNameClip;
		try
		{
			AudioInputStream clipNameAIS = AudioSystem
					.getAudioInputStream(getClass().getResourceAsStream("/sound/button.wav"));

			clipNameClip = AudioSystem.getClip();
			clipNameClip.open(clipNameAIS);
			clipNameClip.setFramePosition(0);
			clipNameClip.start();
		} catch (Exception e1) {
			System.out.println("Failure to load sound");
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		
		
		if (!isEnabled()) {
			gradient = new GradientPaint(new Point(0, 0), Color.GRAY.brighter(), new Point(0, getHeight()),
					Color.GRAY.darker());

		} else if (isEnabled()) {
			if (!selected) {
				gradient = new GradientPaint(new Point(0, 0), Color.ORANGE.darker(), new Point(0, getHeight()),
						Color.YELLOW.brighter());
			} else if (selected) {
				gradient = new GradientPaint(new Point(0, 0), Color.YELLOW.brighter(), new Point(0, getHeight()),
						Color.ORANGE.darker());
			}
		}
	    
		setHorizontalTextPosition(SwingConstants.LEFT);
		setHorizontalAlignment(SwingConstants.RIGHT);
		
	
		
		g2.setPaint(Color.DARK_GRAY);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2.setPaint(gradient);
		g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 15, 15);
		
		
		g2.setPaint(Color.BLACK);
		g2.drawString(getText(), 20, getHeight() / 2 - 5);
		
		reward = new JLabel("");
		reward.setIcon(new ImageIcon(new ImageIcon(file).getImage().getScaledInstance(40,
				40, Image.SCALE_DEFAULT)));
		reward.setBounds(100, 100, 50,50);
		
		add(reward);
		reward.setVisible(true);
		

		g2.finalize();
		// The drawString(string) must be put after the setPaint(gradient)

		g2.dispose();

	}
}