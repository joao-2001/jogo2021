package menus;

import javax.swing.JButton;
import java.awt.Color;

public class Botao extends JButton {

    //Construtora
    public Botao(String texto, int largura, int altura) {
        //Inicialização de Texto e Tamanho.
        this.setText(texto);
        this.setSize(largura, altura);
        
        //Cor padrão
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
    }
}