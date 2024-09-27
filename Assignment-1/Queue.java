public class Queue <Item> {

    public Node frontOfQueue, backOfQueue;
    public int size;

    Stack<Item> errorLog = new Stack<>();

    public int size() {
        return size;
    }

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    {
        return frontOfQueue == null || backOfQueue == null;
    }

    public void enqueue(Item item)
    {
        Node lastItem = backOfQueue;
        backOfQueue = new Node();
        backOfQueue.item = item;
        backOfQueue.next = null;
        size++;
        if(isEmpty()) {
            frontOfQueue = backOfQueue;
        }
        else {
            lastItem.next = backOfQueue;
        }
    }

    public Item dequeue()
    {
        if(isEmpty()) {
            return null;
        }

        Item item = frontOfQueue.item;
        frontOfQueue = frontOfQueue.next;

        size--;

        return item;
    }
}
