package game.supermario;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundRun extends JFrame{

   
    ImageIcon background = new ImageIcon("/Users/m/Downloads/R1280x0.png");
    Image backimg=background.getImage();
    
    int back=0;
    int back2=backimg.getWidth(null);
    
	class MyPanel extends JPanel{
	
		public MyPanel() {//������
			setFocusable(true);
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true) {
						//System.out.println(back+" "+back2);
						back--;
						back2--;

						if (back < -(backimg.getWidth(null))) {
							back = backimg.getWidth(null);
						}

						if (back2 <-(backimg.getWidth(null))) {
							back2 = backimg.getWidth(null);
						}
						 
						repaint();
						try {
							Thread.sleep(10);	
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						
					}
				}
				
			}).start();		
					
		}
		
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(backimg,back,0,this);
            g.drawImage(backimg,back2,0,this);
            
        }
        
        
    }
		
	
	public BackgroundRun() {	
		
		System.out.println(backimg.getWidth(null));
		JFrame frame =new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100,100,450,300);
		 JPanel panel = new MyPanel();
		frame.add(panel);
		frame.setVisible(true);
	
		
        //this.add(panel);
       // this.setBounds();
        //this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BackgroundRun();
	}
	
}

