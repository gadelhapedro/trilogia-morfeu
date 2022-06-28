package application.battle;

import application.character.TipoPersonagem;
import application.control.record.DadosPersonagem;
import application.control.record.Registro;

import java.util.HashMap;

public class Guerra {
    // Vamos receber um registro e dese extrair qual o jogador vencedor
    HashMap<TipoPersonagem, DadosPersonagem> potuacaoJogador1;
    HashMap<TipoPersonagem, DadosPersonagem> potuacaoJogador2;
    String nomeJogador1;
    String nomeJogador2;
    String vencedor;

    public Guerra(Registro registroJogador1, Registro registroJogador2, String nomeJogador1, String nomeJogador2) {
        potuacaoJogador1 = registroJogador1.getDadosPersonagemPorTipo();
        potuacaoJogador2 = registroJogador2.getDadosPersonagemPorTipo();
        this.nomeJogador1 = nomeJogador1;
        this.nomeJogador2 = nomeJogador2;
        vencedor = getVencedor();
    }
    private void verificarVencedor() {
        // Vamos comparar a pontuação final de cada personagem de cada jogador
        // Se o jogador 1 tiver a maior pontuação, venceu
        int vitoriaJogador1 = 0;
        int vitoriaJogador2 = 0;
        for (TipoPersonagem tipo : TipoPersonagem.values()) {
            if (potuacaoJogador1.get(tipo).getPontuacao() > potuacaoJogador2.get(tipo).getPontuacao()) {
                vitoriaJogador1++;
            } else if (potuacaoJogador1.get(tipo).getPontuacao() < potuacaoJogador2.get(tipo).getPontuacao()) {
                vitoriaJogador2++;
            }
        }
        if (vitoriaJogador1 > vitoriaJogador2) {
            vencedor = nomeJogador1;
        } else if (vitoriaJogador1 < vitoriaJogador2) {
            vencedor = nomeJogador2;
        } else {
            vencedor = "Empate";
        }
    }
    public String getVencedor() {
        verificarVencedor();
        return vencedor;
    }


}
