package minesweeper;

import java.util.Scanner; 

public class Player {
	
	Scanner s = new Scanner(System.in); 
	private String name;
	
	public Player() {
		setName(new String()); 
	}
	
	public void takeInputs() {
		System.out.print("Enter Player name: ");
		setName(s.nextLine()); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
