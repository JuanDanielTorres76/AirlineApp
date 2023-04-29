package model;
public class BST <K extends Comparable<K>, T> implements IBinarySearchTree<K, T>{
    private Node<K, T> root;

    public BST(Node<K, T> root){
        this.root = root;
    }

    public T getRoot() {
        if (root == null) {
            return null;
        }
        return root.getValue();
    }

    // activation method.

    public T search(K key) {
        Node<K, T> node = searchNode(root, key);
        if (node == null) {
            return null;
        } else {
            return node.getValue();
        }
    }
    
    private Node<K, T> searchNode(Node<K, T> node, K key) {
        if (node == null || node.getKey().equals(key)) {
            return node;
        }
        int comparison = key.compareTo(node.getKey());
        if (comparison < 0) {
            return searchNode(node.getLeft(), key);
        } else {
            return searchNode(node.getRight(), key);
        }
    }

    // activation method.

    public void insert(K key, T value) {
        root = insertNode(root, key, value);
    }

    private Node<K, T> insertNode(Node<K, T> node, K key, T value) {
        if (node == null) {
            return new Node<>(key, value);
        }
        int comparison = key.compareTo(node.getKey());
        if (comparison < 0) {
            node.setLeft(insertNode(node.getLeft(), key, value));
        } else if (comparison > 0) {
            node.setRight(insertNode(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }
        return node;
    }

    // activation method.

    public T delete(K key) {
        Node<K, T> node = deleteNode(root, key);
        if (node == null) {
            return null;
        }
        else{
            return node.getValue();
        }
    }

    private Node<K, T> deleteNode(Node<K, T> node, K key) {
        if (node == null) {
            return null;
        }
        int comparasion = key.compareTo(node.getKey());
        if (comparasion < 0) {
            node.setLeft(deleteNode(node.getLeft(), key));
        } else if (comparasion > 0) {
            node.setRight(deleteNode(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                Node<K, T> minNode = findMin(node.getRight());
                node.setKey(minNode.getKey());
                node.setValue(minNode.getValue());
                node.setRight(deleteMin(node.getRight()));
            }
        }
        return node;
    }

    private Node<K, T> deleteMin(Node<K, T> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

    private Node<K, T> findMin(Node<K, T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    // activation method.

    public String inOrder() {
        StringBuilder msj = new StringBuilder();
        Node<K, T> current = root;
        while (current != null) {
            if (current.getLeft() == null) {
                msj.append(current.getValue().toString()).append(" ");
                current = current.getRight();
            } else {
                Node<K, T> predecessor = current.getLeft();
                while (predecessor.getRight() != null && predecessor.getRight() != current) {
                    predecessor = predecessor.getRight();
                }
                if (predecessor.getRight() == null) {
                    predecessor.setRight(current);
                    current = current.getLeft();
                } else {
                    predecessor.setRight(null);
                    msj.append(current.getValue().toString()).append(" ");
                    current = current.getRight();
                }
            }
        }
        return msj.toString();
    }
    
}