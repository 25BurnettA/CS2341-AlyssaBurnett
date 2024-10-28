import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2
{

    //Create File for task1.txt
    File task2File = new File("assets/task2-input.txt");

    PQTask2 task2Queue = new PQTask2(100);
    ArrayList<TaskObj> task1ArrayList = new ArrayList<>();

    public void load()
    {
        try
        {
            Scanner task2Data = new Scanner(task2File);

            while (task2Data.hasNext()) {
                //Split up the current line of ShowList.csv, using "," as a delimiter
                String[] task2Array = task2Data.nextLine().split(" ");

                int id = Integer.parseInt(task2Array[0]);
                int pt = Integer.parseInt(task2Array[1]);
                int pc = Integer.parseInt(task2Array[2]);

                TaskObj currTask2 = new TaskObj(id, pt, pc);

                task2Queue.insert(currTask2);
            }//End while

        }//End try for task2-input.txt

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

        System.out.print("Execution Order: [");
        for(int i = 0; i < 100; i++)
        {
            min = task2Queue.deleteMin();
            //average += min.processingTime;
            average += min.processingTime;

            System.out.print(min.id + ", ");

            //System.out.println(min.priorityClass + " " + min.processingTime);
        }
        System.out.print("]");

        average = average / 100;
        System.out.println("\nAverage Completion Time: " + average);
    }

}
