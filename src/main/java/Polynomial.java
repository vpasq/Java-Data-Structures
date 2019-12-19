/******************************************************************************
 * Polynomial represents a polynomial from algebra with double coefficients.
 * e.g. 4x3 + 3x2 - 5x + 2
 ******************************************************************************/


import java.util.*;

public class Polynomial implements Cloneable {
  private int degree;
  private double[] data;

  /**
   * Constructs a polynomial with all zero coefficients.
   *
   * @postcondition 0th coefficient is 0, degree is 0
   **/
  public Polynomial() {
    data = new double[1];
    data[0] = 0;
  }

  /**
   * Constructs a polynomial and sets the 0th coefficient to the parameter, a0,
   * and all other coefficients to zero. (a zero degree polynomial: constant)
   *
   * @param a0 the 0th coefficient
   * @postcondition 0th coefficient is a0, degree is 0
   **/
  public Polynomial(double a0) {
    data = new double[1];
    data[0] = a0;
  }

  /**
   * Constructs a polynomial as a copy of the parameter, source.
   *
   * @param source is the Polynomial object that is copied.
   */
  public Polynomial(Polynomial source) {
    data = new double[source.data.length];
    System.arraycopy(source.data, 0, data, 0, source.data.length);
  }

  /**
   * Assigns coefficient to term with degree k
   *
   * @param newCoefficient is the assigned coefficient
   * @param k              is the degree of the polynomial
   * @throws IllegalArgumentException Indicates that k is negative
   * @postcondition newCoefficient is assigned to nth term with degree k
   **/
  public void assignCoefficient(double newCoefficient, int k) {
    if (k < 0)
      throw new IllegalArgumentException("k < 0 : Invoked from assignCoeffecient()");
    reserve(k);
    degree = k;
    data[k] = newCoefficient;
  }

  /**
   * Accessor method that returns the degree of the polynomial
   *
   * @return the degree of the polynomial
   */
  public int getDegree() {
    if (degree == 0 && data[0] == 0)
      return -1;
    else
      return degree;
  }

  /**
   * Accessor method for value of coefficient at degree k.
   *
   * @param k is the degree of the polynomial
   * @return value of coefficient at degree k.
   * @throws IllegalArgumentException indicates k is negative.
   * @precondition k is non-negative
   **/
  public double getCoefficient(int k) {
    if (k < 0)
      throw new IllegalArgumentException("k < 0 : Invoked from getCoefficient()");
    return data[k];
  }


  /**
   * Adds parameter, amount, to coefficient of polynomial term with degree k.
   *
   * @param amount is the amount to add to coefficient of polynomial term
   *               with degree k.
   * @param k      the degree of the polynomial
   * @throws IllegalArgumentException indicates k is negative.
   * @postcondition amount added to coefficient of term with degree k.
   **/
  public void addToCoefficient(double amount, int k) {
    if (k < 0)
      throw new IllegalArgumentException("k < 0 : Invoked from addToCoefficient()");
    data[k] = data[k] + amount;
  }

  /**
   * Allocate space for polynomial with degree k
   *
   * @param degree the polynomial degree
   * @throws IllegalArgumentException indicates degree is negative.
   * @precondition the degree is non-negative
   * @postcondition Space in the underlying array for the polynomial is reserved.
   * If the underlying array's length was already at or greater than the length
   * needed for the polynomial, then the array's length is left unchanged.
   **/
  private void reserve(int degree) {
    if (data.length < degree + 1)
      data = Arrays.copyOf(data, degree + 1);
  }

  /**
   * Clears the data array
   *
   * @postcondition 0th coefficient is 0, degree is 0
   */
  public void clear() {
    data = new double[1];
    data[0] = 0;
  }

  /**
   * Generate a copy of this polynomial.
   *
   * @return a copy of this polynomial.
   **/
  public Polynomial clone() {
    Polynomial answer;

    try {
      answer = (Polynomial) super.clone();
    } catch (CloneNotSupportedException e) {
      // This exception should not occur. But if it does, it would probably
      // indicate a programming error that made super.clone unavailable.
      // The most common error would be forgetting the "Implements Cloneable"
      // clause at the start of this class.
      throw new RuntimeException
          ("This class does not implement Cloneable");
    }

    answer.data = data.clone();

    return answer;
  }

  /**
   * Compares the data array of the calling Polynomial to the passed in Polynomial.
   *
   * @param obj the passed in Polynomial object
   * @return true if the data array of the calling Polynomial object has the same
   * values as the data array of the passed in Polynomial object, false
   * otherwise.
   */
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() == obj.getClass()) {
      Polynomial other = (Polynomial) obj;
      return Arrays.equals(data, other.data);
    } else {
      return false;
    }
  }

  /**
   * Accessor method for value of coefficient of first nonzero term
   * after term with degree k.
   *
   * @param k is the degree of the polynomial
   * @return next term with a nonzero coefficient after term with degree k.
   * If there are no nonzero terms after the term with degree k,
   * then returns -1.
   * @throws IllegalArgumentException indicates k is negative.
   * @precondition k is non-negative
   **/
  public double nextTerm(int k) {
    if (k < 0)
      throw new IllegalArgumentException("k < 0 : Invoked from nextTerm()");

    for (int i = k; i < degree; i++) {
      if (data[i+1] != 0)
        return data[i+1];
    }

    return -1;
  }

  /**
   * Evaluate polynomial at the given value of x.
   *
   * @param x the given value of x.
   * @return the value of the polynomial at the given value of x.
   */
  public double eval(double x) {
    double sum = data[0];
    for(int i = 0; nextTerm(i) != -1; i++) {
      while(data[i+1] == 0) {
        i++;
      }
      sum += nextTerm(i) * Math.pow(x, i+1);
    }

    return (double)Math.round(sum * 100d) / 100d;
  }
}