package domain.model;

/**
 * Created by tiebe on 9/05/2017.
 */
public class Punt {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public Punt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+ x+", "+ y +")";
	}
	public boolean equals(Object o){
		
		if (o == null) return false;
		
		if (o instanceof Punt) {
			Punt p = (Punt)o;
			
			return (p.getX() == this.getX() && p.getY() == this.getY());
		}
		return false;
	}
	
	
}
