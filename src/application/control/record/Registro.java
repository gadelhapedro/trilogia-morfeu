package application.control.record;

import application.battle.BatalhaFinal;
import application.character.Personagem;
import application.character.TipoPersonagem;

import java.util.ArrayList;
import java.util.HashMap;

public class Registro {
    private int numBatalhas;
    private int numCombates;
    private DadosSuperPoderes dadosSuperPoderes;
    private DadosPontuacao dadosPontuacao;
    private HashMap<TipoPersonagem, DadosPersonagem> dadosPersonagemPorTipo;
    
    public Registro() {
        numBatalhas = 0;
        numCombates = 0;
        dadosSuperPoderes = new DadosSuperPoderes();
        dadosPontuacao = new DadosPontuacao();
        loadMap();
    }

    public void registrar(BatalhaFinal batalhaFinal) {
        this.numBatalhas = batalhaFinal.getNumBatalhas();
        this.numCombates = batalhaFinal.getNumCombates();
        this.dadosSuperPoderes.registrar(batalhaFinal);
        this.dadosPontuacao.registrar(batalhaFinal);
        calcularDadosPersonagens(batalhaFinal);
    }

    private void loadMap(){
        dadosPersonagemPorTipo = new HashMap<TipoPersonagem, DadosPersonagem>();
        for (TipoPersonagem tipo : TipoPersonagem.values()) {
            dadosPersonagemPorTipo.put(tipo, new DadosPersonagem());
        }
    }

    private void calcularDadosPersonagens(BatalhaFinal batalhaFinal) {
        ArrayList<Personagem[]> personagens = batalhaFinal.getPersonagens();
        for (Personagem[] personagensCache : personagens) {
            for (Personagem p : personagensCache) {
                dadosPersonagemPorTipo.get(p.getTipo()).addOcorrencia();
                dadosPersonagemPorTipo.get(p.getTipo()).addPontuacao(p.getPontuacao());
            }
        }
    }
    
    // get para o escritor
    public String getDados() {
        String dados = "";
        // Numero de batalhas e combates
        dados += numBatalhas + ";";
        dados += numCombates + ";";

        // Ocorrências e pontuação de cada tipo
        dados += getOcorrenciaEPontuacaoDeCadaTipo();

        // Número e nome de super poderes
        dados += getNumeroENomeDeSuperPoderes();

        // Número e nome vivos e mortos
        dados += getNumeroENomeVivosEMortos();
        return dados;
    }
    private String getSeparacao(int count, int length) {
        if (count + 2 < length) {
            return ",";
        }else {
            return ";";
        }
    }
    private String getOcorrenciaEPontuacaoDeCadaTipo() {
        String retorno = "";
        int count = 0;
        for (TipoPersonagem tipo : TipoPersonagem.values()) {
            if (!tipo.equals(TipoPersonagem.DEFAULT) && !tipo.equals(TipoPersonagem.EMPATE)){
                retorno += tipo.name() + "=";
                retorno += dadosPersonagemPorTipo.get(tipo).getNumOcorrencias();
                // Vamos apenas certificar que o último elemento será terminado com ";"
                count++;
                retorno += getSeparacao(count, TipoPersonagem.values().length);
            }
        }
        count = 0;
        for (TipoPersonagem tipo : TipoPersonagem.values()) {
            if (!tipo.equals(TipoPersonagem.DEFAULT) && !tipo.equals(TipoPersonagem.EMPATE)){
                retorno += tipo.name() + "=";
                retorno += dadosPersonagemPorTipo.get(tipo).getPontuacao();
                // Vamos apenas certificar que o último elemento será terminado com ";"
                count++;
                retorno += getSeparacao(count, TipoPersonagem.values().length);
            }
        }
        return retorno;
    }

    private String getNumeroENomeDeSuperPoderes() {
        String retorno = "";
        int count = 0;
        retorno += dadosSuperPoderes.getNumSuperPoderes() + ";";
        for (String superPoder : dadosSuperPoderes.getNomes()) {
            retorno += superPoder;
            count++;
            retorno += getSeparacao(count, dadosSuperPoderes.getNomes().size());
        }
        return retorno;
    }
    private String getNumeroENomeVivosEMortos() {
        String retorno = "";
        int count = 0;
        retorno += dadosPontuacao.getNumVivos() + ";";
        retorno += dadosPontuacao.getNumMortos() + ";";
        for (String nome : dadosPontuacao.getNomeVivos()) {
            retorno += nome;
            count++;
            retorno += getSeparacao(count, dadosPontuacao.getNomeVivos().size());
        }
        count = 0;
        for (String nome : dadosPontuacao.getNomeMortos()) {
            retorno += nome;
            count++;
            retorno += getSeparacao(count, dadosPontuacao.getNomeMortos().size());
        }
        return retorno;
    }
    public HashMap<TipoPersonagem, DadosPersonagem> getDadosPersonagemPorTipo() {
        return dadosPersonagemPorTipo;
    }
}









