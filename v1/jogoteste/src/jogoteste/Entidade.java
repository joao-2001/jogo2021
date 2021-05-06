package jogoteste;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entidade {
	protected float altura;
	protected float largura;
	
	protected float posicaoX, posicaoY;
	
	protected float velocidadeX;
	protected float velocidadeY;
	
	GerenciadorDeEntidades gerenciador;
	
	protected ID id;
	
	public Entidade(float posx, float posy, float alt, float larg,GerenciadorDeEntidades gerenciador, ID id) {
		posicaoX = posx;
		posicaoY = posy;
		altura = alt;
		largura = larg;
		this.id = id;
		velocidadeX = 0;
		velocidadeY = 0;
		this.gerenciador = gerenciador;
	}
	
	public void setPosX(float x) {
		posicaoX = x;
	}
	public void setPosY(float y) {
		posicaoY = y;
	}
	public void setVelX(float vx) {
		velocidadeX = vx;
	}
	public void setVelY(float vy) {
		velocidadeY = vy;
	}
	public void setID(ID id) {
		this.id = id;
	}
	public float getPosX() {
		return posicaoX;
	}
	public float getPosY() {
		return posicaoY;
	}
	public float getVelX() {
		return velocidadeX;
	}
	public float getVelY() {
		return velocidadeY;
	}
	public ID getID() {
		return id;
	}
	public Rectangle delimitar() {
		return new Rectangle((int)posicaoX, (int)posicaoY, (int)altura, (int)largura);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
