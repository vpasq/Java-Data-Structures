package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class GCDTest {
  GCD gcd;

  @Test
  public void gcdIsValid() {
    gcd = new GCD();
    int expected = 5;

    int actual = gcd.gcd(25, 5);

    assertEquals(expected, actual);

    gcd = null;
  }

  @Test
  public void GCDWithNegativeM() {
    gcd = new GCD();

    try {
      int actual = gcd.gcd(-25, 5);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("m < 0 || n < 0 || n >= m", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    gcd = null;
  }

  @Test
  public void GCDWithNegativeN() {
    gcd = new GCD();

    try {
      int actual = gcd.gcd(25, -5);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("m < 0 || n < 0 || n >= m", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    gcd = null;
  }

  @Test
  public void GCDWithNGreaterThanM() {
    gcd = new GCD();

    try {
      int actual = gcd.gcd(5, 25);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("m < 0 || n < 0 || n >= m", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    gcd = null;
  }


  @Test
  public void GCDWithNEqualToM() {
    gcd = new GCD();

    try {
      int actual = gcd.gcd(5, 5);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("m < 0 || n < 0 || n >= m", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    gcd = null;
  }

}