package imp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exercício SD Unip
 *
 * @author Fabiano Felix & Victor Barreiros
 */

public class impl {

    public static void main( String[] args ) {

        //Obtenção de valores para a árvore
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número da árvore binária: ");
        int valor = scanner.nextInt();
        BinaryTree tree = new BinaryTree(valor);
        //While para preencher a árvore até selecionar 0 para parar de adicionar
        while (valor !=0) {
            System.out.println("Digite o próximo número para a árvore binária ou digite 0 para ordená-lo usando Bubblesort: ");
            valor = scanner.nextInt();
            if (valor !=0) {
                tree.insertValue(valor);
            }
        }

        System.out.println("Array obtido percorrendo como pré ordem:" +
                Arrays.toString(tree.percorreArvore(tree.procurarValor(tree.getValue()))));

        System.out.println(("Array ordenado usando Bubblesort:" + tree.bubbleSort(
                tree.percorreArvore(tree.procurarValor(tree.getValue()))
        )));
    }

}
