package model.projeteis;

import model.Entidade;
import model.ID;
import java.awt.Color;

public abstract class Projetil extends Entidade {

    public Projetil(int x0, int y0, int vX0, int vY0, Color cor, ID id) {
        super(x0, y0, vX0, vY0, 10, 30, cor, id);
    }

    public void tick() {
        // Implementar
        // Os projeteis vao apenas se mover normal.
    }

    public void renderizar() {
        // Implementar
        // desenha ele mesmo.
    }
}
