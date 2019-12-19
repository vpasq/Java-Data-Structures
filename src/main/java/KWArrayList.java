// Create our own ArrayList class

import java.util.Arrays;

public class KWArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private E[] theData;
    private int size = 0;
    private int capacity = 0;

    @SuppressWarnings("unchecked")
    public KWArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public KWArrayList(int initialCapacity) {
        capacity = initialCapacity;
        theData = (E[]) new Object[capacity];
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return theData[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public E[] getArray() {
        return theData;
    }

    public E set(int index, E newValue) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    // if size is already equal to capacity, we must first allocate a new array
    // to hold the data and then copy the data to this new array.
    public boolean add(E anEntry) {
        if (size == capacity)
            reallocate();
        theData[size++] = anEntry;
        return true;
    }

    public void add(int index, E anEntry) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        if (size == capacity)
            reallocate();
//        for(int i = size; i > index; i--) {
//            theData[i] = theData[i-1];
//        }
        System.arraycopy(theData, index, theData, (index + 1), (theData.length - 1) - index);
        theData[index] = anEntry;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        E removedValue = theData[index];
//        for(int i = index + 1; i < size; i++) {
//            theData[i-1] = theData[i];
//        }
//        theData[size-1] = null;
        System.arraycopy(theData, index+1, theData, (index), (theData.length - 1) - index);
        size--;
        return removedValue;
    }

    private void reallocate() {
       capacity = 2 * capacity;
       theData = Arrays.copyOf(theData, capacity);
    }

    public int indexOf(E target) {
        for (int index = 0; index < size; index++) {
            if(target == null && theData[index] == null)
                return index;
            if (theData[index].equals(target)) {
                return index;
            }
        }
        return -1;
    }

    public void printArrayList() {
        for (int i = 0; i < size; i++) {
            System.out.println(theData[i]);
        }
    }

    public static void main(String[] args) {
        KWArrayList<Integer> customArrayList = new KWArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);
        customArrayList.add(6);
        customArrayList.add(7);
        customArrayList.add(8);
        customArrayList.add(9);
        customArrayList.add(10);
//        customArrayList.add(11);
//        customArrayList.add(13);
//        customArrayList.add(14);
//        customArrayList.add(15);

        customArrayList.remove(5);
        customArrayList.remove(4);
        customArrayList.remove(0);

        System.out.println("==============");
        System.out.println("Index = " + customArrayList.indexOf(7));
        System.out.println("Capacity = " + customArrayList.getCapacity());
        System.out.println("Size = " + customArrayList.getSize());
        customArrayList.printArrayList();
        System.out.println("==============");


        KWArrayList<String> customArrayList2 = new KWArrayList<>(7);
        customArrayList2.add("Vin");
        customArrayList2.add("John");
        customArrayList2.add("Evette");
        customArrayList2.add(null);
        //System.out.println(Arrays.toString(customArrayList2.getArray()));
        System.out.println("Index = " + customArrayList2.indexOf(null));
        System.out.println("Capacity = " + customArrayList2.getCapacity());
        System.out.println("Size = " + customArrayList2.getSize());
        customArrayList2.printArrayList();
        System.out.println("==============");


        Object[] strArray2 = customArrayList2.getArray();
        for(Object str : strArray2) {
            System.out.println(str);
        }
        System.out.println("==============");

        customArrayList2.add(1, "Peter");
        strArray2 = customArrayList2.getArray();
        for(Object str : strArray2) {
            System.out.println(str);
        }
        System.out.println("==============");

        customArrayList2.printArrayList();

        System.out.println("==============");
        customArrayList2.remove(1);
        strArray2 = customArrayList2.getArray();
        for(Object str : strArray2) {
            System.out.println(str);
        }
        System.out.println("==============");

        customArrayList2.printArrayList();


    }
}