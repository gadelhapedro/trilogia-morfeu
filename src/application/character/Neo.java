package application.character;

import java.util.ArrayList;
import java.util.HashMap;

public class Neo extends Personagem{
    public Neo(String nome, ArrayList<Integer> ataque, ArrayList<Integer> defesa, TipoPersonagem tipo, Arma arma,
                  HashMap<Arma, Integer> habilidades, int forca) {
        super(nome, ataque, defesa, tipo, arma, habilidades, forca);
        preencherHabilidades();
        preparar();
    }
    public Neo(HashMap<Arma, Integer> habilidades) {
        super(habilidades);
        preencherHabilidades();
    }
    protected void preencherHabilidades() {
        habilidades.put(Arma.MARTELO, -2);
        habilidades.put(Arma.ESPADA, 2);
        habilidades.put(Arma.LANCA, 3);
        habilidades.put(Arma.ARCO, 5);
        habilidades.put(Arma.ATIRADEIRA, 1);
        habilidades.put(Arma.BASTAO, 4);
        habilidades.put(Arma.CHACO, 1);
    }
}
