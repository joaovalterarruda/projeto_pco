import java.util.List;

/**
 * The type Utente.
 */
public class Utente extends UtilizadorRegistado{
    /**
     * Instantiates a new Utente.
     *
     * @param nome     the nome
     * @param password the password
     * @param email    the email
     * @param role     the role
     */
    public Utente(String nome, String password, String email, String role) {
        super(nome, password, email, role);
    }

    /**
     * Pesquisar contato.
     */
    public void pesquisarContato(){

    }

    /**
     * Consultar detalhes interacao list .
     *
     * @return the list
     */
    public List <InteracaoAlimentar> consultarDetalhesInteracao(){ // confirmar se é assim

        return null;
    }

    /**
     * Cancelar pesquisa boolean.
     *
     * @return the boolean
     */
    public boolean cancelarPesquisa(){

        return false;
    }
}
