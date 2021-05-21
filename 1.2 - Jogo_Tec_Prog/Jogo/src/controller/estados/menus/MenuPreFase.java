package controller.estados.menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.estados.fases.Fase;

public class MenuPreFase extends Menu {

    private JLabel txtJogador1;
    private JLabel txtJogador2;
    private JTextField txfNomeJogador1;
    private JTextField txfNomeJogador2;
    private Botao btJogar;
    private Botao btMenuInicial;

    public MenuPreFase() {
        super(Color.GREEN);
        inicializarElementos();
        adicionarElementosAoPainel();
        posicionarElementos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Inicia novo jogo
        if (e.getSource() == btJogar) {
            System.out.println("Começa o jogo");
            // Cria um jogador 1 e 2
            // Cria uma fase
            // Adiciona os jogadores a fase
            this.finalizar();
            jogo.setEstado(new Fase());
        }

        // Volta para o menu principal
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
        // Cria os textos para identificar onde o jogador insere o nome
        txtJogador1 = new JLabel("Jogador 1:");
        txtJogador1.setForeground(Color.WHITE);

        txtJogador2 = new JLabel("Jogador 2:");
        txtJogador2.setForeground(Color.WHITE);

        // Cria caixas de texto para os nomes dos jogadores
        txfNomeJogador1 = new JTextField();
        txfNomeJogador2 = new JTextField();

        // Cria os botões e adiciona o tratamento de evento dos mesmos
        btJogar = new Botao("Jogar", 150, 50);
        btJogar.addActionListener(this);

        btMenuInicial = new Botao("Menu Inicial", 150, 50);
        btMenuInicial.addActionListener(this);
    }

    @Override
    public void adicionarElementosAoPainel() {
        // Adiciona os elementos ao painel
        this.add(txtJogador1);
        this.add(txtJogador2);
        this.add(txfNomeJogador1);
        this.add(txfNomeJogador2);
        this.add(btMenuInicial);
        this.add(btJogar);
    }

    @Override
    public void posicionarElementos() {
        // Seta o layout
        setLayout(null);

        // Posicionamento dos elementos
        txtJogador1.setBounds(230, 200, 80, 20);

        txtJogador2.setBounds(txtJogador1.getX(), txtJogador1.getY() + txtJogador2.getHeight() + 20,
                txtJogador1.getWidth(), txtJogador1.getHeight());

        txfNomeJogador1.setBounds(txtJogador1.getX() + txtJogador1.getWidth(), txtJogador1.getY(), 100,
                txtJogador1.getHeight());

        txfNomeJogador2.setBounds(txtJogador2.getX() + txtJogador2.getWidth(), txtJogador2.getY(),
                txfNomeJogador1.getWidth(), txtJogador2.getHeight());

        btJogar.setBounds((this.getWidth() - btJogar.getWidth()) / 2, 250, btJogar.getWidth(), btJogar.getHeight());

        btMenuInicial.setBounds((this.getWidth() - btMenuInicial.getWidth()) / 2,
                this.getHeight() - btMenuInicial.getHeight() - 60, btMenuInicial.getWidth(), btMenuInicial.getHeight());
    }
}