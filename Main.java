import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando o programa..Aguarde...");
        Sistema.carregarDataset("dataset.json");
        Sistema.escolhaOpcoes();
    }
}
