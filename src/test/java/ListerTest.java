
import org.junit.*;
import static org.junit.Assert.*;

public class ListerTest {

  @Test
  public void LinkedSeq() {
    LinkedSeq<Integer> seq = new LinkedSeq<Integer>();
    seq.addAfter(1);
    seq.addAfter(2);
    seq.addAfter(3);

    Lister<Integer> lister = new Lister<Integer>(seq.getHead());

    while (lister.hasNext()) {
      System.out.println(lister.next());
    }

    seq = null;
  }

  public static <E> int countNull(LinkedSeq<E> head) {

    Lister<E> lister = new Lister<E>(head.getHead());

    int count = 0;
    while (lister.hasNext()) {
      if (lister.next() == null) {
        count++;
      }
    }
    return count;
  }

  @Test
  public void countNullTest() {
    LinkedSeq<Integer> linkedSeq = new LinkedSeq<>();
    linkedSeq.addAfter(1);
    linkedSeq.addBefore(null);
    linkedSeq.addAfter(2);
    linkedSeq.addBefore(null);
    linkedSeq.addAfter(3);

    //Lister<Integer> lister = new Lister<Integer>(linkedSeq.getHead());

    System.out.println(ListerTest.countNull(linkedSeq));
  }

  public static <E> E find(Node<E> head, Comparable<E> x) {

    Lister<E> lister = new Lister<E>(head);

    E answer;
    while(lister.hasNext()) {
      answer = lister.next();
      if (answer != null && x.compareTo(answer) < 0 )
        return answer;
    }

    return null;
  }

  @Test
  public void countTest() {
    LinkedSeq<Integer> linkedSeq = new LinkedSeq<>();
    linkedSeq.addAfter(1);
    linkedSeq.addBefore(null);
    linkedSeq.addAfter(2);
    linkedSeq.addBefore(null);
    linkedSeq.addAfter(3);
    linkedSeq.addBefore(11);
    //linkedSeq.print();

    //Lister<Integer> lister = new Lister<Integer>(linkedSeq.getHead());


    System.out.println(ListerTest.find(linkedSeq.getHead(), 2));

  }
}
