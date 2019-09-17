package br.ufrn.imd.edb2;

public class Node {
    private Node left = null;
    private Node right = null;
    private int value;

    public Node(){ }

    public Node(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    public Node getLeft(){ return left;}
    public Node getRight(){ return right;}

    public void insert(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }
        return null;
    }

    public Node checarMaiorFilho(Node arvore){

        if(arvore.right == null){
            return arvore;
        }
        return checarMaiorFilho(arvore.right);
    }

    private boolean hasLeftChild() {
        return this.left != null;
    }

    private boolean hasRightChild() {
        return this.right != null;
    }

    private boolean isLeaf() {
        return !this.hasLeftChild() && !this.hasRightChild();
    }

    private boolean has2Children() {
        return this.hasLeftChild() && this.hasRightChild();
    }

    private boolean hasOnlyOneChild() {
        return (hasRightChild() && !hasLeftChild()) || (!hasRightChild() && hasLeftChild());
    }
    public boolean delete(int key) {
        return delete(key, null);
    }

    private boolean delete(int key, Node parent) {
        Node node = search(key);
        if (node == null) {
            return false;
        }

        if(this == node){
            //No folha
            if (isLeaf()) {
                if (parent != null) {
                    if (key < parent.getValue()) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return true;
                }
                //No com 1 filho
            } else if (hasOnlyOneChild()) {
                if (hasLeftChild()) {
                    this.value = node.left.getValue();
                    return this.left.delete(this.getValue(), this);
                } else {
                    this.value = node.right.getValue();
                    return this.right.delete(this.getValue(), this);
                }
                //No com 2 filhos
            } else {
                Node tmp = checarMaiorFilho(node.left);
                this.value = tmp.value;
                return this.left.delete(this.getValue(), this);
            }
        } else if (key < this.getValue()) {
            return this.left.delete(key, this);
        } else {
            return this.right.delete(key, this);
        }
        return false;
    }


}
