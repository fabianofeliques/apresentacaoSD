package imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTree {


    private int value;

    private BinaryTree left;

    private BinaryTree right;

    public BinaryTree(int newValue) {
        this.value = newValue;
    }

    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }


    public BinaryTree getLeft() {
        return left;
    }


    public void setLeft(BinaryTree left) {
        this.left = left;
    }


    public BinaryTree getRight() {
        return right;
    }


    public void setRight(BinaryTree right) {
        this.right = right;
    }


    //Método para somar todos os nodos subsequentes daquele fornecido pelo usuario e encontrado no método procurarValor
    public int[] percorreArvore(BinaryTree tree) {

        ArrayList<Integer> subsequentes = new ArrayList<>();

        tree.numeroPorNodo(tree,subsequentes);

        int[] v = new int[subsequentes.size()];

        for (int i=0; i < v.length; i++)
        {
            v[i] = Integer.parseInt(subsequentes.get(i).toString());
        }

        return v;
    }


    public String bubbleSort(int[] v){


        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
     return Arrays.toString(v);
    }
    //Método para inserir os números fornecidos pelo usuário
    public void insertValue(int valor) {


        if (valor < this.getValue()) {
            if (this.getLeft() != null) {
                this.getLeft().insertValue(valor);
            } else {
                this.setLeft(new BinaryTree(valor));
            }
        } else if (valor > this.getValue()) {
            if (this.getRight() != null) {
                this.getRight().insertValue(valor);
            } else {
                this.setRight(new BinaryTree(valor));
            }
        }

    }

    //Método para encontra os números subsequentes diretos pelo nodo
    public  void numeroPorNodo(BinaryTree tree, List<Integer> subsequentes) {
        if(tree != null){
            if (subsequentes.size()==0) {
                subsequentes.add(tree.getValue());
                if (tree.getLeft()!=null) {
                    subsequentes.add(tree.getLeft().getValue());
                }
                if (tree.getRight()!=null) {
                    subsequentes.add(tree.getRight().getValue());
                }
            }else {
                if (tree.getLeft()!=null) {
                    subsequentes.add(tree.getLeft().getValue());
                }
                if (tree.getRight()!=null) {
                    subsequentes.add(tree.getRight().getValue());
                }
            }
            if (tree.getLeft()!=null) {
                numeroPorNodo(tree.getLeft(),subsequentes);
            }
            if (tree.getRight()!=null) {
                numeroPorNodo(tree.getRight(),subsequentes);
            }

        }
    }

    // Método para procurar o valor solicitado pelo usuario para o nodo que deverá ser somado os subsequentes
    public BinaryTree procurarValor(int valor) {

        if (valor == this.getValue()) {
            return this;
        } else {
            if (valor > this.getValue()) {
                if (this.getRight() == null) {
                    return null;
                }
                return this.getRight().procurarValor(valor);
            } else {
                if (this.getLeft() == null) {
                    return null;
                }
                return this.getLeft().procurarValor(valor);
            }
        }
    }
}
