package menus;

import javax.swing.JFrame;
import jogoteste.Jogo;

import jogoteste.Janela;

public class GerenciadorDeMenus {

    private JanelaMenu janela;
    private Menu menu;

    public GerenciadorDeMenus() {
        // Inicia janela
    	janela = new JanelaMenu("Guerra Espacial", 640, 480);


        //Inicia com o estado do menu Inicial
        menu = new MenuInicial(this);
        
        iniciar();
    }

    public void iniciar() {
        // Abre a janela
        janela.setVisible(true);

        // Loop do jogo
        while (true) {
//            estado.executar();
        }
    }
    
    public void iniciarJogo() {
    	janela.setVisible(false);
    	janela.dispose();
    	
    	new Jogo("p1", "p2");
    }

    public void setEstado(Menu menu) {
        this.menu = menu;
    }

    public JanelaMenu getJanela() {
        return janela;
    }
}
