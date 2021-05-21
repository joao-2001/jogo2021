package model.personagens;

import model.Entidade;
import model.ID;
import java.awt.Color;

public abstract class Personagem extends Entidade {

    private static final int vidaMax = 100;
    protected int vida;

    public Personagem(int x0, int y0, int vX0, int vY0, int largura, int altura, Color cor, ID id) {
        super(x0, y0, vX0, vY0, largura, altura, cor, id);
        vida = vidaMax;
    }

    public void setVida(int v) {
        this.vida = v;
    }

    public void aumentaVida(int v) {
        if (vida + v >= vidaMax)
            setVida(vidaMax);
        else
            setVida(vida + v);
    }

    public void diminuirVida(int v) {
        if (vida - v <= 0)
            setVida(0);
        else
            setVida(vida - v);
    }

    public int getVida() {
        return vida;
    }

    public static int getVidaMax() {
        return vidaMax;
    }

    public abstract void atirar();
}
