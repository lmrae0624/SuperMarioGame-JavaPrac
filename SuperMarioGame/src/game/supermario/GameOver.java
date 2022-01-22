package game.supermario;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameOver extends JFrame implements ActionListener {

	ImageIcon background = new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/gameover1.gif");
	ImageIcon background2 = new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/gameover2.gif");
	
	Image backimg = background.getImage();

	ImageIcon play= new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/play.png");
	ImageIcon exit= new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/exit.png");
		
	JFrame frame = new JFrame();
	MyPanel myPanel = new MyPanel();
	
	int backimgx = backimg.getWidth(null);
	int backimgy = backimg.getHeight(null);
	private JButton btnstrat,btnexit;
	
	public void makebtn() {
		
		
		btnstrat=new JButton();
		btnstrat.setIcon(play);
		btnstrat.setBorderPainted(false);
		btnstrat.addActionListener(this);
		btnstrat.setVisible(false);

		btnexit=new JButton();
		btnexit.setIcon(exit);
		btnexit.addActionListener(this);
		btnexit.setBorderPainted(false);
		btnexit.setVisible(false);
	
		myPanel.add(btnstrat);
		myPanel.add(btnexit);
	
		Timer timer= new Timer();
		TimerTask timertask= new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				backimg=background2.getImage();
				repaint();
				btnstrat.setVisible(true);
				btnexit.setVisible(true);	
			}
			
		};
		timer.schedule(timertask, 6000);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnstrat) {
			frame.dispose();
			new GameProcess();
		}else if(e.getSource()==btnexit) {
			System.exit(0);
		}
		
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(backimg, 0, 0, this);
		}
	}
	
	
	public GameOver() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.add(myPanel);
		frame.setBounds((d.width - backimgx) / 2, (d.height - backimgy) / 2, backimgx, backimgy);
		frame.setVisible(true);
		makebtn();
		
		btnstrat.setBounds(500,frame.getHeight()/2-90,play.getIconWidth(),play.getIconHeight());
		btnexit.setBounds(500,frame.getHeight()/2,exit.getIconWidth(),exit.getIconHeight());
		
		frame.setResizable(false);
	}

	public static void main(String[] args) {
		new GameOver();
	}
}
