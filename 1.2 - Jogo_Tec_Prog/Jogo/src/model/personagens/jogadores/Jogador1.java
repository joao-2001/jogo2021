package model.personagens.jogadores;

import model.ID;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Jogador1 extends Jogador {

    public Jogador1(int x0, int y0, String nome) {
        super(nome, x0, y0, Color.BLUE, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A, KeyEvent.VK_CONTROL,
                ID.Jogador1);
    }
}
