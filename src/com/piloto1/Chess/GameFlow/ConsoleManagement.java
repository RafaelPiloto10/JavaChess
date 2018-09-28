package com.piloto1.Chess.GameFlow;

import java.util.Scanner;

import com.piloto1.Chess.Board.Piece.Piece;

public class ConsoleManagement {
	Scanner scanner;
	
	public ConsoleManagement() {
		scanner = new Scanner(System.in);
	}
	public int[] promptMoveInput(Piece[][] board, String message, String Player) {
		if(message != null) {
			System.out.print(message);
		} else {
			System.out.print("Enter the piece's coordinates 'rank file' and then enter the target location 'rank file'"
					+ "\n(Seperated by spaces press ENTER when done)\n"
					+ Player + "'s move: ");
		}
		
		int[] targetedMove = new int[4];
		
		for(int i = 0; i < 4; i++) {
			if(scanner.hasNextInt()) {
				 targetedMove[i] = scanner.nextInt() - 1;
			}
		}
		
		return targetedMove;
	}
	
	public void raiseError(String error) {
		clearConsole();
		System.out.println(error);
	}
	
	public void clearConsole() {
		for(int i = 0; i < 20; i++) {
			System.out.println("\n");
		}
	}
	
}







