package jogoteste;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public  float VIDA = 100;
	
	public int score = 1;
 
	
	public void tick() {
		
		score++;
		VIDA = Jogo.clamp((int)VIDA, 0, 100);

	}
	
	public void dano(float dano) {
		VIDA -= dano;
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, (int)VIDA * 2, 32);
		g.setColor(Color.white);
		g.drawString("Score: " + score, 10, 80);
	}
}
