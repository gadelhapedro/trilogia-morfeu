package presentation;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class PainelArquivos extends JPanel {
    JButton entrada;
    JButton saida;
    JTextField entradaPath;
    JTextField saidaPath;
    JPanel containerEntrada;
    JPanel containerSaida;

    public PainelArquivos() {
        inicializar();
        estilizar();
        adicionarEventos();
    }

    private void inicializar() {
        entrada = new JButton("Entrada :");
        saida = new JButton("Saida :");
        entradaPath = new JTextField(10);
        saidaPath = new JTextField(10);
        containerEntrada = new JPanel();
        containerSaida = new JPanel();

        containerEntrada.add(entrada);
        containerEntrada.add(entradaPath);
        containerSaida.add(saida);
        containerSaida.add(saidaPath);
        add(containerEntrada);
        add(containerSaida);
    }
    private void estilizar() {
        setLayout(new GridLayout(2, 1));
        containerEntrada.setLayout(new FlowLayout(FlowLayout.CENTER));
        containerSaida.setLayout(new FlowLayout(FlowLayout.CENTER));
        saida.setMargin(new Insets(0, 7, 0, 7));
    }
    private void adicionarEventos(){
        entrada.addActionListener(e ->entradaEvent(entradaPath));
        saida.addActionListener(e ->saidaEvent(saidaPath));
    }
    private void entradaEvent(JTextField textField) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Escolha o arquivo de entrada");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showOpenDialog(this);
        if(chooser.getSelectedFile() != null) {
            textField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }
    private void saidaEvent(JTextField textField) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Escolha o diretório de saída");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(this);
        if(chooser.getSelectedFile() != null) {
            textField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }
    public String getEntrada() {
        return entradaPath.getText();
    }
    public String getSaida() {
        return saidaPath.getText();
    }


}
