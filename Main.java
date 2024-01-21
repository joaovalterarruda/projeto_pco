import java.io.IOException;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando o programa..Aguarde...");
        Sistema.carregarDataset("dataset.json");
        Sistema.escolhaOpcoes();
    }
}
