package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class SearchStringTest {

  @Test
  public void charIsFound() {
    SearchString searchString = new SearchString();
    boolean expected = true;

    boolean actual = searchString.isTargetPresent("tictoc", 'o');

    assertEquals(expected, actual);

    searchString = null;
  }

  @Test
  public void charIsNotFound() {
    SearchString searchString = new SearchString();
    boolean expected = false;

    boolean actual = searchString.isTargetPresent("tictoc", 'z');

    assertEquals(expected, actual);

    searchString = null;
  }

}