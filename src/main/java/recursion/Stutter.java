package recursion;
import java.util.InputMismatchException;

/**
 * Stutter represents a string that repeats each of its characters
 */
public class Stutter {

  /**
   * @param str the specified string
   * @return the string with all its characters repeated
   */
  public String stutterChars(String str){
    if (str.length() == 1)
      return str + str;
    else
      return str.charAt(0) + "" + str.charAt(0) +
          stutterChars(str.substring(1));
  }
}