package com.company;
public class MyArrayList<T extends Comparable> implements MyList<T> {
    private Comparable[] arr;
    private int length = 0;
    private int capacity = 3;
    public MyArrayList() {
        arr = new Comparable[capacity];
    }
    public void add(T item) {
        if (length == capacity)
            increaseCapacity();
        arr[length++] = item;
    }
    @Override
    public void add(T item, int index) {
        if (length == capacity)
            increaseCapacity();
        Comparable[] temp = new Comparable[arr.length];
        if (index >= 0) System.arraycopy(arr, 0, temp, 0, index);
        temp[index] = item;
        if (arr.length - index >= 0) System.arraycopy(arr, index, temp, index + 1, arr.length - index);
        arr = temp;
        length += 1;
    }
    @Override
    public boolean remove(T item) {
        if (contains(item)) {
            Comparable[] temp = new Comparable[arr.length];

            for (int i =0 ; i < arr.length; i++) {
                if (arr[i] == item) break;
                temp[i] = arr[i];
            }
            for (int i = 0; i < arr.length - 1; i++) {
                temp[i] = arr[i + 1];
            }
            arr = temp;
            length -= 1;
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index > 0 && index < arr.length - 1) {
            Object temp = arr[index];
            System.arraycopy(arr, index + 1, arr, index + 1 - 1, arr.length - index + 1);
            arr[arr.length - 1] = null;
            length -= 1;
            return (T)temp;
        }
        return null;
    }

    @Override
    public void clear() {
        arr = new Comparable[capacity];
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Comparable[] old = arr;
        arr = new Comparable[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public int indexOf(Comparable o) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == o) return i;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Comparable o) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == o) return i;
        }
        return -1;
    }
    @Override
    public void sort() {
        for (int i = 0; i < length; i++)
            for (int j = 0; j < i; j++)
                if (arr[i].compareTo(arr[j]) > 1) {
                    Comparable temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
    }
    public int size() {
        return length;
    }
    @Override
    public boolean contains(Comparable o) {
        for (int i = 0; i < length; i++) if (arr[i] == o) return true;
        return true;
    }
}

