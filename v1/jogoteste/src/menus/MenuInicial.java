package menus;

import java.awt.Color;
import java.awt.event.ActionEvent;

public class MenuInicial extends Menu {

    private Botao btNovoJogo;
    private Botao btCarregar;
    private Botao btRanking;
    private Botao btSairDoJogo;

    public MenuInicial(GerenciadorDeMenus gerenciador) {
        super(Color.YELLOW, gerenciador);

        // Cria os elementos (Botoes e imagem)
        inicializarElementos();

        // Adiciona os elementos (botoes e imagem) ao painel
        adicionarElementosAoPainel();

        // Posiciona os elementos na tela.
        posicionarElementos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Abre menu para determinar numero de jogadores.
        if (e.getSource() == btNovoJogo) {
            this.finalizar();
            gerenciador.setEstado(new MenuPreFase(gerenciador));
        }

        // Abre menu com jogos salvos.
        if (e.getSource() == btCarregar)
            System.out.println("Carrega jogo iniciado");

        // Abrir menu ranking
        if (e.getSource() == btRanking) {
            this.finalizar();
            gerenciador.setEstado(new MenuRanking(gerenciador));
        }

        // Finalizar o jogo
        if (e.getSource() == btSairDoJogo) {
            System.exit(0);
        }
    }

    @Override
    public void executar() {
        // Pode realizar alguma animação no painel
    }

    @Override
    public void finalizar() {
        // Remove o painel da janela
        this.setVisible(false);
        gerenciador.getJanela().remove(this);
    }

    @Override
    void inicializarElementos() {

        // Cria os botoes e adiciona o tratamento de evento do mesmo
        btNovoJogo = new Botao("Novo Jogo", 150, 50);
        btNovoJogo.addActionListener(this);

        btCarregar = new Botao("Carregar", btNovoJogo.getWidth(), btNovoJogo.getHeight());
        btCarregar.addActionListener(this);

        btRanking = new Botao("Ranking", btNovoJogo.getWidth(), btNovoJogo.getHeight());
        btRanking.addActionListener(this);

        btSairDoJogo = new Botao("Sair do Jogo", btNovoJogo.getWidth(), btNovoJogo.getHeight());
        btSairDoJogo.addActionListener(this);
    }

    @Override
    void adicionarElementosAoPainel() {
        // Adiciona o Botao ao painel
        this.add(btNovoJogo);
        this.add(btCarregar);
        this.add(btRanking);
        this.add(btSairDoJogo);
    }

    @Override
    void posicionarElementos() {
        // Seta o layout
        setLayout(null);

        int espacamento = 10;

        // Posiciona de baixo para cima
        btSairDoJogo.setBounds((this.getWidth() - btSairDoJogo.getWidth()) / 2,
                this.getHeight() - btSairDoJogo.getHeight() - 60, btSairDoJogo.getWidth(), btSairDoJogo.getHeight());

        btRanking.setBounds((this.getWidth() - btRanking.getWidth()) / 2,
                btSairDoJogo.getY() - btRanking.getHeight() - espacamento, btRanking.getWidth(), btRanking.getHeight());

        btCarregar.setBounds((this.getWidth() - btCarregar.getWidth()) / 2,
                btRanking.getY() - btCarregar.getHeight() - espacamento, btCarregar.getWidth(), btCarregar.getHeight());

        btNovoJogo.setBounds((this.getWidth() - btNovoJogo.getWidth()) / 2,
                btCarregar.getY() - btNovoJogo.getHeight() - espacamento, btNovoJogo.getWidth(),
                btNovoJogo.getHeight());

    }
}