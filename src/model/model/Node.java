package model;

public class Node <K, T>{
    private K key;
    private T value;
    private Node<K, T> left;
    private Node<K, T> right;

    public Node(K key, T value){
        this.key = key;
        this.value = value;
    }

    public Node(int i) {
    }

    public K getKey(){
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<K,T> getLeft() {
        return this.left;
    }

    public void setLeft(Node<K,T> left) {
        this.left = left;
    }

    public Node<K,T> getRight() {
        return this.right;
    }

    public void setRight(Node<K,T> right) {
        this.right = right;
    }

}