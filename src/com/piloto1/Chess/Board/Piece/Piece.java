package com.piloto1.Chess.Board.Piece;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Piece {
	private String type;
	private boolean state;
	private String player;
	public BufferedImage img = null;
	public boolean used = false;
	public boolean squareLit = false;

	
	public Piece(String type, boolean state, String player){
		this.type = type;
		this.setPlayer(player);
		this.state = state;
		
		try {
			File file = new File(Piece.class.getResource(".").getPath() + "\\images\\" + (this.player + this.type + ".png"));
	        img = ImageIO.read(file);
	    } catch (IOException e) {
	    	System.out.println("Cannot find image. ERROR: " + e);
	    }

	}
	
	public void refreshImage() {
		try {
			File file = new File(Piece.class.getResource(".").getPath() + "\\images\\" + (this.player + this.type + ".png"));
	        this.img = ImageIO.read(file);
	    } catch (IOException e) {
	    	System.out.println("Cannot find image. ERROR: " + e);
	    }
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
