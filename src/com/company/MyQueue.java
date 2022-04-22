package com.company;
import java.util.Arrays;
import java.util.Objects;
public class MyQueue<T extends Comparable<T>>{
    private final Object[] queue;
    private static int first, last, capacity;
    public MyQueue(int size) {
        first = last = 0;
        capacity = size;
        queue = new Object[capacity + 1];
    }
    public void add(T element) {
        if (last == capacity) return;
        queue[last] = element;
        last++;
    }
    public T get(int element) {
        return (T) queue[element];
    }
    public void remove(){
        if (first == last) return;
        if (last - 1 + 1 >= 0) System.arraycopy(queue, 1, queue, 0, last - 1 + 1);
        if (capacity > last) queue[last] = null;
        last--;
    }
    public Object peek(){
        if (first == last) return null;
        return queue[first];
    }
    public Object poll(){
        if (first == last) return null;
        Object tmp = queue[first];
        remove();
        return tmp;
    }
    @Override
    public String toString() {
        return "" + Arrays.stream(queue).filter(Objects::nonNull).toList();
    }
}
