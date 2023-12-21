import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class Sistema {

    public static void registarUtilizador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registo de Utilizador");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();
        UtilizadorRegistado utilizador = new UtilizadorRegistado(nome, password, email, role);
        List<UtilizadorRegistado> utilizadores = carregarUtilizadores();
        utilizadores.add(utilizador);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(utilizadores);

        try (FileWriter writer = new FileWriter("utilizadores.json")) {
            writer.write(json);
            System.out.println("Utilizador registado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<UtilizadorRegistado> carregarUtilizadores() {
        File file = new File("utilizadores.json");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(file)) {
            Type tipoListaUtilizadores = new TypeToken<List<UtilizadorRegistado>>() {}.getType();
            return new Gson().fromJson(reader, tipoListaUtilizadores);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }



//    public static void startup(){
//        carregar docs
//                carregar users
//
//    }

    public static void criarMedicamento() {
        System.out.println("Numero 2");
    }

    public static void criarInteracaoAlimentar() {
        System.out.println("Numero 3");
    }

    public static void criarSubstanciasAtivas() {
        System.out.println("Numero 4");
    }

    public static void listarMedicamentos() {
        System.out.println("Numero 5");
    }

    public static void listarInteracaoAlimentares() {
        System.out.println("Numero 6");
    }

    private static int scan() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static void menu(){
        System.out.println("Bem vindo ao Sistema de Medicamentos");
        System.out.println("1 - Registar Utilizador");
        System.out.println("2 - Criar Medicamento");
        System.out.println("3 - Criar Interacao Alimentar");
        System.out.println("4 - Criar Substancias Ativas");
        System.out.println("5 - Listar Medicamentos");
        System.out.println("6 - Listar Interacoes Alimentares");
        System.out.println("0 - Exit");
    }
    public static void main(String[] args) {
        menu();
        do {
            System.out.print(" >>> ");
            int option = scan();
            switch (option) {
                case 1:
                    registarUtilizador();
                    break;
                case 2:
                    criarMedicamento();
                    break;
                case 3:
                    criarInteracaoAlimentar();
                    break;
                case 4:
                    criarSubstanciasAtivas();
                    break;
                case 5:
                    listarMedicamentos();
                    break;
                case 6:
                    listarInteracaoAlimentares();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao Inválida");
                    break;
            }
        } while (true);
    }
}
