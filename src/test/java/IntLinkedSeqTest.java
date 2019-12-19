

import org.junit.*;
import static org.junit.Assert.*;

public class IntLinkedSeqTest {
  private IntLinkedSeq linkedListSequence;

  @Test
  public void construct() {
    linkedListSequence = new IntLinkedSeq();
    int[] expected = {};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addAfterWithEmptyList() {
    linkedListSequence = new IntLinkedSeq(); // empty linked list
    linkedListSequence.addAfter(30);
    int[] expected = {30};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addAfterWithCurrentElementAtHead() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(10);
    linkedListSequence.addAfter(20);
    int[] expected = {10, 20};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addAfterWithCurrentElementNullAndOneElementInList() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(10);
    linkedListSequence.advance();
    linkedListSequence.addAfter(20);
    int[] expected = {10, 20};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addAfterWithThreeElements() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(10);
    linkedListSequence.addAfter(20);
    linkedListSequence.addAfter(30); // list = 10, 20, 30
    int[] expected = {10, 20, 30};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithEmptyListt() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(10);
    int[] expected = {10};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithOneElement() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(20);
    int[] expected = {20, 10};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithManyElements() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(80); // list = 10, 80, 20
    linkedListSequence.addBefore(90); // list = 10, 80, 20
    int[] expected = {90, 80, 10, 20};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithCurrentElementNullAndOneElementInList() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(10);
    linkedListSequence.advance();
    linkedListSequence.addBefore(20);

    int[] expected = {20, 10};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithCurrentElementNotNullAndInMiddleOfList() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(30);
    linkedListSequence.addBefore(40);
    linkedListSequence.addBefore(50);
    linkedListSequence.advance();
    linkedListSequence.advance();
    linkedListSequence.addBefore(60);

    int[] expected = {50, 40, 60, 30,20, 10};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromHeadBefore() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(80); // list = 80, 10, 20

    linkedListSequence.removeCurrent();       // new list = 10, 20
    int[] expected = {10, 20};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromHeadAfter() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(20);
    linkedListSequence.addAfter(10);
    linkedListSequence.addAfter(80); // list = 20, 10, 80

    linkedListSequence.removeCurrent();       // new list = 20, 10
    int[] expected = {20, 10};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromHeadWithOneElementUsingAfter() { // cursor equals tail
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(20);
    linkedListSequence.removeCurrent();
    int[] expected = {};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromHeadWithOneElementUsingBefore() { // cursor equals tail
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(20);
    linkedListSequence.removeCurrent();
    int[] expected = {};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromMiddleBefore() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(80); // list = 10, 80, 20
    linkedListSequence.removeCurrent();      // new list = 10, 20
    int[] expected = {10, 20};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromMiddleAfter() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(20);
    linkedListSequence.addAfter(10);
    linkedListSequence.addAfter(80); // list = 20, 10, 80
    linkedListSequence.removeCurrent();      // new list = 20, 10
    int[] expected = {20, 10};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromTailBefore() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(80); // list = 80, 10, 20
    linkedListSequence.removeCurrent();      // new list  = 20, 10
    int[] expected = {10, 20};
    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentWithBothBeforeAndAfter() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(20);
    linkedListSequence.addAfter(30);
    linkedListSequence.addBefore(40); // 20, 40, 30
    linkedListSequence.removeCurrent();      // new list  = 20, 40
    int[] expected = {20, 30};
    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentWithBothBeforeAndAfterAndAdvance() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(20);
    linkedListSequence.addAfter(30);
    linkedListSequence.addBefore(40); // 20, 40, 30
    linkedListSequence.advance();
    linkedListSequence.removeCurrent();      // new list  = 20, 40
    int[] expected = {20, 40};

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentWithNoCurrentElement() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addAfter(80); // list = 10, 80, 20
    linkedListSequence.advance();
    linkedListSequence.advance();            // new current = null

    try {
      linkedListSequence.removeCurrent();
      fail("Expected an IllegalStateException to be thrown");
    } catch (IllegalStateException e) {
      String message = e.getMessage();
      assertTrue(message.contains("isCurrent() == false : Invoked from removeCurrent"));
    }

    try {
      linkedListSequence.getCurrent();
      fail("Expected an IllegalStateException to be thrown");
    } catch (IllegalStateException e) {
      String message = e.getMessage();
      assertTrue(message.contains("isCurrent() == false : Invoked from getCurrent()"));
    }

    linkedListSequence = null;
  }

  @Test
  public void addAll() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(1);
    linkedListSequence.addAfter(2);

    IntLinkedSeq linkedListSequence2 = new IntLinkedSeq();
    linkedListSequence2.addAfter(3);
    linkedListSequence2.addAfter(4);

    int[] expected = {1,  2, 3, 4};

    linkedListSequence.addAll(linkedListSequence2);

    int[] actual = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
    linkedListSequence2 = null;
  }

  @Test
  public void addAllToEmptyList() {
    linkedListSequence = new IntLinkedSeq();

    IntLinkedSeq linkedListSequence2 = new IntLinkedSeq();
    linkedListSequence2.addAfter(3);
    linkedListSequence2.addAfter(4);

    int[] expected = {3, 4};

    linkedListSequence.addAll(linkedListSequence2);

    int[] actual = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
    linkedListSequence2 = null;
  }

  @Test
  public void addAllWithAddendIsNull() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(1);
    IntLinkedSeq linkedListSequence2 = null;

    try {
      linkedListSequence.addAll(linkedListSequence2);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("addend is null : Invoked from addAll()"));
    }

    linkedListSequence = null;
  }

