#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

/* Struct para representar o bucket */
typedef struct {
    int *array;
    int tam;
    int capacidade;
} Bucket;

/* Cria bucket com capacidade inicial */
Bucket criaBucket(int iniCapacidade) {
    Bucket b;
    b.array = (int *)malloc(iniCapacidade * sizeof(int));
    if (b.array == NULL) {
        fprintf(stderr, "Alocacao de memoria falhou para os buckets\n");
        exit(EXIT_FAILURE);
    }
    b.tam = 0;
    b.capacidade = iniCapacidade;
    return b;
}

/* Insere valor no bucket com expansao automatica */
void insereNoBucket(Bucket *b, int valor) {
    if (b->tam == b->capacidade) {
        b->capacidade *= 2;
        b->array = (int *)realloc(b->array, b->capacidade * sizeof(int));
        if (b->array == NULL) {
            fprintf(stderr, "Bucket expansion failed\n");
            exit(EXIT_FAILURE);
        }
    }
    b->array[b->tam++] = valor;
}

/* Libera memoria do bucket */
void freeBucket(Bucket *b) {
    free(b->array);
    b->tam = 0;
    b->capacidade = 0;
}
/* troca dois inteiros */
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

/* Função auxiliar para ajustar o heap */
void heapify(int *array, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && array[left] > array[largest])
        largest = left;

    if (right < n && array[right] > array[largest])
        largest = right;

    if (largest != i) {
        swap(&array[i], &array[largest]);
        heapify(array, n, largest);
    }
}

/* HeapSort para ordenar os buckets */
void heapSort(int *array, int n) {
    /* Constrói o heap máximo */
    int i;
    for (i = n / 2 - 1; i >= 0; i--)
        heapify(array, n, i);

    /* Extrai elementos do heap um por um */
    for (i = n - 1; i > 0; i--) {
        swap(&array[0], &array[i]);
        heapify(array, i, 0);
    }
}

/* Bucket Sort */
void bucketSort(int *array, int n) {
    int i, j, idx, numBuckets, valMax, bucketIdx;
    
    if (n <= 0) return;

    /* Determina o numero de buckets */
    numBuckets = (int)sqrt(n);
    if (numBuckets < 1) numBuckets = 1;

    /* Encontra valor maximo */
    valMax = array[0];
    for (i = 1; i < n; i++) {
        if (array[i] > valMax) valMax = array[i];
    }

    /* Caso todos valores sejam 0 */
    if (valMax == 0) {
        return; 
    }

    /* Cria buckets */
    Bucket *buckets = (Bucket *)malloc(numBuckets * sizeof(Bucket));
    if (buckets == NULL) {
        fprintf(stderr, "falha para alocar os buckets do array\n");
        exit(EXIT_FAILURE);
    }

    for (i = 0; i < numBuckets; i++) {
        buckets[i] = criaBucket(4); /* tamanho inicial pequeno */
    }

    /* Distribui valores nos buckets */
    for (i = 0; i < n; i++) {
        bucketIdx = (array[i] * numBuckets) / (valMax + 1);
        /* Garante que o indice do bucket esteja nos limites */
        bucketIdx = bucketIdx < 0 ? 0 : bucketIdx;
        bucketIdx = bucketIdx >= numBuckets ? numBuckets - 1 : bucketIdx;
        insereNoBucket(&buckets[bucketIdx], array[i]);
    }

    /* Ordena buckets com HeapSort e concatena resultado */
    idx = 0;

    for (i = 0; i < numBuckets; i++) {
        if (buckets[i].tam > 0) {
            heapSort(buckets[i].array, buckets[i].tam); 
        }
        for (j = 0; j < buckets[i].tam; j++) {
            array[idx++] = buckets[i].array[j];
        }
        freeBucket(&buckets[i]);
    }
}

/* Extrai parte numerica do nome do arquivo para nomear destino */
void extraiNumero(const char *nomeArquivo, char *numStr) {
    int i, j = 0;
    for (i = 0; nomeArquivo[i] != '\0' && j < 19; i++) {
        if (nomeArquivo[i] >= '0' && nomeArquivo[i] <= '9') {
            numStr[j++] = nomeArquivo[i];
        }
        else if (j > 0) {
            break;
        }
    }
    numStr[j] = '\0';
}

int main(int argc, char *argv[]) {
    FILE *arquivoIn, *arquivoOut;
    int *numeros = NULL;
    int capacidade = 100;
    int tam = 0;
    int valor;
    char numStr[20] = {0};
    char nomeSaida[256];
    int i;

    if (argc < 2) {
        printf("Uso: %s <input_file> [output_file]\n", argv[0]);
        return 1;
    }

    /* Abre o arquivo */
    arquivoIn = fopen(argv[1], "r");
    if (arquivoIn == NULL) {
        fprintf(stderr, "Erro: nao pode abrir arquivo de entrada\n");
        return 1;
    }

    /* Le numeros em um array dinamico */
    numeros = (int *)malloc(capacidade * sizeof(int));
    if (numeros == NULL) {
        fclose(arquivoIn);
        fprintf(stderr, "Erro: Alocacao de memoria falhou\n");
        return 1;
    }

    while (fscanf(arquivoIn, "%d", &valor) == 1) {
        if (tam >= capacidade) {
            capacidade *= 2;
            numeros = (int *)realloc(numeros, capacidade * sizeof(int));
            if (numeros == NULL) {
                fclose(arquivoIn);
                fprintf(stderr, "Erro: Realocacao de memoria falhou.\n");
                return 1;
            }
        }
        numeros[tam++] = valor;
    }
    fclose(arquivoIn);

    /* Ordena os numeros */
    bucketSort(numeros, tam);

    /* determina nome do destino */
    extraiNumero(argv[1], numStr);

    if (argc >= 3) {
        strncpy(nomeSaida, argv[2], sizeof(nomeSaida) - 1);
        nomeSaida[sizeof(nomeSaida) - 1] = '\0';
    } else {
        snprintf(nomeSaida, sizeof(nomeSaida), "sorted_%s.txt", numStr);
    }

    /* Escreve numeros ordenados no destino */
    arquivoOut = fopen(nomeSaida, "w");
    if (arquivoOut == NULL) {
        free(numeros);
        fprintf(stderr, "Erro: nao foi possivel criar arquivo de saida\n");
        return 1;
    }

    for (i = 0; i < tam; i++) {
        fprintf(arquivoOut, "%d\n", numeros[i]);
    }
    fclose(arquivoOut);
    free(numeros);

    printf("Ordenacao concluida. Valores armazenados em: %s\n", nomeSaida);
    return 0;
}