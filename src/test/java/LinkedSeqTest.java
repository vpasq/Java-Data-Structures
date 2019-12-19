
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class LinkedSeqTest {
  private LinkedSeq linkedListSequence;

  @Test
  public void construct() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    Object[] expected = {};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addAfterWithEmptyList() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>(); // empty linked list
    linkedListSequence.addAfter(30);
    Object[] expected = {30};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addAfterWithCurrentElementAtHead() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(10);
    linkedListSequence.addAfter(20);
    Object[] expected = {10, 20};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addAfterWithCurrentElementNullAndOneElementInList() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(10);
    linkedListSequence.advance();
    linkedListSequence.addAfter(20);
    Object[] expected = {10, 20};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addAfterWithThreeElements() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(10);
    linkedListSequence.addAfter(20);
    linkedListSequence.addAfter(30); // list = 10, 20, 30
    Object[] expected = {10, 20, 30};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithEmptyListt() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(10);
    Object[] expected = {10};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithOneElement() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(20);
    Object[] expected = {20, 10};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithManyElements() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(80); // list = 10, 80, 20
    linkedListSequence.addBefore(90); // list = 10, 80, 20
    Object[] expected = {90, 80, 10, 20};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithCurrentElementNullAndOneElementInList() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(10);
    linkedListSequence.advance();
    linkedListSequence.addBefore(20);

    Object[] expected = {20, 10};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void addBeforeWithCurrentElementNotNullAndInMiddleOfList() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(30);
    linkedListSequence.addBefore(40);
    linkedListSequence.addBefore(50);
    linkedListSequence.advance();
    linkedListSequence.advance();
    linkedListSequence.addBefore(60);

    Object[] expected = {50, 40, 60, 30,20, 10};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromHeadBefore() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(80); // list = 80, 10, 20

    linkedListSequence.removeCurrent();       // new list = 10, 20
    Object[] expected = {10, 20};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromHeadAfter() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(20);
    linkedListSequence.addAfter(10);
    linkedListSequence.addAfter(80); // list = 20, 10, 80

    linkedListSequence.removeCurrent();       // new list = 20, 10
    Object[] expected = {20, 10};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromHeadWithOneElementUsingAfter() { // cursor equals tail
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(20);
    linkedListSequence.removeCurrent();
    Object[] expected = {};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromHeadWithOneElementUsingBefore() { // cursor equals tail
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(20);
    linkedListSequence.removeCurrent();
    Object[] expected = {};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromMiddleBefore() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(80); // list = 10, 80, 20
    linkedListSequence.removeCurrent();      // new list = 10, 20
    Object[] expected = {10, 20};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromMiddleAfter() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(20);
    linkedListSequence.addAfter(10);
    linkedListSequence.addAfter(80); // list = 20, 10, 80
    linkedListSequence.removeCurrent();      // new list = 20, 10
    Object[] expected = {20, 10};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentFromTailBefore() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(20);
    linkedListSequence.addBefore(10);
    linkedListSequence.addBefore(80); // list = 80, 10, 20
    linkedListSequence.removeCurrent();      // new list  = 20, 10
    Object[] expected = {10, 20};
    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentWithBothBeforeAndAfter() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(20);
    linkedListSequence.addAfter(30);
    linkedListSequence.addBefore(40); // 20, 40, 30
    linkedListSequence.removeCurrent();      // new list  = 20, 40
    Object[] expected = {20, 30};
    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentWithBothBeforeAndAfterAndAdvance() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(20);
    linkedListSequence.addAfter(30);
    linkedListSequence.addBefore(40); // 20, 40, 30
    linkedListSequence.advance();
    linkedListSequence.removeCurrent();      // new list  = 20, 40
    Object[] expected = {20, 40};

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeCurrentWithNoCurrentElement() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
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
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(1);
    linkedListSequence.addAfter(2);

    LinkedSeq<Integer> linkedListSequence2 = new LinkedSeq<Integer>();
    linkedListSequence2.addAfter(3);
    linkedListSequence2.addAfter(4);

    Object[] expected = {1,  2, 3, 4};

    linkedListSequence.addAll(linkedListSequence2);

    Object[] actual = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
    linkedListSequence2 = null;
  }

  @Test
  public void addAllToEmptyList() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();

    LinkedSeq<Integer> linkedListSequence2 = new LinkedSeq<Integer>();
    linkedListSequence2.addAfter(3);
    linkedListSequence2.addAfter(4);

    Object[] expected = {3, 4};

    linkedListSequence.addAll(linkedListSequence2);

    Object[] actual = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
    linkedListSequence2 = null;
  }

  @Test
  public void addAllWithAddendIsNull() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(1);
    LinkedSeq<Integer> linkedListSequence2 = null;

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
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(1);
    linkedListSequence.addAfter(2);

    LinkedSeq<Integer> linkedListSequence2 = new LinkedSeq<Integer>();
    linkedListSequence2.addAfter(3);
    linkedListSequence2.addAfter(4);
    Object[] expected = {1, 2, 3, 4}; // convert linked list to an array for testing

    LinkedSeq<Integer> actualConcat = LinkedSeq.concatenation(linkedListSequence, linkedListSequence2);
    Object[] actual = actualConcat.toArray();  // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
    linkedListSequence2 = null;
  }

  @Test
  public void concatenationWithS1Null() {
    LinkedSeq<Integer> linkedListSequence = null;
    LinkedSeq<Integer> linkedListSequence2 = new LinkedSeq<Integer>();
    linkedListSequence2.addAfter(3);
    LinkedSeq<Integer> actual;

    try {
      actual = LinkedSeq.concatenation(linkedListSequence, linkedListSequence2);
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
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(1);
    LinkedSeq<Integer> linkedListSequence2 = null;
    LinkedSeq<Integer> actual;

    try {
      actual = LinkedSeq.concatenation(linkedListSequence, linkedListSequence2);
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
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    Object[] expected = {};

    LinkedSeq<Integer> actualCopy = (LinkedSeq<Integer>)linkedListSequence.clone();

    Object[] actual = actualCopy.toArray();   // convert linked list to an array for testing

    //assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void cloneTest2() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(1);
    //linkedListSequence.start();
    Object[] expected = {1};

    LinkedSeq actualCopy = (LinkedSeq<Integer>)linkedListSequence.clone();
    Object[] actual = actualCopy.toArray();   // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void cloneTest3() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(11);
    linkedListSequence.addAfter(12);
    linkedListSequence.start();
    Object[] expected = {11, 12};

    LinkedSeq<Integer> actualCopy = (LinkedSeq<Integer>)linkedListSequence.clone();

    Object[] actual = actualCopy.toArray();   // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void cloneTest4() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addBefore(1);
    linkedListSequence.addAfter(2);
    linkedListSequence.addAfter(3);
    linkedListSequence.start();
    Object[] expected = {1, 2, 3};

    LinkedSeq<Integer> actualCopy = (LinkedSeq<Integer>)linkedListSequence.clone();

    Object[] actual = actualCopy.toArray();   // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void advance() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(2);
    linkedListSequence.addAfter(3);
    linkedListSequence.addBefore(33);
    linkedListSequence.addAfter(4);
  }

  @Test
  public void removeFoundElement() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(11);
    linkedListSequence.addAfter(12);
    Node<Integer> elem = new Node<Integer>(11, new Node<Integer>(12, null));
    Object[] expected = {11};

    linkedListSequence.remove(elem);

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void removeNotFoundElement() {
    LinkedSeq<Integer> linkedListSequence = new LinkedSeq<Integer>();
    linkedListSequence.addAfter(11);
    linkedListSequence.addAfter(12);
    Node<Integer> elem = new Node<Integer>(111, new Node<Integer>(12, null));
    Object[] expected = {11, 12};

    linkedListSequence.remove(elem);

    Object[] actual  = linkedListSequence.toArray(); // convert linked list to an array for testing

    assertArrayEquals(expected, actual);

    linkedListSequence = null;
  }

  @Test
  public void iterator() {
//    linkedListSequence = new LinkedSeq<Integer>();
//    linkedListSequence.addAfter(2);
//    linkedListSequence.addAfter(3);
//    linkedListSequence.addBefore(33);
//    linkedListSequence.addAfter(4);

    LinkedSeq<String> linkedListSequence = new LinkedSeq<String>();
    linkedListSequence.addAfter("jjj");
    linkedListSequence.addAfter("ghg");
    linkedListSequence.addBefore("yhy");
    linkedListSequence.addAfter("ABD");

    Iterator<String> it = linkedListSequence.iterator();

    while (it.hasNext())
      System.out.println(it.next());

    for (Object elem : linkedListSequence)
      System.out.println(elem);


    Integer[] a = {1,2,3};
    ArrayIterator<Integer> ai = new ArrayIterator<Integer>(a);

    while (ai.hasNext())
      System.out.println(ai.next());

    for (Integer elem : a)
      System.out.println(elem);



  }
}