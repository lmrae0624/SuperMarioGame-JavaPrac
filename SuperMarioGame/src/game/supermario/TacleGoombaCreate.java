package game.supermario;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class TacleGoombaCreate {
	ArrayList<Goomba> taclelist=new ArrayList<Goomba>();
	GameImg img = new GameImg();

	public ArrayList<Goomba> getTaclelist() {
		return taclelist;
	}

	public void setTaclelist(ArrayList<Goomba> taclelist) {
		this.taclelist = taclelist;
	}

	public void make() {	
		Goomba tc = new Goomba();
		tc.x_tcl=img.backimgx+(int)(Math.random()*200);
		tc.y_tcl=370;
		tc.speed=3;
		
		taclelist.add(tc);
	}
	
	
	public void move() {
		for (int i = 0; i < taclelist.size(); i++) {
			Goomba tc=taclelist.get(i);
			tc.x_tcl=tc.x_tcl-tc.speed-1;
			
			if(taclelist.get(i).x_tcl <=0) {
				taclelist.remove(i);
			}
		}
	}
	
	
	public void paintComponent(Graphics g) {
		for (int i = 0; i < taclelist.size(); i++) {
			Goomba tc = taclelist.get(i);
			tc.draw(g);
		} 
	}
}
