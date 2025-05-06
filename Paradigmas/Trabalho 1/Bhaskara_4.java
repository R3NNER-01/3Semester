import java.util.Scanner;

public class Bhaskara_4 {
    public static void calculaBhask (double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4*a*c;
        if (delta < 0) {
            System.out.println("Nao existem raizes reais para a equacao.");
        } else {
            double x1 = (-b+Math.sqrt(delta))/(2*a);
            double x2 = (-b-Math.sqrt(delta))/(2*a);
            if (delta == 0) {
                System.out.println("A raiz da equacao inserida tem valor x = "+ x1);
            } else {
                System.out.println("As raizes da equacao inserida tem valores x1 = " + x1 + " e x2 = "+ x2);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Ex.4: Equacao de segundo grau =====\n");
        System.out.print("Digite os coeficientes a, b e c da equacao ax²+bx+c=0: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        calculaBhask(a, b, c);

        scanner.close();
    }
}
