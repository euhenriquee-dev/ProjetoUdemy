import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario user = new Usuario();

        mostrarMenu();
        int opcao = lerNumero(scanner, "Digite a opção desejada: ");
        while (opcao != 0) {
            if (opcao == 1) {
                user = criarConta(scanner);
                System.out.println("Conta criada para o usuaário " + user.nome);
            }
            if (opcao == 2) {
                fazerLogin(scanner, user);
            }
            if (opcao == 3) {
                fazerLogout(user);
            }
            mostrarMenu();
            opcao = lerNumero(scanner, "Digite uma nova Opção");
        }
    }

    public static void mostrarMenu() {
        System.out.println("==== Menu Udemy (Console) ====");
        System.out.println("1) - Criar conta");
        System.out.println("2) - Entrar");
        System.out.println("3) - Sair");
        System.out.println("=============================");
    }

    public static Usuario criarConta(Scanner scanner) {
        Usuario user = new Usuario();
        System.out.println("-- Criar conta --");
        user.nome = lerLinha(scanner, "Nome Completo: ");
        user.email = lerLinha(scanner, "Email: ");
        user.senha = lerLinha(scanner, "Senha: ");
        System.out.println("Conta criada com sucesso!");
        System.out.println("Nome: " + user.nome);
        System.out.println("Email: " + user.email);
        System.out.println("Senha: " + user.senha);
        return user;
    }

    public static String lerLinha(Scanner scanner, String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static int lerNumero(Scanner scanner, String msg) {
        System.out.println(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void fazerLogin(Scanner scanner, Usuario user) {
        if (user.email != null) {
            System.out.println("-- Fazer Login --");
            String email = lerLinha(scanner, "Email: ");
            String senha = lerLinha(scanner, "Senha: ");
            if (user.email.equals(email) && user.senha.equals(senha)) {
                System.out.println("Login efetuado com sucesso!");
            } else {
                System.out.println("Email ou senha incorretos!");
            }
        }else {
            System.out.println("Não tem ninguem logado!");
        }
    }

    public static void fazerLogout(Usuario user){
        if(user.email != null){
            user.email = null;
            user.senha = null;
            user.tipoUsuario = null;
            System.out.println("Logout efetuado com sucesso!");
        }else {
            System.out.println("Não tem ninguem logado!");
        }
    }

}