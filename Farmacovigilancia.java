/**
 * The type Farmacovigilancia.
 */
public class Farmacovigilancia {
    private String nome;
    private long contato;

    /**
     * Instantiates a new Farmacovigilancia.
     *
     * @param nome    the nome
     * @param contato the contato
     */
    public Farmacovigilancia(String nome, long contato) {
        this.nome = nome;
        this.contato = contato;
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
     * Gets contato.
     *
     * @return the contato
     */
    public long getContato() {
        return contato;
    }

    /**
     * Sets contato.
     *
     * @param contato the contato
     */
    public void setContato(long contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Farmacovigilancia{" +
                "nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}
