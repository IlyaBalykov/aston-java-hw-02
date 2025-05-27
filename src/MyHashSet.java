import java.util.ArrayList;
import java.util.Collection;

public class MyHashSet <E> implements Collection <E> {

    private ArrayList <E> newArray;

    public MyHashSet() {
        this.newArray = new ArrayList<>();
    }

    @Override
    public boolean add(E someObj) {
        if(newArray.contains(someObj)) {
            return false;
        } else {
            newArray.add(someObj);
            return true;
        }
    }

    @Override
    public boolean remove(Object someObj) {
        return  newArray.remove(someObj);
    }
}