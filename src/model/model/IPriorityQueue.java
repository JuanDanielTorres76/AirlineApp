package model;
public interface IPriorityQueue<T extends Comparable<T>> {
    
    public void add(T element);
    
    public T remove();

    public boolean isEmpty();

    public int size();

    public T peek();
    
}
