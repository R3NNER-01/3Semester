import java.util.Scanner;
public class GreaterMedia_5 {
    public static void numMaiores(int[] a, float media) {
        System.out.println("Os numeros maiores que a media sao: ");
        for (int i = 0; i < 10; i++) {
            if (a[i] > media) {
                System.out.println(a[i]);
            }
        }


    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== Ex.5: Maiores que a media =====\n");
        System.out.println("Insira 10 valores inteiros:");
        int[] a = new int[10];
        float media = 0;
        for (int i = 0; i < 10; i++){
            a[i] = scanner.nextInt();
            media += (float) a[i]/10;
        }
        System.out.println("\nA media dos numeros tem valor = "+ media);
        numMaiores(a, media);
        scanner.close();

    }
}
