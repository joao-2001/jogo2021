package jogoteste;

import java.awt.Color;
import java.awt.Graphics;

public class Jogador extends Entidade{
	
	public Jogador(int posx, int posy, int alt, int larg, ID id) {
		super(posx, posy, alt, larg, id);
	}
	
	public void tick() {
		posicaoX += velocidadeX;
		posicaoY += velocidadeY;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(posicaoX, posicaoY, largura, altura);
	}
}
