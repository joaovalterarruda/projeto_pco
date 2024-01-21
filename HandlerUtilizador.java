import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Handler utilizador.
 */
public class HandlerUtilizador{
    private List <UtilizadorRegistado> utilizadores = new ArrayList<>();

    /**
     * Criar utilizador.
     *
     * @param utilizadorRegistado the utilizador registado
     */
    public void criarUtilizador(UtilizadorRegistado utilizadorRegistado){
        utilizadores.add(utilizadorRegistado);
    }

    /**
     * Remover utilizador.
     *
     * @param nomeUtilizador the nome utilizador
     */
    public void removerUtilizador(String nomeUtilizador) {
        UtilizadorRegistado utilizadorRemover = null;
        for (UtilizadorRegistado utilizador : utilizadores) {
            if (utilizador.getNome().equals(nomeUtilizador)) {
                utilizadorRemover = utilizador;
                break;
            }
        }

        if (utilizadorRemover != null) {
            utilizadores.remove(utilizadorRemover);
            System.out.println("Utilizador removido com sucesso!");
        } else {
            System.out.println("Utilizador não encontrado.");
        }
    }

    /**
     * Verificar credenciais utilizador registado.
     *
     * @param nomeUtilizador the nome utilizador
     * @param password       the password
     * @return the utilizador registado
     */
    public UtilizadorRegistado verificarCredenciais(String nomeUtilizador, String password) {
        for (UtilizadorRegistado utilizador : utilizadores) {
            if (utilizador.getNome().equals(nomeUtilizador) && utilizador.getPassword().equals(password)) {
                return utilizador;
            }
        }
        return null; // Credenciais não correspondem a nenhum utilizador
    }

    /**
     * Carregar utilizadores do ficheiro json handler utilizador.
     *
     * @return the handler utilizador
     */
    static HandlerUtilizador carregarUtilizadoresDoFicheiroJson() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("utilizadores.json")) {
            UtilizadorRegistado[] utilizadoresArray = gson.fromJson(reader, UtilizadorRegistado[].class);
            HandlerUtilizador listaUtilizadores = new HandlerUtilizador();

            if (utilizadoresArray != null) {
                for (UtilizadorRegistado utilizador : utilizadoresArray) {
                    listaUtilizadores.criarUtilizador(utilizador);
                }
            }
            return listaUtilizadores;
        } catch (IOException e) {
            System.out.println("Erro ao tentar carregar utilizadores do ficheiro JSON: " + e.getMessage());
            return new HandlerUtilizador(); // Retorna uma instância vazia em caso de erro
        }
    }

    /**
     * Gets utilizadores.
     *
     * @return the utilizadores
     */
    public List<UtilizadorRegistado> getUtilizadores() {
        return utilizadores;
    }

    /**
     * Sets utilizadores.
     *
     * @param utilizadores the utilizadores
     */
    public void setUtilizadores(List<UtilizadorRegistado> utilizadores) {
        this.utilizadores = utilizadores;
    }

    /**
     * Mostrar informacoes utilizadores.
     */
    public void mostrarInformacoesUtilizadores() {
        for (UtilizadorRegistado utilizador : utilizadores) {
            System.out.println("Nome: " + utilizador.getNome());
            System.out.println("Password: " + utilizador.getPassword());
            System.out.println("-------------");
        }
    }

}
