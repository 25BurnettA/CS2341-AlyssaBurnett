public class LinearProbingHashST<Key, Value>
{
    private int M = 20000;
    private Value[] vals = (Value[]) new Object[M];
    private Key[] keys = (Key[]) new Object[M];

    private int hash(Key key)
    {
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

    private void put(Key key, Value val)
    {
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % M)
        {
            if (keys[i].equals(key))
            {
                break;
            }
        }
        keys[i] = key;
        vals[i] = val;
    }

    public Value get(Key key)
    {
        for (int i = hash(key); keys[i] != null; i = (i+1) % M)
        {
            if (key.equals(keys[i]))
            {
                return vals[i];
            }
        }
        return null;
    }
}
