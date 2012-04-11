package game;
/*
 * TODO: static framerate!
 */
import java.awt.*;
import java.awt.event.*;
public abstract class Core implements MouseListener, MouseMotionListener, KeyListener {

	private boolean running;
	protected ScreenManager s;

	//stop method
	public void stop() {
		running = false;
	}

	//run method
	public void run() {
		try {
			//initialize the game
			init();

			//start the game-loop
			gameLoop();
		} finally {
			s.restoreScreen();
		}
	}

	//initialization method
	public void init() {
		//create new ScreenManager Object
		s = new ScreenManager();

		//create Window with size (a,b)
		s.createWindow(500,500);

		//set the Frames background color to black by default
		Frame f = s.getFrame();
		f.setBackground(new Color(255,255,255));
		
		//add Mouse Listeners
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		f.addKeyListener(this);
		

		// start the game
		running = true;
	}

	public void gameLoop() {
		//time variables
		long startTime = System.currentTimeMillis();
		long cumTime = startTime;

		while(running) {
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;

			//call update method of the game
			update(timePassed);

			//Get Graphics object from ScreenManager
			Graphics2D g = s.getGraphics();
			//call draw method of the Game
			draw(g);
			//delete graphics object
			g.dispose();
			//call to update window content
			s.update();
			//s.getFrame().repaint();

			try {
				//sleep 3 millis
				Thread.sleep(3);
			} catch (Exception e) {}

		}
	}

	// update method NEEDS TO BE IMPLEMENTED by child
	public abstract void update(long timePassed);

	// draw method NEEDS TO BE IMPLEMENTED by child
	public abstract void draw(Graphics2D g);

	//mouse handlers, override in Game class if needed
	public void mouseMoved(MouseEvent e) { }
	public void mouseDragged(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	//key handlers, override in Game  class if needed
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}

