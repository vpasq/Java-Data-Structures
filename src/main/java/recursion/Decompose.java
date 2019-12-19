package recursion;
import java.util.InputMismatchException;

/**
 * Decompose and then recover an integer.
 */
public class Decompose {

  /**
   * @precondition n is a non-negative number
   * @param n represents a number
   * @return the integer, n, decomposed and then recovered
   * @throws IllegalArgumentException Indicates n is negative
   */
  public int decompose(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    else if (n < 10)
      return n;
    else
      return (n / 10) * 10 + (n % 10);
  }
}