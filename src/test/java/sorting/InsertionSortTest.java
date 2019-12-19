package sorting;

import org.junit.*;

import java.util.Arrays;
import java.util.Random;

public class InsertionSortTest {
  private InsertionSort<Integer> is;

  @Test
  public void insert(){
    is = new InsertionSort<>(10);
    is.insert(77);
    is.insert(99);
    is.insert(44);
    is.insert(55);
    is.insert(55);
    is.insert(88);
    is.insert(11);
    is.insert( 0);
    is.insert(66);
    is.insert(33);

    //System.out.println(is.toString());
    is.insertionSort();
    System.out.println(is.toString());


    is = null;
  }

  @Test
  public void insert2(){
    is = new InsertionSort<>(10);
    is.insert(77);
    is.insert(99);
    is.insert(44);
    is.insert(55);
    is.insert(22);
    is.insert(55);
    is.insert(11);
    is.insert( 0);
    is.insert(66);
    is.insert(33);

    //System.out.println(is.toString());
    is.insertionSort2();
    System.out.println(is.toString());

    is = null;
  }

  @Test
  public void insert3(){
    int size = 100000;
    is = new InsertionSort<>(size);

    Random random = new Random();
    Integer[] data = new Integer[size];
    for (int i = 0; i < size; i++) {
      is.insert(random.nextInt());
    }

    //System.out.println(is.toString());
    is.insertionSort2();
    System.out.println(is.toString());

    is = null;
  }

  @Test
  public void insertWithAlreadySortedArray(){
    is = new InsertionSort<>(10);
    is.insert(1);
    is.insert(2);
    is.insert(3);
    is.insert(4);
    is.insert(5);
    is.insert(6);
    is.insert(7);
    is.insert(8);
    is.insert(9);
    is.insert(10);

    //System.out.println(is.toString());
    is.insertionSort();
    System.out.println(is.toString());

    is = null;
  }

  @Test
  public void insertWithBackwardSortedArray(){
    is = new InsertionSort<>(10);
    is.insert(10);
    is.insert(11);
    is.insert(12);
    is.insert(13);
    is.insert(14);
    is.insert(15);
    is.insert(16);
    is.insert(17);
    is.insert(18);
    is.insert(19);

    //System.out.println(is.toString());
    is.insertionSort();
    System.out.println(is.toString());

    is = null;
  }


  @Test
  public void insertWithOnlyOneElement(){
    is = new InsertionSort<>(1);
    is.insert(10);

    //System.out.println(is.toString());
    is.insertionSort();
    System.out.println(is.toString());

    is = null;
  }

  //Todo: fix
//  @Test
//  public void insertWithZeroElements(){
//    is = new InsertionSort(10);
//
//    System.out.println(is.toString());
//    is.insertionSort();
//    System.out.println(is.toString());
//
//  }


}
