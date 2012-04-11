package game;

import java.awt.*;

public abstract class PhysicsObject {
	//Shape shape; 	//The shape of the Object TODO: Write own shape class with rotation etc, OpenGL?
	double vx; 		// Velocity in X direction
	double vy;		//Velocity in Y direction
	double direction; //the angle of the Object -- TODO: Implement angles  - is this Possible with e.g. Rectangle2D?
	public int time = 0; //workaround
	
	public abstract void draw(Graphics2D g);
	
	//TODO: This is where all the physics stuff should happen
	public void update(long timePassed) {
		setX(vx * timePassed);
		setY(vy * timePassed);
	}
	
	//Getters and Setters
	public double getVelocityX() {
		return vx;
	}
	
	public double getVelocityY() {
		return vy;
	}
	
	public double getDirection() {
		return direction;
	}
	
	public void setVelocityX(double vx) {
		this.vx = vx;
	}
	
	public void setVelocityY(double vy) {
		this.vy = vy;
	}
	
	//ugly :/
	public abstract void setX(double x);
	public abstract void setY(double y);
	
	
}
