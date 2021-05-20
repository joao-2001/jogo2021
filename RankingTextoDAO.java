import java.util.Formatter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RankingTextoDAO extends RankingDAO {

    //O Ranking ja deve estar devidamente ordenado
    public void escreverRanking(Ranking r) {
        // Abre o arquivo
        try {
            escritor = new Formatter("ranking.txt"); // abre o arquivo
        } catch (SecurityException securityException) {
            System.err.println("Permissao de escrita negada. Encerrando.");
            System.exit(1); // termina o programa
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Arquivo nao encontrado. Encerrando.");
            System.exit(1); // termina o programa
        }

        // Escreve o arquivo
        for (int i = 0; i < r.qntJogadores; i++) {
            escritor.format("%s %s%n", r.getRanking()[i][0], r.getRanking()[i][1]);
        }

        // Fecha o arquivo
        if (escritor != null) {
            escritor.close();
        }
    }

    public void carregarRanking(Ranking r) {
        // Abre o arquivo
        try {
            leitor = new Scanner(Paths.get("ranking.txt"));
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo. Encerrando.");
            System.exit(1);
        }

        // Le o arquivo
        for (int i = 0; i < r.getQntJogadores(); i++) {
            String nome = leitor.next();
            String pontuacao = leitor.next();

            r.getRanking()[i][0] = nome;
            r.getRanking()[i][1] = pontuacao;
        }

        // Fecha o arquivo
        if (leitor != null) {
            leitor.close();
        }
    }
}
