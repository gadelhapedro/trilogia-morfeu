package presentation;

import application.character.Arma;
import application.character.TipoPersonagem;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PainelJogador extends JPanel {
    private PainelNome painelNome;

    private PainelArquivos painelArquivos;
    private PainelDados painelDados;
    private EscolhaArmas escolhaArmas;
    int numeroJogador;

    public PainelJogador(int numeroJogador) {
        this.numeroJogador = numeroJogador;
        inicializar();
        estilizar();
    }
    private void inicializar() {
        painelNome = new PainelNome(numeroJogador);
        painelArquivos = new PainelArquivos();
        escolhaArmas = new EscolhaArmas();
        painelDados = new PainelDados(escolhaArmas.getMorfeu(), escolhaArmas.getCafezito(), escolhaArmas.getCopinho(),
                escolhaArmas.getNeo(), escolhaArmas.getOraculo(), escolhaArmas.getTrinity());
        add(painelNome);
        add(painelArquivos);
        add(painelDados);
        add(escolhaArmas);
    }
    private void estilizar() {
        setLayout(new GridLayout(4, 1));

    }
    public String getNomeJogador() {
        return painelNome.getNomeJogador();
    }
    public HashMap<TipoPersonagem, Arma> getArmaEscolhida() {
        return escolhaArmas.getArmasEscolhidas();
    }
    public String getEntrada() {
        return painelArquivos.getEntrada();
    }
    public String getSaida() {
        return painelArquivos.getSaida();
    }
    public boolean validarCampos() {
        if (painelNome.getNomeJogador().equals("")) {
            return false;
        }
        if (painelArquivos.getEntrada().equals("")) {
            return false;
        }
        return !painelArquivos.getSaida().equals("");
    }


}
