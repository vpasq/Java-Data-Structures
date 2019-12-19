

import org.junit.*;
import static org.junit.Assert.*;

public class DoubleArraySeqTest {

  private DoubleArraySeq sequence;

  @Test
  public void constructWithInitialCapacity() {
    // (1) setup (arrange, build)
    sequence = new DoubleArraySeq(18);
    int expected = 18;

    // (2) exercise (act, operate)
    int actual = sequence.getCapacity();

    // (3) verify (assert, check)
    assertEquals(expected, actual);

    // (4) teardown
    sequence = null;
  }

  @Test
  public void constructWithoutInitialCapacity() {
    sequence = new DoubleArraySeq();

    int actual = sequence.getCapacity();

    assertEquals(10, actual);

    sequence = null;
  }

  @Test
  public void constructWithNegativeInitialCapacity() {
    try {
      sequence = new DoubleArraySeq(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      //assertEquals("initialCapacity < 0 : Invoked from constructor", e.getMessage());
      assertTrue(message.contains("initialCapacity < 0 : Invoked from constructor"));
    }

    sequence = null;
  }

  @Test
  public void isCurrentIsValid() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);

    assertEquals(true, sequence.isCurrent());

    sequence.start();
    assertEquals(true, sequence.isCurrent());

    sequence = null;
  }

  @Test
  public void getCurrent() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);

    assertEquals(1.0, sequence.getCurrent(), 0.0);
  }

  @Test
  public void getCurrentElementWhenThereIsNone() {
    sequence = new DoubleArraySeq();

    try {
      sequence.getCurrent();
      fail("Expected an IllegalStateException to be thrown");
    } catch (IllegalStateException e) {
      String message = e.getMessage();
      assertTrue(message.contains("isCurrent() == false : Invoked from getCurrent()"));
    }

    sequence = null;
  }

  @Test
  public void getSize() {
    sequence = new DoubleArraySeq();

    int actual = sequence.getSize();

    assertEquals(0, actual);

    sequence = null;
  }

  @Test
  public void start() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.start();

    double actual = sequence.getCurrent();

    assertEquals(1.0, actual, 0.0);

    sequence = null;
  }

  @Test
  public void advance() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);
    sequence.start();
    sequence.advance();
    sequence.advance();

    double actual = sequence.getCurrent();

    assertEquals(1.0, actual, 0.0);

    sequence = null;
  }

  @Test
  public void advanceWithInvalidCurrentelement() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.advance();

    try {
      sequence.advance();
      fail("Expected an IllegalStateException to be thrown");
    } catch (IllegalStateException e) {
      String message = e.getMessage();
      assertTrue(message.contains("isCurrent() == false : Invoked from advance()"));
    }

    // junit 5 lamda expression
