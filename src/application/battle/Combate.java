package application.battle;

import application.character.Personagem;
import application.character.TipoPersonagem;

import java.util.ArrayList;

public class Combate {

    // Ordem será importante para o mesmo personagen não atacar duas vezes
    private final Personagem primeiroPersonagem;
    private final Personagem segundoPersonagem;
    // O vencedor será tratado como tipo, para tratarmos caso de empate.
    private TipoPersonagem vencedor;
    private final int codigo;
    // Variáveis para controle de relatório
    private int numVivos;
    private int numMortos;
    private ArrayList<String> nomeVivos;
    private ArrayList<String> nomeMortos;

    public Combate(Personagem p1, Personagem p2, int codigo) {
        this.primeiroPersonagem = p1;
        this.segundoPersonagem = p2;
        nomeVivos = new ArrayList<String>();
        nomeMortos = new ArrayList<String>();
        this.codigo = codigo;
    }
    public void lutar() {
        // antes de lutar computaremos os superpoderes de cada personagem
        compararListas(primeiroPersonagem, segundoPersonagem);
        compararListas(segundoPersonagem, primeiroPersonagem);
        // após o combate, computaremos o vencedor
        verificarVencedor();
    }

    public TipoPersonagem getTipoVencedor() {
        verificarVencedor();
        return vencedor;
    }

    private void verificarVencedor() {
        if (primeiroPersonagem.getPontuacao() > segundoPersonagem.getPontuacao()) {
            vencedor = primeiroPersonagem.getTipo();
        } else if (primeiroPersonagem.getPontuacao() < segundoPersonagem.getPontuacao()) {
            vencedor = segundoPersonagem.getTipo();
        } else {
            vencedor = TipoPersonagem.EMPATE;
        }
    }


    private void compararListas(Personagem p1, Personagem p2) {
        for (int i = 0; i < p1.getAtaque().size(); i++) {
            // Caso do primeiro ganhar
            if (p1.getAtaque().get(i) > p2.getDefesa().get(i)) {
                // computando a diferença
                p2.removePontuacao(p1.getAtaque().get(i) - p2.getDefesa().get(i));
                p1.addPontuacao(p1.getAtaque().get(i) - p2.getDefesa().get(i));
            }
            // Caso do segundo ganhar
            else if (p2.getDefesa().get(i) > p1.getAtaque().get(i)) {
                // computando a diferença
                p1.removePontuacao(p2.getDefesa().get(i) - p1.getAtaque().get(i));
                p2.addPontuacao(p2.getDefesa().get(i) - p1.getAtaque().get(i));
            }
            // em caso de empate não computamos nada
        }

    }
    public void calcVivos() {
        numVivos = 0;
        numMortos = 0;
        if (primeiroPersonagem.isVivo()) {
            numVivos++;
            nomeVivos.add(primeiroPersonagem.getNome());
        }
        else{
            numMortos++;
            nomeMortos.add(primeiroPersonagem.getNome());
        }
        if (segundoPersonagem.isVivo()) {
            numVivos++;
            nomeVivos.add(segundoPersonagem.getNome());
        }
        else{
            numMortos++;
            nomeMortos.add(segundoPersonagem.getNome());
        }
    }
    public int getNumVivos() {
        calcVivos();
        return numVivos;
    }
    public int getNumMortos() {
        calcVivos();
        return numMortos;
    }
    public ArrayList<String> getNomeVivos() {
        calcVivos();
        return nomeVivos;
    }
    public ArrayList<String> getNomeMortos() {
        calcVivos();
        return nomeMortos;
    }

    public int getNumSuperPoderes() {
        int superPoderes = 0;
        if (primeiroPersonagem.temSuperPoder()) {
            superPoderes++;
        }
        if (segundoPersonagem.temSuperPoder()) {
            superPoderes++;
        } else {
            return 0;
        }
        return superPoderes;
    }
    public Personagem getPrimeiroPersonagem() {
        return primeiroPersonagem;
    }
    public Personagem getSegundoPersonagem() {
        return segundoPersonagem;
    }
    public ArrayList<String> getNomeSuperPoderes() {
        ArrayList<String> superPoderes = new ArrayList<>();
        if (primeiroPersonagem.temSuperPoder()) {
            superPoderes.add(primeiroPersonagem.getNome());
        }
        if (segundoPersonagem.temSuperPoder()) {
            superPoderes.add(segundoPersonagem.getNome());
        }
        return superPoderes;
    }
    public String toString() {
        String retorno = "";
        retorno += "Código: " + codigo + "\n";
        retorno += "Primeiro Personagem: " + primeiroPersonagem.getNome() + "\n";
        retorno += "Segundo Personagem: " + segundoPersonagem.getNome() + "\n";
        return retorno;
    }

}