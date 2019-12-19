
import org.junit.*;
import static org.junit.Assert.*;

public class IntNodeTest {
  private IntNode linkedList;

  @Test
  public void constructWithInitialDataAndNullReference() {
    linkedList = new IntNode(42, null);
    int expectedInitialData = 42;
    IntNode expectedInitialLink = null;

    int actualInitialData = linkedList.getData();
    IntNode actualInitialLink = linkedList.getLink();

    assertEquals(expectedInitialData, actualInitialData);
    assertEquals(expectedInitialLink, actualInitialLink);

    linkedList = null;
  }

  @Test
  public void getData() {
    linkedList = new IntNode(42, null);
    int expectedInitialData = 42;

    int actualInitialData = linkedList.getData();

    assertEquals(expectedInitialData, actualInitialData);

    linkedList = null;
  }

  @Test
  public void getLink() {
    linkedList = new IntNode(42, new IntNode(20, null));
    IntNode expected = new IntNode(20, null);

    IntNode actual = linkedList.getLink();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void setData() {
    linkedList = new IntNode(42, null);
    linkedList.setData(41);
    int expected = 41;

    int actual = linkedList.getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  //Todo:
  @Test
  public void setLink() {
    linkedList = new IntNode(42, null);
    linkedList.setLink(new IntNode(55, null));
    int expected = linkedList.getLink().getData();

    int actual = linkedList.getLink().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listLength() {
    linkedList = new IntNode(1, null);
    linkedList.addNodeAfter(2);
    linkedList.addNodeAfter(3);
    int expected = 3;

    int actual = IntNode.listLength(linkedList);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listLengthWithNull() {
    linkedList = null;
    int expected = 0;

    int actual = IntNode.listLength(linkedList);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listSearch() {
    linkedList = new IntNode(1, null);
    linkedList.addNodeAfter(2);
    linkedList.addNodeAfter(3);  // list = 1, 3, 2

    IntNode expected = new IntNode(3, new IntNode(2, null));

    IntNode actual = IntNode.listSearch(linkedList, 3);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listSearchWithNull() {
    linkedList = null;
    IntNode expected = null;

    IntNode actual = IntNode.listSearch(linkedList, 2);

    assertEquals(expected, actual);

    linkedList = null;
  }
  
  @Test
  public void listPosition(){
    linkedList = new IntNode(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3

    IntNode expected = new IntNode(4, new IntNode(3, null) );

    IntNode actual = IntNode.listPosition(linkedList, 2);

    System.out.println(expected.equals(actual));

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPositionWithNull(){
    linkedList = null;
    IntNode expected = null;

    IntNode actual = IntNode.listPosition(linkedList, 11);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPositionWithNegative(){
    linkedList = new IntNode(11, null);

    try {
      IntNode actual = IntNode.listPosition(linkedList, -3);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("position < 0 : Invoked from listPosition()"));
    }

    linkedList = null;
  }

  @Test
  public void listCopy() {
    linkedList = new IntNode(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    IntNode expected = new IntNode(11, new IntNode(4, new IntNode(3, null)));

    IntNode actual = IntNode.listCopy(linkedList);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listCopyWithNull() {
    linkedList = null;
    IntNode expected = null;

    IntNode actual = IntNode.listCopy(linkedList);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listCopyWithTail() {
    linkedList = new IntNode(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    IntNode[] expected = new IntNode[2];
    expected[0] = new IntNode(11, new IntNode(4, new IntNode(3, null)));
    expected[1] = new IntNode(3, null);

    IntNode[] actual = IntNode.listCopyWithTail(linkedList);

    assertArrayEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listCopyWithTailWithNull() {
    linkedList = null;
    IntNode[] expected = null;

    IntNode[] actual = IntNode.listCopyWithTail(linkedList);

    assertArrayEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPart() {
    linkedList = new IntNode(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    IntNode[] expected = new IntNode[2];
    expected[0] = new IntNode(4, new IntNode(3, null));
    expected[1] = new IntNode(3, null);

    IntNode start = linkedList.getLink();
    IntNode end = linkedList.getLink().getLink();
    IntNode[] actual = IntNode.listPart(start, end);

    assertArrayEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void listPartWhithStartIsNull() {
    linkedList = new IntNode(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    IntNode start = null;
    IntNode end = linkedList.getLink().getLink();

    try {
      IntNode[] actual = IntNode.listPart(start, end);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("start is null : Invoked from listPart()"));
    }

    linkedList = null;
  }

  @Test
  public void listPartWhithEndIsNull() {
    linkedList = new IntNode(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    IntNode start = linkedList.getLink();
    IntNode end = null;

    try {
      IntNode[] actual = IntNode.listPart(start, end);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("end is null : Invoked from listPart()"));
    }

    linkedList = null;
  }

  @Test
  public void listPartWithEndNotFound() {
    linkedList = new IntNode(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);  // list = 11, 4 ,3
    IntNode start = linkedList;
    IntNode end = new IntNode(8, null);

    try {
      IntNode[] actual = IntNode.listPart(start, end);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("end node was not found on this list"));
    }

    linkedList = null;
  }

  @Test
  public void countOccurrences() {
    linkedList = new IntNode(11, null);
    linkedList.addNodeAfter(3);
    linkedList.addNodeAfter(4);
    linkedList.addNodeAfter(3);// list = 11, 5, 4 ,3

    int expected = 2;

    int actual = IntNode.countOccurrences( linkedList, 3);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void equals1() {
    IntNode node1 = new IntNode(4,new IntNode(3, null));
    IntNode node2 = new IntNode(4,new IntNode(3, null));
    boolean expected = true;

    boolean actual = node1.equals(node2);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void equals2() {
      IntNode node1 = new IntNode(4,null);
      IntNode node2 = new IntNode(4,new IntNode(3, null));
      boolean expected = false;

      boolean actual = node1.equals(node2);

      assertEquals(expected, actual);

      linkedList = null;
  }

  @Test
  public void equals3() {
    IntNode node1 = new IntNode(4,new IntNode(3, null));
    IntNode node2 = new IntNode(4,null);
    boolean expected = false;

    boolean actual = node1.equals(node2);

    assertEquals(expected, actual);

    linkedList = null;
  }



}