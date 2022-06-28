package application.character;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Personagem {
    protected boolean vencedor;
    protected int pontuacao;
    private ArrayList<Integer> ataque;
    private ArrayList<Integer> defesa;
    // específico de cada personagem
    private String nome;
    private int forca;
    protected boolean teveSuperPoder;
    protected Arma arma;
    // trataremos as habilidades como hashmap, armazenará um valor para cada arma.
    protected HashMap<Arma, Integer> habilidades;
    // superpoder virá do tipo de personagem
    protected TipoPersonagem tipo;
    protected int superPoder;

    public Personagem(String nome, ArrayList<Integer> ataque, ArrayList<Integer> defesa, TipoPersonagem tipo, Arma arma,
                      HashMap<Arma, Integer> habilidades, int forca) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.teveSuperPoder = false;
        this.tipo = tipo;
        this.superPoder = tipo.getSuperPoder();
        this.arma = arma;
        this.habilidades = habilidades;
        this.forca = forca;
    }
    public Personagem(HashMap<Arma, Integer> habilidades) {
        this.habilidades = habilidades;
    }

    
    public void addPontuacao(int pontuacao) {
        this.pontuacao += pontuacao;
    }
    public void removePontuacao(int pontuacao) {
        this.pontuacao -= pontuacao;
    }

    protected void preparar() {
        verificarSuperPoderes();
        verificarHabilidades();
        computarForca();
    }
    private void verificarSuperPoderes() {
        // multiplica o ataque por 2 na próxima iteração, caso tenha superpoder
        for (int i = 0; i < ataque.size(); i++) {
            if (teveSuperPoder) {
                ataque.set(i, ataque.get(i) * 2);
            }
            if (ataque.get(i) == superPoder) {
                teveSuperPoder = true;
            }
        }
    }
    private void verificarHabilidades() {
        // para cara Arma na chave do nosso HashMap iremos comparar com a arma escolhida para o personagem
        for (Arma arma : habilidades.keySet()) {
            if (arma == this.arma) {
                computarHabilidade(habilidades.get(arma));
            }
        }
    }
    protected abstract void preencherHabilidades();
    private void computarForca() {
        ataque.replaceAll(integer -> integer + forca);
        defesa.replaceAll(integer -> integer + forca);
    }
    private void computarHabilidade(int valorHabilidade) {
        ataque.replaceAll(integer -> integer * valorHabilidade);
    }
    // gets
    public String toString() {
        String retorno = "";
        retorno += "Nome: " + nome + "\n";
        retorno += "Tipo: " + tipo + "\n";
        retorno += "Ataque: " + ataque + "\n";
        retorno += "Defesa: " + defesa + "\n";
        return retorno;
    }
    public boolean temSuperPoder() {
        return teveSuperPoder;
    }
    public boolean isVivo() {
        return pontuacao > 0;
    }public String getNome() {
        return nome;
    }
    public TipoPersonagem getTipo() {
        return tipo;
    }
    public ArrayList<Integer> getAtaque() {
        return ataque;
    }
    public ArrayList<Integer> getDefesa() {
        return defesa;
    }
    public int getPontuacao() {
        return pontuacao;
    }
    public HashMap<Arma, Integer> getHabilidades() {
        return habilidades;
    }
    public String[] getHabilidadesToArrayString() {
        String[] habilidades = new String[this.habilidades.size()];
        int i = 0;
        for (Arma arma : this.habilidades.keySet()) {
            habilidades[i] = arma.toString() + ": " + this.habilidades.get(arma);
            i++;
        }
        return habilidades;
    }
}
