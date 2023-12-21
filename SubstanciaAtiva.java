/**
 * The type Substancia ativa.
 */
public class SubstanciaAtiva {
    private String nome;

    /**
     * Instantiates a new Substancia ativa.
     *
     * @param nome the nome
     */
    public SubstanciaAtiva(String nome) {
        this.nome = nome;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "SubstanciaAtiva{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
