package jogoteste;

public abstract class Fase {
	GerenciadorDeEntidades gerenciador;
	
	public Fase(GerenciadorDeEntidades gerenciador) {
		this.gerenciador = gerenciador;
		
	}
	
	public abstract void tick();
}
