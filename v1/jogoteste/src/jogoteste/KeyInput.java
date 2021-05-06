package jogoteste;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private GerenciadorDeEntidades gerenciador;
	private boolean[] keyDownp1 = new boolean[4];
	private boolean[] keyDownp2 = new boolean[4];
	
	public KeyInput(GerenciadorDeEntidades gerenciador) {
		this.gerenciador = gerenciador;
		
		keyDownp1[0] = false;
		keyDownp1[1] = false;
		keyDownp1[2] = false;
		keyDownp1[3] = false;
		
		keyDownp2[0] = false;
		keyDownp2[1] = false;
		keyDownp2[2] = false;
		keyDownp2[3] = false;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i < gerenciador.entidades.size(); i++) {
			Entidade tempEnt = gerenciador.entidades.get(i);
			
			if(tempEnt.getID() == ID.Jogador1) {
				if(key==KeyEvent.VK_W) {tempEnt.setVelY(-5); keyDownp1[0] = true;}
				if(key==KeyEvent.VK_D) {tempEnt.setVelX(5); keyDownp1[1] = true;}
				if(key==KeyEvent.VK_S) {tempEnt.setVelY(5); keyDownp1[2] = true;}
				if(key==KeyEvent.VK_A) {tempEnt.setVelX(-5); keyDownp1[3] = true;}
			}
			if(tempEnt.getID() == ID.Jogador2) {
				if(key==KeyEvent.VK_UP) {tempEnt.setVelY(-5); keyDownp2[0] = true;}
				if(key==KeyEvent.VK_RIGHT) {tempEnt.setVelX(5); keyDownp2[1] = true;}
				if(key==KeyEvent.VK_DOWN) {tempEnt.setVelY(5); keyDownp2[2] = true;}
				if(key==KeyEvent.VK_LEFT) {tempEnt.setVelX(-5); keyDownp2[3] = true;}
			}
		}
		if(key==KeyEvent.VK_ESCAPE) System.exit(0);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < gerenciador.entidades.size(); i++) {
			Entidade tempEnt = gerenciador.entidades.get(i);
			
			if(tempEnt.getID() == ID.Jogador1) {
				if(key==KeyEvent.VK_W) keyDownp1[0] = false; //tempEnt.setVelY(0);
				if(key==KeyEvent.VK_D) keyDownp1[1] = false; //tempEnt.setVelX(0);
				if(key==KeyEvent.VK_S) keyDownp1[2] = false; //tempEnt.setVelY(0);
				if(key==KeyEvent.VK_A) keyDownp1[3] = false; //tempEnt.setVelX(0);
				
				if(!keyDownp1[0] && !keyDownp1[2]) tempEnt.setVelY(0);
				if(!keyDownp1[1] && !keyDownp1[3]) tempEnt.setVelX(0);
			}
			if(tempEnt.getID() == ID.Jogador2) {
				if(key==KeyEvent.VK_UP) keyDownp2[0] = false; //tempEnt.setVelY(0);
				if(key==KeyEvent.VK_RIGHT) keyDownp2[1] = false; //tempEnt.setVelX(0);
				if(key==KeyEvent.VK_DOWN) keyDownp2[2] = false; //tempEnt.setVelY(0);
				if(key==KeyEvent.VK_LEFT) keyDownp2[3] = false; //tempEnt.setVelX(0);
				
				if(!keyDownp2[0] && !keyDownp2[2]) tempEnt.setVelY(0);
				if(!keyDownp2[1] && !keyDownp2[3]) tempEnt.setVelX(0);
			}
		}
	}
}
