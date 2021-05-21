package model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Entidade {

    protected int x;
    protected int y;
    protected int velocidadeX;
    protected int velocidadeY;
    protected int largura;
    protected int altura;
    protected Color cor;
    protected ID id;

    public Entidade(int x0, int y0, int vX0, int vY0, int largura, int altura, Color cor, ID id) {
        this.x = x0;
        this.y = y0;
        this.velocidadeX = vX0;
        this.velocidadeY = vY0;
        this.largura = largura;
        this.altura = altura;
        this.cor = cor;
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelocidadeX(int vX) {
        this.velocidadeX = vX;
    }

    public void setVelocidadeY(int vY) {
        this.velocidadeY = vY;
    }

    public void setLargura(int l) {
        this.largura = l;
    }

    public void setAltura(int a) {
        this.altura = a;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelocidadeX() {
        return velocidadeX;
    }

    public int getVelocidadeY() {
        return velocidadeY;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public Color getCor() {
        return cor;
    }

    public ID getID() {
        return id;
    }

    public abstract void tick();
    public abstract void renderizar(Graphics g);
}
