package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner; 

public class Board {
	
	Scanner s = new Scanner(System.in); 
	char board[][]; 
	ArrayList<Integer> mines;
	public int unopened;
	private int counter; 
	
	public Board() {
		board = new char[9][9]; 
		for(char[] arr: board) {
			Arrays.fill(arr, '*');
		}
		unopened = 81 - 10; 
		counter = 0; 
	}

	public void initializeMines() {
		
		mines = new ArrayList<>(); 
		Random r = new Random(); 
		int c = 0; 
		while(c<10) {
			int a = r.nextInt(80); 
			if(mines.indexOf(a)==-1) {
				mines.add(a); 
				c++; 
			}
		}
		
	}

	public void printBoard() {
		
		System.out.println("\n");
		
		System.out.println("  1 2 3 4 5 6 7 8 9");
		
		for(int i = 0; i<9; i++) {
			System.out.print((i+1)+" ");
			for(int j = 0; j<9; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("\n");
		
	}

	public boolean click() {
		
		System.out.print("Enter row and column: ");
		int r = s.nextInt(); 
		int c = s.nextInt(); 
		
		if(r>9||r<1||c>9||c<1) {
			System.out.println("Invalid Move, try again");
			return false; 
		}
		
		r--;
		c--;
		
		if(board[r][c]=='O') {
			System.out.println("Already opened, try again");
			return false; 
		}
		
		if(mines.indexOf(r*10 + c)==-1) {
			counter++; 
			if(counter==4) {
				counter=0; 
				bigMove(r,c); 
			}else {
				smallMove(r,c); 
			}
			 
			printBoard();
			
			return (unopened==0); 
		}
		
		printFinal(); 
		
		return true;
	}

	private void bigMove(int r, int c) {
		
		int sr, sc; 
		
		if(r==0) {
			sr = 0; 
		}else if(r==8) {
			sr = 6; 
		}else {
			sr = r-1; 
		}
		
		if(c==0) {
			sc = 0; 
		}else if(c==8) {
			sc = 6; 
		}else {
			sc = c-1; 
		}
		
		for(int i = sr; i<sr+3; i++) {
			for(int j = sc; j<sc+3; j++) {
				if(board[i][j]=='O'||mines.indexOf(i*10+j)!=-1) {
					continue; 
				}else {
					board[i][j]='O';
					unopened--; 
				}
			}
		}
		
		
		
	}

	private void smallMove(int r, int c) {
		board[r][c] = 'O';
		unopened--;
	}

	private void printFinal() {
		System.out.println("\nSorry, you stepped on a mine.\n");
		
		System.out.println("  1 2 3 4 5 6 7 8 9");
		
		for(int i = 0; i<9; i++) {
			
			System.out.print((i+1)+" ");
			
			for(int j = 0; j<9; j++) {
				
				if(mines.indexOf(i*10 + j)==-1) {
					System.out.print(board[i][j]+" ");
				}else {
					System.out.print('x'+" ");
				}
			}
			
			System.out.println();
		}
		
		
		System.out.println("\n");
		
	}
	
	

}
