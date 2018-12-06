package generics;

/**
 * @author: Quinten Mortier
 **/
public class Demo_2 {


    public static void main(String[] args) {
        PriorityQueue<String> myQueue = new PriorityQueue<>();
        myQueue.enqueue("alfa", 2);
        myQueue.enqueue("beta", 5);
        myQueue.enqueue("gamma", 2);
        myQueue.enqueue("delta", 3);
        System.out.println("Overzicht van de PriorityQueue:");
        System.out.println(myQueue.toString());
        System.out.println("aantal: " + myQueue.getSize());
        System.out.println("positie van gamma: " + myQueue.search("gamma"));
        for(int i = 0; i < 4; i++) {
            System.out.println("Dequeue: " + myQueue.dequeue());
        }
        System.out.println("Size na dequeue: " + myQueue.getSize());
    }
}
