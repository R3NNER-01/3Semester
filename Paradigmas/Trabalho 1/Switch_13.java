import java.util.Scanner;

public class Switch_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ex.13: SWITCH EM JAVA


        // o switch-case é utilizado para evitar vários casos condicionais com uma mesma variável e
        // colocados apenas em uma estrutura condicional.
        //Exemplo:
        int numero = scanner.nextInt(); // usuário seleciona um número

        switch (numero){  // variavel que será comparada com cada caso
            case 1: //caso seja 1, executa a ação
                System.out.println("O número 1 foi selecionado");
                break;  // sai da estrutura Switch, evitando que a execução continue nos próximos case

            case 2: // caso seja 2, executa a ação
                System.out.println("O número 2 foi selecionado");
                break;

            case 3:
                System.out.println("O número 3 foi selecionado");
                break;

            default:  // se nenhum case for acessado, é executado o default (opcional haver)
                System.out.println("O número " + numero + " foi selecionado (fora do previsto)");
                break;

        }

        //tipos suportados para utilizar o switch-case: int, byte, short, char, String(Java 7 acima),
        // enum, var (com inferência de tipos no Java 14+)



    }
}
