package jogoteste;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static float VIDA = 100;
	
	public static int score = 0;

	
	public static void tick(float dano) {
		VIDA -= dano;
		
		VIDA = Jogo.clamp((int)VIDA, 0, 100);
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
