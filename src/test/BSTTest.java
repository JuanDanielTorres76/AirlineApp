package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import model.BST;
import model.Node;

public class BSTTest<K> {
    private BST<Integer, String> bst;

    @Before
    public void setUp() {
        bst = new BST<>(new Node<>(10, "root"));
        bst.insert(6, "A");
        bst.insert(12, "B");
        bst.insert(3, "C");
        bst.insert(8, "D");
        bst.insert(11, "E");
        bst.insert(14, "F");
    }

    @Test
    public void testInsertSingleNode() {
        bst.insert(5, "G");
        assertEquals("G", bst.search(5));
    }

    @Test
    public void testInsertExistingNode() {
        bst.insert(6, "H");
        assertEquals("H", bst.search(6));
    }

    @Test
    public void testInsertNewNode() {
        bst.insert(4, "I");
        assertEquals("I", bst.search(4));
    }
    
    @Test
    public void testInsertLargerTree() {
        bst.insert(15, "J");
        assertEquals("J", bst.search(15));
    }
    
    @Test
    public void testInsertSmallerTree() {
        bst.insert(2, "K");
        assertEquals("K", bst.search(2));
    }
    
    @Test
    public void testInsertSameSubtree() {
        bst.insert(7, "L");
        assertEquals("L", bst.search(7));
    }

    @Test
    public void testDeleteExistingNode() {
        bst.delete(6);
        assertNull(bst.search(6));
    }
    
    @Test
    public void testDeleteNodeWithNoChildren() {
    BST<Integer, String> bst = new BST<>(new Node<>(5, "A"));
    bst.insert(15, "B");
    bst.insert(18, "C");
    bst.delete(15);
    assertNull(bst.search(15));
}

    @Test
    public void testDeleteNodeWithOneChild() {
    BST<Integer, String> bst = new BST<>(new Node<>(5, "A"));

    bst.insert(21, "D");
    bst.delete(18);
    assertNull(bst.search(18));
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
    BST<Integer, String> bst = new BST<>(new Node<>(5, "A"));
    bst.insert(15, "B");
    bst.insert(18, "C");
    bst.insert(19, "E");
    bst.delete(18);
    assertNull(bst.search(18));
    }

    @Test
    public void testInOrderDesordered() {
        Node<Integer, String> root = new Node<>(10, "A");
        BST<Integer, String> bst = new BST<>(root);
        bst.insert(15, "B");
        bst.insert(7, "C");
        bst.insert(3, "D");
        bst.insert(8, "E");
        bst.insert(12, "F");
        bst.insert(20, "G");
        String expected = "D C E A F B G ";
        String actual = bst.inOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testInOrderOrdered() {
    Node<Integer, String> root = new Node<>(1, "A");
    BST<Integer, String> bst = new BST<>(root);
    bst.insert(2, "B");
    bst.insert(3, "C");
    bst.insert(4, "D");
    bst.insert(5, "E");
    String expected = "A B C D E ";
    String actual = bst.inOrder();
    assertEquals(expected, actual);
    }

    @Test
    public void testInOrderUnElemento() {
    Node<Integer, String> root = new Node<>(1, "A");
    BST<Integer, String> bst = new BST<>(root);
    String expected = "A ";
    String actual = bst.inOrder();
    assertEquals(expected, actual);
    }


}