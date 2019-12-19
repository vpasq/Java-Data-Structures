package recursion;
import java.util.InputMismatchException;

/**
 * Fibonacci represents the well-known Fibonacci sequence.
 */
public class Fibonacci {

  /**
   * @precondition n is non-negative
   * @param n the index of the term in the sequence
   * @return the n-th term in the sequence
   * @throws IllegalArgumentException Indicates n is negative
   */
  public int fibRecursive1(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    else if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else
      return fibRecursive1(n-1) + fibRecursive1(n-2);
  }

  /**
   * @precondition n is non-negative
   * @param n the index of the term in the sequence
   * @return the n-th term in the sequence
   * @throws IllegalArgumentException Indicates n is negative
   */
  public int fibRecursive2(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    else if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else {
      int aux = 1;
      for(int i = 1; i < (n-1); i++){
        aux += fibRecursive2(i);
      }
      return aux;
    }
  }

  /**
   * @precondition n is non-negative
   * @param n the index of the term in the sequence
   * @return the n-th term in the sequence
   * @throws IllegalArgumentException Indicates n is negative
   */
  public int fibIterative(int n) throws IllegalArgumentException {
    if (n < 0)
      throw new IllegalArgumentException("n < 0");
    int t1 = 0;
    int t2 = 1;
    for (int i = 0; i < n; i++) {
      int t3 = t1 + t2;
      t1 = t2;
      t2 = t3;
    }
    return t1;
  }
}