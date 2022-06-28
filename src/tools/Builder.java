package tools;

import application.battle.Batalha;
import application.battle.BatalhaFinal;
import application.battle.Combate;
import application.character.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Builder {
    // Essa classe vai preencher os objetos lidos e carregados e retornar a Batalha Final.
    // Aqui estão pontos críticos do programa, que podem resultar em uma parada, portanto vamos tratar especificamente para retornar ao usuario.

    private final int numBatalhas;
    private final int numCombates;
    private final int numCombatesPorBatalha;
    private final ArrayList<String[]> info;

    // Componentes da batalha final
    private final ArrayList<Personagem[]> personagens;
    private ArrayList<Combate> combates;
    private ArrayList<Batalha> batalhas;
    private BatalhaFinal batalhaFinal;
    private final HashMap<TipoPersonagem, Arma> armasJogador1;


    public Builder(File file, String key, HashMap<TipoPersonagem, Arma> armasJogador1) {
        this.armasJogador1 = armasJogador1;
        info = Leitor.ler(file, key);
        combates = new ArrayList<>();
        batalhas = new ArrayList<>();
        personagens = new ArrayList<>();
        numBatalhas = getNumBatalhas();
        numCombates = getNumCombates();
        numCombatesPorBatalha = getNumCombatesPorBatalha(numBatalhas, numCombates);
        buildPersonagens();
        buildCombates();
        buildBatalhas();
        buildBatalhaFinal();
    }

    public BatalhaFinal getBatalhaFinal() {
        return batalhaFinal;
    }

    private void buildCombates() {
        for (int i = 0; i < numCombates; i++) {
            buildCombate(i);
        }
    }

    private void buildBatalhaFinal() {
        batalhaFinal = new BatalhaFinal(batalhas);
        batalhaFinal.setNumBatalhas(numBatalhas);
        batalhaFinal.setNumCombates(numCombates);
        batalhaFinal.setPersonagens(personagens);
    }

    private void buildBatalhas() {
        // numCombates --> numCombatesPorBatalha*numBatalhas
        // loop no numero total de combates
        for (int i = 0; i < numCombates; i+=numCombatesPorBatalha) {
            ArrayList<Combate> combatesCache = new ArrayList<>();
            // loop no numero de combates por batalha
            // montamos as batalhas com as posições no array de combates
            // 0 + 1, 0 + 2, 0 + 3, ... 
            for (int j = 0; j < numCombatesPorBatalha; j++) {
                combatesCache.add(combates.get(i+j));
            }
            Batalha batalha = new Batalha(combatesCache, Integer.parseInt(info.get(i)[1]));
            batalhas.add(batalha);
        }
    }

    private void buildCombate(int linha) {
        String[] linhaInfo = info.get(linha);
        Combate combate = new Combate(personagens.get(linha)[0], personagens.get(linha)[1], Integer.parseInt(linhaInfo[2]));
        combates.add(combate);
    }
    // controle de erro de tipo de personagem
    private void buildPersonagens() {
        // removendo os índices 0 e 1 do ArrayList
        // Os personagens serão armazenados em pares em um arrayList.
        ArrayList<String[]> cache = info;
        cache.remove(0);
        cache.remove(cache.size()- 1);
        for (String[] linha : cache) {
            TipoPersonagem tipo1 = TipoPersonagem.parseTipoPersonagem(linha[3]);
            String nome1 = linha[4];
            int forca1 = Integer.parseInt(linha[5]);
            TipoPersonagem tipo2 = TipoPersonagem.parseTipoPersonagem(linha[6]);
            String nome2 = linha[7];
            int forca2 = Integer.parseInt(linha[8]);
            ArrayList<Integer> ataque1 = new ArrayList<>();
            ArrayList<Integer> defesa1 = new ArrayList<>();
            ArrayList<Integer> ataque2 = new ArrayList<>();
            ArrayList<Integer> defesa2 = new ArrayList<>();
            for (int i = 9; i < 19; i++) {
                ataque1.add(Integer.parseInt(linha[i]));
            }
            for (int i = 19; i < 29; i++) {
                defesa1.add(Integer.parseInt(linha[i]));
            }
            for (int i = 29; i < 39; i++) {
                ataque2.add(Integer.parseInt(linha[i]));
            }
            for (int i = 39; i <= 48; i++) {
                defesa2.add(Integer.parseInt(linha[i]));
            }

            HashMap<Arma, Integer> habilidades1 = new HashMap<>();
            HashMap<Arma, Integer> habilidades2 = new HashMap<>();

            Arma arma1 = armasJogador1.get(tipo1);
            Arma arma2 = armasJogador1.get(tipo2);
            Personagem p1 = getPersonagemPorTipo(nome1, ataque1, defesa1, tipo1, arma1, habilidades1, forca1);
            Personagem p2 = getPersonagemPorTipo(nome2, ataque2, defesa2, tipo2, arma2, habilidades2, forca2);
            Personagem[] p = {p1, p2};
            personagens.add(p);
        }
    }
    // controle de erro de tipo de personagem
    private Personagem getPersonagemPorTipo(String nome, ArrayList<Integer> ataque, ArrayList<Integer> defesa,
    TipoPersonagem tipo, Arma arma, HashMap<Arma, Integer> habilidades, int forca){
        return switch (tipo) {
            case MOR -> new Morfeu(nome, ataque, defesa, TipoPersonagem.MOR, arma, habilidades, forca);
            case CAF -> new Cafezito(nome, ataque, defesa, TipoPersonagem.CAF, arma, habilidades, forca);
            case TRI -> new Trinity(nome, ataque, defesa, TipoPersonagem.TRI, arma, habilidades, forca);
            case COP -> new Copinho(nome, ataque, defesa, TipoPersonagem.COP, arma, habilidades, forca);
            case NEO -> new Neo(nome, ataque, defesa, TipoPersonagem.NEO, arma, habilidades, forca);
            case ORC -> new Oraculo(nome, ataque, defesa, TipoPersonagem.ORC, arma, habilidades, forca);
            default -> new Morfeu(nome, ataque, defesa, TipoPersonagem.DEFAULT, Arma.ARMA_NULA, habilidades, 0) {
            };
        };
    }

    private int getNumCombatesPorBatalha (int numBatalhas, int numCombates) {
        return (numCombates/numBatalhas);
    }

    private int getNumBatalhas(){
        return Integer.parseInt(info.get(info.size() - 2)[1]);
    }

    private int getNumCombates(){
        return Integer.parseInt(info.get(0)[0]);
    }


}
