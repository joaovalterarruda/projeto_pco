
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Sistema {
    static final String FILENAME = "dataset.json";
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
                    adicionarUtilizador(scanner, listaUtilizadores);
                    break;
                case 2:
                    listarMedicamentos();
                    break;
                case 3:
                    System.out.println("dois");
                    break;
                case 4:
                    System.out.println("dois");
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
    // continuar a partir daqui as funcoes
    public static void adicionarUtilizador(Scanner scanner, HandlerUtilizador<UtilizadorRegistado> listaUtilizador){
        System.out.println("Introduza o nome de utilizador: ");
        String nome = scanner.nextLine();
        System.out.println("Introduza uma password: ");
        String password = scanner.nextLine();
        System.out.println("Introduza o seu email: ");
        String email = scanner.nextLine();
        System.out.println("Introduza o tipo de utilizador: \n1) Administrador\n2) Indústria\n3) Farmacêutico"); // será o role, mas para ficar coerente com o que se tem
//        int role = scanner.nextInt();
//        switch (role){
//            case 1:
//                System.out.println("Administrador");
//                break;
//            case 2:
//                System.out.println("Indústria");
//                break;
//            case 3:
//                System.out.println("Farmacêutico");
//                break;
//        }

    }
    public static void removerUtilizador(){
        // falta completar
    }

    public static void listarMedicamentos() {

    }


}
