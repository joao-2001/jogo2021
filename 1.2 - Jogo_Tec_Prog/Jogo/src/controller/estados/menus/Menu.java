package controller.estados.menus;

import controller.estados.EstadoJogo;
import java.awt.event.ActionListener;
import java.awt.Color;

abstract public class Menu extends EstadoJogo implements ActionListener {

    // Construtora
    public Menu(Color corFundo) {
        super(corFundo);
    }

    // Executa de acordo com o estado do jogo
    public abstract void tick();

    public abstract void renderizar();

    // Finaliza de acordo com o estado do jogo
    public abstract void finalizar();

    // Cria os elementos do menu (botoes, caixas, etc.)
    public abstract void inicializarElementos();

    // Adiciona os elementos (botoes e imagem) ao painel
    public abstract void adicionarElementosAoPainel();

    // Posiciona os elementos do menu
    public abstract void posicionarElementos();
}