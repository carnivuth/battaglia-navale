package  model;
import java.util.Random;

import  constants.ConstantMatch;
import  constants.ConstantShip;
import  exceptions.BattleshipException;
public class Match implements ConstantMatch,ConstantShip{
	private Field field;
	private Ship ships[];
	
	public Match(){
		this.field=new Field(GROUNDDIMENSION);
		this.ships=new Ship[NUMBERSHIPS];
		this.setShips();
	}
	public Field getField(){
			return this.field;
	}
	
	public Ship[] getShips(){
			return ships;
	}
	
	
	public void setShips(){
			this.ships[0]=SHIP31;
			this.ships[1]=SHIP32;
			this.ships[2]=SHIP21;
			this.ships[3]=SHIP22;
			this.ships[4]=SHIP23;
			this.ships[5]=SHIP11;
			this.ships[6]=SHIP12;
			this.ships[7]=SHIP13;
			this.ships[8]=SHIP14;
	}
	private void setDirectingShips(){ 	//METODO PER IMPOSTARE LA DIREZIONE DELLE NAVI
		Random generator=new Random();   		
			for (int i=0;i<NUMBERSHIPS;i++){
				if(generator.nextInt(2)==0){
					this.ships[i].setDirecting(ORIZZONTALLY);
				}else{
					this.ships[i].setDirecting(VERTICALLY);
				}
			}	
	}
	private boolean locateShip(Ship ship){						//METODO PER POSIZIONARE NAVE
		int i=0;
		boolean located=NO;
		boolean cellFree=YES;
		int originX;
		int originY;
		int x;
		int y;
		Random generator=new Random();
		while(!located){
			
			x=generator.nextInt(GROUNDDIMENSION-2)+1;
			y=generator.nextInt(GROUNDDIMENSION-2)+1;
			originX=x;
			originY=y;
			i=0;
			 cellFree=YES;
			while(i<ship.getNumberUnits() && cellFree){
					i++;
					if(this.positionIsFree(x,y)){
						if(ship.getDirecting()==VERTICALLY){
							y++;
						}else{
							x++;
						}	
					}else{
						cellFree=NO;
					}
			}
			if(cellFree){
				located=YES;
				ship.locate(originX,originY);
				field.setCellsOccupied(originX,originY,ship.getDirecting(),ship.getNumberUnits());	
				return true;
			}
		}
		return false;
	}
	public int play(int x,int y)throws BattleshipException{
			if(x<0||x>=GROUNDDIMENSION||y<0||y>=GROUNDDIMENSION)throw new BattleshipException("cella inesistente");
			if(this.field.getGround()[x][y].getCovered()==NO)throw new BattleshipException("cella gia selezionata");
			this.field.setCellUNcovered(x,y);
			if(this.field.getGround()[x][y].getOccupied()){
				
				return ships[this.findShip(x,y)].setUnitHit(x,y); 
			}
			return NOTHITTED;
	}
	public boolean win(){
		for(int i=0;i<NUMBERSHIPS;i++){
			if(ships[i].getShipState()!=SUNKED)return NO;
		}
		return YES;
	}		
	
	
	public int findShip(int x,int y)throws BattleshipException{
			for(int i=0;i<NUMBERSHIPS;i++){
				if(ships[i].findUnits(x,y))return i;
			}
			throw new BattleshipException("nave non trovata");
	}
	private boolean positionIsFree(int x,int y){									//CONTROLLO POSIZIONE LIBERA
		boolean result=true;
		try{
			if(this.field.getGround()[x][y]!=null){
				if(this.field.getGround()[x][y].getOccupied()==YES)return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){return result=false;}
		try{
			if(this.field.getGround()[x+1][y+1]!=null){
				if(this.field.getGround()[x+1][y+1].getOccupied()==YES) return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(this.field.getGround()[x+1][y]!=null){
				if(this.field.getGround()[x+1][y].getOccupied()==YES)return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(this.field.getGround()[x+1][y-1]!=null){
				if(this.field.getGround()[x+1][y-1].getOccupied()==YES)return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{	
			if(this.field.getGround()[x-1][y+1]!=null){
				if(this.field.getGround()[x-1][y+1].getOccupied()==YES)return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(this.field.getGround()[x-1][y-1]!=null){
				if(this.field.getGround()[x-1][y-1].getOccupied()==YES)return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{	
			if(this.field.getGround()[x][y-1]!=null){
				if(this.field.getGround()[x][y-1].getOccupied()==YES)return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(this.field.getGround()[x-1][y]!=null){
				if(this.field.getGround()[x-1][y].getOccupied()==YES)return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){}
		try{
			if(this.field.getGround()[x][y+1]!=null){
				if(this.field.getGround()[x][y+1].getOccupied()==YES)return result=false;
			}
		}catch(ArrayIndexOutOfBoundsException e){}	
		return result;
	}
	
	public void locateShips(){								//metodo per il posizionamento del plotone di navi
		this.setDirectingShips();
		for(int i=0;i<NUMBERSHIPS;i++){
				this.locateShip(ships[i]);
		}
	}
	public String printField(){
		String s="";
		for(int i=0;i<GROUNDDIMENSION;i++){
			if(i<10 && i!=0)s+="\n"+i+" ";
			else if(i!=0)s+="\n"+i;
			if(i==0){
				s+="  ";
				for(int h=0;h<GROUNDDIMENSION;h++){
					if(h<10)s+=" "+h+" ";
					else
					s+=h+" ";
				}
			s+="\n0 "	;
			}
			for(int j=0;j<GROUNDDIMENSION;j++){
				
				if(this.field.getGround()[i][j].getOccupied()){
					s+="[*]";
				}else{
					s+="[ ]";
				}
			}
		}
		return s;
		
	}
	
	
}
