package sorting;

import org.junit.*;
import java.util.Arrays;

public class MergeSortTest {

  @Test
  public void insert() {
    Integer[] arr = {8, 4, 6, 39, 3};

    Integer[] data = MergeSort.mergeSort(arr, 0, 5);


    System.out.println( Arrays.toString( data ));

  }

  @Test
  public void insert2() {
    Character[] arr = {'d', 'z', 'm', 'g', 'b'};

    Character[] data = MergeSort.mergeSort(arr, 0, 5);

    System.out.println( Arrays.toString( data ));

  }

  @Test
  public void insert3() {

    System.out.println( Arrays.toString( MergeSort.mergeSort2() ));

  }

}