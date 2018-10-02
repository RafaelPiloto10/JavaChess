package com.piloto1.Chess.GameFlow;

import com.piloto1.Chess.Board.Board;
import com.piloto1.Chess.Board.Piece.Piece;

public class GameFlow {
	
	MoveValidator validator = new MoveValidator();
	ConsoleManagement input = new ConsoleManagement();

	public Piece[][] makeMove(Board B, String player) {
		// Rank is a row board[rank]
		// File is a column board[rank][file]
		Piece[][] board = B.board;
		boolean validMove = false;
		while(!validMove) {
			int[] tMove = input.promptMoveInput(board, null, player);
			
			if(board[tMove[0]][tMove[1]].getPlayer() != player) {
				input.raiseError("That is not your piece! try again\n");
				B.displayBoard();
				continue;
			} else if( (board[tMove[2]][tMove[3]]) != null && (board[tMove[0]][tMove[1]].getPlayer() == board[tMove[2]][tMove[3]].getPlayer())) {
				input.raiseError("You cannot move a piece to an occupied square\n");
				B.displayBoard();
				continue;
			}
			
			board[tMove[2]][tMove[3]] = board[tMove[0]][tMove[1]];
			board[tMove[0]][tMove[1]] = null;
			validMove = true;
			
		}
		
		return board;
	
	}
	
	public Piece[][] makeMoveUI(Piece[][] board, int x, int y, int tX, int tY){
		if(validator.validate(board, x, y, tX, tY)) {
			board[tX][tY] = board[x][y];
			board[x][y] = null;
		} else {
			System.out.println("Cannot make move");
		}
		
		return board;
	}
	
	
}
