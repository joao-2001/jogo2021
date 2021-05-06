package jogoteste;

import java.awt.Color;
import java.awt.Graphics;

public class InimigoComum extends Inimigo {
	
	InimigoComum(float posx, float posy, GerenciadorDeEntidades gerenciador, ID id){
		super(posx, posy, 50, 50, gerenciador, 5, 10, id);
	}
	
	@Override
	public void tick() {
		
		posicaoX += velocidadeX;
		posicaoY += velocidadeY;
		
		vida = Jogo.clamp((int)vida, 0, vidaMax); 
		
		if (vida == 0) {
			gerenciador.entidades.remove(this);
			HUD.score += 50;
		}
		
		colide();
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)posicaoX, (int)posicaoY, (int)largura, (int)altura);
		g.setColor(Color.green);
		g.fillRect((int)posicaoX,(int)posicaoY - 15, (int)(vida*(largura/vidaMax)), 10);
	}
}
