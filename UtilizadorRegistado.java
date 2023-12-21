public class UtilizadorRegistado {
    private String nome;
    private String password;
    private String email;
    private String role;


    public UtilizadorRegistado(String nome, String password, String email, String role) {
        this.nome = nome;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
