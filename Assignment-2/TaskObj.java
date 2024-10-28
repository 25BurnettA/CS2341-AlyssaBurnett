public class TaskObj implements Comparable<TaskObj>
{
    public int processingTime, id, priorityClass = 0;

    TaskObj(int a, int b)
    {
        id = a;
        processingTime = b;
    }

    TaskObj(int a, int b, int c)
    {
        id = a;
        processingTime = b;
        priorityClass = c;
    }


    boolean higherPriority(TaskObj compareTo)
    {
        return this.processingTime > compareTo.processingTime;
    }

    boolean higherClass(TaskObj compareTo)
    {
       return this.priorityClass > compareTo.priorityClass;
    }

    boolean sameClass(TaskObj compareTo)
    {
        return this.priorityClass == compareTo.priorityClass;
    }

    boolean hasPriorityClass()
    {
        return this.priorityClass > 0;
    }

    int getProccessingTime()
    {
        return this.processingTime;
    }

    int getId()
    {
        return this.id;
    }

    int getPriorityClass()
    {
        return this.priorityClass;
    }

    @Override
    public int compareTo(TaskObj o) {
        return 0;
    }
}