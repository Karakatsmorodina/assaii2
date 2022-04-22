package com.company;

public interface MyList<T extends Comparable> {
    int size();
    boolean contains(Comparable o);
    void add(T item);
    void add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    void clear();
    T get(int index);
    int indexOf(Comparable o);
    int lastIndexOf(Comparable o);
    void sort();
}

