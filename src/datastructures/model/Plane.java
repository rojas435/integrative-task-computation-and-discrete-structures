package datastructures.model;

public class Plane<K extends Comparable<K>, V> {

    private int length;

    private HashTable <K, V>[] list;

    //Constructor

    public Plane(int length) {

        this.length = length;

        list = new HashTable[length];
    }

    public int getLength() {

        return length;
    }

    public void setLength(int length) {

        this.length = length;
    }

    public void setList(HashTable<K, V>[] list) {

        this.list = list;
    }

    public HashTable<K, V>[] getList() {

        return list;
    }

    // Metodo de insercion, este recibe el hash code de la Key
    //donde esta puede ser +,- o 0, este metodo su unica funcion es determinar
    // si el hash code es negativo y si no se mantiene igual
    public int hash(K key){

        int hash = key.hashCode();

        if(hash < 0){

            hash = -hash;
        }

        return hash % length;
    }
    
    public void insert(K key, V value) {

        int index = hash(key);

        HashTable<K, V> node = new HashTable<>(key, value);

        if (list[index] == null) {

            list[index] = node;

        } else {

            HashTable<K, V> current = list[index];

            while (current.getNext() != null) {

                current = current.getNext();

            }

            current.setNext(node);

            node.setPrev(current);
        }
    }

    public V get(K key){

        int index=hash(key);

        HashTable<K,V> node=list[index];

        while(node!=null){

            if(node.getKey().compareTo(key)==0){

                return node.getValue();
            }

            node=node.getNext();
        }

        return null;
    }

    public void remove(K key) {

        int index = hash(key);

        HashTable<K, V> current = list[index];

        HashTable<K, V> prev = null;

        while (current != null && !current.getKey().equals(key)) {

            prev = current;
            
            current = current.getNext();
        }

        if (current == null) {

            return; // La clave no se encontró en la tabla
        }

        if (prev == null) {

            list[index] = current.getNext();

        } else {

            prev.setNext(current.getNext());

        }

        if (current.getNext() != null) {

            current.getNext().setPrev(prev);
        }
    }
    
    //sb instancia del StringBuilder

    public String print() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {

            sb.append("[ ");

            HashTable<K, V> node = list[i];

            while (node != null) {

                sb.append(node.getValue().toString());

                if (node.getNext() != null) {

                    sb.append(", ");
                }

                node = node.getNext();
            }

            sb.append(" ]\n");
            
        }
        return sb.toString();
    }




}
