package model.personagens.jogadores;

import model.ID;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Jogador2 extends Jogador {

    public Jogador2(int x0, int y0, String nome) {
        super(nome, x0, y0, Color.GREEN, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT,
                KeyEvent.VK_M, ID.Jogador2);
    }
}
