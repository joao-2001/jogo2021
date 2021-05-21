package jogoteste;

import java.awt.Graphics;

public abstract class Inimigo extends Entidade {
	int dano;
	int vida, vidaMax;
	
	Inimigo(float posx, float posy, float alt, float larg, GerenciadorDeEntidades gerenciador, int dano, int vidaMax, HUD hud, ID id){
		super(posx, posy, alt, larg, gerenciador, hud, id);
		this.dano = dano;
		this.vidaMax = vidaMax;
		this.vida = this.vidaMax;
	}
	
	public float getDano() {
		return dano;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void colide() {
		for (int i = 0; i < gerenciador.entidades.size(); i++) {
			
			Entidade tempEnt = gerenciador.entidades.get(i);
			
			if(tempEnt.getID() == ID.Projetil) {
				if(delimitar().intersects(tempEnt.delimitar())) {
					vida--;
				}
			}
		}
	}

}
