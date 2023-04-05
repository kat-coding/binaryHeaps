package heap;

public class BinaryHeap <T extends Comparable<T>>
{
    private T[] heap;
    private int size;

    public BinaryHeap()
    {
        heap = (T[])new Comparable[10];
        size = 0;
    }

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
    private void swap(int first, int second){
        T temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }
    public T remove(){
        return null;
    }
}
