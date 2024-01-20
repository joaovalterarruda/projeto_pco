import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Creation handler medicamento.
 */
public class HandlerMedicamento {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Medicamento> medicamentos = new ArrayList<>();


    /**
     * Criar medicamento.
     */
    public void criarMedicamento(){
        System.out.println("Digite o nome do medicamento: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a dosagem do medicamento: ");
        String dosagem = scanner.nextLine();

        System.out.println("Digite a forma do medicamento (comprimido, líquido, etc) ");
        String forma = scanner.nextLine();

        System.out.println("Digite o laboratório do medicamento ");
        String laboratorio = scanner.nextLine();

        System.out.println("Digite as substancias do medicamento: ");
        String substancias = scanner.nextLine();

        Medicamento medicamento = new Medicamento(nome,forma, dosagem, laboratorio, substancias);

        medicamentos.add(medicamento);

        System.out.println("Medicamento criado com sucesso!");
    }

    /**
     * Get lista medicamentos list .
     *
     * @return the list
     */
    public List <Medicamento> getListaMedicamentos(){
        return null;
    }


}
