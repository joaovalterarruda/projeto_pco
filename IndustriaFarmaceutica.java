public class IndustriaFarmaceutica extends UtilizadorRegistado {
    private String nome;

    public IndustriaFarmaceutica(String nome, String password, String email, String role) {
        super(nome, password, email,role);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "IndustriaFarmaceutica{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
