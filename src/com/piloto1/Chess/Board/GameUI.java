package com.piloto1.Chess.Board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.piloto1.Chess.Board.Piece.Piece;
import com.piloto1.Chess.GameFlow.GameFlow;

public class GameUI extends JFrame implements MouseListener{
	
	int height;
	int width;
	Piece[][] board;
	GameFlow gameControl;
	
	int prevX;
	int prevY;
	boolean prev = false;
	
	
	public GameUI(String title, int width, int height, Piece[][] board, GameFlow gf){
		setSize(width, height);
	    setTitle(title);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	    // setLocationRelativeTo(null);
	    setResizable(false);
	    
	    this.height = height;
	    this.width = width;
	    this.board = board;
	    this.gameControl = gf;   
	    addMouseListener(this);
	    
	}
	
	public void move(int tX, int tY) {
    	this.board = gameControl.makeMoveUI(this.board, this.prevX, this.prevY, tX,tY);
	}
	
	public void paint(Graphics g) {		
		boolean isLight;
		
		for(int i = 0; i < 800; i += 100) {
			for(int j = 0; j < 800; j += 100) {
				isLight = (((i / 100) % 2) == ((j / 100) % 2)) ? true : false;
				if(isLight) {
					if(this.board[j / 100][i / 100] != null) {
						if(this.board[j / 100][i / 100].squareLit) { g.setColor(new Color(255, 0, 0));}
						else { g.setColor(new Color(255, 223, 99));}
					} else { g.setColor(new Color(255, 223, 99)); }
				} else {
					if(this.board[j / 100][i / 100] != null) {
						if(this.board[j / 100][i / 100].squareLit) {g.setColor(Color.RED);}
						else { g.setColor(new Color(255, 187, 50));}
					}else { g.setColor(new Color(255, 187, 50));}
				}
				g.fillRect(i, j + 25, 100, 100);
			}
		}
		
		for(int i = 0; i < 800; i += 100) {
			for(int j = 0; j < 800; j += 100) {
				if(board[i / 100][j / 100] != null) {
					g.drawImage(board[i / 100][j / 100].img, j + 25, i + 50, null);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent mouse) {
		// TODO Auto-generated method stub
		this.prevX = mouse.getX() / 100;
		this.prevY = mouse.getY() / 100;		
	}

	@Override
	public void mouseReleased(MouseEvent mouse) {
		// TODO Auto-generated method stub
		this.board = this.gameControl.makeMoveUI(this.board, this.prevY, this.prevX, mouse.getY() / 100, mouse.getX() / 100);
		repaint();
	}
		
}
