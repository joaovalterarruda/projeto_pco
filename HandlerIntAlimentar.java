import java.util.ArrayList;
import java.util.List;

/**
 * The type Handler int alimentar.
 */
public class HandlerIntAlimentar {
    private List<InteracaoAlimentar> interacaoAlimentar = new ArrayList<>();

    /**
     * Criar interection.
     *
     * @param bibliography the bibliography
     * @param effect       the effect
     * @param effectLevel  the effect level
     * @param explanation  the explanation
     * @param food         the food
     * @param substances   the substances
     */
    public void criarInterection(String bibliography, String effect, int effectLevel, String explanation, String food, String substances) {
        InteracaoAlimentar novaInteracao = new InteracaoAlimentar(bibliography, effect, effectLevel, explanation, food, substances);
        interacaoAlimentar.add(novaInteracao);
    }

    /**
     * Remover interacao.
     *
     * @param interacao the interacao
     */
    public void removerInteracao(InteracaoAlimentar interacao) {
        interacaoAlimentar.remove(interacao);
    }

    /**
     * Gets lista interacao alimentares.
     *
     * @return the lista interacao alimentares
     */
    public List<InteracaoAlimentar> getListaInteracaoAlimentares() {
        return interacaoAlimentar;
    }

}
