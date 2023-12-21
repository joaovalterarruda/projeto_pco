/**
 * The type Utilizador registado.
 */
public class UtilizadorRegistado {
    private String nome;
    private String password;
    private String email;
    private String role;

    /**
     * Instantiates a new Utilizador registado.
     *
     * @param nome     the nome
     * @param password the password
     * @param email    the email
     * @param role     the role
     */
    public UtilizadorRegistado(String nome, String password, String email, String role) {
        this.nome = nome;
        this.password = password;
        this.email = email;
        this.role = role;
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
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UtilizadorRegistado{" +
                "nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
