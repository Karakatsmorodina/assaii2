package com.company;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> MQ = new MyQueue<Integer>(5);
        MQ.add(4);
        MQ.add(5);
        MQ.add(6);
        MQ.add(7);
        MQ.add(8);
        System.out.println(MQ + " - my queue add()");
        MQ.remove();
        MQ.remove();
        System.out.println(MQ + " - my queue - remove()");
        System.out.println(MQ.poll() + " - my queue poll()");
        System.out.println(MQ + " - result of poll()");
        System.out.println(MQ.peek() + " - my queue peek()");
        System.out.println("----------");
        MyStack<Integer> MS = new MyStack<Integer>();
        System.out.println(MS.empty() + " - my stack empty()");
        MS.push(4);
        MS.push(5);
        MS.push(6);
        System.out.println(MS + " - my stack push()");
        System.out.println(MS.peek() + " - my stack peek()");
        System.out.println(MS.pop() + " - my stack pop()");
        System.out.println(MS + " - result of pop()");
        System.out.println("------------");
        MyHeap MH = new MyHeap(10);
        MH.add(10);
        MH.add(4);
        MH.add(9);
        MH.add(1);
        MH.add(7);
        MH.add(5);
        MH.add(3);
        System.out.println(MH + " - my heap add() & heapify()");
        MH.remove(0);
        System.out.println(MH + " - my heap remove() & heapifyDown()");
        MH.removeRoot();
        System.out.println(MH + " - my heap removeRoot()");
    }
}