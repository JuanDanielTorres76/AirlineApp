package test;

import model.PriorityQueue;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriorityqueueTest {

    // add method.

    @Test
    public void testAddDuplicateElements(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.add(4);
        priorityQueue.add(3);
        Assertions.assertEquals(3, (int) priorityQueue.remove());
        Assertions.assertEquals(4, (int) priorityQueue.remove());
        Assertions.assertEquals(4, (int) priorityQueue.remove());
    }


    @Test
    public void testAddPQueueWithElements() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(8);
        priorityQueue.add(6);
        Assertions.assertEquals(4, priorityQueue.size());
        Assertions.assertEquals(3, priorityQueue.peek());
    }

    @Test
    public void testAddWithCapacityEnlargement() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 1; i <= 100; i++) {
            priorityQueue.add(i);
        }
        priorityQueue.add(101);
        Assertions.assertEquals(101, priorityQueue.size());
        Assertions.assertEquals(1, priorityQueue.peek());
    }

    // remove method
    
    @Test
    public void testRemoveOneElementQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(5);
        int result = priorityQueue.remove();
        Assertions.assertEquals(5, result);
        Assertions.assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void testRemoveFromQueueWithOneElement() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        Assertions.assertEquals(1, priorityQueue.size());
        Assertions.assertEquals(Integer.valueOf(5), priorityQueue.remove());
        Assertions.assertEquals(0, priorityQueue.size());
    }

    @Test
    public void testRemoveSameMinimum() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(1);
        int min1 = priorityQueue.remove();
        Assertions.assertEquals(1, min1);
        int min2 = priorityQueue.remove();
        Assertions.assertEquals(1, min2);
        int min3 = priorityQueue.remove();
        Assertions.assertEquals(1, min3);
        int min4 = priorityQueue.remove();
        Assertions.assertEquals(2, min4);
        int min5 = priorityQueue.remove();
        Assertions.assertEquals(3, min5);
        Assertions.assertTrue(priorityQueue.isEmpty());
    }
    

    // peek method

    @Test
    public void testPeekAfterAddAndRemove() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(6);
        queue.add(5);
        queue.remove();
        queue.remove();
        Assertions.assertEquals(3, (int) queue.peek());
    }

    @Test
    public void testPeekEmpty(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        try {
            queue.peek();
            Assertions.fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            //
        }
    }

    @Test
    public void testPeekAfterAddingLargerElement() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        Assertions.assertEquals(1, (int) queue.peek());
    }

}