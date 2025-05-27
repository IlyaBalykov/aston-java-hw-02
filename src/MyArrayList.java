import java.util.Collection;
import java.util.List;

public class MyArrayList <E> implements List<E> {

    private E[] newArray;
    private int size;

    public MyArrayList(int initialSize) {
        if (initialSize >= 0) {
            this.newArray = (E[]) new Object[initialSize];
        }
        this.size = 0;
    }

    @Override
    public boolean add(E obj) {
        if (size == newArray.length) {
            Object[] tmpArray = new Object[(int) ((size * 1.5) + 1)];
            System.arraycopy(newArray, 0, tmpArray, 0, size);
            newArray = (E[]) tmpArray;
            newArray[size] = obj;
            size++;
            return true;
        } else {
            newArray[size] = obj;
            size++;
            return true;
        }
    }

    @Override
    public boolean addAll(Collection <? extends  E> elements) {
        if (size + elements.size()> newArray.length) {
            Object[] tmpArray = new Object[(int) (size + elements.size() + 1)];
            System.arraycopy(newArray, 0, tmpArray, 0, size);
            newArray = (E[]) tmpArray;
        }
        for (E el: elements) {
            newArray[size] = el;
            size++;
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= size - 1) {
            return (E) newArray[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ. Индекс: " + index + " Размер: " + size);
        }
    }

    @Override
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
