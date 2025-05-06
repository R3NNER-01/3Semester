public class VetoresMatrizes_11 {
    public static void main(String[] args) {

        /* Os vetores são alocações contínuas na memória que auxiliam no agrupamento de dados semelhantes em
        uma única variável, apenas com um índice para cada registro. Esta ferramenta auxilia no acesso da memória,
        pois conhecendo a posição inicial do vetor, podemos encontrar as respectivas posições na memória, já que estão
        alocadas em sequência. Segue nos exemplos abaixo como é realizada esta alocação e atribuição de valores.
         */


        // VETORES UNIDIMENSIONAIS:

        int[] vetor= new int[10];  // vetor declarado e inicializado na mesma linha (mais comum).

        int[] vetor2;
        vetor2 = new int[2];       //vetor declarado em uma linha e inicializado em outra.


        //podemos inicializar o vetor diretamente com os valores:
        int[] vetor3 = { 1, 2, 3, 4, 5};


        // MATRIZES:
        //é uma alocação simples na memória, porém com mais dimensões (linhas, colunas, etc) para facilitar
        //o acesso da célula.

        //declarando e inicializando após:
        int[][]matriz;
        matriz = new int[10][10];

        //declarando e inicializando juntamente:
        int[][] matriz2 = new int[5][5];

        //inserindo diretamente valores:
        int[][] matriz3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        // podemos inicializar uma matriz irregular também, como vetores de vetores com tamanho variável:
        int[][]matriz4 = new int[4][];

        matriz4[0] = new int[3];
        matriz4[1] = new int[2];
        matriz4[2] = new int[5];
        matriz4[3] = new int[4];


        // para a escrita de valores em posições específicas no vetor utilizamos
        // do índice da posição - 1, já que o índice começa em 0:

        // registrar o valor 3 na posição 2 do vetor:
        vetor[1] = 3;

        int i = 4;
        int j = 3;
        //registrar o valor de i na posição j+1 do vetor:
        vetor[j] = i;

        // para matrizes, utilizamos dos índices de linhas e colunas, respectivamente:

        // registrar o valor 10 na posição na linha 3 coluna 2 do vetor:
        matriz[2][1] = 10;

        int z = 10;
        // registrar o valor de z na matriz na linha i+1 e coluna j+1:
        matriz[i][j] = 10;



    }

}
