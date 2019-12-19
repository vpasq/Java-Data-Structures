package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class FactorialTest {
  private Factorial factorial;

  @Test
  public void factRecursiveWithPositiveN() {
    factorial = new Factorial();
    int expected = 5040;

    int actual = factorial.factRecursive(7);

    assertEquals(expected, actual);

    factorial = null;
  }

  @Test
  public void factRecursiveWithNegativeN() {
    factorial = new Factorial();

    try {
      int actual = factorial.factRecursive(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("n < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    factorial = null;
  }

  @Test
  public void factIterativeWithPositiveN() {
    factorial = new Factorial();
    int expected = 5040;

    int actual = factorial.factIterative(7);

    assertEquals(expected, actual);

    factorial = null;
  }

  @Test
  public void factIterativeWithNegativeN() {
    factorial = new Factorial();

    try {
      int actual = factorial.factIterative(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("n < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    factorial = null;
  }

}