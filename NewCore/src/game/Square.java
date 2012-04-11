package game;

import java.awt.*;
import java.awt.geom.*;

public class Square extends PhysicsObject {
	Rectangle2D.Double r; // should be inherited from PhysicsObject. Also, Rectangle2D does not support rotation
	

	//CONSTRUCTOR
	public Square(double x, double y, double width, double height) {
		r 	= new Rectangle2D.Double();
		r.x = x; 
		r.y = y;
		r.height = height;
		r.width = width;
		setVelocityY(9.81d); //THIS should be velocity, but its actually used as acceleration
	}
	public void draw(Graphics2D g) {
		g.setColor(Color.red);
		g.draw(r);
	}

	public void update(long timePassed) {
		/*count the time from the beginning
		 * use it to calculate
		 */
		time += timePassed;
		r.x += getVelocityX() * timePassed;
		r.y += (getVelocityY() * time/1000) /2d; //not correct :D
	}
	public Rectangle2D.Double getRectangle() {
		return r;
	}
	
	public void setX(double x) {
		r.x = x;
	}
	
	public void setY(double y) {
		r.y = y;
	}
}
