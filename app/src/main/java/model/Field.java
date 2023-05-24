package  model;

import  constants.ConstantShip;

public class Field  implements ConstantShip{
		private Cell ground[][];
		private int groundDimension;
		
		public Cell [][] getGround(){
			return this.ground;
		}
		public int getGroundDimension(){
			return this.groundDimension;
		}
		public Field(int groundDimension){
			this.groundDimension=groundDimension;
			ground =new Cell[groundDimension][groundDimension];
			for(int j=0;j<groundDimension;j++){
				for(int l=0;l<groundDimension;l++){
					ground[j][l]=new Cell();
				}
			}
		
		}
		public void setCellsOccupied(int x,int y,boolean directing,int cells){
				for(int i=0;i<cells;i++){	
					this.ground[x][y].setOccupied(YES);
					if(directing==ORIZZONTALLY){
						x++;
					}	
					if(directing==VERTICALLY){
						y++;
					}
				}
		}
		public void setCellUNcovered(int x,int y){
			this.ground[x][y].setCovered(NO);
		}
	
	
} 
