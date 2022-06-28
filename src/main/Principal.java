package main;

import presentation.JanelaPrincipal;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        new JanelaPrincipal();
    }
}
