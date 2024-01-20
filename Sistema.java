import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Sistema.
 */
public class Sistema {
    static String filename = "dataset.json";
    static List<Medicamento> drugs;
    static List<SubstanciaAtiva> substanciasAtivas;
    static List<InteracaoAlimentar> interacaoAlimentares;

    public Sistema(List<Medicamento> drugs, List<SubstanciaAtiva> substanciaAtivas, List<InteracaoAlimentar> interacaoAlimentars) {
        Sistema.drugs = new ArrayList<>(drugs);
        Sistema.substanciasAtivas = new ArrayList<>(substanciaAtivas);
        Sistema.interacaoAlimentares = new ArrayList<>(interacaoAlimentars);
    }

    public static void carregarDados(String filename) {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(filename)) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            // Inicializar as listas
            drugs = new ArrayList<>();
            substanciasAtivas = new ArrayList<>();
            interacaoAlimentares = new ArrayList<>();

            // Carregar lista de medicamentos
            JsonArray medicamentosArray = jsonObject.getAsJsonArray("drugs");
            if (medicamentosArray != null) {
                for (int i = 0; i < medicamentosArray.size(); i++) {
                    JsonObject medObject = medicamentosArray.get(i).getAsJsonObject();
                    Medicamento medicamento = gson.fromJson(medObject, Medicamento.class);
                    drugs.add(medicamento);
                }
            }

            // Carregar lista de substâncias ativas
            JsonArray substanciasArray = jsonObject.getAsJsonArray("substanciaAtivas");
            if (substanciasArray != null) {
                for (int i = 0; i < substanciasArray.size(); i++) {
                    JsonObject substanciaObject = substanciasArray.get(i).getAsJsonObject();
                    SubstanciaAtiva substanciaAtiva = gson.fromJson(substanciaObject, SubstanciaAtiva.class);
                    substanciasAtivas.add(substanciaAtiva);
                }
            }

            // Carregar lista de interações alimentares
            JsonArray interacoesArray = jsonObject.getAsJsonArray("interacaoAlimentars");
            if (interacoesArray != null) {
                for (int i = 0; i < interacoesArray.size(); i++) {
                    JsonObject interacaoObject = interacoesArray.get(i).getAsJsonObject();
                    InteracaoAlimentar interacaoAlimentar = gson.fromJson(interacaoObject, InteracaoAlimentar.class);
                    interacaoAlimentares.add(interacaoAlimentar);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Menu opcoes.
     */
    public static void menuOpcoes() {
        System.out.println(" Bem Vindo ao programa de Gestão de Farmacoviligância");
        System.out.println("******************************** ");
        System.out.println("1 ) Iniciar Sessão ");
        System.out.println("2 ) Registar Utilizador");
        System.out.println("3 ) Remover Utilizador");
        System.out.println("4 ) Adicionar Medicamento");
        System.out.println("5 ) Adicionar Interação Alimentar");
        System.out.println("6 ) Adicionar Substância Ativa");
        System.out.println("7 ) Consultar Medicamentos");
        System.out.println("8 ) Consultar Utilizadores");
        System.out.println("9 ) Consultar Substâncias Ativas");
        System.out.println("10 ) Consultar Interações Alimentares");
        System.out.println("11 ) Pesquisar Interações Alimentares");
        System.out.println("12 ) Pesquisar Contato da Farmacovigilância");
        System.out.println("0 ) Sair");
        System.out.println("********************************");
        System.out.print("Introduza uma opção: ");
    }

    /**
     * Escolha opcoes.
     */
    public static void escolhaOpcoes() {
        /// estas duas aqui funcao startup
        HandlerUtilizador<UtilizadorRegistado> listaUtilizadores = new HandlerUtilizador<>();
        // carregar medicamentos (esta aqui para juntar no startup)
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            menuOpcoes();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Carregando Medicamentos..");
                    carregarDados(filename);
                    break;
                case 2:
                    consultarMedicamentos();
                    break;
                case 3:
                    consultarInteracoesAlimentares();
                    break;
                case 4:
                    consultarSubstanciasAtivas();
                    break;
                case 5:
                    System.out.println("dois");
                    break;
                case 6:
                    System.out.println("dois");
                    break;
                case 7:
                    System.out.println("dois");
                    break;
                case 8:
                    System.out.println("dois");
                    break;
                case 9:
                    System.out.println("dois");
                    break;
                case 10:
                    System.out.println("dois");
                    break;
                case 11:
                    System.out.println("dois");
                    break;
                case 12:
                    System.out.println("dois");
                    break;
                case 13:
                    System.out.println("dois");
                    break;
                case 0:
                    System.out.println("A sair do programa..\nObrigado pela sua visita! Volte sempre!");
                    return;
            }
        } while (true);
    }

    /**
     * Consultar medicamentos list.
     *
     * @return the list
     */
// continuar a partir daqui as funcoes
//    public List<Medicamento> consultarMedicamentos(){
//        return null;
//    }

    /**
     * Consultar interacao alimentar list.
     *
     * @return the list
     */
    public List<InteracaoAlimentar> consultarInteracaoAlimentar(){
        return null;
    }

    /**
     * Consultar substancias list.
     *
     * @return the list
     */
    public List<SubstanciaAtiva> consultarSubstancias(){
        return null;
    }

    /**
     * Pesquisar interacao alimentar list.
     *
     * @return the list
     */
    public List<InteracaoAlimentar> pesquisarInteracaoAlimentar(){
        return null;
    }

    /**
     * Pesquiasr medicamento list.
     *
     * @return the list
     */
    public List<Medicamento> pesquiasrMedicamento(){
        return null;
    }

    /**
     * Pesquisar substancia list.
     *
     * @return the list
     */
    public List<SubstanciaAtiva> pesquisarSubstancia(){
        return null;
    }

    /**
     * Pesquisar contato string.
     *
     * @return the string
     */
    public String pesquisarContato(){
        return null;
    }

    /**
     * Consulta detalhes interacao string.
     *
     * @return the string
     */
    public String consultaDetalhesInteracao(){
        return null;
    }

    public static void consultarMedicamentos() {
        if (drugs != null && !drugs.isEmpty()) {
            for (Medicamento medicamento : drugs) {
                System.out.println(medicamento);
            }
        } else {
            System.out.println("Nenhum medicamento carregado.");
        }
    }

    /**
     * Consultar todas as substâncias ativas carregadas.
     */
    public static void consultarSubstanciasAtivas() {
        if (substanciasAtivas != null && !substanciasAtivas.isEmpty()) {
            for (SubstanciaAtiva substanciaAtiva : substanciasAtivas) {
                System.out.println(substanciaAtiva);
            }
        } else {
            System.out.println("Nenhuma substância ativa carregada.");
        }
    }

    /**
     * Consultar todas as interações alimentares carregadas.
     */
    public static void consultarInteracoesAlimentares() {
        if (interacaoAlimentares != null && !interacaoAlimentares.isEmpty()) {
            for (InteracaoAlimentar interacaoAlimentar : interacaoAlimentares) {
                System.out.println(interacaoAlimentar);
            }
        } else {
            System.out.println("Nenhuma interação alimentar carregada.");
        }
    }


}
