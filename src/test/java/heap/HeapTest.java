package heap;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

public class HeapTest {
  Heap<Integer> heap;

  @Test
  public void add() {
    heap = new Heap<>(4);
    heap.add(1);
    heap.add(2);
    heap.add(3);
    heap.add(4);
    heap.add(5);
    heap.add(6);
    heap.add(7);
    heap.add(8);
    heap.add(9);
    heap.add(10);

    System.out.println(heap.toString());
  }

  @Test
  public void add2() {
    Heap<String> heap = new Heap<>(6);
    heap.add("J");
    heap.add("A");
    heap.add("M");
    heap.add("B");
    heap.add("L");
    heap.add("E");

    System.out.println(heap);
    System.out.println(heap.remove() + "\n");
    System.out.println(heap);

  }





}