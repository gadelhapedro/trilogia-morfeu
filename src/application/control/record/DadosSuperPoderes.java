package application.control.record;

import application.battle.BatalhaFinal;

import java.util.ArrayList;

public class DadosSuperPoderes {
    private int numOcorrencias;
    private ArrayList<String> nomes;

    public DadosSuperPoderes() {
        numOcorrencias = 0;
        nomes = new ArrayList<String>();
    }

    public void registrar(BatalhaFinal batalhaFinal){
        for (String nome : batalhaFinal.getNomeSuperPoderes()) {
            if (!nomes.contains(nome)) {
                nomes.add(nome);
                numOcorrencias++;
            }
        }
    }

    public void addOcorrencia(String nome) {
        numOcorrencias++;
        nomes.add(nome);
    }
    public int getNumOcorrencias() {
        return numOcorrencias;
    }
    public ArrayList<String> getNomes() {
        return nomes;
    }
    public String toString() {
        String retorno = "";
        retorno += "Número de superpoderes: " + numOcorrencias + "\n";
        retorno += "Nomes dos superpoderosos:\n";
        for (String nome : nomes) {
            retorno += nome + "\n";
        }
        retorno += nomes;
        return retorno;
    }

    public String getNumSuperPoderes() {
        return this.numOcorrencias + "";
    }
}















