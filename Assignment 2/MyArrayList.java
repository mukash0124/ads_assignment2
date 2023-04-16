import java.util.Arrays;

public class MyArrayList<T> implements MyList<T>{
    private Object[] hiddenArray;
    private int length;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        hiddenArray = new Object[initialCapacity];
    }

    private void increaseArray() {
        int biggerSize = (int)(hiddenArray.length * 2);
        Object[] newArray = new Object[biggerSize];

        for (int i = 0; i < hiddenArray.length; i++) {
            newArray[i] = hiddenArray[i];
        }

        hiddenArray = newArray;
    }

    @Override
    public void add(T item) {
        if (length == hiddenArray.length) {
            increaseArray();
        }

        hiddenArray[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (length == hiddenArray.length) {
            increaseArray();
        }

        for (int i = length; i > index; i++) {
            hiddenArray[i] = hiddenArray[i - 1];
        }

        hiddenArray[index] = item;
        
    }

    @Override
    public T get(int index) {
        if (index >= length) throw new IndexOutOfBoundsException();

        return (T)hiddenArray[index];
    }

    @Override
    public T remove(int index) {
        if (index >= length) throw new IndexOutOfBoundsException();

        T item = get(index);

        for (int i = index; i < length; i++) {
            hiddenArray[i] = hiddenArray[i + 1];
        }
        length--;

        return item;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if(get(i) == o) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if(get(i) == o) {
                index = i;
            }
        }

        return index;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            hiddenArray[i] = null;
        }
        length = 0;
    }

    @Override
    public void sort() {
        Arrays.sort(hiddenArray);
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < length; i++) {
            if(hiddenArray[i] == o) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(indexOf(o) == -1) {
            return false;
        } else {
            remove(indexOf(o));
            return true;
        }
    }


}
