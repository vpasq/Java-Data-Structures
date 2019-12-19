package recursion;
import org.junit.*;
import static org.junit.Assert.*;

public class StutterTest {

  @Test
  public void stutter() {
    Stutter stutter = new Stutter();
    String expected = "HHeelllloo!!";

    String actual = stutter.stutterChars("Hello!");

    assertEquals(expected, actual);

    stutter = null;
  }

}