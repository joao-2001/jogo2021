package jogoteste;

public class PrimeiraFase extends Fase {
	private int criar;

	public PrimeiraFase(GerenciadorDeEntidades gerenciador, HUD hud) {
		super(gerenciador, hud);
	}
	
	public void tick() {
			
			switch (criar){
				case 0:
					break;
				case 1:
					this.gerenciador.addEntidade(GeradorDeInimigos.geraInimigo(1, hud, gerenciador));
					criar=0;
					break;
				case 2:
					this.gerenciador.addEntidade(GeradorDeInimigos.geraInimigo(2, hud, gerenciador));
					criar=0;
					break;
			}
			
			if(hud.score%250==0) {
				criar = 1;
			}
			if(hud.score%1000==0) {
				criar = 2;
			}
	}
	

}
