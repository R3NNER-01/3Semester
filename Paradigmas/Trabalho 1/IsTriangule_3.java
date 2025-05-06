import java.util.Scanner;
public class IsTriangule_3 {
    public static void verificaTri(int a, int b, int c) {

        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("O triangulo inserido possui dimensões impossiveis.");
            return;
        }
        if (a == b && b == c && a == c) {
            System.out.println("O triangulo inserido eh equilatero.");
        } else if (a == b || b == c || a == c) {
            System.out.println("O triangulo inserido eh isosceles.");
        } else {
            System.out.println("O triangulo inserido eh escaleno.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Ex.3: Verificacao de Triangulo =====\n");
        System.out.println("Digite as dimensoes inteiras dos lados do triangulo: ");
        int l1 = scanner.nextInt();
        int l2 = scanner.nextInt();
        int l3 = scanner.nextInt();
        verificaTri(l1, l2, l3);

        scanner.close();
    }
}