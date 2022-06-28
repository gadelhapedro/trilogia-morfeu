package application.control.record;


public class DadosPersonagem {
    private int numOcorrencias;
    private int pontuacao;

    public DadosPersonagem() {
        this.numOcorrencias = 0;
        this.pontuacao = 0;
    }

    public void addOcorrencia() {
        numOcorrencias++;
    }
    public void addPontuacao(int pontuacao) {
        this.pontuacao += pontuacao;
    }

    public int getNumOcorrencias() {
        return numOcorrencias;
    }
    public int getPontuacao() {
        return pontuacao;
    }

    public String toString() {
        String retorno = "";
        retorno += "Número de ocorrências: " + numOcorrencias + "\n";
        retorno += "Pontuação: " + pontuacao + "\n";
        return retorno;
    }
    public String toStringInterface() {
        String retorno = "";
        retorno += "Ocorrências: " + numOcorrencias + " ";
        retorno += "Pontuação: " + pontuacao;
        return retorno;
    }

}
