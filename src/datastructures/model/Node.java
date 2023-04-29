package datastructures.model;

public class Node <K, V>{
    K key;
    V value;

    private Node <K, V> next = null;


    //Constructor
    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }
    //Gets And setters
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}