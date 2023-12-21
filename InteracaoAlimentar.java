/**
 * The type Interacao alimentar.
 */
public class InteracaoAlimentar {
    /**
     * The Expliccao.
     */
    public String explicacao;
    /**
     * The Alimento.
     */
    public String alimento;
    /**
     * The Efeito.
     */
    public String efeito;
    /**
     * The Bibliografia.
     */
    public String bibliografia;

    /**
     * Instantiates a new Interacao alimentar.
     *
     * @param explicacao    the expliccao
     * @param alimento     the alimento
     * @param efeito       the efeito
     * @param bibliografia the bibliografia
     */
    public InteracaoAlimentar(String explicacao, String alimento, String efeito, String bibliografia) {
        this.explicacao = explicacao;
        this.alimento = alimento;
        this.efeito = efeito;
        this.bibliografia = bibliografia;
    }

    /**
     * Gets expliccao.
     *
     * @return the expliccao
     */
    public String getExpliccao() {
        return explicacao;
    }

    /**
     * Sets expliccao.
     *
     * @param expliccao the expliccao
     */
    public void setExpliccao(String expliccao) {
        this.explicacao = expliccao;
    }

    /**
     * Gets alimento.
     *
     * @return the alimento
     */
    public String getAlimento() {
        return alimento;
    }

    /**
     * Sets alimento.
     *
     * @param alimento the alimento
     */
    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    /**
     * Gets efeito.
     *
     * @return the efeito
     */
    public String getEfeito() {
        return efeito;
    }

    /**
     * Sets efeito.
     *
     * @param efeito the efeito
     */
    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    /**
     * Gets bibliografia.
     *
     * @return the bibliografia
     */
    public String getBibliografia() {
        return bibliografia;
    }

    /**
     * Sets bibliografia.
     *
     * @param bibliografia the bibliografia
     */
    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    @Override
    public String toString() {
        return "InteracaoAlimentar{" +
                "explicacao='" + explicacao + '\'' +
                ", alimento='" + alimento + '\'' +
                ", efeito='" + efeito + '\'' +
                ", bibliografia='" + bibliografia + '\'' +
                '}';
    }
}
