package generics;

import java.util.*;

/**
 * @author: Quinten Mortier
 **/
public class PriorityQueue<T> implements FIFOQueue {
    private Map<Integer, LinkedList<T>> queue = new TreeMap<>();

    @Override
    public boolean enqueue(Object element, int priority) {
        //als de key nog niet bestaat
        if (!queue.containsValue(element)){
            if (!(queue.containsKey(priority))){
                LinkedList newList = new LinkedList();
                newList.add(element);
                queue.put(priority,newList);
                return true;

            } else {
                //
                LinkedList getList = queue.get(priority);
                getList.add(element);
                queue.put(priority, getList);
                return true;
            }
        }
        return false;
    }

   @Override
    public Object dequeue() {
       int highestPriority = 0;

       for (Integer integer : queue.keySet()) {
           if (integer > highestPriority){
               highestPriority = integer;
           }
       }

       Object object  =queue.get(highestPriority).removeFirst();
       if (queue.get(highestPriority).isEmpty()){
           queue.remove(highestPriority);
       }
       return object;
    }

    @Override
    public int search(Object element) {
        int index = 1;
        for (int i = queue.size(); i > 0; i--) {
            for (T t : queue.get(i)) {
                index++;
                if (element.equals(t)) return index;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public String toString() {
        StringBuilder string =  new StringBuilder();
        for (Integer i : queue.keySet()) {
            string.append(i).append(": ");
            for (T t : queue.get(i)) {
                string.append(t).append(", ");
            }
            string.append("\n");
        }
        return string.toString();
    }
}
