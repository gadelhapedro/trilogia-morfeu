package application.control.record;

import application.battle.BatalhaFinal;

import java.util.ArrayList;

public class DadosPontuacao {
    private int numVivos;
    private int numMortos;
    private ArrayList<String> nomeVivos;
    private ArrayList<String> nomeMortos;


    public DadosPontuacao() {
        numVivos = 0;
        numMortos = 0;
        nomeVivos = new ArrayList<String>();
        nomeMortos = new ArrayList<String>();
    }

    public void addVivo(String nome) {
        numVivos++;
        nomeVivos.add(nome);
    }
    public void addMorto(String nome) {
        numMortos++;
        nomeMortos.add(nome);
    }
    public int getNumVivos() {
        return numVivos;
    }
    public int getNumMortos() {
        return numMortos;
    }
    public ArrayList<String> getNomeVivos() {
        return nomeVivos;
    }
    public ArrayList<String> getNomeMortos() {
        return nomeMortos;
    }

    public void registrar(BatalhaFinal batalhaFinal) {
        for (String nome : batalhaFinal.getNomeVivos()) {
            if (!nomeVivos.contains(nome)) {
                nomeVivos.add(nome);
                numVivos++;
            }
        }
        for (String nome : batalhaFinal.getNomeMortos()) {
            if (!nomeMortos.contains(nome)) {
                nomeMortos.add(nome);
                numMortos++;
            }
        }
    }

    public String toString() {
        String retorno = "";
        retorno += "Número de vivos: " + numVivos + "\n";
        retorno += "Nomes dos vivos:\n";
        for (String nome : nomeVivos) {
            retorno += nome + "\n";
        }
        retorno += "Número de mortos: " + numMortos + "\n";
        retorno += "Nomes dos mortos:\n";
        for (String nome : nomeMortos) {
            retorno += nome + "\n";
        }
        return retorno;
    }

}
