package controller.estados.menus.ranking;

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
            ranking[i][0] = new String();
            ranking[i][1] = new String();
        }

        //Solicita ao DAO para inicializar o ranking
        RankingTextoDAO gerenciadorDAO = new RankingTextoDAO();
        gerenciadorDAO.carregarRanking(this);
    }

    public String[][] getRanking() {
        return ranking;
    }

    public int getQntJogadores() {
        return qntJogadores;
    }
}