package Heap;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> maxHeap ;
    PriorityQueue<Integer> minHeap ;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) ->(b-a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        
        if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
        else if(maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}

public class findMedianDataStream {
    
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(9);
        m.addNum(7);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
        m.addNum(1);
        System.out.println(m.findMedian()); 
        m.addNum(4);
        System.out.println(m.findMedian()); 
    }
}
