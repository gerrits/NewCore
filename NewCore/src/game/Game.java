package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

//Game class
public class Game extends Core {
	PhysicsObject a,b; //Physics Objects
	
	public static void main(String[] args) {
		Game g = new Game();
		g.run();
	}
	
	public void init() {
		super.init(); // call Core's init()
		a = (Square) new Square(15,15,30,30);
		b = (Square) new Square(15,15,30,30);
		
		//give a and b a little x velocity
		a.setVelocityX(0.3d);
		b.setVelocityX(0.5d);
	}

	@Override
	public void update(long timePassed) { //global update method
		a.update(timePassed);
		b.update(timePassed);
	}

	@Override 
	public void draw(Graphics2D g) { //global draw Method
		g.fillRect(0, 0, s.getWidth(), s.getHeigth()); // Repaint Background
		a.draw(g);
		b.draw(g);
		
	}
	
	public void mousePressed(MouseEvent e) {
		a.setX(10);
		a.setY(10);
		b.setX(10);
		b.setY(10);
		a.time = 0;
		b.time = 0;
	}
}
