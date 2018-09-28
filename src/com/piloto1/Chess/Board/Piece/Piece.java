package com.piloto1.Chess.Board.Piece;

public class Piece {
	private String type;
	private boolean state;
	private String player; 
	
	public Piece(String type, boolean state, String player){
		this.type = type;
		this.setPlayer(player);
		this.state = state;
	}
	
	public Piece(String type, String player){
		this.type = type;
		this.setPlayer(player);
		this.state = true;
	}
	public Piece(boolean state, String player){
		this.state = state;
		this.setPlayer(player);
		this.type = "Pawn";
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean getState() {
		return this.state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
}
