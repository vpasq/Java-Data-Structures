package BST;

import org.junit.*;
import static org.junit.Assert.*;

public class BSTNodeTest {
  private BSTNode<Integer> btNode;

  @Test
  public void getDataWithInitialData() {
    btNode = new BSTNode<Integer>(3, null, null);
    int expected = 3;

    int actual = btNode.getData();

    assertEquals(expected, actual);

    btNode = null;
  }

  @Test
  public void getDataWithChildrenNull() {
    btNode = new BSTNode<Integer>(3, null, null);
    BSTNode<Integer> expectedLeft = null;
    BSTNode<Integer> expectedRight = null;

    BSTNode<Integer> actualLeft = btNode.getLeft();
    BSTNode<Integer> actualRight = btNode.getRight();

    assertEquals(expectedLeft, actualLeft);
    assertEquals(expectedRight, actualRight);

    btNode = null;
  }

  @Test
  public void setData() {
    btNode = new BSTNode<Integer>(3, null, null);
    int expected = 6;

    btNode.setData(6);
    int actual = btNode.getData();

    assertEquals(expected, actual);

    btNode = null;
  }

  @Test
  public void isLeaf() {
    btNode = new BSTNode<Integer>(3, null, null);
    boolean expected = true;

    boolean actual = btNode.isLeaf();

    assertEquals(expected, actual);

    btNode = null;
  }

  @Test
  public void treeDepth() {
    final String LEFT_QUESTION = "Are you bigger than a cat?";
    final String ROOT_QUESTION = "Are you a mamal?";
    final String RIGHT_QUESTION = "Do you live underwater?";
    final String Animal1 = "Kangaroo";
    final String Animal2 = "Mouse";
    final String Animal3 = "Trout";
    final String Animal4 = "Robin";

    BSTNode<String> root;
    BSTNode<String> child;

    root = new BSTNode<String>(ROOT_QUESTION, null, null);

    // create and attach the left subtree
    child = new BSTNode<String>(LEFT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal1, null, null));
    child.setRight(new BSTNode<String>(Animal2, null, null));
    root.setLeft(child);

