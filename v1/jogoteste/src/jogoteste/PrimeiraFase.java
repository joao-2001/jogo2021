package jogoteste;

public class PrimeiraFase extends Fase {

	public PrimeiraFase(GerenciadorDeEntidades gerenciador) {
		super(gerenciador);
		
		this.gerenciador.addEntidade(GeradorDeInimigos.geraInimigo(1, gerenciador));

	}
	
	public void tick() {
		
	}

}
