package com.piloto1.Chess.GameFlow;

import java.util.Arrays;

import com.piloto1.Chess.Board.Board;
import com.piloto1.Chess.Board.Piece.Piece;

public class GameFlow {
	
	public Piece[][] makeMove(Board B, String player) {
		// Rank is a row board[rank]
		// File is a column board[rank][file]
		ConsoleManagement input = new ConsoleManagement();
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
		board[tX][tY] = board[x][y];
		board[x][y] = null;
		
		return board;
	}
	
	
}
