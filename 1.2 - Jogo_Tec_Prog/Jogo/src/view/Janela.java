package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame {

    public Janela(String titulo, int largura, int altura) {
        // Titulo da janela
        super(titulo);
        // Dimensoes da jenala
        setSize(largura, altura);
        // Redimensionar a janela
        setResizable(false);
        // Posicionar a janela no centro da tela
        setLocationRelativeTo(null);
        // Finalizar o aplicativo ao clicar em Close (X)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addPainel(JPanel painel) {
        // Adiciona um painel ao painel do JFrame
        this.getContentPane().add(painel);
    }
}