    // create and attach the right subtree
    child = new BSTNode<String>(RIGHT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal3, null, null));
    child.setRight(new BSTNode<String>(Animal4, null, null));
    root.setRight(child);


    BSTNode<String> child2;
    child2 = new BSTNode<String>(RIGHT_QUESTION, null, null);
    child2.setLeft(new BSTNode<String>(Animal3, null, null));
    child2.setRight(new BSTNode<String>(Animal4, null, null));
    child.setLeft(child2);


    child2 = new BSTNode<String>(RIGHT_QUESTION, null, null);
    child2.setLeft(new BSTNode<String>(Animal3, null, null));
    child2.setRight(new BSTNode<String>(Animal4, null, null));
    child.setRight(child2);

    int expected = 3;

    int actual = BSTNode.treeDepth(root);

    assertEquals(expected, actual);

    root = null;
    child = null;

  }

  @Test
  public void treeDepthWithOnlyOneNode() {
    final String ROOT_QUESTION = "Are you a mamal?";
    BSTNode<String> root;
    root = new BSTNode<String>(ROOT_QUESTION, null, null);
    int expected = 0;

    int actual = BSTNode.treeDepth(root);

    assertEquals(expected, actual);

    root = null;
  }

  @Test
  public void treeDepthWithNullTree() {
    BSTNode<String> root = null;
    int expected = -1;

    int actual = BSTNode.treeDepth(root);

    assertEquals(expected, actual);

    root = null;
  }

  @Test
  public void treeSizeStaticMethod() {
    final String ROOT_QUESTION = "Are you a mamal?";
    final String LEFT_QUESTION = "Are you bigger than a cat?";
    final String RIGHT_QUESTION = "Do you live underwater?";
    final String Animal1 = "Kangaroo";
    final String Animal2 = "Mouse";
    final String Animal3 = "Trout";
    final String Animal4 = "Robin";

    BSTNode<String> root;
    BSTNode<String> child;

    root = new BSTNode<String>(ROOT_QUESTION, null, null);

    // create and attach the left subtree
    child = new BSTNode<String>(LEFT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal1, null, null));
    child.setRight(new BSTNode<String>(Animal2, null, null));
    root.setLeft(child);

    // create and attach the right subtree
    child = new BSTNode<String>(RIGHT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal3, null, null));
    child.setRight(new BSTNode<String>(Animal4, null, null));
    root.setRight(child);

    int expected = 7;

    int actual = BSTNode.treeSize(root);

    assertEquals(expected, actual);

    root = null;
    child = null;

  }

  @Test
  public void treeSizeWithNullTree() {
    BSTNode<String> root = null;
    int expected = 0;

    int actual = BSTNode.treeSize(root);

    assertEquals(expected, actual);

    root = null;
  }

  @Test
  public void preorderPrint() {
    final String ROOT_QUESTION = "Are you a mamal?";
    final String LEFT_QUESTION = "Are you bigger than a cat?";
    final String RIGHT_QUESTION = "Do you live underwater?";
    final String Animal1 = "Kangaroo";
    final String Animal2 = "Mouse";
    final String Animal3 = "Trout";
    final String Animal4 = "Robin";

    BSTNode<String> root;
    BSTNode<String> child;

    root = new BSTNode<String>(ROOT_QUESTION, null, null);

    // create and attach the left subtree
    child = new BSTNode<String>(LEFT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal1, null, null));
    child.setRight(new BSTNode<String>(Animal2, null, null));
    root.setLeft(child);

    // create and attach the right subtree
    child = new BSTNode<String>(RIGHT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal3, null, null));
    child.setRight(new BSTNode<String>(Animal4, null, null));
    root.setRight(child);

    //root.preorderPrint();

    root = null;
    child = null;
  }


  @Test
  public void inorderPrint() {
    final String ROOT_QUESTION = "Are you a mamal?";
    final String LEFT_QUESTION = "Are you bigger than a cat?";
    final String RIGHT_QUESTION = "Do you live underwater?";
    final String Animal1 = "Kangaroo";
    final String Animal2 = "Mouse";
    final String Animal3 = "Trout";
    final String Animal4 = "Robin";

    BSTNode<String> root;
    BSTNode<String> child;

    root = new BSTNode<String>(ROOT_QUESTION, null, null);

    // create and attach the left subtree
    child = new BSTNode<String>(LEFT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal1, null, null));
    child.setRight(new BSTNode<String>(Animal2, null, null));
    root.setLeft(child);

    // create and attach the right subtree
    child = new BSTNode<String>(RIGHT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal3, null, null));
    child.setRight(new BSTNode<String>(Animal4, null, null));
    root.setRight(child);

    //root.inorderPrint();

    root = null;
    child = null;
  }

  @Test
  public void postorderPrint() {
    final String ROOT_QUESTION = "Are you a mamal?";
    final String LEFT_QUESTION = "Are you bigger than a cat?";
    final String RIGHT_QUESTION = "Do you live underwater?";
    final String Animal1 = "Kangaroo";
    final String Animal2 = "Mouse";
    final String Animal3 = "Trout";
    final String Animal4 = "Robin";

    BSTNode<String> root;
    BSTNode<String> child;

    root = new BSTNode<String>(ROOT_QUESTION, null, null);

    // create and attach the left subtree
    child = new BSTNode<String>(LEFT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal1, null, null));
    child.setRight(new BSTNode<String>(Animal2, null, null));
    root.setLeft(child);

    // create and attach the right subtree
    child = new BSTNode<String>(RIGHT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal3, null, null));
    child.setRight(new BSTNode<String>(Animal4, null, null));
    root.setRight(child);

    //root.postorderPrint();

    root = null;
    child = null;
  }


  @Test
  public void postorderPrintStatic() {
    final String ROOT_QUESTION = "Are you a mamal?";
    final String LEFT_QUESTION = "Are you bigger than a cat?";
    final String RIGHT_QUESTION = "Do you live underwater?";
    final String Animal1 = "Kangaroo";
    final String Animal2 = "Mouse";
    final String Animal3 = "Trout";
    final String Animal4 = "Robin";

    BSTNode<String> root;
    BSTNode<String> child;

    root = new BSTNode<String>(ROOT_QUESTION, null, null);

    // create and attach the left subtree
    child = new BSTNode<String>(LEFT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal1, null, null));
    child.setRight(new BSTNode<String>(Animal2, null, null));
    root.setLeft(child);

    // create and attach the right subtree
    child = new BSTNode<String>(RIGHT_QUESTION, null, null);
    child.setLeft(new BSTNode<String>(Animal3, null, null));
    child.setRight(new BSTNode<String>(Animal4, null, null));
    root.setRight(child);

    //BSTNode.preorderPrint(root);

    root = null;
    child = null;
  }

}