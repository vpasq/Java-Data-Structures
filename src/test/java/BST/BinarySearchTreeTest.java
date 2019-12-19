package BST;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator;

public class BinarySearchTreeTest {
  BinarySearchTree<Integer> treeBag;

  @Test
  public void treeSizeWithIterativeStaticMethod() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 4;

    int actual = treeBag.size();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void treeSizeWithRecursiveMethod() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 4;

    int actual = treeBag.size2();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void treeSizeWithStack() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 4;

    int actual = treeBag.size3();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void cloneWithNull() {
    treeBag = new BinarySearchTree<Integer>();
    int expected = 0;

    BinarySearchTree<Integer> actual = (BinarySearchTree<Integer>)treeBag.clone();
    int size = actual.size();

    assertEquals(expected, size);

    treeBag = null;
  }

  @Test
  public void cloneWithElements() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 4;

    BinarySearchTree<Integer> myCLone = (BinarySearchTree<Integer>)treeBag.clone();
    int actual = myCLone.size();

    assertEquals(expected, actual);


    treeBag = null;
  }

  @Test
  public void add() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(5);
    int expected = 3;

    int actual = treeBag.size();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void insert() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(5);
    int expected = 3;

    int actual = treeBag.size();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void countOccurancesWithNullTree() {
    treeBag = new BinarySearchTree<Integer>();
    int expected = 0;

    int size = treeBag.countOccurrences(3);

    assertEquals(expected, size);

    treeBag = null;
  }

  @Test
  public void countOccurances1() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);

    int expected = 1;

    int actual = treeBag.countOccurrences(3);

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void countOccurances2() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    int expected = 0;

    int size = treeBag.countOccurrences(32);

    assertEquals(expected, size);

    treeBag = null;
  }

  @Test
  public void getRightmostData() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 22;

    int actual = treeBag.root.getRightmostData();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void getRight() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 22;

    int actual = treeBag.root.getRight().getRight().getData();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void getLeftmostData() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 3;

    int actual = treeBag.root.getLeftmostData();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void getLeft() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 3;

    int actual = treeBag.root.getLeft().getData();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void remove() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(1);
    treeBag.add(2);
    treeBag.add(15);
    treeBag.add(22);
    boolean expected = true;

    treeBag.root.preOrderPrint();
    System.out.println();

    boolean actual = treeBag.remove(15);

    treeBag.root.preOrderPrint();

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void remove2() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(1);
    treeBag.add(2);
    treeBag.add(15);
    treeBag.add(22);

    treeBag.root.preOrderPrint();
    System.out.println();

    treeBag.remove(15);

    treeBag.root.preOrderPrint();

    treeBag = null;
  }

  @Test
  public void contains() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(1);
    treeBag.add(2);
    treeBag.add(15);
    treeBag.add(22);
    boolean expected = true;

    boolean actual = treeBag.contains(22);

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void get() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(1);
    treeBag.add(2);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 15;

    int actual = treeBag.get(15);

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void getWithNull() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(1);
    treeBag.add(2);
    treeBag.add(15);
    treeBag.add(22);
    Integer expected = null;

    Integer actual = treeBag.get2(5);

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void get2() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(1);
    treeBag.add(2);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 15;

    int actual = treeBag.get2(15);

    assertEquals(expected, actual);

    treeBag = null;
  }

  @Test
  public void inOrder() {
    treeBag = new BinarySearchTree<Integer>();
    treeBag.add(11);
    treeBag.add(3);
    treeBag.add(1);
    treeBag.add(2);
    treeBag.add(15);
    treeBag.add(22);
    int expected = 15;

    Iterator<Integer> it = treeBag.getIterator(BSTInterface.Traversal.Postorder);

    while(it.hasNext()) {
      System.out.println(it.next());
    }


    //assertEquals(expected, actual);

    treeBag = null;
  }

}
