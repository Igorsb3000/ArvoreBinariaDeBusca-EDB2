package br.ufrn.imd.edb2;

public class ArvoreBinariaBusca {
    private Node raiz = null;

    public Node getRaiz(){
        return raiz;
    }
    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(Node node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }
    public boolean delete(int key){
        if(raiz == null){
            System.out.println("Arvore vazia!");
            return false;
        }
        if(raiz.getValue() == key){
            //No raiz folha
            if(raiz.getLeft() == null && raiz.getRight() == null){
                System.out.println("No raiz folha removido");
                raiz = null;
                return true;
            }
        }
        return raiz.delete(key);
    }

}

