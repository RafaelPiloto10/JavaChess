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
						System.out.println("Rook");
						break;
					case "Knight":
						System.out.println("Knight");
						break;
					case "Bishop":
						System.out.println("Bishop");
						break;
					case "King":
						System.out.println("King");
						break;
					case "Queen":
						System.out.println("Queen");
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
						System.out.println("Rook");
						break;
					case "Knight":
						System.out.println("Knight");
						break;
					case "Bishop":
						System.out.println("Bishop");
						break;
					case "King":
						System.out.println("King");
						break;
					case "Queen":
						System.out.println("Queen");
						break;
			}
				break; // Black Switch case
		}
		
		return true;
	}
	
}
