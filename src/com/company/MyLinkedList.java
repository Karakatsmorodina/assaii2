package com.company;

public class MyLinkedList<T extends Comparable> implements MyList<T> {
    private static class MyNode<T> {
        T data;
        MyNode<T> next, prev;
        MyNode(T data) {
            this.data = data;
        }
    }
    private int length = 0;
    private MyNode<T> head, tail;
    public MyLinkedList() {
    }
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            MyNode<T> temp = head;
            int counter = index;
            while (temp.next != null && counter != 0) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        length += 1;
    }

    @Override
    public boolean remove(T item) {
        boolean result = true;
        if (head.data == item) {
            head = head.next;
            length -= 1;
        } else {
            MyNode<T> temp = head;
            MyNode<T> lag = null;
            while (temp.next != null && temp.next.data != item) {
                lag = temp;
                temp = temp.next;
            }
            assert lag != null;
            lag.next = temp.next;
            length -= 1;
        }
        return result;
    }

    @Override
    public T remove(int index) {
        if (index == 0) {
            head = head.next;
            length -= 1;
            return head.data;
        } else {
            MyNode<T> temp = head;
            MyNode<T> lag = null;
            while (temp.next != null && index != 0) {
                lag = temp;
                temp = temp.next;
            }
            assert lag != null;
            lag.next = temp.next;
            length -= 1;
            return temp.data;
        }
    }
    @Override
    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }
    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        MyNode<T> temp = head;
        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }
    @Override
    public int indexOf(Comparable o) {
        if (head.data == o) return 0;
        else {
            MyNode<T> temp = head;
            for (int i = 0; temp.data != null; i++, temp = temp.next) {
                if (temp.data == o) {
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Comparable o) {
        if (head.data == o) return 0;
        else {
            MyNode<T> temp = head;
            int index = -1;
            for (int i = 0; temp.data != null; i++, temp = temp.next) {
                if (temp.data == o) {
                    index = i;
                }
            }
            return index;
        }
    }
    @Override
    public void sort() {
        MyNode<T> current = head, index = null;
        if (head != null) {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.data.compareTo(index.data) > 0) {
                        T temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
    public int size() {
        return length;
    }
    @Override
    public boolean contains(Comparable o) {
        return false;
    }
}
