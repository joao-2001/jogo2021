package menus;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

abstract class Menu extends JPanel implements ActionListener {
	GerenciadorDeMenus gerenciador;

    // Construtora
    public Menu(Color corFundo, GerenciadorDeMenus gerenciador) {
    	// Seta as dimensões com o tamanho da janela
        this.setSize(gerenciador.getJanela().getWidth(), gerenciador.getJanela().getHeight());
        // Seta a cor do fundo
        this.setBackground(corFundo);
        // Adiciona o Painel a janela do jogo
        gerenciador.getJanela().getContentPane().add(this);
        
        this.gerenciador = gerenciador;
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