package game;

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
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawArc((int)x,(int) y,(int) radius,(int) radius, 0, 360);
	}

	@Override
	public void update(long timePassed) {
		// TODO Auto-generated method stub
		x = getVelocityX() * timePassed;
		y = getVelocityY() * timePassed;
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

}
