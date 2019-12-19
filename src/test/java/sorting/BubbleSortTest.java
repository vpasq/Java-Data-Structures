package sorting;

import org.junit.*;
import java.util.Random;

public class BubbleSortTest {
    private BubbleSort<Integer> bs;

@Test
public void insert(){
    bs=new BubbleSort<Integer>(10);
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
    bs.bubbleSort2();
    System.out.println(bs);

    }


    @Test
    public void insert2(){

        // Will take some time
        int size = 100000;
        bs=new BubbleSort<Integer>(size);

        Random random = new Random();
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            bs.insert(random.nextInt());
        }

        bs.bubbleSort();
        System.out.println(bs);

    }


}
