import java.util.Scanner;
public class ContRegressiva_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Ex.9: Contagem ate 0 =====\n");
        System.out.print("Digite um numero positivo: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Insercao invalida.\nEncerrando programa...\n");
            return;
        }
        System.out.println("\nContagem Regressiva a partir de " + n);
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
        scanner.close();
    }
}
