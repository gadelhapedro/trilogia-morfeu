package presentation;

import javax.swing.*;
import java.awt.*;

public class PainelNome extends JPanel{
    private JPanel containerNome;
    private JLabel jogador;
    private JTextField nomeJogador;


    int numeroJogador;

    public PainelNome(int numeroJogador) {
        this.numeroJogador = numeroJogador;
        inicializar();
        estilizar();
    }
    private void inicializar() {
        containerNome = new JPanel();
        jogador = new JLabel("Nome do jogador " + numeroJogador + " :");
        nomeJogador = new JTextField(10);
        containerNome.add(jogador);
        containerNome.add(nomeJogador);
        add(containerNome);
    }
    private void estilizar() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }
    public String getNomeJogador() {
        return nomeJogador.getText();
    }
}
