package jogoteste;

import java.awt.Color;
import java.awt.Graphics;

public class Jogador extends Entidade{
	private	String nome;
	public Jogador(String nome, float posx, float posy, float alt, float larg, GerenciadorDeEntidades gerenciador, HUD hud, ID id) {
		super(posx, posy, alt, larg, gerenciador, hud, id);
		this.nome = nome;
	}
	
	public void tick() {
		posicaoX += velocidadeX;
		posicaoY += velocidadeY;
		
		posicaoY = Jogo.clamp((int)posicaoY, 0, Jogo.HEIGHT-88);
		posicaoX = Jogo.clamp((int)posicaoX, 0, Jogo.WIDTH-65);
		
		colide();
	}
	
	public void colide() {
		for (int i = 0; i < gerenciador.entidades.size(); i++) {
			
			Entidade tempEnt = gerenciador.entidades.get(i);
			
			if(tempEnt.getID() == ID.Inimigo) {
				if(delimitar().intersects(tempEnt.delimitar())) {
					hud.dano(((Inimigo)tempEnt).getDano());
				}
			}
		}
	}
	
	public void render(Graphics g) {
		if(id == ID.Jogador1)
			g.setColor(Color.white);
		if(id == ID.Jogador2)
			g.setColor(Color.blue);
		g.fillRect((int)posicaoX, (int)posicaoY, (int)largura, (int)altura);
	}
	
	public Projetil atira(float x, float y) {
		float vely = (float)Math.floor(10 * (y - posicaoY)/Math.sqrt(Math.pow((y - posicaoY), 2) + Math.pow((x - posicaoX),2)));
		float velx = (float)Math.floor(10 * (x - posicaoX)/Math.sqrt(Math.pow((y - posicaoY), 2) + Math.pow((x - posicaoX),2)));
		
		return new Projetil(posicaoX, posicaoY, velx, vely, gerenciador, hud, ID.Projetil);
	}
}
