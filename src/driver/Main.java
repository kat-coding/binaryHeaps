package driver;

import heap.BinaryHeap;

public class Main {
    public static void main(String[] args) {

        BinaryHeap<String> heapOfLetters = new BinaryHeap<>();
        String [] inputs = {"q", "s", "v", "g", "i", "p", "a", "k", "b"};

        for (String input: inputs) {
            heapOfLetters.add(input);
        }
        System.out.println(heapOfLetters.remove());
        System.out.println(heapOfLetters.remove());

    }
}