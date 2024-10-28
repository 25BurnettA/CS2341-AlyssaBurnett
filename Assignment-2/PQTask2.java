public class PQTask2
{
    private TaskObj[] pq;
    private int size = 0;

    public PQTask2(int capacity)
    {
        pq = (TaskObj[]) new TaskObj[capacity + 1];
    }

    //PRIORITY QUEUE BASIC OPERATIONS:
    public boolean isEmpty()
    {
        return size == 0;
    }

    public void insert(TaskObj taskObj)
    {
        pq[++size] = taskObj;
        swim(size);
    }

    public TaskObj deleteMin()
    {
        //System.out.println(pq[0]);
        TaskObj min = pq[1];
        exchange(1, size--);
        sink(1);
        pq[size+1] = null;
        return min;
    }

    //HEAP HELPER FUNCTIONS:
    private void swim(int k)
    {
        while(k > 1 && greaterPriority(k/2, k) || (k > 1 && samePriority(k/2, k) && greater(k/2, k)))
        {
            exchange(k, k/2);
            k = k/2;
        }

    }

    private void sink(int k)
    {
        while(2*k <= size)
        {
            int j = 2*k;

            if(j < size && greaterPriority(j, j+1) || (j < size && samePriority(j, j+1) && greater(j, j+1)))
            {
                j++;
            }

            exchange(k, j);
            k = j;
        }

    }

    //ARRAY HELPER FUNCTIONS:
    private boolean greater(int i, int j)
    {
        //return pq[i].higherClass(pq[j]);
        return pq[i].higherPriority(pq[j]);
    }

    private boolean greaterPriority(int i, int j)
    {
        return pq[i].higherClass(pq[j]);
    }

    private boolean samePriority(int i, int j)
    {
        return pq[i].sameClass(pq[j]);
    }

    private void exchange(int i, int j)
    {
        TaskObj swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}