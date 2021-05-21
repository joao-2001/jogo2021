package model.personagens.jogadores;

import model.personagens.Personagem;
import model.ID;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Jogador extends Personagem {

    protected String nome;
    protected int pontos;
    protected int codTeclaCima;
    protected int codTeclaBaixo;
    protected int codTeclaDireita;
    protected int codTeclaEsquerda;
    protected int codTeclaTiro;

    public Jogador(String nome, int x0, int y0, Color cor, int codCima, int codBaixo, int codDireita, int codEsquerda,
            int codTiro, ID id) {
        super(x0, y0, 0, 0, 50, 50, cor, id);
        this.nome = nome;
        this.pontos = 0;
        this.codTeclaCima = codCima;
        this.codTeclaBaixo = codBaixo;
        this.codTeclaDireita = codEsquerda;
        this.codTeclaEsquerda = codEsquerda;
        this.codTeclaTiro = codTiro;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public void setPontos(int p) {
        this.pontos = p;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int getCodTeclaCima() {
        return codTeclaCima;
    }

    public int getCodTeclaBaixo() {
        return codTeclaBaixo;
    }

    public int getCodTeclaDireita() {
        return codTeclaDireita;
    }

    public int getCodTeclaEsquerda() {
        return codTeclaEsquerda;
    }

    public int getCodTeclaTiro() {
        return codTeclaTiro;
    }

    public void tick() {
        // Implementar
    }

    public void renderizar(Graphics g) {
        // Implementar
    }

    public void atirar() {
        // Implementar
    }
}
