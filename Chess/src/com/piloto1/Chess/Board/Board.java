package com.piloto1.Chess.Board;

import com.piloto1.Chess.Board.Piece.Piece;

public class Board {
	
	private Piece[][] board;
	private String[] pieceTypes = {"Rook", "Knight", "Bishop", "King", "Queen", "Bishop", "Knight", "Rook"};
	
	public void createBoard() {
		board = new Piece[8][8];
		for(int i = 0; i < 8; i++) {
			board[0][i] = new Piece(pieceTypes[i], true);
			board[1][i] = new Piece("Pawn", true);
			
			board[board.length -1][i] = new Piece(pieceTypes[board.length - 1 - i], true);
			board[board.length - 2][i] = new Piece("Pawn", true);
		}
	}
	
	public void displayBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] != null) {
					System.out.print(String.format("%11s,", board[i][j].getType()));
				} else {
					System.out.print(String.format("%11s,", ""));
				}
			} System.out.println();
		}
	}
	
}
