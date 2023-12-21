public class Administrador extends UtilizadorRegistado{
    public Administrador(String nome, String password, String email, String role) {
        super(nome, password, email, role);
    }


    // Sistema
    public int indicarContato(){
        return 0;
    }
    public SubstanciaAtiva criarSubstancia(){
        return null;
    }
    public String indicarNomeSubstancia(){
        return null;
    }
    public boolean confirmarSubstancia(){
        return false;
    }
    public boolean recuperarSubstancia(){
        return false;
    }
}
