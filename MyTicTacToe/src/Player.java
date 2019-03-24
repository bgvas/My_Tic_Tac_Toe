/**
 * 
 * 
 * Class for Players creation
 *
 */


public class Player {
	
	private String name;
	private String sign;

	public Player(String name) {
		this.name = name;
	}
	
	public String getPlayersName() {
		return this.name;
	}
	
	public void setSign() {
		if(Sign.getSign() == 1) {
			this.sign = "X";
		}
		else {
			this.sign = "O";
		}
	}
	
	public String getSign() {
		return this.sign;
	}
	
	public void printSign() {
		System.out.println(getSign());
	}
	
	
	
}
