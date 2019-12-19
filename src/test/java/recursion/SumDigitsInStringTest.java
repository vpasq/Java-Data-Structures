package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class SumDigitsInStringTest {

  @Test
  public void toNumber() {
    SumDigitsInString sumDigits = new SumDigitsInString();
    int expected = 24;

    int actual = sumDigits.toNumber("a777e3");

    assertEquals(expected, actual);

    sumDigits = null;
  }

}