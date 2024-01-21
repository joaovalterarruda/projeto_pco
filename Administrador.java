public class Administrador {
    private final String nome;
    private final String password;

    public Administrador(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }
}
