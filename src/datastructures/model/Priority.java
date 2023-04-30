package datastructures.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Priority <T extends  Comparable<T>> {
    
    private ArrayList<T> heap;

    public Priority(){
        heap = new ArrayList<>();
    }
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    
    public void print() {
        System.out.println("Primera Clase\n");
        for (T item : heap) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public void insert(T item) {
        heap.add(item);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0 && heap.get(childIndex).compareTo(heap.get(parentIndex)) > 0) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public T delete() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        T root = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);
        heap.set(0, lastItem);

        int parent = 0;
        int leftChild = 1;
        int rightChild = 2;

        while (leftChild < heap.size()) {
            int maxChild = leftChild;
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) > 0) {
                maxChild = rightChild;
            }

            if (heap.get(parent).compareTo(heap.get(maxChild)) < 0) {
                swap(parent, maxChild);
                parent = maxChild;
                leftChild = 2 * parent + 1;
                rightChild = 2 * parent + 2;
            } else {
                break;
            }
        }
        return root;
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
