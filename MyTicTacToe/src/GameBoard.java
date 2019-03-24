/**
 * In this Class, there are methods
 * for GameBoard creation and drawing
 * and methods for add moves and for win
 * check.  
 */


public class GameBoard {
	
	private String board [][] = new String[5][11];
	private Player p1;
	private Player p2;
	private String winPlayer;
	
	public GameBoard(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	// Design GameBoard
	// Will create a 2 dimensional array of Strings (5,11)
	// Where we will put inside the designed board and will
	// remain 9 cells for the moves.
	public void designBoard() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 11; j++) {
				if((i%2 == 0) && (j == 1 || j == 5 || j == 9)) {
					board[i][j] = " ";
				}
				else if(j == 3 || j == 7) {
					board[i][j] = "|";
				}
				else if((i == 1 || i == 3) && (j != 3 || j != 7)) {
					board[i][j] = "-";
				}
				else if((i%2 == 0) && (j != 1 || j != 5 || j != 9)) {
					board[i][j] = " ";
				}
			}
		}
	}
	
	// Drawing the tic-tac-toe board 
	public void printBoard() {
		System.out.println(" 0   1   2");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 11; j++) {
				System.out.print(board[i][j]);
			}
			if(i%2 == 0) {
				System.out.print("  " + i/2);
			}
			System.out.println();
		}
	}
	
	// Check if move is accepted and save it to array
	public boolean newMove(Player player, int hor, int vert) {
		boolean moveOk = false;
		if((hor <= 2 && hor >= 0) && (vert <= 2 && vert >= 0)) {
			if(board[vert*2][(hor*4)+1].equals(" ")) {
				board[vert*2][(hor*4)+1] = player.getSign();
				moveOk = true;
			}
		}
		return moveOk;
	}
	
	
	public boolean winCheck() {
		boolean win = false;
		
		// Check if there is a winner in any line  
		for(int i = 0; i < 5; i = i + 2) {
			int notNull = 0;
			for(int j = 1; j < 10 ; j = j + 4) {
				if(board[i][j] != " ") {
					 notNull++;
				}
			}
			if(notNull == 3) {
				if(board[i][1] == board[i][5] && board[i][1] == board[i][9]) {
					win = true;
					if(board[i][1] == p1.getSign()) {
						this.winPlayer = p1.getPlayersName();
					}
					else {this.winPlayer = p2.getPlayersName();}
					break;
				}
			}
		}
		
		// Check if there is a winner in any column
		for(int i = 1; i < 10; i = i + 4) {
			int notNull = 0;
			for(int j = 0; j < 5; j = j + 2) {
				if(board[j][i] != " ") {
					notNull++;
				}
			}
			if(notNull == 3) {
				if(board[0][i] == board[2][i] && board[0][i] == board[4][i]) {
					win = true;
					if(board[0][i] == p1.getSign()) {
						this.winPlayer = p1.getPlayersName();
					}
					else {this.winPlayer = p2.getPlayersName();} 
					break;
				}
			}
		}
		
		// Check if there is a winner diagonally
			if(board[0][1] != " " && board[2][5] != " " && board[4][9] != " ") {
				if(board[0][1] == board[2][5] && board[0][1] == board[4][9]) {
					win = true;
					if(board[0][1] == p1.getSign()) {
						this.winPlayer = p1.getPlayersName();
					}
					else {this.winPlayer = p2.getPlayersName();}
				}
			}
			else if(board[4][1] != " " && board[2][5] != " " && board[0][9] != " ") {
				if(board[4][1] == board[2][5] && board[4][1] == board[0][9]) {
					win = true;
					if(board[4][1] == p1.getSign()) {
						this.winPlayer = p1.getPlayersName();
					}
					else {this.winPlayer = p2.getPlayersName();}
				}
			}
		return win;
	}
	
	
	public String getwinnersName() {
		return this.winPlayer;
	}

}

