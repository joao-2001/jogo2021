package jogoteste;

import java.awt.Color;
import java.awt.Graphics;

public class Projetil extends Entidade{
	int efetividade;
	int efeito;
	
	Projetil(float posx, float posy, float velx, float vely, GerenciadorDeEntidades gerenciador, ID id) {
		super(posx, posy, 10, 10, gerenciador, id);
		velocidadeX = velx;
		velocidadeY = vely;
		efetividade = 6;
		efeito = 0;
	}
	
	
	public void tick() {
		posicaoX += velocidadeX;
		posicaoY += velocidadeY;
		
		colide();
	}
	
	public void colide() {
		for (int i = 0; i < gerenciador.entidades.size(); i++) {
			
			Entidade tempEnt = gerenciador.entidades.get(i);
			
			if(tempEnt.getID() == ID.Inimigo) {
				if(delimitar().intersects(tempEnt.delimitar())) {
					efeito++;
					if(efeito == efetividade) {
						gerenciador.entidades.remove(this);
					}
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)posicaoX, (int)posicaoY, (int)largura, (int)altura);
	}
}
