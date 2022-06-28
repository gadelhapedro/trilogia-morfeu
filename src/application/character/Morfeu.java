package application.character;

import java.util.ArrayList;
import java.util.HashMap;

public class Morfeu extends Personagem{
    public Morfeu(String nome, ArrayList<Integer> ataque, ArrayList<Integer> defesa, TipoPersonagem tipo, Arma arma,
                   HashMap<Arma, Integer> habilidades, int forca) {
        super(nome, ataque, defesa, tipo, arma, habilidades, forca);
        preencherHabilidades();
        preparar();
    }
    public Morfeu(HashMap<Arma, Integer> habilidades) {
        super(habilidades);
        preencherHabilidades();
    }


    protected void preencherHabilidades() {
        habilidades.put(Arma.MARTELO, 2);
        habilidades.put(Arma.ESPADA, 2);
        habilidades.put(Arma.LANCA, 3);
        habilidades.put(Arma.ARCO, 1);
        habilidades.put(Arma.ATIRADEIRA, 5);
        habilidades.put(Arma.BASTAO, -2);
        habilidades.put(Arma.CHACO, 4);
    }

}
