import java.util.List;

public class Utente extends UtilizadorRegistado{
    public Utente(String nome, String password, String email, String role) {
        super(nome, password, email, role);
    }

    public void pesquisarContato(){

    }
    public List consultarDetalhesInteracao(){

        return null;
    }
    public boolean cancelarPesquisa(){

        return false;
    }
}
