package jogoteste;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	private GerenciadorDeEntidades gerenciador;
	
	public MouseInput(GerenciadorDeEntidades gerenciador) {
		this.gerenciador = gerenciador;
	}
	public void mouseClicked(MouseEvent e) {
		int y = e.getY();
		int x = e.getX();
		
		for(int i = 0; i < gerenciador.entidades.size(); i++) {
			Entidade tempEnt = gerenciador.entidades.get(i);
			
			if(tempEnt.getID() == ID.Jogador1) {
				gerenciador.addEntidade(((Jogador) tempEnt).atira(x, y));

				
			}
		}
	}
}
