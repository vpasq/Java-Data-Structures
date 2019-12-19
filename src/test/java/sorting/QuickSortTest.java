package sorting;

import org.junit.*;

import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {
  private QuickSort qs;

  @Test
  public void quickSortHigh1() {
    int size  = 1000000;
    Random rd = new Random();
    Integer[] data = new Integer[size];
    for (int i = 0; i < size; i++) {
      data[i] = rd.nextInt();
    }

    int left = 0;
    int right = data.length - 1;

    Integer[] partIndex = QuickSort.recQuickSort(data, left, right);
    System.out.println(Arrays.toString(data));
  }

  @Test
  public void quickSortHigh2() {
    int size  = 1000000;
    Random rd = new Random();
    Integer[] data = new Integer[size];
    for (int i = 0; i < size; i++) {
      data[i] = rd.nextInt();
    }

    int left = 0;
    int right = data.length - 1;

    Integer[] partIndex = QuickSort.recQuickSort2(data, left, right);
    System.out.println(Arrays.toString(data));
  }


  @Test
  public void quickSort1() {
    Integer[] data = {33, 44, 22, 11, 99, 0, 1};

    int left = 0;
    int right = data.length-1;

    Integer[] partIndex = QuickSort.recQuickSort(data, left, right);
    System.out.println(Arrays.toString(data));
  }

  @Test
  public void quickSort2() {
    String[] data = {"c", "v",  "a", "f", "y"};

    int left = 0;
    int right = data.length - 1;

    String[] partIndex = QuickSort.recQuickSort(data, left, right);
    System.out.println(Arrays.toString(data));
  }

  @Test
  public void quickSortInsertionSort() {
    Integer[] data = {33, 44, 22, 11, 99, 0, 1};

    int left = 0;
    int right = data.length-1;

    Integer[] partIndex = QuickSort.recQuickSort2(data, left, right);
    System.out.println(Arrays.toString(data));
  }

  @Test
  public void quickSortInsertionSort2() {
    String[] data = {"c", "v",  "a", "f", "y"};

    int left = 0;
    int right = data.length - 1;

    String[] partIndex = QuickSort.recQuickSort(data, left, right);
    System.out.println(Arrays.toString(data));
  }

  @Test
  public void partitionIt1() {
    String[] data = {"c", "v",  "a", "f", "y"};

    int left = 0;
    int right = data.length - 1;
    String pivot = "c";

    System.out.println("Pivot is " + pivot);
    int size = data.length - 1;

    int partIndex = QuickSort.partitionIt(data,left, size, pivot);
    System.out.println("Partition is at index " + partIndex);
    System.out.println(Arrays.toString(data));
  }

  @Test
  public void partitionIt2() {
    Integer[] data = {33, 44, 22, 11, 99, 0, 1, 4};

    int left = 0;
    int right = data.length - 1;
    int pivot = 22;

    System.out.println("Pivot is " + pivot);
    int size = data.length - 1;

    int partIndex = QuickSort.partitionIt(data,0, size, pivot);
    System.out.println("Partition is at index " + partIndex);
    System.out.println(Arrays.toString(data));
  }


}