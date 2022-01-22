package game.supermario;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class TacleRocketCreate {
	ArrayList<Rocket> taclelist=new ArrayList<Rocket>();
	GameImg img = new GameImg();

	/**
	 * @return the taclelist
	 */
	public ArrayList<Rocket> getTaclelist() {
		return taclelist;
	}

	/**
	 * @param taclelist the taclelist to set
	 */
	public void setTaclelist(ArrayList<Rocket> taclelist) {
		this.taclelist = taclelist;
	}

	
	public void make() {
		Rocket tc = new Rocket();
		tc.x_tcl=img.backimgx+(int)(Math.random()*300);
		tc.y_tcl=320;
		tc.speed=5;
		
		taclelist.add(tc);	 
	}
	
	
	public void move() {
		for (int i = 0; i < taclelist.size(); i++) {
			Rocket tc=taclelist.get(i);
			tc.x_tcl=tc.x_tcl-tc.speed-1;
			
			if(taclelist.get(i).x_tcl <=0) {
				taclelist.remove(i);
			}
		}
	}
	
	
	public void paintComponent(Graphics g) {
		for (int i = 0; i < taclelist.size(); i++) {
			Rocket tc = taclelist.get(i);
			tc.draw(g);
		} 
	}
}
