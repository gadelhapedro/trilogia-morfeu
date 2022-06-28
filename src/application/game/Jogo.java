package application.game;

import application.character.Arma;
import application.character.TipoPersonagem;
import application.control.process.Controller;
import application.control.record.DadosPersonagem;
import application.control.record.Registro;

import java.io.File;
import java.util.HashMap;

public class Jogo {
    Controller controlPlayer1;
    Controller controlPlayer2;

    Registro registroPlayer1;
    Registro registroPlayer2;

    HashMap<TipoPersonagem, DadosPersonagem> dadosPlayer1;
    HashMap<TipoPersonagem, DadosPersonagem> dadosPlayer2;
    String nomePlayer1;
    String nomePlayer2;
    String nomeVencedor;


    public Jogo(File entrada, String saidaPath, HashMap<TipoPersonagem, Arma> armasJogador1, HashMap<TipoPersonagem, Arma> armasJogador2,
                               String nomeJogador1, String nomeJogador2) {
        controlPlayer1 = new Controller(entrada, saidaPath, armasJogador1);
        controlPlayer2 = new Controller(entrada, saidaPath, armasJogador2);

        registroPlayer1 = controlPlayer1.getRegistro();
        registroPlayer2 = controlPlayer2.getRegistro();

        dadosPlayer1 = registroPlayer1.getDadosPersonagemPorTipo();
        dadosPlayer2 = registroPlayer2.getDadosPersonagemPorTipo();

        nomePlayer1 = nomeJogador1;
        nomePlayer2 = nomeJogador2;

        verificarVencedor();
    }

    private void verificarVencedor() {
        int pontosPlayer1 = 0;
        int pontosPlayer2 = 0;
        for (TipoPersonagem tipoPersonagem : dadosPlayer1.keySet()) {
            int pontuacaoPlayer1 = dadosPlayer1.get(tipoPersonagem).getPontuacao();
            int pontuacaoPlayer2 = dadosPlayer2.get(tipoPersonagem).getPontuacao();
            if (pontuacaoPlayer1 > pontuacaoPlayer2) {
                pontosPlayer1++;
            } else if (pontuacaoPlayer1 < pontuacaoPlayer2) {
                pontosPlayer2++;
            }
        }
        if (pontosPlayer1 > pontosPlayer2) {
            nomeVencedor = "Vencedor: " + nomePlayer1;
        } else if (pontosPlayer1 < pontosPlayer2) {
            nomeVencedor = "Vencedor: " + nomePlayer2;
        } else {
            nomeVencedor = "Empate";
        }
    }
    public String getNomeVencedor() {
        return nomeVencedor;
    }
    public String[] getDadosPlayer1() {
        return getDadosPlayer(dadosPlayer1);
    }
    public String[] getDadosPlayer2() {
        return getDadosPlayer(dadosPlayer2);
    }
    private String[] getDadosPlayer(HashMap<TipoPersonagem, DadosPersonagem> dadosPlayer) {
        String[] dados = new String[dadosPlayer.size()];
        int i = 0;
        for (TipoPersonagem tipoPersonagem : dadosPlayer.keySet()) {
            if (!tipoPersonagem.equals(TipoPersonagem.DEFAULT) && !tipoPersonagem.equals(TipoPersonagem.EMPATE)) {
                dados[i] = tipoPersonagem.getNome() + ": ";
                dados[i] += dadosPlayer.get(tipoPersonagem).toStringInterface();
                i++;
            }
        }
        return dados;
    }

}
