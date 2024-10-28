import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3
{

    //Create File for task1.txt
    File task3File = new File("assets/task3-input.txt");

    //PQTask3 task3Queue = new PQTask3(100);

    PQTask1 task3Queue = new PQTask1(100);
    ArrayList<TaskObj> incoming = new ArrayList();
    ArrayList<Integer> indices = new ArrayList();

    /**Loads "task3-input.txt" into "incoming" ArrayList*/
    public void load()
    {
        try
        {
            Scanner task3Data = new Scanner(task3File);

            while (task3Data.hasNext()) {
                //Split up the current line of ShowList.csv, using "," as a delimiter
                String[] task3Array = task3Data.nextLine().split(" ");

                int id = Integer.parseInt(task3Array[0]);
                int pt = Integer.parseInt(task3Array[1]);
                int at = Integer.parseInt(task3Array[2]);

                TaskObj currTask3 = new TaskObj(id, pt, at);

                incoming.add(currTask3);

            }//End while

            //System.out.println(incoming.size());

        }//End try for task3-input.txt

        catch (FileNotFoundException e)
        {
            //throw new RuntimeException(e);
            System.out.println("File not found");
        }//End catch for task2-input.txt

    }

    public void print()
    {
        TaskObj min;
        int average = 0;
        int time = 0;

        System.out.print("Execution Order: [");
        while(!incoming.isEmpty() || !task3Queue.isEmpty())
        {

            for (int i = 0; i < incoming.size(); i++)
            {
                if (incoming.get(i).getPriorityClass() <= time)
                {
                    TaskObj temp = incoming.get(i);
                    //Drop arrival time

                    TaskObj newTemp = new TaskObj(temp.id, temp.processingTime);

                    task3Queue.insert(newTemp);
                    indices.add(i);
                }
            }

            for (int i = indices.size()-1; i >= 0; i--)
            {
                incoming.remove(indices.get(i).intValue());
            }

            indices.clear();

            min = task3Queue.deleteMin();
            average += min.processingTime;

            System.out.print(min.id + ", ");
            //System.out.println("Arrival Time: " + min.priorityClass + " Processing Time: " + min.processingTime + " Id: " + min.id);

            time = time + min.getProccessingTime();
        }
        System.out.print("]");

        average = average / 100;

        System.out.println("\nAverage Completion Time: " + average);


    }

    public void print1()
    {
        TaskObj min;
        int average = 0;

        System.out.print("Execution Order: [");
        for(int i = 0; i < 100; i++)
        {
            min = task3Queue.deleteMin();
            average += min.processingTime;

            //System.out.print(min.id + ", ");

            System.out.println(min.priorityClass + " " + min.processingTime);
        }
        System.out.print("]");

        average = average / 100;
        System.out.println("\nAverage Completion Time: " + average);
    }

}
