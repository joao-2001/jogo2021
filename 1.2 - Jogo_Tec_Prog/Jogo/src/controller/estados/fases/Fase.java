package controller.estados.fases;

import controller.estados.EstadoJogo;
import controller.estados.menus.MenuInicial;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class Fase extends EstadoJogo implements KeyListener {

    public Fase() {
        super(Color.RED);
        this.addKeyListener(this);
    }

    @Override
    public void tick() {
        // Pode realizar alguma animação no painel
        System.out.println("Atualizou");
    }

    @Override
    public void renderizar() {
        // Renderiza o menu
        System.out.println("Renderizou");
    }

    @Override
    public void finalizar() {
        // TODO Auto-generated method stub
        this.setVisible(false);
        jogo.getJanela().remove(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_E) {
            this.finalizar();
            jogo.setEstado(new MenuInicial());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
