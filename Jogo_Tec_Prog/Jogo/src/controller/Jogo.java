package controller;

import view.Janela;
import controller.estados.EstadoJogo;
import controller.estados.menus.MenuInicial;

public class Jogo {

    private Janela janela;
    private EstadoJogo estado;

    public Jogo() {
        // Inicia janela
        janela = new Janela("Guerra Espacial", 640, 480);

        // Referencia o jogo para os estados poderem fazer alterações
        EstadoJogo.setJogo(this);

        //Inicia com o estado do menu Inicial
        estado = new MenuInicial();
    }

    public void iniciar() {
        // Abre a janela
        janela.setVisible(true);

        // Loop do jogo
        while (true) {
            estado.executar();
        }
    }

    public void setEstado(EstadoJogo estado) {
        this.estado = estado;
    }

    public Janela getJanela() {
        return janela;
    }
}
