public class RedBlackTree<Key extends Comparable<Key>, Value>
{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node
    {
        Key key;
        Value val;
        Node left, right;
        /**Returns color of parent link*/
        boolean color;

        public Node(Key key, Value val, Boolean color)
        {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }//End Node

    private boolean isRed(Node x)
    {
        //All null links are black
        if(x == null) return false;
        return x.color == RED;
    }

    /**Use Parent Node as parameter for this function*/
    private Node rotateLeft(Node y)
    {
        assert isRed(y.right);
        Node x = y.right;
        y.right = x.left;
        x.left = y;
        x.color = y.color;
        y.color = RED;
        return x;
    }//End rotateLeft

    private Node rotateRight(Node y)
    {
        assert isRed(y.left);
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        x.color = y.color;
        y.color = RED;
        return x;
    }//End rotateRight

    private void flipColors(Node y)
    {
        assert !isRed(y);
        assert isRed(y.left);
        assert isRed(y.right);
        y.color = RED;
        y.left.color = BLACK;
        y.right.color = BLACK;
    }//End flipColors

    public void insert(Key key, Value val)
    {
        root = insert(root, key, val);
    }

    private Node insert(Node y, Key key, Value val)
    {
        //Insert at the bottom and give it the color RED
        if(y == null)
        {
            return new Node(key, val, RED);
        }

        int cmp = key.compareTo(y.key);

        if(cmp < 0)
        {
            y.left = insert(y.left, key, val);
        }
        else if(cmp > 0)
        {
            y.right = insert(y.right, key, val);
        }
        else
        {
            y.val = val;
        }//End else if chain of basic put function

        //Lean left:
        if(isRed(y.right) && !isRed(y.left))
        {
            y = rotateLeft(y);
        }

        //Balance 4-node:
        if(isRed(y.left) && isRed(y.left.left))
        {
            y = rotateRight(y);
        }

        //Split 4-node:
        if(isRed(y.left) && isRed(y.right))
        {
            flipColors(y);
        }
        return y;
    }//End insert


    public Value get(Key key)
    {
        Node x = root;

        while(x != null)
        {
            int cmp = key.compareTo(x.key);

            if(cmp < 0)
            {
                x = x.left;
            }
            else if(cmp > 0)
            {
                x = x.right;
            }
            else
            {
                return x.val;
            }
        }
        return null;
    }//End get

}
