package jogoteste;

import java.awt.Color;
import java.awt.Graphics;

public class InimigoForte extends Inimigo {
	
	InimigoForte(float posx, float posy, GerenciadorDeEntidades gerenciador, HUD hud, ID id){
		super(posx, posy, 75, 75, gerenciador, 5, 20, hud, id);
	}
	
	@Override
	public void tick() {
		
		posicaoX += velocidadeX;
		posicaoY += velocidadeY;
		
		vida = Jogo.clamp((int)vida, 0, vidaMax); 
		
		if (vida == 0) {
			gerenciador.entidades.remove(this);
			hud.score += 50;
		}
		
		colide();
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)posicaoX, (int)posicaoY, (int)largura, (int)altura);
		g.setColor(Color.green);
		g.fillRect((int)posicaoX,(int)posicaoY - 15, (int)(vida*(largura/vidaMax)), 10);
	}
}
