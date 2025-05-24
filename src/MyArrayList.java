import java.sql.Array;
import java.util.Collection;

public class MyArrayList <E> implements Collection <E> {

    private Object[] newArray;
    private int size;

    public MyArrayList(int initialSize) {
        if (initialSize >= 0) {
            this.newArray = new Object[initialSize];
        }
        this.size = 0;
    }

    public boolean add(E obj) {
        if (size == newArray.length) {
            Object[] tmpArray = new Object[(int) ((size * 1.5) + 1)];
            System.arraycopy(newArray, 0, tmpArray, 0, size);
            newArray = tmpArray;
            newArray[size] = obj;
            size++;
            return true;
        } else {
            newArray[size] = obj;
            size++;
            return true;
        }
    }

    public boolean addAll() {

    }

    public E get() {

    }

    public boolean remove(Object obj) {
        int foundIndex = -1;
        for (int index = 0; index < size; index++) {
            if (newArray[index] != null && newArray[index].equals(obj)) {
                foundIndex = index;
                break;
            }
        }

        if (foundIndex != -1) {
            System.arraycopy(newArray, foundIndex + 1, newArray, foundIndex, size - (foundIndex + 1));
            size--;
            newArray[size] = null;
            return true;
        } else {
            return false;
        }
    }
}
