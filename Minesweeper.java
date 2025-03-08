package minesweeper;

public class Minesweeper {
	
	private Board b; 
	private Player p; 
	
	public Minesweeper(){
		b = new Board(); 
		p = new Player(); 
	}
	
	public void play() {
		
		welcomePlayer(); 
		
		p.takeInputs();
		
		b.initializeMines(); 
		
		printIntructions(); 
		
		playGame(); 
		
		
	}
	
	private void playGame() {
		
		b.printBoard(); 
		
		boolean gameOver = false; 
		
		while(!gameOver) {
			gameOver = b.click(); 
		}
		
		if(b.unopened==0) {
			System.out.println("Congrats "+p.getName()+", you won!!!");
		}else {
			System.out.println("Sorry "+p.getName()+", you lost.");
		}
		
	}

	private void printIntructions() {
		System.out.println("\n\n");
		System.out.println("Mines will be placed randomly in the grid.\nThere are 10 mines in the 9X9 grid.");
		System.out.println("Select the cell you want to unlock by selecting the row and column of the cell. \n(Row count and column count range from 1 to 9)");
		System.out.println("If the cell contains a mine, its game over...");
		System.out.println("\nSymbols are as follows: \n*: Unopened cell\nO: Opened cell\nX: Mine");
		System.out.println("Make it through without setting off any mines");
		System.out.println("BEST OF LUCK\n\n");
		
	}

	private void welcomePlayer() {
		System.out.println("Hello! Welcome to Minesweeper!");
		System.out.println("Here you can participate in a 9X9 board Minesweeper game!");
		System.out.println("Proceed if you dare!!1\n");
		
	}

}
