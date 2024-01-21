/**
 * The type Administrador.
 */
public class Administrador {
    private final String nome;
    private final String password;

    public Administrador(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getName() {
        return nome;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
