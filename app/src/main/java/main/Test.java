package main;

import java.io.*;

import constants.ConstantMatch;
import constants.ConstantShip;
import exceptions.BattleshipException;
import model.Match;
public class Test implements ConstantShip,ConstantMatch{
	
	public static void main (String args[]) {
		Match a =new Match();
		a.locateShips();
		System.out.println(a.printField());
		int X,Y;
		boolean win=NO;
		InputStreamReader input =new InputStreamReader(System.in);
		BufferedReader keyboard=new BufferedReader(input);
		while (!win){
			try{
				X= Integer.parseInt(keyboard.readLine());
				Y= Integer.parseInt(keyboard.readLine());
				if(a.play(X,Y)==HITTEDBUTNOTSUNKED)System.out.println("HITTED BUT NOT SUNKED");
				if(a.play(X,Y)==SUNKED)System.out.println("SUNKED");
				if(a.play(X,Y)==NOTHITTED)System.out.println("NOT HITTED");
				if(a.win()){
					System.out.println("HAI VINTO");
					win=YES;
					}
				}catch(IOException e){}catch(BattleshipException e){System.out.println(e.getMsg());}
		}
	}
}

