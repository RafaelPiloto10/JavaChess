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
		if(board[x][y].getType() == "King" && !board[x][y].used && validator.isCastle(board, x, y, tX, tY)) {
			if(board[x][y].squareLit) {
				board[x][y].squareLit = false;
			}
			boolean direction = (tY - y > 0) ? true : false;
			board[x][y].used = true;
			board = validator.Castle(board, x, y, direction);
			return board;
		} else {
			if(validator.validate(board, x, y, tX, tY)) {
				if(board[x][y].squareLit) {
					board[x][y].squareLit = false;
				}
				board[x][y].used = true;
				board[tX][tY] = board[x][y];
				board[x][y] = null;
			} else {
				System.out.println("Cannot make move");
				board[x][y].squareLit = true;
			}
			return board;
		}
	}
	
}
