public class Ranking {

    String[][] ranking;
    int qntJogadores;

    public Ranking() {
        //Inicia a quantidade de jogadores
        qntJogadores = 10;

        //Cria ranking
        ranking = new String[qntJogadores][2];

        //Cria cada elemento do ranking
        for (int i = 0; i < qntJogadores; i++) {
            ranking[i][0] = new String("Jogador" + i);
            ranking[i][1] = new String("" + i);
        }

        //Carrega o ranking a partir de um arquivo de texto
        RankingTextoDAO leitor = new RankingTextoDAO();
        leitor.carregarRanking(this);
    }

    public String[][] getRanking() {
        return ranking;
    }

    public int getQntJogadores() {
        return qntJogadores;
    }

    // TEMPORARIO
    public void imprimeRanking() {
        for (int i = 0; i < qntJogadores; i++) {
            System.out.println(ranking[i][0] + " " + ranking[i][1]);
        }
    }
}