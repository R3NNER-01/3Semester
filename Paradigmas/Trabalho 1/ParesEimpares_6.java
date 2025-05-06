import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ParesEimpares_6 {
    public static int verificaFinal(List<Integer> lista, int maiorPar) {
        int qtdeImpares = 0;
        for (int it : lista) {
            if (it % 2 != 0 && it > maiorPar) {
                qtdeImpares++;
            }
        }
        return qtdeImpares;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();
        int nPares = 0, nImpares = 0, mediaImpar = 0, maiorPar = -10000, imparMaiorPar;
        System.out.println("\n===== Ex.6: Definir números infinitos =====\n");
        while(true) {
            System.out.println("Digite um número inteiro (0 para parar): ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                imparMaiorPar = verificaFinal(numeros, maiorPar);
                break;
            }
            if (numero % 2 == 0) {
                nPares++;
                if (numero > maiorPar) {
                    maiorPar = numero;
                }
            } else {
                nImpares++;
                mediaImpar += numero;
            }
            numeros.add(numero);
        }
        if (nImpares > 0) {
            mediaImpar /= nImpares;
        } else {
            mediaImpar = 0;
        }
        System.out.println("Fim da inserção.\n=======\nNúmero de pares lidos: "+ nPares + "\nMédia dos ímpares inseridos: "+ mediaImpar);
        System.out.println("Maior número par inserido: "+ maiorPar + "\nÍmpares inseridos maiores que o maior par: " + imparMaiorPar);

        System.out.println("Fim do Programa.");

        scanner.close();
    }
}
