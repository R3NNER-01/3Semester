
import java.util.Scanner;
public class Lretangulo_2 {
    public static void calculaParam (double l1, double l2) {
        if (l1 == 0 || l2 == 0) {
            System.out.println("\nLado do retangulo igual a 0, caso impossivel.\nEncerrando o programa...");
            return;

        }
        double area = l1*l2;
        double per = l1*2 + l2*2;
        System.out.println("\nPerimetro do retangulo: " + per + "\nArea do retangulo: " + area);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Ex.2: Calculo de retangulo =====\n");

        System.out.print("Digite o 1° lado do retangulo: ");
        double lado1 = scanner.nextDouble();
        System.out.print("Digite o 2° lado do retangulo: ");
        double lado2 = scanner.nextDouble();
        calculaParam(lado1, lado2);


        scanner.close();
    }

}
