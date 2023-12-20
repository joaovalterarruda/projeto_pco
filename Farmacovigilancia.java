public class Farmacovigilancia {
    private final String nome;
    private String contato;

    public Farmacovigilancia(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
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
