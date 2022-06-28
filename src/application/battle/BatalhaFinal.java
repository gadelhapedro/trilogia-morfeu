package application.battle;

import application.character.Personagem;

import java.util.ArrayList;

public class BatalhaFinal {
    ArrayList<Batalha> batalhas;
    ArrayList<Personagem[]> personagens;
    private int numBatalhas;
    private int numCombates;


    public BatalhaFinal(ArrayList<Batalha> batalhas) {
        this.batalhas = batalhas;
    }

    public void iniciar() {
        for (Batalha batalha : batalhas) {
            batalha.iniciar();
        }
    }

    public int getNumVivos() {
        int num = 0;
        for (Batalha batalha : batalhas) {
            num += batalha.getNumVivos();
        }
        return num;
    }

    public int getNumMortos() {
        int num = 0;
        for (Batalha batalha : batalhas) {
            num += batalha.getNumMortos();
        }
        return num;
    }

    public ArrayList<String> getNomeVivos() {
        ArrayList<String> nomes = new ArrayList<String>();
        for (Batalha batalha : batalhas) {
            nomes.addAll(batalha.getNomeVivos());
        }
        return nomes;
    }
    public ArrayList<String> getNomeMortos() {
        ArrayList<String> nomes = new ArrayList<String>();
        for (Batalha batalha : batalhas) {
            nomes.addAll(batalha.getNomeMortos());
        }
        return nomes;
    }


    public int getNumSuperPoderes() {
        int num = 0;
        for (Batalha batalha : batalhas) {
            num += batalha.getNumSuperPoderes();
        }
        return num;
    }

    public ArrayList<String> getNomeSuperPoderes() {
        ArrayList<String> nomes = new ArrayList<String>();
        for (Batalha batalha : batalhas) {
            nomes.addAll(batalha.getNomeSuperPoderes());
        }
        return nomes;
    }

    public ArrayList<Batalha> getBatalhas() {
        return batalhas;
    }

    public void setNumBatalhas(int numBatalhas) {
        this.numBatalhas = numBatalhas;
    }
    public void setNumCombates(int numCombates) {
        this.numCombates = numCombates;
    }
    public void setPersonagens(ArrayList<Personagem[]> personagens) {
        this.personagens = personagens;
    }
    public ArrayList<Personagem[]> getPersonagens() {
        return personagens;
    }
    public int getNumBatalhas() {
        return numBatalhas;
    }
    public int getNumCombates() {
        return numCombates;
    }
}
