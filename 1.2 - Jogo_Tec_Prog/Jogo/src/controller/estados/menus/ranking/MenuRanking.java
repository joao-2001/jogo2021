package controller.estados.menus.ranking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import controller.estados.menus.Botao;
import controller.estados.menus.Menu;
import controller.estados.menus.MenuInicial;

public class MenuRanking extends Menu {

    // Matriz que irá conter o nome dos jogadores e a pontuacao
    private JLabel[][] tabela; // Contem a lista de jogadores e suas pontuacoes
    private Botao btMenuInicial;

    public MenuRanking() {
        super(Color.BLUE);
        inicializarElementos();
        adicionarElementosAoPainel();
        posicionarElementos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btMenuInicial) {
            this.finalizar();
            jogo.setEstado(new MenuInicial());
        }
    }

    @Override
    public void tick() {
        // Pode realizar alguma animação no painel
    }

    @Override
    public void renderizar() {
        // Renderiza o menu
    }

    @Override
    public void finalizar() {
        // Remove os botoes do painel
        this.setVisible(false);
        jogo.getJanela().remove(this);
    }

    @Override
    public void inicializarElementos() {

        // 1a linha sera o cabeçalho
        tabela = new JLabel[11][3];

        // Cria os Jlabels personalizados
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel texto = new JLabel();
                texto.setForeground(Color.WHITE);
                tabela[i][j] = texto;
            }
        }

        // Cria o cabeçalho
        tabela[0][0].setText("Pos.");
        tabela[0][1].setText("Nome");
        tabela[0][2].setText("Pontos");

        // Cria matriz de String com o ranking dos jogadores a partir do arquivo
        Ranking ranking = new Ranking();

        // Inicia a tabela de ranking
        for (int i = 0; i < ranking.getQntJogadores(); i++) {
            for (int j = 0; j < 3; j++) {
                // Posicao do Jogador no ranking
                tabela[i + 1][0].setText("" + (i + 1));
                // Nome e pontuacao
                atualizarPosicao(i + 1, ranking.getRanking()[i][0], ranking.getRanking()[i][1]);
            }
        }

        // Cria o botão e adiciona o tratamento de evento do mesmo
        btMenuInicial = new Botao("Menu Inicial", 150, 50);
        btMenuInicial.addActionListener(this);
    }

    @Override
    public void adicionarElementosAoPainel() {
        // Adicionando a matriz de texto
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                add(tabela[i][j]);
            }
        }
        // Adiciona o botao Menu inicial
        this.add(btMenuInicial);
    }

    @Override
    public void posicionarElementos() {

        // Seta o layout
        setLayout(null);

        // Define dimensoes
        int altura = 20; // Altura das linhas
        int espacamento = 10; // Espacamento entre linhas
        int tamC1 = 30; // Tamanho da coluna 1
        int tamC2 = 150; // Tamanho da coluna 2
        int tamC3 = 100; // Tamanho da coluna 3

        // Posiciona primeira linha da matriz
        tabela[0][0].setBounds(200, 30, tamC1, altura);
        tabela[0][1].setBounds(tabela[0][0].getX() + tabela[0][0].getWidth(), tabela[0][0].getY(), tamC2, altura);
        tabela[0][2].setBounds(tabela[0][1].getX() + tabela[0][1].getWidth(), tabela[0][0].getY(), tamC3, altura);

        // Posiciona o restante da matriz
        for (int i = 1; i < 11; i++) {
            tabela[i][0].setBounds(tabela[0][0].getX(), tabela[i - 1][0].getY() + altura + espacamento, tamC1, altura);
            tabela[i][1].setBounds(tabela[0][1].getX(), tabela[i - 1][0].getY() + altura + espacamento, tamC2, altura);
            tabela[i][2].setBounds(tabela[0][2].getX(), tabela[i - 1][0].getY() + altura + espacamento, tamC3, altura);
        }

        btMenuInicial.setBounds((this.getWidth() - btMenuInicial.getWidth()) / 2,
                this.getHeight() - btMenuInicial.getHeight() - 60, btMenuInicial.getWidth(), btMenuInicial.getHeight());
    }

    public void atualizarPosicao(int posicao, String nome, String pontuacao) {
        tabela[posicao][1].setText(nome);
        tabela[posicao][2].setText(pontuacao);
    }
}