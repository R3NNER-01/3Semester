import java.util.Scanner;
public class MenuOpcoes_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("--------------------");
        System.out.print("1. Opção 1\n2. Opção 2\n3. Opção 3\n4. Sair\n");
        System.out.print("--------------------\n");

        while (true) {
            System.out.print("Digite a opção desejada: ");
            int n = scanner.nextInt();
            if (n <= 0 || n > 4) {
                System.out.println("Entrada inválida.");
                continue;
            }
            if (n == 4) {
                System.out.println("Saindo do programa...");
                break;
            } else {
                System.out.println("Opção " + n + " selecionada.");
            }
        }
        scanner.close();
    }
}
