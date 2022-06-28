package presentation;

import application.character.TipoPersonagem;

import javax.swing.*;
import java.awt.*;

public class DadosFinais extends JPanel {
    private final JLabel nomeJogador;
    private JPanel containerNome;
    private final JLabel dados1;
    private final JLabel dados2;
    private final JLabel dados3;
    private final JLabel dados4;
    private final JLabel dados5;
    private final JLabel dados6;
    private JPanel painelDados;

    public DadosFinais(String nomeJogador, String[] dados) {
        this.nomeJogador = new JLabel(nomeJogador);
        dados1 = new JLabel(dados[0]);
        dados2 = new JLabel(dados[1]);
        dados3 = new JLabel(dados[2]);
        dados4 = new JLabel(dados[3]);
        dados5 = new JLabel(dados[4]);
        dados6 = new JLabel(dados[5]);

        organizar();
    }
    private void organizar() {
        painelDados = new JPanel();
        containerNome = new JPanel();
        containerNome.add(nomeJogador);
        painelDados.add(dados1);
        painelDados.add(dados2);
        painelDados.add(dados3);
        painelDados.add(dados4);
        painelDados.add(dados5);
        painelDados.add(dados6);

        add(containerNome);
        add(painelDados);
        painelDados.setLayout(new GridLayout(6, 1));
        setLayout(new GridLayout(2, 1));
    }

}
