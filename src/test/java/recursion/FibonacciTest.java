package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class FibonacciTest {
  private Fibonacci fibonacci;

  @Test
  public void fibRecursive1WithNegativeN() {
    fibonacci = new Fibonacci();

    try {
      int actual = fibonacci.fibRecursive1(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("n < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    fibonacci = null;
  }

  @Test
  public void fibRecursive1WithPositiveN() {
    fibonacci = new Fibonacci();
    int expected = 13;

    int actual = fibonacci.fibRecursive1(7);

    assertEquals(expected, actual);

    fibonacci = null;
  }

  @Test
  public void fibRecursive2WithNegativeN() {
    fibonacci = new Fibonacci();

    try {
      int actual = fibonacci.fibRecursive2(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("n < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    fibonacci = null;
  }

  @Test
  public void fibRecursive2WithPositiveN() {
    fibonacci = new Fibonacci();
    int expected = 13;

    int actual = fibonacci.fibRecursive2(7);

    assertEquals(expected, actual);

    fibonacci = null;
  }

  @Test
  public void fibIterative() {
    fibonacci = new Fibonacci();
    int expected = 13;

    int actual = fibonacci.fibIterative(7);

    assertEquals(expected, actual);

    fibonacci = null;
  }
}