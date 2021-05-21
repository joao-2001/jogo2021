package jogoteste;

public class SegundaFase extends Fase {
	private int criar;

	public SegundaFase(GerenciadorDeEntidades gerenciador, HUD hud) {
		super(gerenciador, hud);
		
//		Jogador jogador1 = new Jogador(100, 100, 50, 50, gerenciador, hud, ID.Jogador1); 
//		Jogador jogador2 = new Jogador(100, 100, 50, 50, gerenciador, hud, ID.Jogador2);

//		gerenciador.addEntidade(jogador1);
//		gerenciador.addEntidade(jogador2);
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
			
			if(hud.score%125==0) {
				criar = 1;
			}
			if(hud.score%500==0) {
				criar = 2;
			}
	}
	

}