  @Test
  public void concatenation() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(1);
    linkedListSequence.addAfter(2);

    IntLinkedSeq linkedListSequence2 = new IntLinkedSeq();
    linkedListSequence2.addAfter(3);
    linkedListSequence2.addAfter(4);
    int[] expected = {1, 2, 3, 4}; // convert linked list to an array for testing

    IntLinkedSeq actualConcat = IntLinkedSeq.concatenation(linkedListSequence, linkedListSequence2);
    int[] actual = actualConcat.toArray();  // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
    linkedListSequence2 = null;
  }

  @Test
  public void concatenationWithS1Null() {
    linkedListSequence = null;
    IntLinkedSeq linkedListSequence2 = new IntLinkedSeq();
    linkedListSequence2.addAfter(3);
    IntLinkedSeq actual;

    try {
      actual = IntLinkedSeq.concatenation(linkedListSequence, linkedListSequence2);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("s1 is null : Invoked from concatenation()"));
    }

    linkedListSequence = null;
    linkedListSequence2 = null;
  }

  @Test
  public void concatenationWithS2Null() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(1);
    IntLinkedSeq linkedListSequence2 = null;
    IntLinkedSeq actual;

    try {
      actual = IntLinkedSeq.concatenation(linkedListSequence, linkedListSequence2);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("s2 is null : Invoked from concatenation()"));
    }

    linkedListSequence = null;
    linkedListSequence2 = null;
  }

  @Test
  public void cloneTest1() {
    linkedListSequence = new IntLinkedSeq();
    int[] expected = {};

    IntLinkedSeq actualCopy = (IntLinkedSeq)linkedListSequence.clone();
    int[] actual = actualCopy.toArray();   // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void cloneTest2() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(1);
    //linkedListSequence.start();
    int[] expected = {1};

    IntLinkedSeq actualCopy = (IntLinkedSeq)linkedListSequence.clone();
    int[] actual = actualCopy.toArray();   // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void cloneTest3() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(11);
    linkedListSequence.addAfter(12);
    linkedListSequence.start();
    int[] expected = {11, 12};

    IntLinkedSeq actualCopy = (IntLinkedSeq)linkedListSequence.clone();


    int[] actual = actualCopy.toArray();   // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void cloneTest4() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addBefore(1);
    linkedListSequence.addAfter(2);
    linkedListSequence.addAfter(3);
    linkedListSequence.start();
    int[] expected = {1, 2, 3};

    IntLinkedSeq actualCopy = (IntLinkedSeq)linkedListSequence.clone();

    int[] actual = actualCopy.toArray();   // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void advance() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(2);
    linkedListSequence.addAfter(3);
    linkedListSequence.addBefore(33);
    linkedListSequence.addAfter(4);
  }

  @Test
  public void removeFoundElement() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(11);
    linkedListSequence.addAfter(12);
    IntNode elem = new IntNode(11, new IntNode(12, null));
    int[] expected = {11};

    linkedListSequence.remove(elem);

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeNotFoundElement() {
    linkedListSequence = new IntLinkedSeq();
    linkedListSequence.addAfter(11);
    linkedListSequence.addAfter(12);
    IntNode elem = new IntNode(111, new IntNode(12, null));
    int[] expected = {11, 12};

    linkedListSequence.remove(elem);

    int[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }



}