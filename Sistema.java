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
    static List<FoodType> foodTypes;
    static List<Laboratory> laboratories;
    static HandlerUtilizador listaUtilizadores = new HandlerUtilizador();
    static HandlerMedicamento listaMedicamento = new HandlerMedicamento();
    static HandlerIntAlimentar interacaoAlimentar = new HandlerIntAlimentar();

    static UtilizadorRegistado utilizadorAutenticado;

    public Sistema(List<Medicamento> drugs, List<SubstanciaAtiva> substances, List<InteracaoAlimentar> foodInteractions) {
        Sistema.drugs = new ArrayList<>(drugs);
        Sistema.substances = new ArrayList<>(substances);
        Sistema.foodInteractions = new ArrayList<>(foodInteractions);
        Sistema.foodTypes = new ArrayList<>(foodTypes);
        Sistema.laboratories = new ArrayList<>(laboratories);
    }

    public static void menuOpcoes() {
        System.out.println();
        System.out.println("******************************************************");
        System.out.println(" Bem Vindo ao programa de Gestão de Farmacoviligância");
        System.out.println("******************************************************");
        System.out.println("1 ) Iniciar Sessão --- DONE");
        if (utilizadorAutenticado == null){
            System.out.println("2 ) Consultar Interações Alimentares");
            System.out.println("3 ) Pesquisar Contato Farmacovigilância");
            System.out.println("0 ) Sair");
        } else {
            switch (utilizadorAutenticado.getRole()){
                case "admin":
                    System.out.println("2 ) Adicionar Utilizador --- DONE");
                    System.out.println("3 ) Remover Utilizador --- DONE");
                    System.out.println("4 ) Adicionar Medicamento --- DONE");
                    System.out.println("5 ) Adicionar Interação Alimentar --- DONE");
                    System.out.println("6 ) Adicionar Substância Ativa");

                    System.out.println("7 ) Consultar Medicamentos ---DONE");
                    System.out.println("8 ) Consultar Utilizadores ---DONE");
                    System.out.println("9 ) Consultar Substâncias Ativas ---DONE");
                    System.out.println("10 ) Consultar Interações Alimentares ---DONE");

                    System.out.println("11 ) Pesquisar Contato da Farmacovigilância");
                    System.out.println("0 ) Sair");
                    break;
                case "farmaceutico":
                    System.out.println("5 ) Adicionar Interação Alimentar");
                    System.out.println("9 ) Consultar Substâncias Ativas ---DONE");
                    System.out.println("10 ) Consultar Interações Alimentares ---DONE");
                    System.out.println("11 ) Pesquisar Contato da Farmacovigilância");
                    System.out.println("0 ) Sair");
                    break;
                case "industria":
                    System.out.println("4 ) Adicionar Medicamento ");
                    System.out.println("7 ) Consultar Medicamentos ---DONE");
                    System.out.println("9 ) Consultar Substâncias Ativas ---DONE");
                    break;
            }
        }

        System.out.println("******************************************************");
        System.out.print("Introduza uma opção: ");
        System.out.println();
    }

    public static void escolhaOpcoes() throws IOException {
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
                    adicionarMedicamento();
                    break;
                case 5:
                    adicionarInteracaoAlimentar();
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
            // Carregar Tipos de Alimentos
            JsonArray arrayFoodTypes = jsonObject.getAsJsonArray("foodTypes");
            foodTypes = new ArrayList<>();
            for (int i = 0; i < arrayFoodTypes.size(); i++) {
                JsonObject foodTypeJson = arrayFoodTypes.get(i).getAsJsonObject();
                FoodType foodType = new FoodType(
                        foodTypeJson.get("Type").getAsString()
                );
                foodTypes.add(foodType);
            }

            // Carregar Laboratórios
            JsonArray arrayLaboratories = jsonObject.getAsJsonArray("laboratories");
            laboratories = new ArrayList<>();
            for (int i = 0; i < arrayLaboratories.size(); i++) {
                JsonObject laboratoryJson = arrayLaboratories.get(i).getAsJsonObject();
                Laboratory laboratory = new Laboratory(
                        laboratoryJson.get("Name").getAsString(),
                        laboratoryJson.get("Surveillance").getAsString()
                );
                laboratories.add(laboratory);
            }

            System.out.println("Dataset carregado com sucesso.");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }

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

    private static void iniciarSessao() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza o nome de utilizador: ");
        String nome = scanner.nextLine();

        System.out.print("Introduza a password: ");
        String password = scanner.nextLine();

        // Verificar credenciais
        utilizadorAutenticado = listaUtilizadores.verificarCredenciais(nome, password);

        if (utilizadorAutenticado != null) {
            System.out.println();
            System.out.println("Sessão iniciada com sucesso!: \n Bem-vindo! "
                    + utilizadorAutenticado.getNome());
            System.out.println("Prima Enter para continuar");
            System.in.read();
            System.out.println();
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

        String role;
        while (true) {
            System.out.println("Escolha o papel para o novo utilizador:");
            System.out.println("1. Farmaceutico");
            System.out.println("2. Industria");
            System.out.println("3. Admin");

            // Lê a escolha do utilizador
            int escolha = scanner.nextInt();

            // Define o papel com base na escolha do utilizador
            switch (escolha) {
                case 1:
                    role = "farmaceutico";
                    break;
                case 2:
                    role = "industria";
                    break;
                case 3:
                    role = "admin";
                    break;
                default:
                    System.out.println("Escolha inválida. Por favor, escolha novamente.");
                    continue;  // Volta ao início do loop para permitir nova escolha
            }

            break;  // Sai do loop se a escolha for válida
        }

        UtilizadorRegistado novoUtilizador = new UtilizadorRegistado(nome, password, email, role);

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

    private static void adicionarMedicamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do Medicamento: ");
        String name = scanner.nextLine();

        System.out.print("Forma: ");
        String form = scanner.nextLine();

        System.out.print("Dosagem: ");
        String dosage = scanner.nextLine();

        System.out.print("Laboratório: ");
        String laboratory = scanner.nextLine();

        System.out.print("Substâncias: ");
        String substances = scanner.nextLine();

        // cria um objeto medicamento com os dados introduzidos pelo utilizador
        Medicamento novoMedicamento = new Medicamento(name, form, dosage, laboratory, substances);
        // adiciona o medicamento a lista existente
        drugs.add(novoMedicamento);
        // atualizar o ficheiro dataset.json
        atualizarDatasetJson();

        System.out.println("Novo medicamento adicionado com sucesso!");
    }

    private static void consultarUtilizadores(String json) {
        try {
            String content = readJson(json);
            Gson gson = new Gson();
            UtilizadorRegistado[] utilizadoresArray = gson.fromJson(content, UtilizadorRegistado[].class);

            if (utilizadoresArray != null && utilizadoresArray.length > 0) {
                System.out.println("");
                System.out.println("Lista de Utilizadores: ");
                System.out.printf("%-20s %-20s %-30s %-10s%n", "Nome", "Password", "Email", "Papel");
                System.out.println("--------------------------------------------------------------------------------");

                for (UtilizadorRegistado utilizador : utilizadoresArray) {
                    System.out.printf("%-20s %-20s %-30s %-10s%n",
                            utilizador.getNome(),
                            utilizador.getPassword(),
                            utilizador.getEmail(),
                            utilizador.getRole());
                }
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Prima Enter para continuar.");
                System.out.println("");
                System.in.read();


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

    public static void consultarMedicamentos() {
        if (drugs != null && !drugs.isEmpty()) {
            int contador = 0;
            for (Medicamento medicamento : drugs) {
                // Imprime cada atributo numa linha separada
                System.out.println("Nome: " + medicamento.getName());
                System.out.println("Forma: " + medicamento.getForm());
                System.out.println("Dosagem: " + medicamento.getDosage());
                System.out.println("Laboratório: " + medicamento.getLaboratory());
                System.out.println("Substâncias: " + medicamento.getSubstances());

                // Adiciona um separador entre medicamentos
                System.out.println("==================================");

                contador++;

                // Pausa a cada 10 medicamentos e oferece a opção de voltar ao menu principal
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

    public static void consultarSubstanciasAtivas() {
        if (substances != null && !substances.isEmpty()) {
            int contador = 0;
            for (SubstanciaAtiva substanciaAtiva : substances) {
                // imprime cada substancia numa linha
                System.out.println("Substancia Ativa: " + substanciaAtiva.getSubstance());
                // Adiciona um separador entre substâncias
                System.out.println("==================================");

                contador++;
                // Pausa a cada 10 substancias e oferece a opção de voltar ao menu principal
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
            System.out.println("Nenhuma substância ativa carregada.");
        }
    }

    /**
     * Consultar todas as interações alimentares carregadas.
     */
    public static void consultarInteracoesAlimentares() {
        if (foodInteractions != null && !foodInteractions.isEmpty()) {
            int contador = 0;
            for (InteracaoAlimentar interacaoAlimentar : foodInteractions) {
                //imprime cada informação de Interações alimentares numa linha
                System.out.println("Bibliografia: " + interacaoAlimentar.getBibliography());
                System.out.println("Efeito: " + interacaoAlimentar.getEffect());
                System.out.println("Nível de Efeito: " + interacaoAlimentar.getEffectLevel());
                System.out.println("Explicação: " + interacaoAlimentar.getExplanation());
                System.out.println("Alimento: " + interacaoAlimentar.getFood());
                System.out.println("Substancias: " + interacaoAlimentar.getSubstances());
                // Adiciona um separador entre Interações alimentares
                System.out.println("==================================");

            contador++;
                // Pausa a cada 10 interações e oferece a opção de voltar ao menu principal
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
            System.out.println("Nenhuma interação alimentar carregada.");
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
     * Adiciona uma nova interação alimentar ao dataset.json.
     */
    private static void adicionarInteracaoAlimentar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bibliografia: ");
        String bibliografia = scanner.nextLine();

        System.out.print("Efeito: ");
        String efeito = scanner.nextLine();

        System.out.print("Nível de Efeito: ");
        int nivelEfeito = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Explicação: ");
        String explicacao = scanner.nextLine();

        System.out.print("Alimento: ");
        System.out.println("Escolha o tipo de alimento:");
        for (int i = 0; i < foodTypes.size(); i++) {
            System.out.println((i + 1) + ". " + foodTypes.get(i).getType());
        }

        String alimento = null;
        boolean escolhaValida = false;

        while (!escolhaValida) {
            int escolhaTipoAlimento = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            // Verificar se a escolha é válida
            if (escolhaTipoAlimento >= 1 && escolhaTipoAlimento <= foodTypes.size()) {
                // Obter o tipo de alimento escolhido
                alimento = foodTypes.get(escolhaTipoAlimento - 1).getType();
                escolhaValida = true;
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }
        }

        System.out.print("Substâncias: ");
        System.out.println("Escolha a substância");
        for (int i = 0; i < substances.size(); i++){
            System.out.println((i + 1) + ". " + substances.get(i).getSubstance());
        }

        String substancias = null;
        boolean escolhaSubstanciaValida = false;

        while (!escolhaSubstanciaValida) {
            int escolhaSubstancia = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            // Verificar se a escolha é válida
            if (escolhaSubstancia >= 1 && escolhaSubstancia <= substances.size()) {
                // Obter a substância escolhida
                substancias = substances.get(escolhaSubstancia - 1).getSubstance();
                escolhaSubstanciaValida = true;
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
            }

        }
        // Criar um objeto InteracaoAlimentar com os dados fornecidos
        InteracaoAlimentar novaInteracao = new InteracaoAlimentar(bibliografia, efeito, nivelEfeito, explicacao, alimento, substancias);

        // Adicionar a nova interação à lista existente
        foodInteractions.add(novaInteracao);

        // Atualizar o arquivo dataset.json
        atualizarDatasetJson();
        System.out.println("Nova interação alimentar adicionada com sucesso!");
    }

    /**
     * Atualiza o arquivo dataset.json com as informações mais recentes.
     */
    private static void atualizarDatasetJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new JsonObject();

        // Adicionar a lista de medicamentos ao JSON
        JsonArray arrayMedicamentos = new JsonArray();
        for (Medicamento medicamento : drugs) {
            JsonObject medicamentoJson = new JsonObject();
            // Preencher os detalhes do medicamento no objeto JSON
            medicamentoJson.addProperty("Name", medicamento.getName());
            medicamentoJson.addProperty("Form", medicamento.getForm());
            medicamentoJson.addProperty("Dosage", medicamento.getDosage());
            medicamentoJson.addProperty("Laboratory", medicamento.getLaboratory());
            medicamentoJson.addProperty("Substances", medicamento.getSubstances());
            // Adicionar o objeto medicamento ao array
            arrayMedicamentos.add(medicamentoJson);
        }
        jsonObject.add("drugs", arrayMedicamentos);

        // Adicionar a lista de interações alimentares ao JSON
        JsonArray arrayInteracoes = new JsonArray();
        for (InteracaoAlimentar interacaoAlimentar : foodInteractions) {
            JsonObject interacaoJson = new JsonObject();
            // Preencher os detalhes da interação alimentar no objeto JSON
            interacaoJson.addProperty("Bibliography", interacaoAlimentar.getBibliography());
            interacaoJson.addProperty("Effect", interacaoAlimentar.getEffect());
            interacaoJson.addProperty("EffectLevel", interacaoAlimentar.getEffectLevel());
            interacaoJson.addProperty("Explanation", interacaoAlimentar.getExplanation());
            interacaoJson.addProperty("Food", interacaoAlimentar.getFood());
            interacaoJson.addProperty("Substances", interacaoAlimentar.getSubstances());
            // Adicionar o objeto interação alimentar ao array
            arrayInteracoes.add(interacaoJson);
        }
        jsonObject.add("foodInteractions", arrayInteracoes);

        // Adicionar a lista de tipos de alimentos ao JSON
        JsonArray arrayFoodTypes = new JsonArray();
        for (FoodType foodType : foodTypes) {
            JsonObject foodTypeJson = new JsonObject();
            foodTypeJson.addProperty("Type", foodType.getType());
            arrayFoodTypes.add(foodTypeJson);
        }
        jsonObject.add("foodTypes", arrayFoodTypes);

        // Adicionar a lista de laboratórios ao JSON
        JsonArray arrayLaboratories = new JsonArray();
        for (Laboratory laboratory : laboratories) {
            JsonObject laboratoryJson = new JsonObject();
            laboratoryJson.addProperty("Name", laboratory.getName());
            laboratoryJson.addProperty("Surveillance", laboratory.getSurveillance());
            arrayLaboratories.add(laboratoryJson);
        }
        jsonObject.add("laboratories", arrayLaboratories);

        // Adicionar a lista de substâncias ativas ao JSON
        JsonArray arraySubstancias = new JsonArray();
        for (SubstanciaAtiva substanciaAtiva : substances) {
            JsonObject substanciaJson = new JsonObject();
            // Preencher os detalhes da substância ativa no objeto JSON
            substanciaJson.addProperty("Substance", substanciaAtiva.getSubstance());
            // Adicionar o objeto substância ao array
            arraySubstancias.add(substanciaJson);
        }
        jsonObject.add("substances", arraySubstancias);

        // Escrever o objeto JSON atualizado no arquivo dataset.json
        try (FileWriter writer = new FileWriter("dataset.json")) {
            gson.toJson(jsonObject, writer);
            System.out.println("Dataset atualizado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao tentar atualizar o arquivo JSON: " + e.getMessage());
        }
    }
}
