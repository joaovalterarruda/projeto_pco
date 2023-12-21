/**
 * The type Medicamento.
 */
public class Medicamento {
    /**
     * The Nome.
     */
    public String nome;
    /**
     * The Formula.
     */
    public String formula;
    /**
     * The Dosagem.
     */
    public int dosagem;
    /**
     * The Laboratorio.
     */
    public String laboratorio;
    /**
     * The Substancias.
     */
    public String substancias;

    /**
     * Instantiates a new Medicamento.
     *
     * @param nome        the nome
     * @param formula     the formula
     * @param dosagem     the dosagem
     * @param laboratorio the laboratorio
     * @param substancias the substancias
     */
    public Medicamento(String nome, String formula, int dosagem, String laboratorio, String substancias) {
        this.nome = nome;
        this.formula = formula;
        this.dosagem = dosagem;
        this.laboratorio = laboratorio;
        this.substancias = substancias;
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

    /**
     * Gets formula.
     *
     * @return the formula
     */
    public String getFormula() {
        return formula;
    }

    /**
     * Sets formula.
     *
     * @param formula the formula
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * Gets dosagem.
     *
     * @return the dosagem
     */
    public int getDosagem() {
        return dosagem;
    }

    /**
     * Sets dosagem.
     *
     * @param dosagem the dosagem
     */
    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    /**
     * Gets laboratorio.
     *
     * @return the laboratorio
     */
    public String getLaboratorio() {
        return laboratorio;
    }

    /**
     * Sets laboratorio.
     *
     * @param laboratorio the laboratorio
     */
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    /**
     * Gets substancias.
     *
     * @return the substancias
     */
    public String getSubstancias() {
        return substancias;
    }

    /**
     * Sets substancias.
     *
     * @param substancias the substancias
     */
    public void setSubstancias(String substancias) {
        this.substancias = substancias;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nome='" + nome + '\'' +
                ", formula='" + formula + '\'' +
                ", dosagem=" + dosagem +
                ", laboratorio='" + laboratorio + '\'' +
                ", substancias='" + substancias + '\'' +
                '}';
    }
}
