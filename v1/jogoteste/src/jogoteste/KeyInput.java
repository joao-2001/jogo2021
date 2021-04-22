package jogoteste;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private GerenciadorDeEntidades gerenciador;
	
	public KeyInput(GerenciadorDeEntidades gerenciador) {
		this.gerenciador = gerenciador;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < gerenciador.entidades.size(); i++) {
			Entidade tempent = gerenciador.entidades.get(i);
			
			if(tempent.getID() == ID.Jogador) {
				if(key==KeyEvent.VK_W) tempent.setVelY(-5);
				if(key==KeyEvent.VK_D) tempent.setVelX(5);
				if(key==KeyEvent.VK_S) tempent.setVelY(5);
				if(key==KeyEvent.VK_A) tempent.setVelX(-5);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < gerenciador.entidades.size(); i++) {
			Entidade tempent = gerenciador.entidades.get(i);
			
			if(tempent.getID() == ID.Jogador) {
				if(key==KeyEvent.VK_W) tempent.setVelY(0);
				if(key==KeyEvent.VK_A) tempent.setVelX(0);
				if(key==KeyEvent.VK_S) tempent.setVelY(0);
				if(key==KeyEvent.VK_D) tempent.setVelX(0);
			}
		}
	}
}
