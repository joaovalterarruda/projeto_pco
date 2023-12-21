public class Farmacovigilancia {
    private String nome;
    private long contato;

    public Farmacovigilancia(String nome, long contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getContato() {
        return contato;
    }
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
