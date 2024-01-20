public class InteracaoAlimentar {
    public String explanation;
    public String food;
    public String effect;
    public String bibliography;
    public int effectLevel;
    public String substances;


    public InteracaoAlimentar(String bibliography, String effect, int effectLevel, String explanation, String food, String substances) {
        this.explanation = explanation;
        this.food = food;
        this.effect = effect;
        this.bibliography = bibliography;
        this.effectLevel = effectLevel;
        this.substances = substances;
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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getBibliography() {
        return bibliography;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public int getEffectLevel() {
        return effectLevel;
    }

    public void setEffectLevel(int effectLevel) {
        this.effectLevel = effectLevel;
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
                "explanation='" + explanation + '\'' +
                ", food='" + food + '\'' +
                ", effect='" + effect + '\'' +
                ", bibliography='" + bibliography + '\'' +
                ", effectLevel=" + effectLevel +
                ", substances='" + substances + '\'' +
                '}';
    }
}