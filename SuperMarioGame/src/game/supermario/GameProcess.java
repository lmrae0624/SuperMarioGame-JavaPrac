package game.supermario;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameProcess extends JFrame{

	GameImg img=new GameImg();
	
	Image backimg=img.backimg;
    Image characimg = img.characimg;
    Image charjumpimg = img.charjumpimg;
    
    
    int back=0;
    int back2=backimg.getWidth(null);
    
    int backimgx=backimg.getWidth(null);
    int backimgy=backimg.getHeight(null);
    
	
	MyPanel myPanel;
	JFrame frame = new JFrame();
	int imgy = 200;

	boolean j=false;
	boolean f=false;
	boolean s = false;
	boolean gover = false;

	TacleGoombaCreate goomba= new TacleGoombaCreate();
	TacleRocketCreate rocket= new TacleRocketCreate();
	
	class MyPanel extends JPanel{
		
		public MyPanel() {
			javax.swing.Timer timer2 = new javax.swing.Timer(2000, new ActionListener() { // 방해물 생성
				public void actionPerformed(ActionEvent e) {
					if((int) (Math.random() * 10)%2==0) {
						goomba.make();
					}else {
						rocket.make();
					}
					
				}
			});
			timer2.start(); 
			
			timer();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) { // 배경 이동
						back--;
						back2--;
						if (f==false && j==false && characimg != img.charac.getImage()) {
							characimg = img.charac.getImage();
							imgy=320;
							repaint();
						}
						
						if (back < -(backimg.getWidth(null))) {
							back = backimg.getWidth(null)-1;
						}
						if (back2 <-(backimg.getWidth(null))) {
							back2 = backimg.getWidth(null)-1;
						}
						repaint();
						try {
							Thread.sleep(10);	
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			}).start();		
			
			frame.addKeyListener(new KeyAdapter() { //캐릭터 조작 
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_UP && j==false && f==false && s==false) {
						
						new Thread(new Runnable() {
							@Override
							public void run() {						
								while (imgy>200) {
									j=true;
									characimg=img.charjumpimg;
					
									imgy--;
									repaint();
									try {
										Thread.sleep(3);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								j=false;
								FallRun();
							}
						}).start();
					}
					else if (e.getKeyCode() == KeyEvent.VK_DOWN&& j==false && f==false && s==false) {
						s=true;
						new Thread(new Runnable() {
							@Override
							public void run() {						
								while (s) {
									characimg=img.charslimg;
									imgy=370;
									repaint();
								}
							}
						}).start();
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						s=false;
					}
				}
			});
				FallRun();
		}
	
        public void paintComponent(Graphics g){
            g.drawImage(backimg,back,0,this);
            g.drawImage(backimg,back2,0,this);
           
            g.drawImage(characimg, 0, imgy, this);
            
           goomba.paintComponent(g);
           rocket.paintComponent(g);
        }
    }
		
	
	public void FallRun() {
		if(f==false && j==false && imgy<320) {
			f=true;
			MarioFall fall=new MarioFall(GameProcess.this);
			fall.start();
		}
		f=false;
	}
	
	public void timer() {
		Timer timer= new Timer();
		TimerTask timertask= new TimerTask() {
		
			@Override
			public void run() { // 방해물 이동 
				if(gover==false) {
					goomba.move();
					rocket.move();
					over();
				}else {
					timer.cancel();
				}
			}	
		};
		timer.schedule(timertask, 10,10);
	}


	public GameProcess() {	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((d.width-backimgx)/2,(d.height-backimgy)/2,backimgx,backimgy);
		
		myPanel=new MyPanel();
		frame.add(myPanel);
		frame.setVisible(true);
		//frame.setResizable(false);
	}
	
	
	public void over() { // 게임 종료 조건
		int x, y, z;
		
		x=characimg.getWidth(null)/2; 	
		y=imgy+characimg.getHeight(null)/2;
		z=imgy-characimg.getHeight(null)/2;
	
		int tx,ty;
		int rx,ry;
		
		while(true) {
			for(int i=0;i<goomba.taclelist.size();i++) {
				tx=goomba.taclelist.get(i).x_tcl-img.tclimg.getWidth(null)/2;
				ty=goomba.taclelist.get(i).y_tcl-img.tclimg.getHeight(null)/2;
				if(x>tx && y>ty) {
					gover=true;
					frame.dispose();
					new GameOver();
				}
			}
			
			for(int i=0;i<rocket.taclelist.size();i++) {
				rx=rocket.taclelist.get(i).x_tcl - img.tclimg2.getWidth(null)/2;
				ry=rocket.taclelist.get(i).y_tcl - img.tclimg2.getHeight(null)/2;
				
				if(x>rx && z<ry) {
					gover=true;
					frame.dispose();
					new GameOver();
				}
			}
			break;
		}
	}


	/**
	 * @return the myPanel
	 */
	public MyPanel getMyPanel() {
		return myPanel;
	}

	/**
	 * @param myPanel the myPanel to set
	 */
	public void setMyPanel(MyPanel myPanel) {
		this.myPanel = myPanel;
	}

	/**
	 * @return the imgy
	 */
	public int getImgy() {
		return imgy;
	}

	/**
	 * @param imgy the imgy to set
	 */
	public void setImgy(int imgy) {
		this.imgy = imgy;
	}

	public static void main(String[] args) {
		new GameProcess();
	}
	
}

