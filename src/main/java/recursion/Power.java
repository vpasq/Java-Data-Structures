package recursion;
import java.util.InputMismatchException;

/**
 * Power is a utility class that represents power functions
 *
 */
public  class Power {

  /**
   * Power method that doesn't except negative exponents
   *
   * @precondition n >= 0
   * @param x the number being raised to a power
   * @param n the exponent
   * @return x raised to a power n
   */
  public double powRecursive1(double x, int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    else if (n == 0)
      return 1;
    else
      return x * powRecursive1(x, n-1);
  }

  /**
   * Power method that accepts negative exponents
   *
   * @param x the number being raised to a power
   * @param n the exponent
   * @return x raised to a power n
   */
  public double powRecursive2(double x, int n) {
    if (n == 0)
      return 1;
    else if( n < 0)
      return 1 / (-n * powRecursive2(x, -n-1));
    else
      return x * powRecursive2(x, n-1);
  }
}

