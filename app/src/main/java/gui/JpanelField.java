package gui;
import java.awt.*;
import javax.swing.*;

import constants.ConstantMatch;
import constants.ConstantShip;
import exceptions.BattleshipException;
import model.Match;

public class JpanelField extends JPanel implements ConstantMatch,ConstantShip{
		private Match match;
		
		public JpanelField(Match p){

			this.setPreferredSize(new Dimension(800,800));
			this.setMatch(p);
			} 
		public void setMatch(Match p){
			this.match=p;
			
			}
		public void paintComponent(Graphics g){
			//super.paintComponents(g);
			g.setColor(Color.black); 
			int i=0;
			for(i=0; i<=GROUNDDIMENSION;i++){
				if(i==GROUNDDIMENSION){g.drawLine(0,(i*(this.getHeight() / GROUNDDIMENSION))-1 ,this.getWidth(),(i*(this.getHeight() / GROUNDDIMENSION))-1);}
				g.drawLine(0,i*(this.getHeight() / GROUNDDIMENSION) ,this.getWidth(),i*(this.getHeight() / GROUNDDIMENSION));
			}
			
			for(i=0; i<=GROUNDDIMENSION;i++){
				if(i==GROUNDDIMENSION){	g.drawLine((i*(this.getWidth() / GROUNDDIMENSION))-1,0,(i*(this.getWidth() / GROUNDDIMENSION))-1 ,this.getHeight());}
				g.drawLine(i*(this.getWidth() / GROUNDDIMENSION),0,(i*(this.getWidth() / GROUNDDIMENSION)) ,this.getHeight());
			}
			int position=0;
			for (int h=0;h<GROUNDDIMENSION;h++){
				for(int j=0;j<GROUNDDIMENSION;j++){
					if(match.getField().getGround()[h][j].getCovered()==NO){//se la cella che sto ciclando è scoperta
						if(match.getField().getGround()[h][j].getOccupied()){
							try{
								position=match.findShip(h,j);
							}catch(BattleshipException e){
								System.out.println(e.getMsg());
								g.setColor(Color.blue);
							}
							if(match.getShips()[position].getShipState()==SUNKED){
								g.setColor(Color.red);
							}else if(match.getShips()[position].getShipState()==HITTEDBUTNOTSUNKED){
								g.setColor(Color.yellow);
							}
						}else{
							g.setColor(Color.blue);
						}
						
						g.drawOval(j*(this.getHeight()/GROUNDDIMENSION),h*(this.getWidth()/GROUNDDIMENSION),this.getWidth()/GROUNDDIMENSION,this.getHeight()/GROUNDDIMENSION);
						g.fillOval(j*(this.getHeight()/GROUNDDIMENSION),h*(this.getWidth()/GROUNDDIMENSION),this.getWidth()/GROUNDDIMENSION,this.getHeight()/GROUNDDIMENSION);
					}
				}
				
			}
			
		 }
		public void drawBoardGame(){this.repaint();}
	
}
