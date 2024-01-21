import java.util.ArrayList;
import java.util.List;

public class HandlerIntAlimentar {
    private List<InteracaoAlimentar> interacaoAlimentar = new ArrayList<>();

    public void criarInterection(String bibliography, String effect, int effectLevel, String explanation, String food, String substances) {
        InteracaoAlimentar novaInteracao = new InteracaoAlimentar(bibliography, effect, effectLevel, explanation, food, substances);
        interacaoAlimentar.add(novaInteracao);
    }

    public void removerInteracao(InteracaoAlimentar interacao) {
        interacaoAlimentar.remove(interacao);
    }

    public List<InteracaoAlimentar> getListaInteracaoAlimentares() {
        return interacaoAlimentar;
    }

}
