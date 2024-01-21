import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    static String filename = "dataset.json";
    static List<Medicamento> drugs;
    static List<SubstanciaAtiva> substanciasAtivas;
    static List<InteracaoAlimentar> interacaoAlimentares;
    static HandlerUtilizador<UtilizadorRegistado> listaUtilizadores = new HandlerUtilizador<>();


    public Sistema(List<Medicamento> drugs, List<SubstanciaAtiva> substanciaAtivas, List<InteracaoAlimentar> interacaoAlimentars) {
        Sistema.drugs = new ArrayList<>(drugs);
        Sistema.substanciasAtivas = new ArrayList<>(substanciaAtivas);
        Sistema.interacaoAlimentares = new ArrayList<>(interacaoAlimentars);
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
        System.out.println("8 ) Consultar Utilizadores");
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
                    consultarSubstancias(filename);
                    break;
                case 5:
                    System.out.println("dois");
                    break;
                case 6:
                    System.out.println("dois");
                    break;
                case 7:
                    consultarMedicamentos(filename);
                    break;
                case 8:
                    System.out.println("dois");
                    break;
                case 9:
                    consultarSubstancias(filename);
                    break;
                case 10:
                    consultarInteracoesAlimentares(filename);
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
// continuar a partir daqui!

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


    private static void guardarUtilizadoresFicheiroJson(List<UtilizadorRegistado> utilizadores) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("utilizadores.json")) {
            gson.toJson(utilizadores, writer);
            System.out.println("Utilizadores foram guardado no ficheiro 'utilizadores.json' ");
        } catch (IOException e) {
            System.out.println("Erro ao tentar guardar os utilizadores em JSON: " + e.getMessage());
        }
    }

    private static void consultarMedicamentos(String json) {
        try {
            String content = readJson(json);
            JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
            JsonArray arrayMedicamentos = jsonObject.getAsJsonArray("drugs");

            for (int i = 0; i < arrayMedicamentos.size(); i++) {
                JsonObject medicament = arrayMedicamentos.get(i).getAsJsonObject();
                Medicamento medicamento = new Medicamento(
                        medicament.get("Name").getAsString(),
                        medicament.get("Form").getAsString(),
                        medicament.get("Dosage").getAsString(),
                        medicament.get("Laboratory").getAsString(),
                        medicament.get("Substances").getAsString()
                );
                System.out.println(medicamento);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o ficheir:  " + e.getMessage());
        }
    }


    private static void consultarSubstancias(String json) {
        try {
            String content = readJson(json);
            JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
            JsonArray arraySubstances = jsonObject.getAsJsonArray("substances");

            for (int i = 0; i < arraySubstances.size(); i++) {
                JsonObject substanceObject = arraySubstances.get(i).getAsJsonObject();

                SubstanciaAtiva substanciaAtiva = new SubstanciaAtiva(
                        substanceObject.get("Substance").getAsString()
                );

                System.out.println(substanciaAtiva);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o ficheiro: " + e.getMessage());
        }
    }

    private static void consultarInteracoesAlimentares(String json) {
        try {
            String content = readJson(json);
            JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
            JsonArray arrayInteracoes = jsonObject.getAsJsonArray("foodInteractions");

            for (int i = 0; i < arrayInteracoes.size(); i++) {
                JsonObject interacaoObject = arrayInteracoes.get(i).getAsJsonObject();
                InteracaoAlimentar interacaoAlimentar = new InteracaoAlimentar(
                        interacaoObject.get("Bibliography").getAsString(),
                        interacaoObject.get("Effect").getAsString(),
                        interacaoObject.get("EffectLevel").getAsInt(),
                        interacaoObject.get("Explanation").getAsString(),
                        interacaoObject.get("Food").getAsString(),
                        interacaoObject.get("Substances").getAsString()
                );
                System.out.println(interacaoAlimentar);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o ficheiro: " + e.getMessage());
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
}
