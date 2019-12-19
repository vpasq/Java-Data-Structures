package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class SumNaturalTest {
  private SumNatural sumNaturals;

  @Test
  public void sumRecursive1WithNegativeN() {
    sumNaturals = new SumNatural();

    try {
      int actual = sumNaturals.sumRecursive1(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("n < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    sumNaturals = null;
  }

  @Test
  public void sumRecursive1WithPositiveN() {
    sumNaturals = new SumNatural();
    int expected = 28;

    int actual = sumNaturals.sumRecursive1(7);

    assertEquals(expected, actual);

    sumNaturals = null;
  }

  @Test
  public void sumRecursive2WithNegativeN() {
    sumNaturals = new SumNatural();

    try {
      int actual = sumNaturals.sumRecursive2(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("n < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    sumNaturals = null;
  }

  @Test
  public void sumRecursive2WithOddN() {
    sumNaturals = new SumNatural();
    int expected = 28;

    int actual = sumNaturals.sumRecursive2(7);

    assertEquals(expected, actual);

    sumNaturals = null;
  }

  @Test
  public void sumRecursive2WithEvenN() {
    sumNaturals = new SumNatural();
    int expected = 36;

    int actual = sumNaturals.sumRecursive2(8);

    assertEquals(expected, actual);

    sumNaturals = null;
  }
}