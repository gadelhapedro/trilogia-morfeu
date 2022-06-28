package presentation;

import application.character.Arma;
import application.character.TipoPersonagem;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class EscolhaArmas extends JPanel {
    private JPanel painelDescricao;
    private JLabel descricao;
    private JPanel painelMorfeu;
    private JLabel morfeuLabel;
    private JComboBox<String> morfeu;
    private JPanel painelCafezito;

    private JLabel cafezitoLabel;
    private JComboBox<String> cafezito;
    private JPanel painelCopinho;
    private JLabel copinhoLabel;
    private JComboBox<String> copinho;
    private JPanel painelNeo;
    private JLabel neoLabel;
    private JComboBox<String> neo;
    private JPanel painelOraculo;
    private JLabel oraculoLabel;
    private JComboBox<String> oraculo;
    private JPanel painelTrinity;
    private JLabel trinityLabel;
    private JComboBox<String> trinity;
    private JPanel painelEscolha;
    private String[] armas;


    public EscolhaArmas () {
        inicializar();
        estilizar();
    }
    private void inicializar() {
        descricao = new JLabel("Escolha suas armas");
        painelDescricao = new JPanel();

        armas = new String[] {"Martelo", "Espada", "Lanca", "Arco", "Atiradeira", "Bastao", "Chaco"};

        morfeuLabel = new JLabel("Morfeu");
        cafezitoLabel = new JLabel("Cafezito");
        copinhoLabel = new JLabel("Copinho");
        neoLabel = new JLabel("Neo");
        oraculoLabel = new JLabel("Oraculo");
        trinityLabel = new JLabel("Trinity");

        morfeu = new JComboBox<>(armas);
        cafezito = new JComboBox<>(armas);
        copinho = new JComboBox<>(armas);
        neo = new JComboBox<>(armas);
        oraculo = new JComboBox<>(armas);
        trinity = new JComboBox<>(armas);

        painelMorfeu = new JPanel();
        painelCafezito = new JPanel();
        painelCopinho = new JPanel();
        painelNeo = new JPanel();
        painelOraculo = new JPanel();
        painelTrinity = new JPanel();

        painelEscolha = new JPanel();

        painelDescricao.add(descricao);
        painelMorfeu.add(morfeuLabel);
        painelMorfeu.add(morfeu);
        painelCafezito.add(cafezitoLabel);
        painelCafezito.add(cafezito);
        painelCopinho.add(copinhoLabel);
        painelCopinho.add(copinho);
        painelNeo.add(neoLabel);
        painelNeo.add(neo);
        painelOraculo.add(oraculoLabel);
        painelOraculo.add(oraculo);
        painelTrinity.add(trinityLabel);
        painelTrinity.add(trinity);
        painelEscolha.add(painelMorfeu);
        painelEscolha.add(painelCafezito);
        painelEscolha.add(painelCopinho);
        painelEscolha.add(painelNeo);
        painelEscolha.add(painelOraculo);
        painelEscolha.add(painelTrinity);

        add(painelDescricao);
        add(painelEscolha);
    }
    private void estilizar() {
        setLayout(new GridLayout(2, 1));
        painelEscolha.setLayout(new GridLayout(2, 3));
    }

    public JComboBox<String> getMorfeu() {
        return morfeu;
    }
    public JComboBox<String> getCafezito() {
        return cafezito;
    }
    public JComboBox<String> getCopinho() {
        return copinho;
    }
    public JComboBox<String> getNeo() {
        return neo;
    }
    public JComboBox<String> getOraculo() {
        return oraculo;
    }
    public JComboBox<String> getTrinity() {
        return trinity;
    }
    public HashMap<TipoPersonagem, Arma> getArmasEscolhidas() {
        HashMap<TipoPersonagem, Arma> armasEscolhida = new HashMap<>();
        armasEscolhida.put(TipoPersonagem.MOR, Arma.parseArma( (String) morfeu.getSelectedItem()));
        armasEscolhida.put(TipoPersonagem.CAF, Arma.parseArma( (String) cafezito.getSelectedItem()));
        armasEscolhida.put(TipoPersonagem.COP, Arma.parseArma( (String) copinho.getSelectedItem()));
        armasEscolhida.put(TipoPersonagem.NEO, Arma.parseArma( (String) neo.getSelectedItem()));
        armasEscolhida.put(TipoPersonagem.ORC, Arma.parseArma( (String) oraculo.getSelectedItem()));
        armasEscolhida.put(TipoPersonagem.TRI, Arma.parseArma( (String) trinity.getSelectedItem()));
    return armasEscolhida;
    }

}
