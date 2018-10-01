package com.piloto1.Chess;

import com.piloto1.Chess.Board.Board;
import com.piloto1.Chess.Board.GameUI;
import com.piloto1.Chess.GameFlow.GameFlow;

public class main {
	public static void main(String[] args) {
		Board game = new Board();
		game.createBoard();
		
		GameFlow gameControl = new GameFlow();
		boolean usingUI = true;
		
		if(usingUI) {
			GameUI UI = new GameUI("Chess", 800, 850);
		} else {
			game.displayBoard();
			int turn = 1;
			while(true) {
				if(turn == 1) {
					game.board = gameControl.makeMove(game, "White");
					game.displayBoard();
					turn *= -1;		
				} else {
					game.board = gameControl.makeMove(game, "Black");
					game.displayBoard();
					turn *= -1;
				}
			}
		}
	}
}


