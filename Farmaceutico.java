public class Farmaceutico extends UtilizadorRegistado {
    public Farmaceutico(String nome, String password, String email, String role) {
        super(nome, password, email, role);
    }

    public void criarInteracao(){

    }
    public void indicarNomeSubstancia(){

    }
    public void indicarExplicacao(){

    }
    public void indicarAlimento(){

    }
    public void indicarEfeito(){

    }
    public void indicarBibliografia(){

    }
    public boolean confirmarCriacao(){
        return false;
    }
    public boolean cancelarCraiacao(){

        return false;
    }
    public <List> InteracaoAlimentar consultarInteracao(){

        return null;
    }
}
