package Objects;

import java.io.Serializable;
import java.util.*;

public class MyQueue implements Serializable{
    List<Object> list;

    public MyQueue() {
        list = new ArrayList<>();
    }

    public void add(Object o) {
        list.add(o);
    }

    public Object remove() {
        if (list.size() == 0) {
            return null;
        }
        return list.remove(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public Object peek() {
        return list.get(0);
    }
}
