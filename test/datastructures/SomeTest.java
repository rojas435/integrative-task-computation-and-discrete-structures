package datastructures;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import datastructures.model.ImplementationHash;
import datastructures.model.Priority;

@RunWith(JUnit4.class)
public class HashTableTest {
    @Test
    public void testInsert() {
        ImplementationHash<String, Integer> hashTable = new ImplementationHash<>(3);
        hashTable.insert("uno", 1);
        hashTable.insert("dos", 2);
        hashTable.insert("tres", 3);
        assertEquals(Integer.valueOf(1), hashTable.get("uno"));
        assertEquals(Integer.valueOf(2), hashTable.get("dos"));
        assertEquals(Integer.valueOf(3), hashTable.get("tres"));
    }

    @Test
    public void testRemove() {
        ImplementationHash<String, Integer> hashTable = new ImplementationHash<>(3);
        hashTable.insert("uno", 1);
        hashTable.insert("dos", 2);
        hashTable.insert("tres", 3);
        hashTable.remove("dos");
        assertNull(hashTable.get("dos"));
    }
    
    public void testInsertPriorityQueue() {
        Priority<Integer> priority = new Priority<>();
        priority.insert(5);
        priority.insert(2);
        priority.insert(10);
        priority.insert(8);
        priority.insert(1);
        assertEquals(10, (int)priority.delete());
        assertEquals(8, (int)priority.delete());
        assertEquals(5, (int)priority.delete());
        assertEquals(2, (int)priority.delete());
        assertEquals(1, (int)priority.delete());
        assertTrue(priority.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteWithException() {
        Priority<Integer> priority = new Priority<>();
        priority.delete(); 
    }

    @Test
    public void testIsEmpty() {
        Priority<String> priority = new Priority<>();
        assertTrue(priority.isEmpty());
        priority.insert("a");
        assertFalse(priority.isEmpty());
        priority.delete();
        assertTrue(priority.isEmpty());
    }

    @Test
    public void testDelete() {
        Priority<Integer> priorityQueue = new Priority<Integer>();
        priorityQueue.insert(10);
        priorityQueue.insert(5);
        priorityQueue.insert(15);
        priorityQueue.insert(20);

        assertEquals(Integer.valueOf(20), priorityQueue.delete());
        assertEquals(Integer.valueOf(15), priorityQueue.delete());
        assertEquals(Integer.valueOf(10), priorityQueue.delete());
        assertEquals(Integer.valueOf(5), priorityQueue.delete());
        assertTrue(priorityQueue.isEmpty());
    }

}