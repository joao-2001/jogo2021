package jogoteste;

import java.awt.Graphics;
import java.util.LinkedList;

public class GerenciadorDeEntidades {
	LinkedList<Entidade> entidades = new LinkedList<Entidade>();
	
	public void tick() {
		for(int i=0; i < entidades.size(); i++) {
			Entidade tempEnt = entidades.get(i);
			tempEnt.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i< entidades.size(); i++) {
			Entidade tempEnt = entidades.get(i);
			tempEnt.render(g);
		}
	}
	
	public void addEntidade(Entidade ent) {
		entidades.add(ent);
	}
	
	public void removeEntidade(Entidade ent) {
		entidades.remove(ent);
	}
}
