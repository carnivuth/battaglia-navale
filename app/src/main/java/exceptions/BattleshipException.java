package exceptions;
public class BattleshipException extends Exception{
	private String msg;
	public BattleshipException (String msg){
		this.msg=msg;
		}
	public String getMsg(){
		return this.msg;
	}
	
	
	}
