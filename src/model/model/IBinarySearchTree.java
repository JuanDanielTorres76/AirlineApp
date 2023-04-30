package model;

public interface IBinarySearchTree<K, T> {
	
	// For testing purposes only in this exercise.
	public T getRoot();
	// K nombre T objeto completo. El comparable es K
	public T search(K key);
	public void insert(K key, T value);
	public T delete(K key);
	public String inOrder();
}