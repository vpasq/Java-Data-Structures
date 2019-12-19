package recursion;

/**
 * GCD represents the greatest common divisor
 *
 * @note Euclid's Algorithm for finding the greatest common divisor (gcd) for
 *       two integers, m and n, based on the following definition:
 *
 *         gcd(m, n) = n if n is a divisor of m
 *         gcd(m, n) = gcd(n, m % n) if n isn't a divisor of m
 *
 *         Recursive algorithm for calculating gcd(m ,n) for m > n
 *         if n is a divisor of m
 *           The result is n
 *         else
 *           The result is gcd(n, m % n)
 *
 * @note Verify:
 *         1. The base case is "n is a divisor of m". If so, the solution is n,
 *            (n is the gcd), which is correct.
 *
 *         2. The recursive case makes progress to the base case because both
 *            arguments in each recursive call are smaller than in the previous
 *            call, and the new second argument is always smaller than the new
 *            first argument (m % n must be less than n).
 *
 *         3. Eventually a divisor will be found, or the second argument will
 *            become 1. Since 1 is a base case (1 divides every integer), we
 *            have verified that the recursive case makes progress toward the
 *            base case.
 */
public class GCD {

  /**
   * @precondition m > 0 and n > 0
   * @param m the larger specified number
   * @param n the smaller specified number
   * @return the greatest common divisor of m and n
   */
  public int gcd(int m, int n) throws IllegalArgumentException{
    if (m < 0 || n < 0 || n >= m)
      throw new IllegalArgumentException("m < 0 || n < 0 || n >= m");
    else if (m % n == 0)
      return n;
    else
      return gcd(n, m % n);
  }
}