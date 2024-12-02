import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SeparateChainingHashST<Key, Value>
{
    private int N; // number of key-value pairs
    private int M; // hash table size
    private int comparisons = 0;
    private SequentialSearchST<Key, Value>[] st = new SequentialSearchST[M]; // array of ST objects

    public SeparateChainingHashST()
    {
        this(997);
    }

    private static class Node
    {
        Object key;
        Object value;

        Node(Object key, Object value)
        {
            this.key = key;
            this.value = value;
        }
    }
    public SeparateChainingHashST(int M)
    {
        // Create M linked lists
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    private int hash(Key key)
    {
        comparisons++;
        String keyString = String.valueOf(key);
        return (stringHash(keyString) & 0x7fffffff) % M;
    }

    public  int stringHash(String key)
    {
        int hash = 0;
        int skip = Math.max(1, key.length() / 8);
        for (int i = 0; i < key.length(); i += skip)
            hash = (hash * 37) + key.charAt(i);
        return hash;
    }

    public Value get(Key key)
    {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val)
    {
        st[hash(key)].put(key, val);
    }

    public Iterable<Key> keys()
    {
        List<Key> keyList = new LinkedList<>();

        for (SequentialSearchST<Key, Value> bucket : st)
        {
            comparisons++;
            for(Key key : bucket.keys())
            {
                keyList.add(key);
            }
        }

        return keyList;
    }

    public int getComparisons()
    {
        return comparisons;
    }
}
