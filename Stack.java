public class Stack <Item> {

    public Node frontOfStack, backOfStack;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    {
        return frontOfStack == null || backOfStack == null;
    }

    public void push(Item item)
    {
        Node firstItem = frontOfStack;
        frontOfStack = new Node();
        frontOfStack.item = item;
        frontOfStack.next = firstItem;
        if(isEmpty()) {
            backOfStack = frontOfStack;
        }
    }

    public Item pop()
    {
        if(isEmpty()) {
            return null;
        }
        Item item = frontOfStack.item;
        frontOfStack = frontOfStack.next;

        return item;
    }
}
