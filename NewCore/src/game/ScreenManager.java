package game;
import java.awt.*;
import java.awt.image.*;
import javax.swing.JFrame;

public class ScreenManager {
	private JFrame f;
	static final long serialVersionUID = 1L;

	///CONSTRUCTOR
	public ScreenManager() {

	}

	//return Objects Frame
	public Frame getFrame() {
		return f;
	}

	//create Window
	public void createWindow(int x,int y) {
		//create new Frame
		f = new JFrame();
		f.setSize(x, y);
		f.setResizable(true);
		f.setFocusable(true);
		f.setVisible(true);

		//create double buffer
		f.createBufferStrategy(2);
	}

	//return the buffer strategys Graphics2D Object
	public Graphics2D getGraphics() {
		if(f != null) {
			BufferStrategy s = f.getBufferStrategy();
			return (Graphics2D)s.getDrawGraphics();
		} else {
			return null;
		}
	}

	//update the Frame's Content from BufferStrategy
	public void update() {
		if(f != null) {
			BufferStrategy s = f.getBufferStrategy();
			if(!s.contentsLost()) {
				s.show();
			}
		}
	}

	//return Width of the Window
	public int getWidth() {
		if(f != null) {
			return f.getWidth();
		} else {
			return 0;
		}
	}	

	//return Height of the Window
	public int getHeigth() {
		if(f != null) {
			return f.getHeight();
		} else {
			return 0;
		}
	}

	//restore the screen
	public void restoreScreen() {
		if(f != null) {
			f.dispose();
		}
	}

}