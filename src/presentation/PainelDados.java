package presentation;

import application.character.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PainelDados extends JPanel {
    // imagens dos personagens
    private static final ImageIcon morfeu = new ImageIcon("resources/morfeu.png");
    private static final ImageIcon cafezito = new ImageIcon("resources/cafezito.png");
    private static final ImageIcon copinho = new ImageIcon("resources/copinho.png");
    private static final ImageIcon neo = new ImageIcon("resources/neo.png");
    private static final ImageIcon oraculo = new ImageIcon("resources/oraculo.png");
    private static final ImageIcon trinity = new ImageIcon("resources/trinity.png");
    // habilidades dos personagens
    private String[] habilidadesMorfeu;
    private String[] habilidadesCafezito;
    private String[] habilidadesCopinho;
    private String[] habilidadesNeo;
    private String[] habilidadesOraculo;
    private String[] habilidadesTrinity;
    private JLabel imagemPersonagem;
    private JLabel nomePersonagem;
    private JPanel habilidadesPersonagem;
    private JLabel habilidade1;
    private JLabel habilidade2;
    private JLabel habilidade3;
    private JLabel habilidade4;
    private JLabel habilidade5;
    private JLabel habilidade6;
    private JLabel habilidade7;
    private final JComboBox<String> morfeuComboBox;
    private final JComboBox<String> cafezitoComboBox;
    private final JComboBox<String> copinhoComboBox;
    private final JComboBox<String> neoComboBox;
    private final JComboBox<String> oraculoComboBox;
    private final JComboBox<String> trinityComboBox;
    private HashMap<String, ImageIcon> personagensImagens;

    public PainelDados(JComboBox<String> morfeu, JComboBox<String> cafezito, JComboBox<String> copinho,
                       JComboBox<String> neo, JComboBox<String> oraculo, JComboBox<String> trinity) {
        morfeuComboBox = morfeu;
        cafezitoComboBox = cafezito;
        copinhoComboBox = copinho;
        neoComboBox = neo;
        oraculoComboBox = oraculo;
        trinityComboBox = trinity;

        inicializar();
        loadImages();
        estilizar();
        adicionarEventos();
    }
    private void carregarDados() {
        habilidadesMorfeu = new Morfeu(new HashMap<>()).getHabilidadesToArrayString();
        habilidadesCafezito = new Cafezito(new HashMap<>()).getHabilidadesToArrayString();
        habilidadesCopinho = new Copinho(new HashMap<>()).getHabilidadesToArrayString();
        habilidadesNeo = new Neo(new HashMap<>()).getHabilidadesToArrayString();
        habilidadesOraculo = new Oraculo(new HashMap<>()).getHabilidadesToArrayString();
        habilidadesTrinity = new Trinity(new HashMap<>()).getHabilidadesToArrayString();
    }
    private void inicializar() {
        carregarDados();
        personagensImagens = new HashMap<>();
        imagemPersonagem = new JLabel();
        nomePersonagem = new JLabel();
        habilidadesPersonagem = new JPanel();
        habilidade1 = new JLabel();
        habilidade2 = new JLabel();
        habilidade3 = new JLabel();
        habilidade4 = new JLabel();
        habilidade5 = new JLabel();
        habilidade6 = new JLabel();
        habilidade7 = new JLabel();

        habilidadesPersonagem.add(nomePersonagem);
        habilidadesPersonagem.add(habilidade1);
        habilidadesPersonagem.add(habilidade2);
        habilidadesPersonagem.add(habilidade3);
        habilidadesPersonagem.add(habilidade4);
        habilidadesPersonagem.add(habilidade5);
        habilidadesPersonagem.add(habilidade6);
        habilidadesPersonagem.add(habilidade7);

        add(imagemPersonagem);
        add(habilidadesPersonagem);
    }
    private void estilizar() {
        habilidadesPersonagem.setLayout(new GridLayout(8, 1));
        setLayout(new GridLayout(1, 2));
    }
    private void adicionarEventos() {
        morfeuComboBox.addActionListener(e -> morfeuClicked());
        cafezitoComboBox.addActionListener(e -> cafezitoClicked());
        copinhoComboBox.addActionListener(e -> copinhoClicked());
        neoComboBox.addActionListener(e -> neoClicked());
        oraculoComboBox.addActionListener(e -> oraculoClicked());
        trinityComboBox.addActionListener(e -> trinityClicked());
    }

    private void morfeuClicked() {
        imagemPersonagem.setIcon(morfeu);
        nomePersonagem.setText("Morfeu");
        preencherHabilidades(habilidadesMorfeu);
    }
    private void cafezitoClicked() {
        imagemPersonagem.setIcon(cafezito);
        nomePersonagem.setText("Cafezito");
        preencherHabilidades(habilidadesCafezito);
    }
    private void copinhoClicked() {
        imagemPersonagem.setIcon(copinho);
        nomePersonagem.setText("Copinho");
        preencherHabilidades(habilidadesCopinho);
    }
    private void neoClicked() {
        imagemPersonagem.setIcon(neo);
        nomePersonagem.setText("Neo");
        preencherHabilidades(habilidadesNeo);
    }
    private void oraculoClicked() {
        imagemPersonagem.setIcon(oraculo);
        nomePersonagem.setText("Oraculo");
        preencherHabilidades(habilidadesOraculo);
    }
    private void trinityClicked() {
        imagemPersonagem.setIcon(trinity);
        nomePersonagem.setText("Trinity");
        preencherHabilidades(habilidadesTrinity);
    }

    private void preencherHabilidades(String[] habilidades) {
        for (int i = 0; i < habilidades.length; i++) {
            if (i == 0) {
                habilidade1.setText(habilidades[i]);
            } else if (i == 1) {
                habilidade2.setText(habilidades[i]);
            } else if (i == 2) {
                habilidade3.setText(habilidades[i]);
            } else if (i == 3) {
                habilidade4.setText(habilidades[i]);
            } else if (i == 4) {
                habilidade5.setText(habilidades[i]);
            } else if (i == 5) {
                habilidade6.setText(habilidades[i]);
            } else if (i == 6) {
                habilidade7.setText(habilidades[i]);
            }
        }
}
    private void loadImages() {
        personagensImagens.put("Morfeu", morfeu);
        personagensImagens.put("Cafezito", cafezito);
        personagensImagens.put("Copinho", copinho);
        personagensImagens.put("Neo", neo);
        personagensImagens.put("Oraculo", oraculo);
        personagensImagens.put("Trinity", trinity);
    }

}
