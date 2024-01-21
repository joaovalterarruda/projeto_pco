/**
 * The type Substancia ativa.
 */
public class SubstanciaAtiva {
    private String substance;

    /**
     * Instantiates a new Substancia ativa.
     *
     * @param substance the nome
     */
    public SubstanciaAtiva(String substance) {
        this.substance = substance;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getSubstance() {
        return substance;
    }

    /**
     * Sets nome.
     *
     * @param substance the nome
     */
    public void setSubstance(String substance) {
        this.substance = substance;
    }

    @Override
    public String toString() {
        return "SubstanciaAtiva{" +
                "nome='" + substance + '\'' +
                '}';
    }
}
