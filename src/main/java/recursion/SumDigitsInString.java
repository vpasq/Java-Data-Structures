package recursion;
import java.util.InputMismatchException;

/**
 * SumDigitsInString represents the sum of the digits in a specified string
 */
public  class SumDigitsInString {

  /**
   * @param str the string to search for and add digits
   * @return the sum of the digit characters in the string, str
   */
  public int toNumber(String str) {
    char c;
    int count = 0;
    if (str.length() == 0)
      return 0;
    else {
      c = str.charAt(0);
      if (Character.isDigit(c))
        return Character.digit(c, 10) + toNumber(str.substring(1));
      else
        return toNumber(str.substring(1));
    }
  }
}
