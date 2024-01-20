import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        System.out.println("7 ) Consultar Medicamentos ---DONE");
        System.out.println("8 ) Consultar Utilizadores");
        System.out.println("9 ) Consultar Substâncias Ativas");
        System.out.println("10 ) Consultar Interações Alimentares");
        System.out.println("11 ) Pesquisar Contato da Farmacovigilância");
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
                    break;
                case 2:
                    consultarMedicamentos(filename);
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
                    consultarMedicamentos(filename);
                    break;
                case 8:
                    System.out.println("dois");
                    break;
                case 9:
                    consultarSubstancias(filename);
                    break;
                case 10:
                    System.out.println("dois");
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

    private static void consultarSubstancias(String filePath) {
        System.out.println("---");
    }
    private static String readJson(String filePath) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
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
