import application.character.Arma;
import application.character.Morfeu;
import application.character.TipoPersonagem;
import presentation.JanelaFinal;
import tools.Leitor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        File file = new File("TP2_v2/BF_1.csv");
        String saidaPath = "saida/";
        String[] dados = new String[] {"Morfeu: Ocorrencias x, Pontuacao X",
        "Cafezito: Ocorrencias x, Pontuacao X", "Cavaleiro: Ocorrencias x, Pontuacao X",
        "Ladino: Ocorrencias x, Pontuacao X", "Mago: Ocorrencias x, Pontuacao X",
        "Paladino: Ocorrencias x, Pontuacao X"};
        new JanelaFinal("Vencedor", "P1", "P2", dados, dados);

    }
}
