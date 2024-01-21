import com.google.gson.*;
//import org.json.JSONArray;
//import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    //static String filename = "dataset.json";
    static String users = "utilizadores.json";
    static List<Medicamento> drugs;
    static List<SubstanciaAtiva> substances;
    static List<InteracaoAlimentar> foodInteractions;
    static HandlerUtilizador<UtilizadorRegistado> listaUtilizadores = new HandlerUtilizador<>();

    public Sistema(List<Medicamento> drugs, List<SubstanciaAtiva> substances, List<InteracaoAlimentar> foodInteractions) {
        Sistema.drugs = new ArrayList<>(drugs);
        Sistema.substances = new ArrayList<>(substances);
        Sistema.foodInteractions = new ArrayList<>(foodInteractions);
    }

    public static void menuOpcoes() {
        System.out.println(" Bem Vindo ao programa de Gestão de Farmacoviligância");
        System.out.println("******************************** ");
        System.out.println("1 ) Iniciar Sessão --- DONE");
        System.out.println("2 ) Adicionar Utilizador --- DONE");
        System.out.println("3 ) Remover Utilizador --- DONE");

        System.out.println("4 ) Adicionar Medicamento");
        System.out.println("5 ) Adicionar Interação Alimentar");
        System.out.println("6 ) Adicionar Substância Ativa");

        System.out.println("7 ) Consultar Medicamentos ---DONE");
        System.out.println("8 ) Consultar Utilizadores ---DONE");
        System.out.println("9 ) Consultar Substâncias Ativas ---DONE");
        System.out.println("10 ) Consultar Interações Alimentares ---DONE");

        System.out.println("11 ) Pesquisar Contato da Farmacovigilância");
        System.out.println("0 ) Sair");
        System.out.println("********************************");
        System.out.print("Introduza uma opção: ");
    }

    public static void escolhaOpcoes() {
        /// estas duas aqui funcao startup
        // carregar medicamentos (esta aqui para juntar no startup)
        listaUtilizadores = HandlerUtilizador.carregarUtilizadoresDoFicheiroJson();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            menuOpcoes();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    iniciarSessao();
                    break;
                case 2:
                    adicionarUtilizador();
                    break;
                case 3:
                    removerUtilizador();
                    break;
                case 4:
                    //consultarSubstanciasAtivas();
                    break;
                case 5:
                    System.out.println("dois");
                    break;
                case 6:
                    System.out.println("dois");
                    break;
                case 7:
                    consultarMedicamentos();
                    break;
                case 8:
                    consultarUtilizadores(users);
                    break;
                case 9:
                    consultarSubstanciasAtivas();
                    break;
                case 10:
                    consultarInteracoesAlimentares();
                    break;
                case 11:
                    System.out.println("dois");
                    break;
                case 0:
                    System.out.println("A sair do programa..\nObrigado pela sua visita! Volte sempre!");
                    return;
            }
        } while (true);
    }

    /**
     * Carrega o dataset do arquivo JSON e armazena nas listas correspondentes.
     *
     * @param jsonFilePath Caminho do arquivo JSON.
     */
    public static void carregarDataset(String jsonFilePath) {

        try {
            String content = readJson(jsonFilePath);
            JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();

            // Carregar Medicamentos
            JsonArray arrayMedicamentos = jsonObject.getAsJsonArray("drugs");
            drugs = new ArrayList<>();
            for (int i = 0; i < arrayMedicamentos.size(); i++) {
                JsonObject medicament = arrayMedicamentos.get(i).getAsJsonObject();
                Medicamento medicamento = new Medicamento(
                        medicament.get("Name").getAsString(),
                        medicament.get("Form").getAsString(),
                        medicament.get("Dosage").getAsString(),
                        medicament.get("Laboratory").getAsString(),
                        medicament.get("Substances").getAsString()
                );
                drugs.add(medicamento);
            }

            // Carregar Substâncias Ativas
            JsonArray arraySubstancias = jsonObject.getAsJsonArray("substances");
            substances = new ArrayList<>();
            for (int i = 0; i < arraySubstancias.size(); i++) {
                JsonObject substancia = arraySubstancias.get(i).getAsJsonObject();
                SubstanciaAtiva substanciaAtiva = new SubstanciaAtiva(
                        substancia.get("Substance").getAsString()
                );
                substances.add(substanciaAtiva);
            }
            // Carregar Interações Alimentares
            JsonArray arrayInteracoes = jsonObject.getAsJsonArray("foodInteractions");
            foodInteractions = new ArrayList<>();
            for (int i = 0; i < arrayInteracoes.size(); i++) {
                JsonObject interacao = arrayInteracoes.get(i).getAsJsonObject();
                InteracaoAlimentar interacaoAlimentar = new InteracaoAlimentar(
                        interacao.get("Bibliography").getAsString(),
                        interacao.get("Effect").getAsString(),
                        interacao.get("EffectLevel").getAsInt(),
                        interacao.get("Explanation").getAsString(),
                        interacao.get("Food").getAsString(),
                        interacao.get("Substances").getAsString()
                );
                foodInteractions.add(interacaoAlimentar);
            }



            System.out.println("Dataset carregado com sucesso.");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo JSON: " + e.getMessage());
        }
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

    public List<InteracaoAlimentar> pesquisarInteracaoAlimentar(){
        return null;
    }

    public List<Medicamento> pesquiasrMedicamento(){
        return null;
    }

    public List<SubstanciaAtiva> pesquisarSubstancia(){
        return null;
    }

    public String pesquisarContato(){
        return null;
    }

    private static void iniciarSessao() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza o nome de utilizador: ");
        String nome = scanner.nextLine();

        System.out.print("Introduza a password: ");
        String password = scanner.nextLine();

        // Verificar credenciais
        UtilizadorRegistado utilizadorAutenticado = listaUtilizadores.verificarCredenciais(nome, password);

        if (utilizadorAutenticado != null) {
            System.out.println("Sessão iniciada com sucesso!: \n Bem-vindo! "
                    + utilizadorAutenticado.getNome());
        } else {
            System.out.println("Introduziu credenciais inválidas. ");
        }
    }

    private static void adicionarUtilizador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza o nome de utilizador a adicionar:  ");
        String nome = scanner.nextLine();

        System.out.print("Introduza a password do utilizador a adicionar:  ");
        String password = scanner.nextLine();

        System.out.print("Introduza o email para o novo utilizador: ");
        String email = scanner.nextLine();

        System.out.print("Introduza um papel para o novo utilizador: ");
        String role = scanner.nextLine();

        UtilizadorRegistado novoUtilizador = new Utente(nome, password, email, role);

        // Adiciona o novo utilizador à lista de utilizadores
        listaUtilizadores.criarUtilizador(novoUtilizador);

        // Guarda a lista de utilizadores num ficheiro JSON
        guardarUtilizadoresFicheiroJson(listaUtilizadores.getUtilizadores());

        System.out.println("Utilizador foi adicionado com sucesso!");
    }

    private static void removerUtilizador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza o nome de utilizador a remover: ");
        String nome = scanner.nextLine();

        // Remove o utilizador da lista
        listaUtilizadores.removerUtilizador(nome);

        // Guarda a lista de utilizadores num ficheiro JSON
        guardarUtilizadoresFicheiroJson(listaUtilizadores.getUtilizadores());

        System.out.println("Utilizador foi removido com sucesso!");
    }

    private static void consultarUtilizadores(String json) {
        try {
            String content = readJson(json);
            Gson gson = new Gson();
            UtilizadorRegistado[] utilizadoresArray = gson.fromJson(content, UtilizadorRegistado[].class);

            if (utilizadoresArray != null && utilizadoresArray.length > 0) {
                System.out.println("Lista de Utilizadores: ");
                for (UtilizadorRegistado utilizador : utilizadoresArray) {
                    System.out.println(utilizador);
                }
            } else {
                System.out.println("Nenhum utilizador foi encontrado!");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o ficheiro: " + e.getMessage());
        }
    }


    private static void guardarUtilizadoresFicheiroJson(List<UtilizadorRegistado> utilizadores) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("utilizadores.json")) {
            gson.toJson(utilizadores, writer);
            System.out.println("Utilizadores foram guardado no ficheiro 'utilizadores.json' ");
        } catch (IOException e) {
            System.out.println("Erro ao tentar guardar os utilizadores em JSON: " + e.getMessage());
        }
    }

    /**
     * Consulta e exibe detalhes dos medicamentos carregados na lista.
     */
    public static void consultarMedicamentos() {
        if (drugs != null && !drugs.isEmpty()) {
            int contador = 0;
            for (Medicamento medicamento : drugs) {
                // Imprime cada atributo em uma linha separada
                System.out.println("Nome: " + medicamento.getName());
                System.out.println("Forma: " + medicamento.getForm());
                System.out.println("Dosagem: " + medicamento.getDosage());
                System.out.println("Laboratório: " + medicamento.getLaboratory());
                System.out.println("Substâncias: " + medicamento.getSubstances());

                // Adiciona um separador entre medicamentos
                System.out.println("==================================");

                contador++;

                // Pausa a cada 10 medicamentos e oferece a opção de retornar ao menu principal
                if (contador % 10 == 0) {
                    System.out.println("Pressione Enter para continuar ou 'M' para voltar ao menu principal:");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine().trim().toUpperCase();
                    if (input.equals("M")) {
                        return; // Retorna ao menu principal
                    }
                }
            }
        } else {
            System.out.println("Nenhum medicamento carregado.");
        }
    }

    private static String readJson(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        }
    }

    /**
     * Consultar todas as substâncias ativas carregadas.
     */
    public static void consultarSubstanciasAtivas() {
        if (substances != null && !substances.isEmpty()) {
            for (SubstanciaAtiva substanciaAtiva : substances) {
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
        if (foodInteractions != null && !foodInteractions.isEmpty()) {
            for (InteracaoAlimentar interacaoAlimentar : foodInteractions) {
                System.out.println(interacaoAlimentar);
            }
        } else {
            System.out.println("Nenhuma interação alimentar carregada.");
        }
    }


}