//    assertThrows(IllegalStateException.class, () -> {
//      sequence.advance();
//    });

    sequence = null;
  }

  @Test
  public void ensureCapacity() {
    sequence = new DoubleArraySeq();
    sequence.ensureCapacity(28);
    sequence.ensureCapacity(27);
    int expected = 28;

    int actual = sequence.getCapacity();

    assertEquals(expected, actual);

    sequence = null;
  }

  @Test
  public void addBefore() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);
    double[] expected = {3.0, 2.0, 1.0};

    double[] actual = buildActualArray();

    assertArrayEquals(expected, actual, 0.0);

    sequence = null;
  }

  @Test
  public void addAll() {
    sequence = new DoubleArraySeq();
    DoubleArraySeq sequence2 = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);
    sequence2.addBefore(11.0);
    sequence2.addBefore(12.0);
    sequence2.addBefore(13.0);
    double[] expected = {3.0, 2.0, 1.0, 13.0, 12.0, 11.0};

    sequence.addAll(sequence2);
    //sequence.print();
    double[] actual = buildActualArray();

    assertArrayEquals(expected, actual, 0.0);

    sequence = null;
  }

  @Test
  public void addAllWithNullArray() {
    sequence = new DoubleArraySeq();
    DoubleArraySeq sequence2 = new DoubleArraySeq();
    sequence2 = null;

    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);

    try {
      sequence.addAll(sequence2);
      fail("Expected an NullPointerException to be thrown");
    } catch (NullPointerException e) {
      String message = e.getMessage();
      assertTrue(message.contains("addend == null : Invoked from addAll()"));
    }
  }

  @Test
  public void addBeforeInMiddle() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);
    sequence.addBefore(4.0);
    sequence.addBefore(5.0);
    sequence.start();
    sequence.advance();
    sequence.advance();
    sequence.addBefore(11);
    double[] expected = {5.0, 4.0, 11.0, 3.0, 2.0, 1.0,};

    double[] actual = buildActualArray();

    assertArrayEquals(expected, actual, 0.0);

    sequence = null;
  }

  @Test
  public void concatenate() {
    DoubleArraySeq sequence1 = new DoubleArraySeq();
    sequence1.addBefore(1.0);
    sequence1.addBefore(2.0);
    sequence1.addBefore(3.0);

    DoubleArraySeq sequence2 = new DoubleArraySeq();
    sequence2.addBefore(11.0);
    sequence2.addBefore(12.0);
    sequence2.addBefore(13.0);

    DoubleArraySeq expected= new DoubleArraySeq(6);
    expected.addBefore(11.0);
    expected.addBefore(12.0);
    expected.addBefore(13.0);
    expected.addBefore(1.0);
    expected.addBefore(2.0);
    expected.addBefore(3.0);
    DoubleArraySeq actual = DoubleArraySeq.concatenate(sequence1, sequence2);

    assertEquals(true, expected.equals(actual));
  }

  @Test
  public void concatenateEnsureCapacity() {
    DoubleArraySeq sequence1 = new DoubleArraySeq();
    sequence1.addBefore(1.0);
    sequence1.addBefore(2.0);
    sequence1.addBefore(3.0);
    sequence1.addBefore(1.0);
    sequence1.addBefore(2.0);
    sequence1.addBefore(3.0);
    sequence1.addBefore(1.0);
    sequence1.addBefore(2.0);
    sequence1.addBefore(3.0);

    DoubleArraySeq sequence2 = new DoubleArraySeq();
    sequence2.addBefore(11.0);
    sequence2.addBefore(12.0);
    sequence2.addBefore(13.0);

    DoubleArraySeq expected= new DoubleArraySeq();
    expected.addBefore(11.0);
    expected.addBefore(12.0);
    expected.addBefore(13.0);
    expected.addBefore(1.0);
    expected.addBefore(2.0);
    expected.addBefore(3.0);
    expected.addBefore(1.0);
    expected.addBefore(2.0);
    expected.addBefore(3.0);
    expected.addBefore(1.0);
    expected.addBefore(2.0);
    expected.addBefore(3.0);
    expected.trimToSize();

    DoubleArraySeq actual = DoubleArraySeq.concatenate(sequence1, sequence2);
    actual.trimToSize();

    assertEquals(expected, actual);
  }

  @Test
  public void concatenateWithNullSequence1() {
    DoubleArraySeq sequence1 = new DoubleArraySeq();
    sequence1 = null;

    DoubleArraySeq sequence2= new DoubleArraySeq();
    sequence2.addBefore(1.0);

    try {
      DoubleArraySeq.concatenate(sequence1, sequence2);
      fail("Expected an NullPointerException to be thrown");
    } catch (NullPointerException e) {
      String message = e.getMessage();
      assertTrue(message.contains("sequence1 == null || sequence2 == null : Invoked from concatenate()"));
    }
  }

  @Test
  public void concatenateWithNullSequence2() {
    DoubleArraySeq sequence1 = new DoubleArraySeq();
    sequence1.addBefore(1.0);

    DoubleArraySeq sequence2= new DoubleArraySeq();
    sequence1 = null;

    try {
      DoubleArraySeq.concatenate(sequence1, sequence2);
      fail("Expected an NullPointerException to be thrown");
    } catch (NullPointerException e) {
      String message = e.getMessage();
      assertTrue(message.contains("sequence1 == null || sequence2 == null : Invoked from concatenate()"));
    }
  }

  @Test
  public void removeCurrent() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);
    sequence.advance();
    double[] expected = {3.0, 1.0};

    sequence.removeCurrent();
    //sequence.print();

    double[] actual = buildActualArray();

    assertArrayEquals(expected, actual, 0.0);

    sequence = null;
  }

  @Test
  public void getCurrentAfterRemovingCurrentElementFromMiddle() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);
    sequence.advance();
    sequence.removeCurrent();
    double expected = 1.0;

    double actual = sequence.getCurrent();

    assertEquals(expected, actual, 0.0);

    sequence = null;
  }

  @Test
  public void getCurrentAfterRemovingCurrentElementFromEnd() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);
    sequence.advance();
    sequence.advance();
    sequence.removeCurrent();

    try {
      sequence.getCurrent();
      fail("Expected an IllegalStateException to be thrown");
    } catch (IllegalStateException e) {
      String message = e.getMessage();
      assertTrue(message.contains("isCurrent() == false : Invoked from getCurrent()"));
    }

    sequence = null;
  }

  @Test
  public void removeCurrentWithNoCurrentElement() {
    sequence = new DoubleArraySeq();

    try {
      sequence.removeCurrent();
      fail("Expected an IllegalStateException to be thrown");
    } catch (IllegalStateException e) {
      String message = e.getMessage();
      //assertEquals("initialCapacity < 0 : Invoked from constructor", e.getMessage());
      assertTrue(message.contains("isCurrent() == false : Invoked from removeCurrent()"));
    }

    sequence = null;
  }

  //Todo:
  @Test
  public void isCurrentWithInvalidCurrentElement() {
    sequence = new DoubleArraySeq();

    assertEquals(false, sequence.isCurrent());
    sequence = null;

    sequence = new DoubleArraySeq();
    sequence.start();
    assertEquals(false, sequence.isCurrent());
    sequence = null;

    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.advance();
    assertEquals(false, sequence.isCurrent());
    sequence = null;

    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.start();
    sequence.advance();
    assertEquals(false, sequence.isCurrent());

    sequence = null;
  }

  @Test
  public void trimToSize() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);
    sequence.addBefore(2.0);
    sequence.addBefore(3.0);
    int expected = 3;

    sequence.trimToSize();

    assertEquals(3, sequence.getCapacity());

    sequence = null;
  }

  @Test
  public void cloneSequence() {
    sequence = new DoubleArraySeq();
    sequence.addBefore(1.0);

    DoubleArraySeq clonedSequence = new DoubleArraySeq();
    clonedSequence = sequence.clone();

    assertEquals(sequence, clonedSequence);
  }

  @Test
  public void performanceTest() {
    sequence = new DoubleArraySeq();
    long expected = 3000000L;
    long time = System.nanoTime();
    sequence.addBefore(3);
    time = System.nanoTime() - time;
    //System.out.println(time);
    assertTrue(time <= expected);

    // junit 5 using lambda expression
//    assertTimeout(Duration.ofSeconds(1), () -> {
//      sequence = new DoubleArraySeq();
//      sequence.addBefore(3);
//    });

    sequence = null;
  }

  private double[] buildActualArray() {
    double[] actual = new double[sequence.getSize()];
    int index = 0;
    for (sequence.start(); sequence.isCurrent(); sequence.advance()) {
      actual[index] = sequence.getCurrent();
      index++;
    }
    return actual;
  }
}