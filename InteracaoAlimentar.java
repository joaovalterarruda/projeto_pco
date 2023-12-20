public class InteracaoAlimentar {
    public String expliccao;
    public String alimento;
    public String efeito;
    public String bibliografia;

    public InteracaoAlimentar(String expliccao, String alimento, String efeito, String bibliografia) {
        this.expliccao = expliccao;
        this.alimento = alimento;
        this.efeito = efeito;
        this.bibliografia = bibliografia;
    }

    public String getExpliccao() {
        return expliccao;
    }

    public void setExpliccao(String expliccao) {
        this.expliccao = expliccao;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    @Override
    public String toString() {
        return "InteracaoAlimentar{" +
                "expliccao='" + expliccao + '\'' +
                ", alimento='" + alimento + '\'' +
                ", efeito='" + efeito + '\'' +
                ", bibliografia='" + bibliografia + '\'' +
                '}';
    }
}
