package application.character;

public enum Arma {
    MARTELO("Martelo"), ESPADA("Espada"), LANCA("Lanca"), ARCO("Arco"),
    ATIRADEIRA("Atiradeira"), BASTAO("Bastao"), CHACO("Chaco"), ARMA_NULA("Arma nula");

    private final String nome;
    Arma(String nome) {
        this.nome = nome;
    }

    public static Arma parseArma(String arma) {
        for (Arma a : Arma.values()) {
            if (a.nome.equals(arma)) {
                return a;
            }
        }
        return ARMA_NULA;
    }

}
