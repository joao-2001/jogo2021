package jogoteste;

public class GeradorDeInimigos {
	
	public static Inimigo geraInimigo(int tipo, HUD hud, GerenciadorDeEntidades gerenciador) {
		Inimigo inimigo = null;
		
			switch(tipo) {
				case 1:
					inimigo = new InimigoComum(300, 300, gerenciador, hud, ID.Inimigo);
					break;
				case 2:
					inimigo = new InimigoForte(300, 300, gerenciador, hud, ID.Inimigo);
					break;
			}
		return inimigo;
	}
	
}
