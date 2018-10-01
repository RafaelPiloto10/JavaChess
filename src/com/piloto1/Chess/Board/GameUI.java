package com.piloto1.Chess.Board;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GameUI extends JFrame{
	
	int height;
	int width;
	
	public GameUI(String title, int width, int height){
		setSize(width, height);
	    setTitle(title);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    
	    this.height = height;
	    this.width = width;
	    
	}
	
	@Override
	public void paint(Graphics g) {
		boolean isLight;
		for(int i = 0; i < 800; i += 100) {
			for(int j = 0; j < 800; j += 100) {
				isLight = (((i / 100) % 2) == ((j / 100) % 2)) ? true : false;
				if(isLight) {
					g.setColor(Color.ORANGE);
				}else {
					g.setColor(Color.yellow);
				}
				g.fillRect(i, j + 50, 100, 100);
			}
		}
	}
}
