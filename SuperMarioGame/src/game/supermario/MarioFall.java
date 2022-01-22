package game.supermario;

public class MarioFall extends Thread{

	GameProcess t;
	int imagy=0;
	
	
	public MarioFall(GameProcess t) {
		super();
		this.t = t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		imagy=t.getImgy();
		
		while (imagy<320) {
			imagy++;
			t.setImgy(imagy);

			t.getMyPanel().repaint();
		
			try {
				Thread.sleep(3); 

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	
}
