package datastructures.model;

public class HashTable<K extends Comparable<K>,V>{
    private K key;
    private V value;

    private HashTable <K, V> next;

    private HashTable <K, V> prev;

    //Constructor
    public HashTable(K key, V value){
        this.key = key;
        this.value = value;
    }

    //Getters and Setters
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public HashTable<K, V> getNext() {
        return next;
    }

    public HashTable<K, V> getPrev() {
        return prev;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(HashTable<K, V> next) {
        this.next = next;
    }

    public void setPrev(HashTable<K, V> prev) {
        this.prev = prev;
    }
}
