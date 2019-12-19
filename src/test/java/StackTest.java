
import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {

  @Test
  public void constructStack() {
    Stack<Integer> stack = new Stack<Integer>();
    int expected = 0;

    int actual = stack.size();

    assertEquals(expected, actual);

    stack = null;
  }

  @Test
  public void push() {
    Stack<Integer> stack = new Stack<Integer>();
    int expected = 1;
    int expected2 = 6;
    int expected3 = 6;

    stack.push(6);
    int actual = stack.size();
    int actual2 = (Integer)stack.peek();
    Integer actual3 = (Integer)stack.pop();

    assertEquals(expected, actual);
    assertEquals(expected2, actual2);
    assertEquals(expected3, actual3, 0.0);

    stack = null;
  }

  @Test
  public void reverseString() {
    Stack<String> stack = new Stack<String>();
    stack.push("t");
    stack.push("a");
    stack.push("n");
    String expected = "nat";

    String actual = "";
    while(!stack.isEmpty())
    actual += stack.pop();

    assertEquals(expected, actual);

    stack = null;
  }

}