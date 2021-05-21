package controller.estados.menus.ranking;

import java.util.Formatter;
import java.util.Scanner;

abstract class RankingDAO {

    protected Formatter escritor;
    protected Scanner leitor;

    abstract void escreverRanking(Ranking r);
    abstract void carregarRanking(Ranking r);
}