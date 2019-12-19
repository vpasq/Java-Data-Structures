package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class DecomposeTest {
  private Decompose DecomposeRecover = new Decompose();

  @Test
  public void decomposeWithNegativeN() {
    try {
      int actual = DecomposeRecover.decompose(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("n < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    DecomposeRecover = null;
  }

  @Test
  public void decomposeWithPositiveN() {
    //DecomposedRecovered = new DecomposedRecovered();
    int expected = 733;

    int actual = DecomposeRecover.decompose(733);

    assertEquals(expected, actual);

    DecomposeRecover = null;
  }
}