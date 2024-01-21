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

    public String food;
    public String substances;


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


    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }


    public String getEffect() {
        return effect;
    }


    public void setEffect(String effect) {
        this.effect = effect;
    }


    public int getEffectLevel() {
        return effectLevel;
    }


    public void setEffectLevel(int effectLevel) {
        this.effectLevel = effectLevel;
    }


    public String getExplanation() {
        return explanation;
    }


    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getSubstances() {
        return substances;
    }

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
