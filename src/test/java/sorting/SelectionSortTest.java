package sorting;

import sorting.SelectionSort;
import org.junit.*;

public class SelectionSortTest {
  private SelectionSort<Integer> bs;

  @Test
  public void insert(){
    bs = new SelectionSort<>(10);
    bs.insert(77);
    bs.insert(99);
    bs.insert(44);
    bs.insert(55);
    bs.insert(22);
    bs.insert(88);
    bs.insert(11);
    bs.insert( 0);
    bs.insert(66);
    bs.insert(33);

    System.out.println(bs);
    bs.selectionSort();
    System.out.println(bs);
  }

  @Test
  public void insert2(){
    bs = new SelectionSort<>(10);
    bs.insert(77);
    bs.insert(99);
    bs.insert(44);
    bs.insert(55);
    bs.insert(22);
    bs.insert(88);
    bs.insert(11);
    bs.insert( 0);
    bs.insert(66);
    bs.insert(33);

    System.out.println(bs);
    bs.selectionSort2();
    System.out.println(bs);
  }

  @Test
  public void insertWithAlreadySortedArray(){
    bs = new SelectionSort<>(10);
    bs.insert(1);
    bs.insert(2);
    bs.insert(3);
    bs.insert(4);
    bs.insert(5);
    bs.insert(6);
    bs.insert(7);
    bs.insert(8);
    bs.insert(9);
    bs.insert(10);

    System.out.println(bs);
    bs.selectionSort();
    System.out.println(bs);
  }

  @Test
  public void insertWithBackwardSortedArray(){
    bs = new SelectionSort<>(10);
    bs.insert(10);
    bs.insert(11);
    bs.insert(12);
    bs.insert(13);
    bs.insert(14);
    bs.insert(15);
    bs.insert(16);
    bs.insert(17);
    bs.insert(18);
    bs.insert(19);

    System.out.println(bs);
    bs.selectionSort();
    System.out.println(bs);
  }


  @Test
  public void insertWithOnlyOneElement(){
    bs = new SelectionSort<>(1);
    bs.insert(10);

    System.out.println(bs);
    bs.selectionSort();
    System.out.println(bs);
  }

  @Test
  public void insertWithZeroElements(){
    bs = new SelectionSort(10);

    System.out.println(bs);
    bs.selectionSort();
    System.out.println(bs);
  }

  @Test
  public void insertWithString(){
    SelectionSort<String> bs;

    bs = new SelectionSort<>(10);
    bs.insert("aa");
    bs.insert("zz");
    bs.insert("gg");
    bs.insert("cc");
    bs.insert("bb");

    System.out.println(bs);
    bs.selectionSort();
    System.out.println(bs);
  }

}
