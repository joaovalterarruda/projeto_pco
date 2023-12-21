import java.util.List;

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

    public Medicamento criarMedicamento(){

        return null;
    }
    public void indicarNomeMedicamento(){

    }
    public void indicarDosagem(){

    }
    public void indicarNomeSubstancia(){

    }

    public boolean confirmarCriacao(){

        return false;
    }
    public boolean cancelarCriacao(){

        return false;
    }
    public <List> Medicamento consultarMedicamento(){

        return null;
    }

    @Override
    public String toString() {
        return "IndustriaFarmaceutica{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
