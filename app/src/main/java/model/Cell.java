package model;

import constants.ConstantUnit;

public class Cell implements ConstantUnit{
	private int x;
	private int y;
	private boolean occupied;
	private boolean covered;

	public Cell(){
		this.x=NOTSET;
		this.y=NOTSET;
		this.occupied=NO;
		this.covered=YES;
		
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
	public int getx(){	
		return this.x;
	}
	public void setOccupied(boolean occupied){	
		this.occupied=occupied;
	}
	public void setCovered(boolean covered){	
		this.covered=covered;
	}
	
	public boolean getCovered(){	
		return this.covered;
	}
	
	public boolean getOccupied(){	
		return this.occupied;
	}
}
