package recursion;

/**
 * Search for finding a target character in a string
 */
public class SearchString {

  /**
   * @param str the string to search in
   * @param target the specified character to search for
   * @return true if target is found, false otherwise
   */
  public boolean isTargetPresent(String str, char target) {
    if (str == null || str.isEmpty())
      return false;
    else if (str.charAt(0) == target) {
      return true;
    } else {
      return isTargetPresent(str.substring(1), target);
    }
  }
}