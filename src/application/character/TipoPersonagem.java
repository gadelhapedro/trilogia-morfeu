package application.character;

import java.util.Locale;

public enum TipoPersonagem{
    MOR(7, "Morfeu"), COP(2, "Copinho"), CAF(5, "Cafezito"), NEO(6, "Neo"), ORC(4, "Oraculo"),
    TRI(3, "Trinity"), EMPATE(0, "Empate"), DEFAULT(0, "Default");
    int superPoder;
    String nome;

    TipoPersonagem(int i, String nome) {
        superPoder = i;
        this.nome = nome;
    }
    public int getSuperPoder() {
        return superPoder;
    }

    public static TipoPersonagem parseTipoPersonagem(String tipo) {
        tipo = tipo.toLowerCase();
        return switch (tipo) {
            case "mor" -> MOR;
            case "morfeu" -> MOR;
            case "cop" -> COP;
            case "copinho" -> COP;
            case "caf" -> CAF;
            case "cafezito" -> CAF;
            case "neo" -> NEO;
            case "orc" -> ORC;
            case "oraculo" -> ORC;
            case "tri" -> TRI;
            case "trinity" -> TRI;
            case "empate" -> EMPATE;
            default -> DEFAULT;
        };
    }
    public String getNome() {
        return nome;
    }


}
