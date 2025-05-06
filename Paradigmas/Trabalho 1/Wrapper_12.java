import java.util.ArrayList;
import java.util.List;

public class Wrapper_12 {
    public static void main(String[] args) {
        // Classes wrapper em Java

        /*
            Em java, temos as classes Wrapper que encapsulam os tipos primitvos dentro de objetos, para
            ser possível utilizar estes dados em coleções ou APIs que exigem objetos ao invés de tipos
             primitivos. As Wrapper possuem métodos eficientes, como conversão de tipos, comparação e
             manipulação de valores.
         */


        Integer b = 3;  // autoboxing (int -> Integer)
        int dado = b;

        int numero = Integer.parseInt("123"); // método de conversão de tipo utilizando classe Wrapper


        // Vantagens e Desvantagens


        //Vantagens:
            // -Uso em coleções
                List<Integer> numeros = new ArrayList<>();
                numeros.add(10); // autoboxing: int -> Integer

            // -Métodos Utilitários
                int num = Integer.parseInt("100"); // converte String para int
                String texto = Integer.toString(50); // converte int para String

            //-Trabalho com Generics
                class Caixa<T> {
                    private T valor;
                    public void setValor(T valor) { this.valor = valor; }
                    public T getValor() { return valor; }
                }
                Caixa<Integer> caixa = new Caixa<>();
                caixa.setValor(42); // funciona porque Integer é um objeto

            // -Possibilidade de valor nulo (NULL)
                Integer idade = null; // válido
                int idade2 = null;  // errado, tipos primitivos não aceitam null

       // Desvantagens:
            // Maior consumo de memória
                // armazena metadados e referências além do valor primitivo
                int numPrimitivo = 10;   // ocupa 4 bytes
                Integer numWrapper = 10; // pode ocupar até 16 bytes ou mais


            // Menor performance
                //são mais lentas que os tipos primitivos, pois exigem autoboxing/unboxing e alocações na heap
                int a = 5, b = 10;
                int soma = a + b; // rápido

                Integer x = 5, y = 10;
                Integer somaObj = x + y; // mais lento devido ao autoboxing/unboxing



    }
}
