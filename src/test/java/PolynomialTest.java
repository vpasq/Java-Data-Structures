
import org.junit.*;
import static org.junit.Assert.*;

public class PolynomialTest {
  private Polynomial polynomial;

  @Test
  public void constructWithNoArguments() {
    polynomial = new Polynomial();
    double expectedCoefficient = 0;
    int expectedDegree = -1;

    double actualCoefficient = polynomial.getCoefficient(0);
    int actualDegree = polynomial.getDegree();

    assertEquals(expectedCoefficient, actualCoefficient, 0.0);
    assertEquals(expectedDegree, actualDegree);

    polynomial = null;
  }

  @Test
  public void constructWithSpecifiedParameter() {
    polynomial = new Polynomial(4.2);
    double expectedCoefficient = 4.2;
    int expectedDegree = 0;

    double actualCoefficient = polynomial.getCoefficient(0);
    int actualDegree = polynomial.getDegree();

    assertEquals(expectedCoefficient, actualCoefficient, 0.0);
    assertEquals(expectedDegree, actualDegree);

    polynomial = null;
  }


  @Test
  public void constructPolynomialCopy() {
    polynomial = new Polynomial();
    polynomial.assignCoefficient(2.2, 2);
    polynomial.assignCoefficient(4.2, 4);

    Polynomial polynomial2 = new Polynomial(polynomial);

    assertTrue(polynomial2.equals(polynomial));

    polynomial = null;

  }

  @Test
  public void assignCoefficient() {
    polynomial = new Polynomial();
    polynomial.assignCoefficient(7.4, 3);
    double expectedCoefficient = 7.4;
    int expectedDegree = 3;

    double actualCoefficient = polynomial.getCoefficient(3);
    int actualDegree = polynomial.getDegree();

    assertEquals(expectedCoefficient, actualCoefficient, 0.0);
    assertEquals(expectedDegree, actualDegree);

    polynomial = null;
  }

  @Test
  public void assignCoefficientWithNegativeK () {
    polynomial = new Polynomial();

    try {
      polynomial.assignCoefficient(7.4, -3);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("k < 0 : Invoked from assignCoeffecient()"));
    }
  }

  @Test
  public void getDegree() {
    polynomial = new Polynomial();
    polynomial.assignCoefficient(2.2, 2);
    polynomial.assignCoefficient(4.2, 4);
    int expected = 4;

    int actual = polynomial.getDegree();

    assertEquals(expected, actual);

    polynomial = null;
  }

  @Test
  public void getCoefficient() {
    polynomial = new Polynomial();
    polynomial.assignCoefficient(2.2, 2);
    polynomial.assignCoefficient(5.2, 5);
    double expected = 2.2;

    double actual = polynomial.getCoefficient(2);

    assertEquals(expected, actual, 0.0);

    polynomial = null;
  }

  @Test
  public void getCoefficientWithNegativeK() {
    polynomial = new Polynomial();
    polynomial.assignCoefficient(2.2, 2);

    try {
      double actual = polynomial.getCoefficient(-2);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("k < 0 : Invoked from getCoefficient()"));
    }

    polynomial = null;
  }

  @Test
  public void reserve() {
    polynomial = new Polynomial(1.1);
    polynomial.assignCoefficient(2.2, 2);
    polynomial.assignCoefficient(3.2, 3);
    int expectedDegree = 3;

    int actualDegree = polynomial.getDegree();

    assertEquals(expectedDegree, actualDegree);

    polynomial = null;
  }

  @Test
  public void nextTerm() {
    polynomial = new Polynomial(5);
    polynomial.assignCoefficient(1.1,1);
    polynomial.assignCoefficient(3.1,3);
    polynomial.assignCoefficient(5.1,5);
    double expected = 3.1;

    double actual = polynomial.nextTerm(1);

    assertEquals(expected, actual, 0.0);

    polynomial = null;
  }

  @Test
  public void nextTermWithNegativeK() {
    polynomial = new Polynomial(1.1);

    try {
      polynomial.nextTerm(-1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("k < 0 : Invoked from nextTerm()"));
    }

    polynomial = null;
  }

  @Test
  public void addToCoefficient() {
    polynomial = new Polynomial(1.1);
    polynomial.assignCoefficient(1.1,1);
    double expected = 8.8;

    polynomial.addToCoefficient(7.7, 1);
    double actual = polynomial.getCoefficient(1);

    assertEquals(expected, actual, 0.0);

    polynomial = null;
  }

  @Test
  public void addToCoefficientWithNegativeK() {
    polynomial = new Polynomial(1.1);

    try {
      polynomial.addToCoefficient(10, -1);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      assertTrue(message.contains("k < 0 : Invoked from addToCoefficient()"));
    }

    polynomial = null;
  }

  @Test
  public void clear() {
    polynomial = new Polynomial();
    double expectedCoefficient = 0;
    int expectedDegree = -1;

    polynomial.clear();
    double actualCoefficient = polynomial.getCoefficient(0);
    int actualDegree = polynomial.getDegree();

    assertEquals(expectedCoefficient, actualCoefficient, 0.0);
    assertEquals(expectedDegree, actualDegree);

    polynomial = null;
  }

  @Test
  public void cloneTest() {
    polynomial = new Polynomial();
    polynomial.assignCoefficient(1.1,1);
    polynomial.assignCoefficient(3.1,3);
    polynomial.assignCoefficient(5.1,5);

    Polynomial polynomial2 = polynomial.clone();

    assertTrue(polynomial.equals(polynomial2));

    polynomial = null;
  }

  @Test
  public void eval() {
    polynomial = new Polynomial(2.2);
    //polynomial = new Polynomial();
    polynomial.assignCoefficient(1.1,1);
    polynomial.assignCoefficient(3.1,3);
    polynomial.assignCoefficient(4.1,4);
    double expectedResult =  4.1 * Math.pow(2, 4) + 3.1 * Math.pow(2, 3) + 1.1 * Math.pow(2, 1) + 2.2;
    //double expectedResult =  4.1 * Math.pow(2, 4) + 1.1 * Math.pow(2, 1) + 2.2;
    //double expectedResult =  4.1 * Math.pow(2, 4);

    double actualResult = polynomial.eval(2);

    assertEquals(expectedResult, actualResult, 0.0);

    polynomial = null;

  }


}


