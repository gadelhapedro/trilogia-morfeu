package application.control.process;

import application.battle.BatalhaFinal;
import application.character.Arma;
import application.character.TipoPersonagem;
import application.control.record.DadosPersonagem;
import application.control.record.Registro;
import tools.Builder;
import tools.Escritor;

import java.io.File;
import java.util.HashMap;

public class Controller {
    private String saidaPath;
    private File file;
    private long tempoInicial;
    private long tempo;
    private final HashMap<TipoPersonagem, Arma> armasJogador;
    // variáveis para o controle da execução
    private int numPersonagems;
    private int numBatalhas;
    private int numCombates;
    private Registro registro;

    public Controller(File file, String saidaPath, HashMap<TipoPersonagem, Arma> armasJogador)  {
        this.saidaPath = saidaPath;
        this.file = file;
        this.armasJogador = armasJogador;
        run();
    }

    public void run() {
        tempoInicial = System.currentTimeMillis();
        // montando objetos
        Builder builder = new Builder(file, ";", armasJogador);
        BatalhaFinal b = builder.getBatalhaFinal();
        b.iniciar();
        registro = new Registro();
        registro.registrar(b);
        // passando texto, nome do arquivo extensão e caminho de saída.
        Escritor.escrever(registro.getDados(), file.getName().replace(".csv", "_RESPOSTA"), "csv",
                saidaPath + getOSBarra());
        // registrando tempo
        tempo = tempoInicial - System.currentTimeMillis();
        // registrando numeros
        numPersonagems = b.getPersonagens().size()*2;
        numCombates = b.getNumCombates();
        numBatalhas = b.getNumBatalhas();
    }
    private String getOSBarra () {
        String os = getOS();
        if (os.contains("linux")) {
            return "/";
        }
        return "\\";
    }
    private String getOS () {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) {
            return "linux";
        }
        if (os.contains("win")) {
            return "win";
        }
        return os;
    }

    public long getTempo() {
        if (tempo < 0) {
            tempo = tempo * -1;
        }
        return (tempo);
    }
    public String getFileName() {
        return file.getName();
    }
    public int getNumPersonagens() {
        return numPersonagems;
    }
    public int getNumBatalhas() {
        return numBatalhas;
    }
    public int getNumCombates() {
        return numCombates;
    }
    public Registro getRegistro() {
        return registro;
    }
    public HashMap<TipoPersonagem, DadosPersonagem> getDadosPersonagens() {
        return registro.getDadosPersonagemPorTipo();
    }

}
