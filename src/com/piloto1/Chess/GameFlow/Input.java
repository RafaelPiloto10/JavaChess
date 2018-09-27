package com.piloto1.Chess.GameFlow;

import java.util.Scanner;

public class Input {
	Scanner scanner;
	
	public Input() {
		scanner = new Scanner(System.in);
	}
	public int promptMoveInput(String message) {
		
		System.out.print(message + ": ");
		
		for(int i = 0; i < 3; i++) {
			if(scanner.hasNextInt()) {
				return scanner.nextInt();
			}
		}
		
	}
}
