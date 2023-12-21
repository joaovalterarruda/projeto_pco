public class UtilizadorRegistado extends Administrador implements IndustriaFarmaceutica, Farmaceutico{
    private String nome;
    private final String password;
    private final String email;
    private final String role;

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

    @Override
    public void criarMedicamento() {
        IndustriaFarmaceutica.super.criarMedicamento();
    }

    @Override
    public void indicarNomeMedicamento() {
        IndustriaFarmaceutica.super.indicarNomeMedicamento();
    }

    @Override
    public void confirmarCriacao() {
        IndustriaFarmaceutica.super.confirmarCriacao();
    }

    @Override
    public void cancelarCriacao() {
        IndustriaFarmaceutica.super.cancelarCriacao();
    }

    @Override
    public void consultarMedicamento() {
        IndustriaFarmaceutica.super.consultarMedicamento();
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

    @Override
    public String toString() {
        return "UtilizadorRegistado{" +
                "nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public void criarInteracao() {
        Farmaceutico.super.criarInteracao();
    }

    @Override
    public void indicarExplicacao() {
        Farmaceutico.super.indicarExplicacao();
    }

    @Override
    public void indicarAlimento() {
        Farmaceutico.super.indicarAlimento();
    }

    @Override
    public void indicarEfeito() {
        Farmaceutico.super.indicarEfeito();
    }

    @Override
    public void indicarBibliografia() {
        Farmaceutico.super.indicarBibliografia();
    }

    @Override
    public void cancelarCraiacao() {
        Farmaceutico.super.cancelarCraiacao();
    }

    @Override
    public void consultarInteracao() {
        Farmaceutico.super.consultarInteracao();
    }
}
