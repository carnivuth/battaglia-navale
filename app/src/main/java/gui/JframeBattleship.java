package gui;
import java.awt.*;
import javax.swing.*;

public class JframeBattleship extends JFrame{
	
	JFrame win;
	
	public JframeBattleship(String nome){
		this.win= new JFrame(nome);
		
	}
	public void start(){
		Container c =win.getContentPane();
		JpanelMatch panel =new JpanelMatch();
		
		
		c.setLayout(new FlowLayout());
		win.setSize(1920,1080);
		win.setLocation(0,0);
		c.add(panel);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		win.setVisible(true);
	}
}

