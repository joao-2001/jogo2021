package jogoteste;

public class GeradorDeInimigos {
	
	public static Inimigo geraInimigo(int tipo, GerenciadorDeEntidades gerenciador) {
		Inimigo inimigo;
//		if(tipo == 1)
		inimigo = new InimigoComum(300, 300, gerenciador, ID.Inimigo);
		return inimigo;
	}
}
