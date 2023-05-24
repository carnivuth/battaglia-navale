package  model;
import  constants.ConstantUnit;

public class Unit  implements ConstantUnit{
	private boolean hit;
	private int x;
	private int y;
	
	public Unit(){
		hit=NO;
		x=NOTSET;
		y=NOTSET;
		}
	public void setHit(boolean hit){	
		this.hit=hit;
	}
	public void setX(int x){	
		this.x=x;
	}
	public void setY(int y){	
		this.y=y;
	}
	public int getY(){	
		return this.y;
	}
	public int getX(){	
		return this.x;
	}
	public boolean getHit(){	
		return this.hit;
	}
	
	}
