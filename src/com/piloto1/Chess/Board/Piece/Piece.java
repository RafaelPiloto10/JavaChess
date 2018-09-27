package com.piloto1.Chess.Board.Piece;

public class Piece {
	private String type;
	private boolean state;
	
	public Piece(String type, boolean state){
		this.type = type;
		this.state = state;
	}
	
	public Piece(String type){
		this.type = type;
		this.state = true;
	}
	public Piece(boolean state){
		this.state = state;
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
	
}
