package  model;

import  constants.ConstantShip;

public class Ship implements ConstantShip{
	private int numberUnits;
	private Unit units[]; 
	private boolean directing;
  
  	public void setNumberUnit(int numberUnits){
		this.numberUnits=numberUnits;
	}
	
	public Unit[] getUnits(){
		return this.units;
	}
	
	public int getNumberUnits(){
		return this.numberUnits;
	}
	
	public boolean getDirecting(){
		return this.directing;
	}
	
	public void setDirecting(boolean directing){
		this.directing=directing;
	}
	
	public Ship(int numberUnits){
		this.setNumberUnit(numberUnits);
		units=new Unit[numberUnits];
		for(int i=0;i<numberUnits;i++){
			units[i]=new Unit();
		}
		
	}
	
	public void locate(int x,int y){
		for(int i=0;i<this.numberUnits;i++){
		
			this.units[i].setX(x);
			this.units[i].setY(y);
			if(this.directing==VERTICALLY){
				y++;
			}else{
				x++;
			}			
		} 
	}
	
	public int setUnitHit(int x,int y){
		for(int i=0;i<numberUnits;i++){
			if(units[i].getX()==x && units[i].getY()==y){
				units[i].setHit(YES);
				return this.getShipState();
			}		
		}
		return this.getShipState();
	}
	public int getShipState(){
		int unitsHitted=0;
		for(int i=0;i<numberUnits;i++){
			if(units[i].getHit()==YES){
				unitsHitted++;
			}		
		}
		if(unitsHitted==numberUnits){
			return SUNKED;
		}if(unitsHitted==0){
			return NOTHITTED;
		
		}
		return HITTEDBUTNOTSUNKED;
	}
	public boolean findUnits(int x,int y){
		for(int i=0;i<this.numberUnits;i++){
			if(units[i].getX()==x && units[i].getY()==y)return true;
		}
		return false;
	
	}
	
}
