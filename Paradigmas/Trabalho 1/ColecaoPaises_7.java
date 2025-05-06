
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ColecaoPaises_7 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listaPaises = new ArrayList<>();

        listaPaises.add("Brasil");
        listaPaises.add("Argentina");
        listaPaises.add("Paraguai");
        listaPaises.add("Estados Unidos");
        listaPaises.add("Canada");
        listaPaises.add("Chile");
        listaPaises.add("Peru");
        listaPaises.add("Japao");
        listaPaises.add("China");
        listaPaises.add("Australia");
        System.out.println("\n===== Ex.6: Lista de Paises =====\n");
        System.out.println("Insira uma string para buscar na lista: ");
        String lida = scanner.nextLine();
        boolean existe = false;
        boolean contem = false;
        for (String it : listaPaises) {
            if (it.equalsIgnoreCase(lida)) {
                System.out.println("O pais digitado existe na lista.");
                existe = true;
                contem = true;
                break;
            }
            if (it.contains(lida)) {
                contem = true;
            }

        }
        if (!existe) {
            System.out.println("O pais digitado nao existe na lista.\n=======\n");
        }
        if (contem) {
            System.out.println("A lista contem a string lida em: ");

            for (String it:listaPaises) {
                if (it.contains(lida)) {
                    System.out.println(it);
                }
            }
        } else {
            System.out.println("A lista nao contem a string lida");
        }
        scanner.close();
    }
}

