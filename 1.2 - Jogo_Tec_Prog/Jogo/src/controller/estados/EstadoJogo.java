package controller.estados;

import controller.Jogo;
import javax.swing.JPanel;
import java.awt.Color;

public abstract class EstadoJogo extends JPanel {

    protected static Jogo jogo;

    public EstadoJogo(Color corFundo) {
        // Seta as dimensões com o tamanho da janela
        this.setSize(jogo.getJanela().getWidth(), jogo.getJanela().getHeight());
        // Seta a cor do fundo
        this.setBackground(corFundo);
        // Adiciona o Painel a janela do jogo
        jogo.getJanela().addPainel(this);
    }

    public static void setJogo(Jogo j) {
        // Referencia o jogo
        jogo = j;
    }

    // Executa de acordo com o estado do jogo
    public abstract void tick();

    // Renderiza de acordo com o estado do jogo
    public abstract void renderizar();

    // Finaliza de acordo com o estado do jogo
    public abstract void finalizar();
}