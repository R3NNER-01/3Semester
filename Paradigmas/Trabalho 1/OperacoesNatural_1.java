import java.util.Scanner;

public class OperacoesNatural_1 {

    public static void realizaOp (int a, int b) {
        System.out.println("\nOperacoes entre " + a + " e " + b + ":\n\nSoma: "+ (a+b) + "\nSubtração: "+ (a-b));
        System.out.println("Multiplicacao: "+ (a*b));
        if (b != 0) {
            System.out.println("Divisao: " + ((double)a / b));
        } else {
            System.out.println("Divisao: impossível (divisão por zero)");
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1, n2;
        System.out.println("\n\n===== Ex.1: Operacoes com Inteiros =====\n");
        System.out.print("Digite o primeiro numero: ");
        n1 = scanner.nextInt();
        System.out.print("\nDigite o segundo numero: ");
        n2 = scanner.nextInt();

        realizaOp(n1, n2);

        scanner.close();
    }
}
