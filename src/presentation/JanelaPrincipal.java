package presentation;

import application.character.Arma;
import application.character.TipoPersonagem;
import application.control.process.Controller;
import application.game.Jogo;
import tools.Validation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.util.HashMap;

import static javax.swing.text.html.HTML.Tag.TITLE;

public class JanelaPrincipal extends JFrame {
    private PainelJogador painelJogador1;
    private PainelJogador painelJogador2;
    private JPanel painelJogadores;
    private JButton botaoIniciar;
    private JPanel painelBotao;
    public JanelaPrincipal() {
        super("Bem-vindo a trilogia Morfeu!");
        setSize(670, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setResizable(false);
        inicializarComponentes();
        estilizar();
        adicionarEventos();

        pack();
        setVisible(true);
    }
    private void inicializarComponentes(){
        painelJogador1 = new PainelJogador(1);
        painelJogador2 = new PainelJogador(2);
        painelJogadores = new JPanel();
        botaoIniciar = new JButton("Iniciar");
        painelBotao = new JPanel();

        painelJogadores.add(painelJogador1);
        painelJogadores.add(painelJogador2);
        painelBotao.add(botaoIniciar);
        add(painelJogadores);
        add(painelBotao);
    }
    private void estilizar() {
        setLayout(new FlowLayout(FlowLayout.LEADING));
        painelJogadores.setLayout(new GridLayout(1, 2));
        botaoIniciar.setPreferredSize(new Dimension(100, 50));
    }
    private void adicionarEventos() {
        botaoIniciar.addActionListener(e -> iniciarClicked());
    }

    private void iniciarClicked() {
        if (!validarCampos()){
            JOptionPane.showMessageDialog(this, "Campos vazios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validarEntrada()){
            JOptionPane.showMessageDialog(this, "Entrada inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        File entrada = new File(painelJogador1.getEntrada());
        String saida = painelJogador1.getSaida();
        HashMap<TipoPersonagem, Arma> armasJogador1 = painelJogador1.getArmaEscolhida();
        HashMap<TipoPersonagem, Arma> armasJogador2 = painelJogador2.getArmaEscolhida();
        String dadosJogador1 = "Dados " + painelJogador1.getNomeJogador();
        String dadosJogador2 = "Dados " + painelJogador2.getNomeJogador();

        Jogo jogo = new Jogo(entrada, saida, armasJogador1, armasJogador2, dadosJogador1, dadosJogador2);
        String[] dados1 = jogo.getDadosPlayer1();
        String[] dados2 = jogo.getDadosPlayer2();
        String vencedor = jogo.getNomeVencedor();

        dispose();

        new JanelaFinal(vencedor, dadosJogador1, dadosJogador2, dados1, dados2);
    }
    private boolean validarCampos() {
        return painelJogador1.validarCampos() && painelJogador2.validarCampos();
    }
    private boolean validarEntrada() {
        return Validation.checkFormat(new File(painelJogador1.getEntrada()));
    }
}
