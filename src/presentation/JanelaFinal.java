package presentation;

import javax.swing.*;
import java.awt.*;

public class JanelaFinal extends JFrame {
    private JLabel labelVencedor;
    private JPanel panelVencedor;
    private DadosFinais dadosFinaisJogador1;
    private DadosFinais dadosFinaisJogador2;
    private JPanel painelDados;

    public JanelaFinal(String nomeVencedor, String nomeJogador1, String nomeJogador2,String[] dados1, String[] dados2) {
        super("Resultado");
        labelVencedor = new JLabel("Vencedor: " + nomeVencedor);
        setSize(430, 560);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dadosFinaisJogador1 = new DadosFinais(nomeJogador1, dados1);
        dadosFinaisJogador2 = new DadosFinais(nomeJogador2, dados2);

        adicionarComponentes();
        estilizar();
        setVisible(true);
    }
    private void adicionarComponentes() {
        painelDados = new JPanel();
        panelVencedor = new JPanel();
        panelVencedor.add(labelVencedor);
        painelDados.add(dadosFinaisJogador1);
        painelDados.add(dadosFinaisJogador2);
        add(panelVencedor);
        add(painelDados);
    }
    private void estilizar() {
        setLayout(new FlowLayout());
        panelVencedor.setLayout(new FlowLayout(FlowLayout.CENTER));
        labelVencedor.setSize(new Dimension(490, 50));
        painelDados.setLayout(new GridLayout(2, 1, 0, 30));
    }
}
