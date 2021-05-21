package jogoteste;

public abstract class Fase {
	GerenciadorDeEntidades gerenciador;
	HUD hud;
	
	public Fase(GerenciadorDeEntidades gerenciador, HUD hud) {
		this.gerenciador = gerenciador;
		this.hud = hud;
		
	}
	
	public abstract void tick();
}
