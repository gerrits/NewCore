package game;
/*
 * Collision detection on circles is easy, just check if any object is nearer then the Circles radius
 * but where to put it?
 */
import java.awt.Graphics2D;

public class Circle extends PhysicsObject {
	private double radius;
	private double x,y;
	
	public Circle(double x,double y, double radius) {
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
	@Override
	public synchronized void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawArc((int)x,(int) y,(int) radius,(int) radius, 0, 360);
	}
	
	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		this.x = x;
		
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y = y;
	}
	@Override
	public double getX() {
		return x;
	}
	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

}
