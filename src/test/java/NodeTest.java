
import org.junit.*;
import static org.junit.Assert.*;


public class NodeTest<E> {
  private Node<Integer> linkedList;

  @Test
  public void constructWithInitialDataAndNullReference() {
    linkedList = new Node<Integer>(42, null);
    int expectedInitialData = 42;
    Node<Integer> expectedInitialLink = null;

    int actualInitialData = linkedList.getData();
    Node<Integer> actualInitialLink = linkedList.getLink();

    assertEquals(expectedInitialData, actualInitialData);
    assertEquals(expectedInitialLink, actualInitialLink);

    linkedList = null;
  }

  @Test
  public void getData() {
    linkedList = new Node<Integer>(42, null);
    int expectedInitialData = 42;

    int actualInitialData = linkedList.getData();

    assertEquals(expectedInitialData, actualInitialData);

    linkedList = null;
  }

  @Test
  public void getLink() {
    linkedList = new Node<Integer>(42, new Node<Integer>(20, null));
    Node<Integer> expected = new Node<Integer>(20, null);

    Node<Integer> actual = linkedList.getLink();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void setData() {
    linkedList = new Node<Integer>(42, null);
    linkedList.setData(41);
    int expected = 41;

    int actual = linkedList.getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  //Todo:
  @Test
  public void setLink() {
    linkedList = new Node<Integer>(42, null);
    linkedList.setLink(new Node<Integer>(55, null));
    int expected = linkedList.getLink().getData();

    int actual = linkedList.getLink().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listLength() {
    linkedList = new Node<Integer>(1, null);
    linkedList.addNodeAfter(2);
    linkedList.addNodeAfter(3);
    int expected = 3;

    int actual = Node.listLength(linkedList);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listLengthWithNull() {
    linkedList = null;
    int expected = 0;

    int actual = Node.listLength(linkedList);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listSearch() {
    linkedList = new Node<Integer>(1, null);
    linkedList.addNodeAfter(2);
    linkedList.addNodeAfter(3);  // list = 1, 3, 2

    Node<Integer> expected = new Node<Integer>(3, new Node<Integer>(2, null));

    Node<Integer> actual = Node.listSearch(linkedList, 3);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listSearchWithNull() {
    linkedList = null;
    Node<Integer> expected = null;

    Node<Integer> actual = Node.listSearch(linkedList, 2);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPosition() {
    linkedList = new Node<Integer>(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3

    Node<Integer> expected = new Node<Integer>(4, new Node<Integer>(3, null));

    Node<Integer> actual = Node.listPosition(linkedList, 2);

    System.out.println(expected.equals(actual));

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPositionWithNull() {
    linkedList = null;
    Node<Integer> expected = null;

    Node<Integer> actual = Node.listPosition(linkedList, 11);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPositionWithNegative() {
    linkedList = new Node<Integer>(11, null);

    try {
      Node<Integer> actual = Node.listPosition(linkedList, -3);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("position < 0 : Invoked from listPosition()"));
    }

    linkedList = null;
  }

  @Test
  public void listCopy() {
    linkedList = new Node<Integer>(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    Node<Integer> expected = new Node<Integer>(11, new Node<Integer>(4, new Node<Integer>(3, null)));

    Node<Integer> actual = Node.listCopy(linkedList);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listCopyWithNull() {
    linkedList = null;
    Node<Integer> expected = null;

    Node<Integer> actual = Node.listCopy(linkedList);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listCopyWithTail() {
    linkedList = new Node<Integer>(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    Object[] expected = new Object[2];

    expected[0] = new Node<Integer>(11, new Node<Integer>(4, new Node<Integer>(3, null)));
    expected[1] = new Node<Integer>(3, null);

    Object[] actual = Node.listCopyWithTail(linkedList);

    assertArrayEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listCopyWithTailWithNull() {
    linkedList = null;
    Node<Integer>[] expected = null;

    Node<Integer>[] actual = (Node<Integer>[])Node.listCopyWithTail(linkedList);

    assertArrayEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPart() {
    linkedList = new Node<Integer>(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    Object[] expected = new Object[2];
    expected[0] = new Node<Integer>(4, new Node<Integer>(3, null));
    expected[1] = new Node<Integer>(3, null);

    Node<Integer> start = linkedList.getLink();
    Node<Integer> end = linkedList.getLink().getLink();
    Object[] actual = Node.listPart(start, end);

    assertArrayEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPartWhithStartIsNull() {
    linkedList = new Node<Integer>(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    Node<Integer> start = null;
    Node<Integer> end = linkedList.getLink().getLink();

    try {
      Object[] actual = Node.listPart(start, end);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("start is null : Invoked from listPart()"));
    }

    linkedList = null;
  }

  @Test
  public void listPartWhithEndIsNull() {
    linkedList = new Node<Integer>(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    Node<Integer> start = linkedList.getLink();
    Node<Integer> end = null;

    try {
      Object[] actual = Node.listPart(start, end);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("end is null : Invoked from listPart()"));
    }

    linkedList = null;
  }

  @Test
  public void listPartWithEndNotFound() {
    linkedList = new Node<Integer>(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    Node<Integer> start = linkedList;
    Node<Integer> end = new Node<Integer>(8, null);

    try {
      Object[]  actual = Node.listPart(start, end);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("end node was not found on this list"));
    }

    linkedList = null;
  }

  @Test
  public void countOccurrences() {
    linkedList = new Node<Integer>(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);
    linkedList.addNodeAfter(3);// list = 11, 5, 4 ,3

    int expected = 2;

    int actual = Node.countOccurrences(linkedList, 3);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void equals1() {
    Node<Integer> node1 = new Node<Integer>(4, new Node<Integer>(3, null));
    Node<Integer> node2 = new Node<Integer>(4, new Node<Integer>(3, null));
    boolean expected = true;

    boolean actual = node1.equals(node2);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void equals2() {
    Node<Integer> node1 = new Node<Integer>(4, null);
    Node<Integer> node2 = new Node<Integer>(4, new Node<Integer>(3, null));
    boolean expected = false;

    boolean actual = node1.equals(node2);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void equals3() {
    Node<Integer> node1 = new Node<Integer>(4, new Node<Integer>(3, null));
    Node<Integer> node2 = new Node<Integer>(4, null);
    boolean expected = false;

    boolean actual = node1.equals(node2);

    assertEquals(expected, actual);

    linkedList = null;
  }
}



