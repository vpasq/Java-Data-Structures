
import org.junit.*;
import static org.junit.Assert.*;

public class VPLinkedListTest {
  VPLinkedList linkedList;

  @Test
  public void constructEmptyList() {
    linkedList = new VPLinkedList();
    IntNode expectedHead = null;
    IntNode expectedTail = null;

    IntNode actualHead = linkedList.getHead();
    IntNode actualTail = linkedList.getTail();

    assertEquals(expectedHead, actualHead);
    assertEquals(expectedTail, actualTail);

    linkedList = null;
  }

  @Test
  public void constructListWithInitialData() {
    linkedList = new VPLinkedList(42, null);
    int expectedInitialData = 42;

    int actualInitialData = linkedList.getHead().getData();

    assertEquals(expectedInitialData, actualInitialData);

    linkedList = null;
  }

  @Test
  public void addFirstNode() {
    linkedList = new VPLinkedList();

    linkedList.addFirstNode(52);
    int expectedHeadData = 52;
    IntNode expectedHeadLink = null;

    int actualHeadData = linkedList.getHead().getData();
    IntNode actualHeadLink = linkedList.getHead().getLink();

    assertEquals(expectedHeadData, actualHeadData);
    assertEquals(expectedHeadLink, actualHeadLink);

    int expectedTailData = 52;
    int actualTailData = linkedList.getTail().getData();
    assertEquals(expectedTailData, actualTailData);
  }

  @Test
  public void getHead() {
    linkedList = new VPLinkedList(42, null);
    int expectedHeadNodeData = 42;
    IntNode expectedHeadNodeLink = null;

    int actualHeadNodeData = linkedList.getHead().getData();
    IntNode actualHeadNodeLink = linkedList.getHead().getLink();

    assertEquals(expectedHeadNodeData, actualHeadNodeData);
    assertEquals(expectedHeadNodeLink, actualHeadNodeLink);

    linkedList = null;
  }

  @Test
  public void setNewHead() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    int expectedNewHeadData = 41;
    int expectedNewHeadLinkData = 42;
    IntNode expectedNewHeadLinkLink = null;

    int actualHeadNodeData = linkedList.getHead().getData();
    int actualHeadNodeLinkData = linkedList.getHead().getLink().getData();
    IntNode actualHeadNodeLinkLink = linkedList.getHead().getLink().getLink();

    assertEquals(expectedNewHeadData, actualHeadNodeData);
    assertEquals(expectedNewHeadLinkData, actualHeadNodeLinkData);
    assertEquals(expectedNewHeadLinkLink, actualHeadNodeLinkLink);

