package menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuRanking extends Menu {

    // Matriz que irá conter o nome dos jogadores e a pontuacao
    private JLabel[][] ranking;
    private Botao btMenuInicial;

    public MenuRanking(GerenciadorDeMenus gerenciador) {
        super(Color.BLUE, gerenciador);
        inicializarElementos();
        adicionarElementosAoPainel();
        posicionarElementos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btMenuInicial) {
            this.finalizar();
            gerenciador.setEstado(new MenuInicial(gerenciador));
        }
    }

    @Override
    public void executar() {
        // TODO Auto-generated method stub

    }

    @Override
    public void finalizar() {
        // Remove os botoes do painel
        this.setVisible(false);
        gerenciador.getJanela().remove(this);
    }

    @Override
    void inicializarElementos() {

        // 1a linha sera o cabeçalho
        ranking = new JLabel[11][3];

        // Cria os Jlabels personalizados
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel texto = new JLabel();
                texto.setForeground(Color.WHITE);
                ranking[i][j] = texto;
            }
        }

        // Cria o cabeçalho
        ranking[0][0].setText("Pos.");
        ranking[0][1].setText("Nome");
        ranking[0][2].setText("Pontos");

        // Inicia a tabela de ranking
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                // Posicao do Jogador no ranking
                ranking[i][0].setText("" + i);
                // Nome e pontuacao
                atualizarPosicao(i, "Nome do Jogador........", 000000000);
            }
        }

        // Cria o botão e adiciona o tratamento de evento do mesmo
        btMenuInicial = new Botao("Menu Inicial", 150, 50);
        btMenuInicial.addActionListener(this);
    }

    @Override
    void adicionarElementosAoPainel() {
        // Adicionando a matriz de texto
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                add(ranking[i][j]);
            }
        }
        // Adiciona o botao Menu inicial
        this.add(btMenuInicial);
    }

    @Override
    void posicionarElementos() {

        // Seta o layout
        setLayout(null);

        // Define dimensoes
        int altura = 20; // Altura das linhas
        int espacamento = 10; // Espacamento entre linhas
        int tamC1 = 30; // Tamanho da coluna 1
        int tamC2 = 150; // Tamanho da coluna 2
        int tamC3 = 100; // Tamanho da coluna 3

        // Posiciona primeira linha da matriz
        ranking[0][0].setBounds(200, 30, tamC1, altura);
        ranking[0][1].setBounds(ranking[0][0].getX() + ranking[0][0].getWidth(), ranking[0][0].getY(), tamC2, altura);
        ranking[0][2].setBounds(ranking[0][1].getX() + ranking[0][1].getWidth(), ranking[0][0].getY(), tamC3, altura);

        // Posiciona o restante da matriz
        for (int i = 1; i < 11; i++) {
            ranking[i][0].setBounds(ranking[0][0].getX(), ranking[i - 1][0].getY() + altura + espacamento, tamC1,
                    altura);

            ranking[i][1].setBounds(ranking[0][1].getX(), ranking[i - 1][0].getY() + altura + espacamento, tamC2,
                    altura);

            ranking[i][2].setBounds(ranking[0][2].getX(), ranking[i - 1][0].getY() + altura + espacamento, tamC3,
                    altura);
        }

        btMenuInicial.setBounds((this.getWidth() - btMenuInicial.getWidth()) / 2,
                this.getHeight() - btMenuInicial.getHeight() - 60, btMenuInicial.getWidth(), btMenuInicial.getHeight());
    }

    public void atualizarPosicao(int posicao, String nome, int pontuacao) {
        ranking[posicao][1].setText(nome);
        ranking[posicao][2].setText("" + pontuacao);
    }
}