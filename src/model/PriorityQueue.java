import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>> {

    private T[] heap;

    private int size;

    private final int DEFAULT_CAPACITY = 100;

    public PriorityQueue() {

        heap = (T[]) new Comparable[DEFAULT_CAPACITY];

        size = 0;

    }

    public void add(T element) {

        if (size >= heap.length - 1) {

            enlargeHeap();

        }

        heap[size + 1] = element;

        size++;

        percolateUp(size);

    }

    public T remove() {

        if (isEmpty()) {

            throw new NoSuchElementException();

        }

        T min = heap[1];

        heap[1] = heap[size];

        heap[size] = null;

        size--;

        percolateDown(1);

        return min;

    }

    public boolean isEmpty() {

        return size == 0;

    }

    public int size() {

        return size;

    }

    public T peek() {

        if (isEmpty()) {

            throw new NoSuchElementException();

        }

        return heap[1];

    }

    private void percolateUp(int index) {

        while (index > 1 && heap[index].compareTo(heap[parent(index)]) < 0) {

            swap(index, parent(index));

            index = parent(index);

        }

    }

    private void percolateDown(int index) {

        while (leftChild(index) <= size) {

            int child = leftChild(index);

            if (child + 1 <= size && heap[child + 1].compareTo(heap[child]) < 0) {

                child++;

            }

            if (heap[index].compareTo(heap[child]) > 0) {

                swap(index, child);

                index = child;

            } else {

                break;

            }
        }
    }

    private void enlargeHeap() {

        T[] newHeap = (T[]) new Comparable[heap.length * 2];

        System.arraycopy(heap, 1, newHeap, 1, size);

        heap = newHeap;

    }

    private void swap(int index1, int index2) {

        T temp = heap[index1];

        heap[index1] = heap[index2];

        heap[index2] = temp;

    }

    private int parent(int index) {

        return index / 2;

    }

    private int leftChild(int index) {

        return index * 2;
        
    }
}