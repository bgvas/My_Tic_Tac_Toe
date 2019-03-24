/**
 * @author Vasileios Georgoulas
 * 
 * This is a Tic-Tac-Toe game.
 * 
 * At first you have to declare the two Players names.
 * Then in Console you will see the game board.
 * The game will ask from a specific player to play.
 * You have to enter one number (0,1,2) for horizontal move
 * and a number (0,1,2) for vertical move. 
 * 
 * Winner is the player that fill out first with his sign
 * a whole line or column or diagonally.
 */



import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String player1 = null, player2 = null;
		int availableMoves = 9;
		int horizontal = 0, vertical = 0;
		
			
		System.out.println("Welcome to Tic-Tac-Toe Game.");
		System.out.println();
		System.out.print("Enter the name of first player:");
		player1 = input.next();
		Player p1 = new Player(player1);
		System.out.print("Enter the name of second player:");
		player2 = input.next();
	
		Player p2 = new Player(player2);
		p1.setSign();
		p2.setSign();
		GameBoard game = new GameBoard(p1,p2);
		game.designBoard();
		System.out.println();
		
		while(true) {
			System.out.println("Enter a number for horizontal and a number for vertical move. ");
			game.printBoard();
			System.out.println("-->" + p1.getPlayersName() + " playing now:");
			System.out.print("Horizontal:");
			horizontal = input.nextInt();
			System.out.print("Vertical:");
			vertical = input.nextInt();
			while(!game.newMove(p1, horizontal, vertical)) {
				game.printBoard();
				System.out.println("Error move. Select an other.");
				System.out.print("Horizontal:");
				horizontal = input.nextInt();
				System.out.print("Vertical:");
				vertical = input.nextInt();
			}
			availableMoves --;	
			game.printBoard();
			if(game.winCheck()) {
				break;
			}
			
			if(availableMoves > 0) {
				System.out.println("Enter a number for horizontal and a number for vertical move. ");
				System.out.println("-->" + p2.getPlayersName() + " playing now:");
				System.out.print("Horizontal:");
				horizontal = input.nextInt();
				System.out.print("Vertical:");
				vertical = input.nextInt();
				while(!game.newMove(p2, horizontal, vertical)) {
					game.printBoard();
					System.out.println("Error move. Select an other.");
					System.out.print("Horizontal:");
					horizontal = input.nextInt();
					System.out.print("Vertical:");
					vertical = input.nextInt();
				}
				availableMoves --;	
			}
			else {break;}
			if(game.winCheck()) {
				break;
			}
		}
		
		
		System.out.println();
		System.out.println("End of Game!!!");
		if(game.winCheck()) {
			game.printBoard();
			System.out.println("The winner is " + game.getwinnersName());
		}
		else {System.out.println("There is no winner.");}
	}

}
