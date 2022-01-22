package game.supermario;

import java.awt.Image;
import javax.swing.ImageIcon;

public class GameImg {
	ImageIcon background = new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/background.JPG");
	Image backimg = background.getImage();

	int backimgx = backimg.getWidth(null);


	ImageIcon charac = new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/mario_run.gif");
	Image characimg = charac.getImage();

	ImageIcon charjump = new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/mario_jump.png");
	Image charjumpimg = charjump.getImage();
	

	ImageIcon charsl = new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/mario_slide.png");
	Image charslimg = charsl.getImage();
	
	
	ImageIcon tcl = new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/goomba.png");
	Image tclimg = tcl.getImage();
	
	ImageIcon tcl2 = new ImageIcon("/Users/m/eclipse-workspace/SuperMarioGame/img/rocket.png");
	Image tclimg2 = tcl2.getImage();
}
