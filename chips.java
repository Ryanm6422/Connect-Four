package application;

import javafx.scene.shape.Circle;

public class chips {
	
	private char c;
	private Circle circ;
	private boolean legalMove;
	private int vert;
	private int ho;
	private int diag1;
	private int diag2;
	private int vertRed;
	private int hoRed;
	private int diag1Red;
	private int diag2Red;
	private boolean win;
	private boolean block;
	private boolean winningLine;
	
	public chips(char c) {
		this.c = c;
	}
	
	public char getCharacter() {
		return this.c;
	}
	
	public void setCharacter(char c) {
		this.c = c;
	}
	
	public void setCircle(Circle c) {
		this.circ = c;
	}
	
	public Circle getCircle() {
		return this.circ;
	}
	
	public boolean getBool() {
		return this.legalMove;
	}
	
	public void setBool(boolean move) {
		this.legalMove = move;
	}
	public int getHo() {
		return this.ho;
	}
	
	public void setHo(int horizontal) {
		this.ho = horizontal;
	}
	public int getDiag1() {
		return this.diag1;
	}
	
	public void setDiag1(int diagonal1) {
		this.diag1 = diagonal1;
	}
	public int getDiag2() {
		return this.diag2;
	}
	
	public void setDiag2(int diagonal2) {
		this.diag2 = diagonal2;
	}
	public int getVert() {
		return this.vert;
	}
	
	public void setVert(int vertical) {
		this.vert = vertical;
	}
	public int getVertRed() {
		return this.vertRed;
	}
	
	public void setVertRed(int vertical) {
		this.vertRed = vertical;
	}
	public int getHoRed() {
		return this.hoRed;
	}
	
	public void setHoRed(int horizontal) {
		this.hoRed = horizontal;
	}
	
	public boolean getWin() {
		return this.win;
	}
	
	public void setWin(boolean winner) {
		this.win = winner;
	}
	
	public boolean getBlock() {
		return this.block;
	}
	
	public void setBlock(boolean blocker) {
		this.block = blocker;
	}
	public int getDiag1Red() {
		return this.diag1Red;
	}
	
	public void setDiag1Red(int diagonal) {
		this.diag1Red = diagonal;
	}
	public int getDiag2Red() {
		return this.diag2Red;
	}
	
	public void setDiag2Red(int diagonal) {
		this.diag2Red = diagonal;
	}
	
	public boolean getWinningLine() {
		return this.winningLine;
	}
	
	public void setWinningLine(boolean winner) {
		this.winningLine = winner;
	}
	
	
	
	
}