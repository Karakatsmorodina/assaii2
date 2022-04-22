package com.company;
public class MyStack<T extends Comparable<T>> {
    private final MyArrayList<T> elements = new MyArrayList<T>();
    public void push(T element){
        elements.add(element);
    }
    public T peek(){
        if (empty()) return null;
        return elements.get(elements.size() - 1);
    }
    public T pop(){
        if (empty()) return null;
        T top = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return top;
    }
    public boolean empty(){
        return elements.size() == 0;
    }
    @Override
    public String toString() {
        return " " + elements;
    }
}
