package jogoteste;

import java.awt.Graphics;

public abstract class Entidade {
	protected int altura;
	protected int largura;
	
	protected int posicaoX, posicaoY;
	
	protected int velocidadeX;
	protected int velocidadeY;
	
	protected ID id;
	
	public Entidade(int posx, int posy, int alt, int larg, ID id) {
		posicaoX = posx;
		posicaoY = posy;
		altura = alt;
		largura = larg;
		this.id = id;
		velocidadeX = 0;
		velocidadeY = 0;
	}
	
	public void setPosX(int x) {
		posicaoX = x;
	}
	public void setPosY(int y) {
		posicaoY = y;
	}
	public void setVelX(int vx) {
		velocidadeX = vx;
	}
	public void setVelY(int vy) {
		velocidadeY = vy;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public int getPosX() {
		return posicaoX;
	}
	public int getPosY() {
		return posicaoY;
	}
	public int getVelX() {
		return velocidadeX;
	}
	public int getVelY() {
		return velocidadeY;
	}
	public ID getID() {
		return id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
