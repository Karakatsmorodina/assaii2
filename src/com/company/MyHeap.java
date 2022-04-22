package com.company;
import java.util.Arrays;
public class MyHeap {
    private final int[] heap;
    private int heapSize;

    public MyHeap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }
    private int parent(int i) {return(i -1)/2;}
    private int child(int i, int k) {
        return 2 * i + k;
    }
    private int maxChild(int i) {
        int leftChild = child(i, 1);
        int rightChild = child(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }
    public void add(int x) {
        if (heapSize == heap.length) return;
        heap[heapSize++] = x;
        heapify(heapSize - 1);
    }
    public void remove(int index) {
        heap[index] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(index);
    }
    public void removeRoot() {
        remove(heap[0]);
    }
    private void heapify(int i) {
        int temp = heap[i];
        while (i > 0 && temp > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }
    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (child(i, 1) < heapSize) {
            child = maxChild(i);
            if (temp < heap[child]) {
                heap[i] = heap[child];
            } else break;
            i = child;
        }
        heap[i] = temp;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(heap, heapSize));
    }
}