package controller.estados.menus;

import controller.estados.EstadoJogo;
import java.awt.Color;

abstract class Menu extends EstadoJogo {

    // Construtora
    public Menu(Color corFundo) {
        super(corFundo);
    }

    // Executa de acordo com o estado do jogo
    public abstract void executar();

    // Finaliza de acordo com o estado do jogo
    public abstract void finalizar();

    // Cria os elementos do menu (botoes, caixas, etc.)
    abstract void inicializarElementos();

    // Adiciona os elementos (botoes e imagem) ao painel
    abstract void adicionarElementosAoPainel();

    // Posiciona os elementos do menu
    abstract void posicionarElementos();
}