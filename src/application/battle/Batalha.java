package application.battle;

import java.util.ArrayList;

public class Batalha {
    // A batalha será composta de vários combates
    private ArrayList<Combate> combates;
    private int codigo;

    // Construtor
    public Batalha(ArrayList<Combate> combates, int codigo) {
        this.combates = combates;
        this.codigo = codigo;
    }

    public void iniciar() {
        for (Combate combate : combates) {
            combate.lutar();
        }
    }
    public ArrayList<Combate> getCombates() {
        return combates;
    }

    public int getNumVivos() {
        int num = 0;
        for (Combate combate : combates) {
            num += combate.getNumVivos();
        }
        return num;
    }

    public int getNumMortos() {
        int num = 0;
        for (Combate combate : combates) {
            num += combate.getNumMortos();
        }
        return num;
    }

    public ArrayList<String> getNomeVivos() {
        ArrayList<String> nomes = new ArrayList<String>();
        for (Combate combate : combates) {
            nomes.addAll(combate.getNomeVivos());
        }
        return nomes;
    }
    public ArrayList<String> getNomeMortos() {
        ArrayList<String> nomes = new ArrayList<String>();
        for (Combate combate : combates) {
            nomes.addAll(combate.getNomeMortos());
        }
        return nomes;
    }

    public int getNumSuperPoderes() {
        int num = 0;
        for (Combate combate : combates) {
            num += combate.getNumSuperPoderes();
        }
        return num;
    }

    public ArrayList<String> getNomeSuperPoderes() {
        ArrayList<String> nomes = new ArrayList<String>();
        for (Combate combate : combates) {
            nomes.addAll(combate.getNomeSuperPoderes());
        }
        return nomes;
    }

    public int getCodigo() {
        return codigo;
    }

    public String toString() {
        String retorno = "";
        for (int i = 0; i < combates.size(); i++) {
            retorno += "Combate " + (i + 1) + "\n";
            retorno += combates.get(i).toString();
        }
        return retorno;
    }
}
