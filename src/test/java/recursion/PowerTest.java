package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class PowerTest {
  Power pow;

  @Test
  public void powRecursive1WithPositiveN() {
    pow = new Power();
    int expected = 27;

    double actual = pow.powRecursive1(3.0, 3);

    assertEquals(expected, actual, 0.0);

    pow = null;
  }

  @Test
  public void powRecursive1WithNegativeN() {
    pow = new Power();

    try {
      double actual = pow.powRecursive1(3.0, -3);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("n < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    pow = null;
  }

  @Test
  public void powRecursive2WithNegativeN() {
    pow = new Power();
    double expected = 1.0 / 27.0;

    double actual = pow.powRecursive2(3.0, -3);

    assertEquals(expected, actual, 0.0);

    pow = null;
  }
}