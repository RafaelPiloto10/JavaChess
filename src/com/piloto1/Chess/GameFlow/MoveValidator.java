package com.piloto1.Chess.GameFlow;

import com.piloto1.Chess.Board.Piece.Piece;

public class MoveValidator {
	
	
	public boolean validate(Piece[][] board, int x, int y, int tX, int tY) {
		int deltaRank = tY - y;
		int deltaFile = tX - x;
		
		// Moving an empty square
		if(board[x][y] == null) {
			return false;
		}
		
		if(board[tX][tY] != null && board[x][y].getPlayer() == board[tX][tY].getPlayer()) {
			System.out.println("Cannot capture friendly peice");
			return false;
		}
		
		
		System.out.println("Delta File : " + deltaFile + " Delta Rank: " + deltaRank);
		
		Piece piece = board[x][y];
		
		switch(piece.getPlayer()) {
			case "white":
				switch(piece.getType()){
					case "Pawn":
						// System.out.println("Rank: " + x + " File: " + y);
						
						if(deltaRank == 0 && board[tX][tY] != null) {
							return false;
						} else {
							if((deltaRank == 1 || deltaRank == -1) && deltaFile == 1) {
								if(board[tX][tY] == null) {
									return false;
								} else {
									return true;
								}
							}
						}
						
						// Valididate empty square in front move
						if(! piece.used) {
							if((deltaFile == 1 || deltaFile == 2) && deltaRank == 0) {
								piece.used = true;
							} else {
								return false;
							}
						} else {
							if(deltaFile == 1 && deltaRank == 0) {
							} else {
								return false;
							}
						}
						
						break;
					case "Rook":
						if(deltaRank != 0 && deltaFile != 0) {
							return false;
						} else if(!(validateMovement(board, x, y, tX, tY, board[x][y].getType()))) {
							return false;
						}
						
						break;
				case "Knight":
					if(!((Math.abs(deltaRank) == 1 && Math.abs(deltaFile) == 2) || (Math.abs(deltaRank) == 2 && Math.abs(deltaFile) == 1))) {
						return false;
					}
					break;
					case "Bishop":
						if(!(Math.abs(deltaRank) == Math.abs(deltaFile))) {
							return false;
						}
						break;
					case "King":
						if(!((Math.abs(deltaRank) == 1 || Math.abs(deltaRank) == 0) && (Math.abs(deltaFile) == 1 || Math.abs(deltaFile) == 0))) {
							return false;
						}
						break;
					case "Queen":
						if(!(Math.abs(deltaRank) == Math.abs(deltaFile)) && (deltaRank != 0 && deltaFile != 0)) {
							return false;
						}
						break;
				}
					break; // White Switch case
					
					
			case "black":
				switch(piece.getType()){
					case "Pawn":
						// System.out.println("Rank: " + x + " File: " + y);
						
						if(deltaRank == 0 && board[tX][tY] != null) {
							return false;
						} else {
							if((deltaRank == 1 || deltaRank == -1) && deltaFile == -1) {
								if(board[tX][tY] == null) {
									return false;
								} else {
									return true;
								}
							}
						}
						
						// Valididate empty square in front move
						if(! piece.used) {
							if((deltaFile == -1 || deltaFile == -2) && deltaRank == 0) {
								piece.used = true;
							} else {
								return false;
							}
						} else {
							if(deltaFile == -1 && deltaRank == 0) {
							} else {
								return false;
							}
						}
						
						break;
					case "Rook":
						if(deltaRank != 0 && deltaFile != 0) {
							return false;
						}else if(!(validateMovement(board, x, y, tX, tY, board[x][y].getType()))) {
							return false;
						}
						break;
					case "Knight":
						if(!((Math.abs(deltaRank) == 1 && Math.abs(deltaFile) == 2) || (Math.abs(deltaRank) == 2 && Math.abs(deltaFile) == 1))) {
							return false;
						}
						break;
					case "Bishop":
						if(!(Math.abs(deltaRank) == Math.abs(deltaFile))) {
							return false;
						}
						break;
					case "King":
						if(!((Math.abs(deltaRank) == 1 || Math.abs(deltaRank) == 0) && (Math.abs(deltaFile) == 1 || Math.abs(deltaFile) == 0))) {
							return false;
						}						
						break;
					case "Queen":
						if(!(Math.abs(deltaRank) == Math.abs(deltaFile)) && (deltaRank != 0 && deltaFile != 0)) {
							return false;
						}
						break;
			}
				break; // Black Switch case
		}
		
		return true;
	}
		
	private boolean validateMovement(Piece[][] board, int x, int y, int tX, int tY, String piece) {
		int deltaRank = tY - y;
		int deltaFile = tX - x;
		
		switch(piece) {
			case "Rook":
				if(deltaRank == 0) { // If the movement is vertical
					for(int i = 1; i < Math.abs(deltaFile); i++) {
						if(board[(i * (Math.abs(deltaFile) / deltaFile)) + x][y] != null) {
							return false;
						}
					}
				} else { // If the movement is horizontal
					for(int i = 1; i < Math.abs(deltaRank); i++) {
						if(board[x][(i * (Math.abs(deltaRank) / deltaRank)) + y] != null) {
							System.out.println("Found object");
							return false;
						}
					}
				}
				break;
			case "Bishop":
				
				break;
				
			case "Queen":
				
				break;
		}
		return true;
	}
	
}
