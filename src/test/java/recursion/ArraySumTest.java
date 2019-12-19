package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class ArraySumTest {
  private ArraySum arraySum;
  //private int[] arr = {1, 2, 3, -4, 5};
  private int[] arr = {1, 2, 3, 4, 5};

  @Test
  public void arraySumRecursive1WithInvalidLen() {
    arraySum = new ArraySum();

    try {
      int actual = arraySum.arraySumRecursive1(arr, -1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertEquals("len < 0", e.getMessage());
      //assertTrue(message.contains("n < 0"));
    }

    arraySum = null;
  }

  @Test
  public void arraySumRecursive1() {
    ArraySum arraySum = new ArraySum();
    int expected = 15;

    int actual = arraySum.arraySumRecursive1(arr, arr.length);

    assertEquals(expected, actual);

    arraySum = null;
  }

  @Test
  public void arraySumRecursive2() {
    ArraySum arraySum = new ArraySum();
    int expected = 15;

    int actual = arraySum.arraySumRecursive2(arr, 0);

    assertEquals(expected, actual);

    arraySum = null;
  }

  @Test
  public void arraySumRecursive3() {
    ArraySum arraySum = new ArraySum();
    int expected = 0;

    int actual = arraySum.arraySumRecursive3(arr,arr.length / 2);

    assertEquals(expected, actual);

    arraySum = null;
  }
}