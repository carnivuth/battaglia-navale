package gui;
import java.awt.*;
import javax.swing.*;

import constants.ConstantMatch;
import constants.ConstantShip;
import exceptions.BattleshipException;
import model.Match;

import java.awt.event.*;
public class JpanelMatch extends JPanel implements ActionListener,ConstantMatch,ConstantShip{
		private Match match;
		private JPanel jpnInput;
		private JpanelField jpnField;
		private JComboBox jcmbxCoordinataX;
		private JComboBox jcmbxCoordinataY;
		private JButton jbtnPlay;
		private JLabel jlbState;
		public JpanelMatch(){
			this.match=new Match();	//instanziamento oggetto match
			this.match.locateShips();
			//instanziamento oggetti grafici
			this.jpnInput=new JPanel();
			this.jpnField=new JpanelField(match);
			this.jlbState=new JLabel("pippo");
			this.jbtnPlay=new JButton("PLAY");
			Integer values[]=new Integer[this.match.getField().getGroundDimension()];
			
			for (int i=0 ;i<this.match.getField().getGroundDimension();i++){
				values[i]=i;
			}
			this.jcmbxCoordinataX=new JComboBox(values);
			this.jcmbxCoordinataY=new JComboBox(values);
			this.jbtnPlay.addActionListener(this);
			//aggiunta oggetti grafici ai pannelli
			this.jpnInput.add(jcmbxCoordinataX);
			this.jpnInput.add(jcmbxCoordinataY);
			this.jpnInput.add(jlbState);
			this.jpnInput.add(jbtnPlay);
			this.add(jpnInput);
			this.add(jpnField);
			/*set layout */
			this.jpnInput.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
			this.jpnField.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
			this.setLayout(new GridLayout(1,2));
		}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==jbtnPlay){
				int x=(int)jcmbxCoordinataX.getSelectedItem();
				int y=(int)jcmbxCoordinataY.getSelectedItem();
				
				try{
					int result =match.play((int)jcmbxCoordinataX.getSelectedItem(),(int)jcmbxCoordinataY.getSelectedItem());
					if(result==HITTEDBUTNOTSUNKED){
						this.jpnField.setMatch(match);
						this.jlbState.setText("HITTED");
					
					}else if(result==SUNKED){
						this.jpnField.setMatch(match);
						this.jlbState.setText("SUNKED");
						
					}else{
						this.jpnField.setMatch(match);
						this.jlbState.setText("NOT HITTED");
						
					}
					
					
				}catch(BattleshipException pippo){System.out.println(pippo.getMsg());this.jlbState.setText(pippo.getMsg());}
				
				this.jpnField.setMatch(match);
				this.repaint();
				if(match.win()){this.jlbState.setText("YOU WIN");}
				System.out.println(match.printField());
			}
		}
		
}
