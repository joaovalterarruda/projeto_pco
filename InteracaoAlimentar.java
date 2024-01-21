/**
 * The type Interacao alimentar.
 */
public class InteracaoAlimentar {
    /**
     * The Expliccao.
     */
    public String bibliography;
    /**
     * The Alimento.
     */
    public String effect;
    /**
     * The Efeito.
     */
    public int effectLevel;
    /**
     * The Bibliografia.
     */
    public String explanation;

    /**
     * The Food.
     */
    public String food;
    /**
     * The Substances.
     */
    public String substances;


    /**
     * Instantiates a new Interacao alimentar.
     *
     * @param bibliography the bibliography
     * @param effect       the effect
     * @param effectLevel  the effect level
     * @param explanation  the explanation
     * @param food         the food
     * @param substances   the substances
     */
    public InteracaoAlimentar(String bibliography, String effect, int effectLevel, String explanation, String food, String substances) {
        this.bibliography = bibliography;
        this.effect = effect;
        this.effectLevel = effectLevel;
        this.explanation = explanation;
        this.food = food;
        this.substances = substances;
    }

    /**
     * Gets expliccao.
     *
     * @return the expliccao
     */
    public String getBibliography() {
        return bibliography;
    }


    /**
     * Sets bibliography.
     *
     * @param bibliography the bibliography
     */
    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }


    /**
     * Gets effect.
     *
     * @return the effect
     */
    public String getEffect() {
        return effect;
    }


    /**
     * Sets effect.
     *
     * @param effect the effect
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }


    /**
     * Gets effect level.
     *
     * @return the effect level
     */
    public int getEffectLevel() {
        return effectLevel;
    }


    /**
     * Sets effect level.
     *
     * @param effectLevel the effect level
     */
    public void setEffectLevel(int effectLevel) {
        this.effectLevel = effectLevel;
    }


    /**
     * Gets explanation.
     *
     * @return the explanation
     */
    public String getExplanation() {
        return explanation;
    }


    /**
     * Sets explanation.
     *
     * @param explanation the explanation
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    /**
     * Gets food.
     *
     * @return the food
     */
    public String getFood() {
        return food;
    }

    /**
     * Sets food.
     *
     * @param food the food
     */
    public void setFood(String food) {
        this.food = food;
    }

    /**
     * Gets substances.
     *
     * @return the substances
     */
    public String getSubstances() {
        return substances;
    }

    /**
     * Sets substances.
     *
     * @param substances the substances
     */
    public void setSubstances(String substances) {
        this.substances = substances;
    }

    @Override
    public String toString() {
        return "InteracaoAlimentar{" +
                "bibliografia='" + bibliography + '\'' +
                ", efeito='" + effect + '\'' +
                ", niveld do efeito='" + effectLevel + '\'' +
                ", explanation='" + explanation + '\'' +
                ", alimento='" + food + '\''+
                ", substancias='" + substances + '\'' +
                '}';
    }
}
