package heap;

import java.util.NoSuchElementException;

public class BinaryHeap <T extends Comparable<T>>
{
    private final T[] heap;
    private int size;

    /**
     * Binary heap constructor
     */
    public BinaryHeap()
    {
        heap = (T[]) new Comparable[10];
        size = 0;
    }

    /**
     * Adds  an element to heap
     * @param element to be added
     */
    public void add(T element)
    {
        heap[size + 1] = element;
        size++;
        swim(size);
    }

    private void swim(int currentIndex)
    {
        //loop from current index to root
        while(currentIndex > 1){
            int parentIndex = currentIndex/2;
            //compare and swap if parent is larger
            if(heap[currentIndex].compareTo(heap[parentIndex]) < 0){
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            }
            else{
                //no looping if in order
                break;
            }
        }
    }
    private void swap(int first, int second)
    {
        T temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }
    public T remove()
    {
        if(size == 0){
            throw new NoSuchElementException("Heap is empty");
        }
        //save element to remove
        T removed = heap[1];

        //replace the root
        heap[1] = heap[size];
        heap[size] = null;
        size--;

        //reorder the heap, sink at root
        sink(1);
        return removed;
    }

    private void sink(int parentIndex)
    {
        // size/2 is largest index with child
        while(parentIndex <= size/2){
            //get children
            int leftIndex = 2*parentIndex;
            int rightIndex = 2*parentIndex+1;

            //determine smallest child
            int smallestChildIndex = leftIndex;
            if(rightIndex <= size && heap[leftIndex].compareTo(heap[rightIndex]) > 0){
                smallestChildIndex = rightIndex;
            }
            //is the parent and child out of order
            if(heap[parentIndex].compareTo(heap[smallestChildIndex]) >0){
                swap(parentIndex, smallestChildIndex);
                parentIndex = smallestChildIndex;
            }else{
                break;
            }

        }
    }
}