    linkedList = null;
  }

  @Test
  public void removeHead() {
    linkedList = new VPLinkedList(42, null);
    linkedList.removeHead();
    IntNode expectedHead = null;
    IntNode expectedTail = null;

    IntNode actualHead = linkedList.getHead();
    IntNode actualTail = linkedList.getTail();

    assertEquals(expectedHead, actualHead);
    assertEquals(expectedTail, actualTail);

    linkedList = null;

  }

  @Test
  public void getHeadAndTail() {
    linkedList = new VPLinkedList(42, null);

    int expectedHeadData = 42;
    IntNode expectedHeadLink = null;

    int actualHeadData = linkedList.getHead().getData();
    IntNode actualHeadLink = linkedList.getHead().getLink();

    assertEquals(expectedHeadData, actualHeadData);
    assertEquals(expectedHeadLink, actualHeadLink);

    int expectedTailData = 42;
    IntNode expectedTailLink = null;

    int actualTailData = linkedList.getTail().getData();
    IntNode actualTailLink = linkedList.getTail().getLink();

    assertEquals(expectedTailData, actualTailData);
    assertEquals(expectedTailLink, actualTailLink);

    //============

    linkedList.setNewHead(43);

    expectedHeadData = 43;
    int expectedHeadLinkData = 42;

    actualHeadData = linkedList.getHead().getData();
    int actualHeadLinkData = linkedList.getHead().getLink().getData();

    assertEquals(expectedHeadData, actualHeadData);
    assertEquals(expectedHeadLinkData, actualHeadLinkData);

    expectedTailData = 42;
    expectedTailLink = null;

    actualTailData = linkedList.getTail().getData();
    actualTailLink = linkedList.getTail().getLink();

    assertEquals(expectedTailData, actualTailData);
    assertEquals(expectedTailLink, actualTailLink);

    linkedList = null;
  }

  @Test
  public void addNodeAfterHead() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99); // list = 99, 41, 41

    // get a selection for the head
    IntNode selection = linkedList.getHead();  // selection = 99
    linkedList.addNodeAfter(selection, 44);  // new list = 99, 44, 41, 42

    int expected = 44;

    int actual = linkedList.getHead().getLink().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }


  @Test
  public void addNodeAfterMiddle() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99); // list = 99, 41, 41

    // get a selection in the middle
    IntNode selection = linkedList.getHead().getLink();  // selection = 41
    linkedList.addNodeAfter(selection, 43);  // new list = 99, 41, 43, 42

    int expected = 43;

    int actual = linkedList.getHead().getLink().getLink().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void addNodeAfterTail() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99); // list = 99, 41, 42
    int expectedTailData = 43;
    IntNode expectedTailLink = null;

    linkedList.addNodeAfter(linkedList.getTail(), 43); // new list = 99, 41, 41, 43

    int actualTailData = linkedList.getTail().getData();
    IntNode actualTailLink= linkedList.getTail().getLink();

    assertEquals(expectedTailData, actualTailData);
    assertEquals(expectedTailLink, actualTailLink);

    linkedList = null;
  }

  @Test
  public void addNodeAfterEmptyList1() {
    linkedList = new VPLinkedList();
    int expected = 42;

    IntNode selection = linkedList.getHead();

    linkedList.addNodeAfter(selection, 42);
    int actual = linkedList.getHead().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void addNodeAfterEmptyListWithHeadNotNullAndSelectionNull() {
    linkedList = new VPLinkedList();
    linkedList.setNewHead(41);
    linkedList.setNewHead(99); // list = 99, 41, 42
    int expected = 99;

    try {
      linkedList.addNodeAfter(null, 42);
      fail("Expected an NullPointerException to be thrown");
    } catch (NullPointerException e) {
      String message = e.getMessage();
      assertTrue(message.contains("selection is null && head != null : Invoked from addNodeAfter()"));
    }

    linkedList = null;
  }

  @Test
  public void addNodeBeforeHead() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99); // list = 99, 41, 42
    int expected = 11;

    IntNode selection = linkedList.getHead(); // 99
    linkedList.addNodeBefore(selection, 11); // new list = 11, 99, 41, 42

    int actual = linkedList.getHead().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void addNodeBeforeMiddle() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99); // list = 99, 41, 42
    int expected = 11;

    IntNode selection = linkedList.getHead().getLink(); // 41
    linkedList.addNodeBefore(selection, 11); // new list = 99, 11, 41, 42

    int actual = linkedList.getHead().getLink().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void addNodeBeforeTail() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99); // list = 99, 41, 42
    int expected = 11;
    int expectedTail = 42;

    IntNode selection = linkedList.getTail(); // 42
    linkedList.addNodeBefore(selection, 11); // new list = 99,  41, 11, 42

    int actual = linkedList.getHead().getLink().getLink().getData();
    int actualTail = linkedList.getTail().getData();

    assertEquals(expected, actual);
    assertEquals(expectedTail, actualTail);

    linkedList = null;
  }

  @Test
  public void addNodeBeforeNull() {
    linkedList = new VPLinkedList();

    try {
      linkedList.addNodeBefore(null, 11);
      fail("Expected an NullPointerException to be thrown");
    } catch (NullPointerException e) {
      String message = e.getMessage();
      assertTrue(message.contains("selection == null : Invoked from addNodeBefore()"));
    }

    linkedList = null;
  }

  @Test
  public void getCountByDataInHead() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);
    int expected = 0;

    int actual = linkedList.getCountByData(linkedList.getHead().getData());

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void getCountByDataInMiddle() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);
    int expected = 1;

    int actual = linkedList.getCountByData(41);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void getCountByDataInTail() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);
    int expected = 2;

    int actual = linkedList.getCountByData(linkedList.getTail().getData());

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void getCountByDataWithNotFound() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);
    int expected = -1;

    int actual = linkedList.getCountByData(100);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void getCountByDataWithEmptyList() {
    linkedList = new VPLinkedList();

    int expected = -1;

    int actual = linkedList.getCountByData(99);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void getNodeByCountHead() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);
    int expected = 42;

    int actual  = linkedList.getCountByData(42);
    actual = linkedList.getNodeByCount(actual).getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void getNodeByCountTail() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);
    int expected = 42;

    int actual  = linkedList.getCountByData(42);
    actual = linkedList.getNodeByCount(actual).getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void getNodeByCountNegative() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);

    try {
      int actual  = linkedList.getCountByData(100);
      actual = linkedList.getNodeByCount(actual).getData();
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("count < 0 : Invoked from getNodeByCount()"));
    }

    linkedList = null;
  }

  @Test
  public void getNodeByCountAfterTail() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);
    IntNode expected = null;

    IntNode actual = linkedList.getNodeByCount(3);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void getNodeByCountWithEmptyList() {
    linkedList = new VPLinkedList();

    IntNode expected = null;

    IntNode actual = linkedList.getNodeByCount(3);

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void removeNodeAfterHead() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99); // list = 99, 41, 42
    int expected = 42;

    IntNode selection = linkedList.getHead();  // selection = 99
    linkedList.removeAfter(selection);         // new list 99, 42

    int actual = linkedList.getHead().getLink().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }


  @Test
  public void removeNodeAfterMiddle() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(45);
    linkedList.setNewHead(99); // list = 99, 45, 41, 42
    int expected = 42;

    // get a selection in the middle
    IntNode selection = linkedList.getHead().getLink();  // selection = 99
    linkedList.removeAfter(selection);         // new list 99, 45, 42

    int actual = linkedList.getHead().getLink().getLink().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }


  @Test
  public void removeNodeAfterTail() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(99); // list = 99, 42
    int expected = 42;

    // get a selection in the middle
    IntNode selection = linkedList.getTail();  // selection = 42
    linkedList.removeAfter(selection);         // new list 99, 42

    int actual = linkedList.getTail().getData();

    assertEquals(expected, actual);

    linkedList = null;
  }

  @Test
  public void removeNodeAfterEmptyList() {
    linkedList = new VPLinkedList();
    IntNode selection = linkedList.getHead();

    linkedList.removeAfter(selection);

    linkedList = null;
  }

  //Todo: method not used
  @Test
  public void getNodeByData() {
    linkedList = new VPLinkedList(42, null);
    linkedList.setNewHead(41);
    linkedList.setNewHead(99);
    linkedList.addNodeAfter(linkedList.getTail(), 43);
    int expected = 43;

    int actual = linkedList.getNodeByData(43).getData();

    assertEquals(expected, actual);
  }

}

