import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1
{

    //Create File for task1.txt
    File task1File = new File("assets/task1-input.txt");

    PQTask1 task1Queue = new PQTask1(100);
    ArrayList<TaskObj> task1ArrayList = new ArrayList<>();

    public void load()
    {
        try
        {
            Scanner task1Data = new Scanner(task1File);

            while (task1Data.hasNext()) {
                //Split up the current line of ShowList.csv, using "," as a delimiter
                String[] task1Array = task1Data.nextLine().split(" ");

                int pt = Integer.parseInt(task1Array[0]);
                int id = Integer.parseInt(task1Array[1]);
                TaskObj currTask1 = new TaskObj(id, pt);

                task1Queue.insert(currTask1);
            }//End while

        }//End try for task1-input.txt

        catch (FileNotFoundException e)
        {
            //throw new RuntimeException(e);
            System.out.println("File not found");
        }//End catch for task1-input.txt

    }

    public void print()
    {
        TaskObj min;
        int average = 0;

        System.out.print("Execution Order: [");
        for(int i = 0; i < 100; i++)
        {
            min = task1Queue.deleteMin();
            average += min.processingTime;

            System.out.print(min.id + ", ");
        }
        System.out.print("]");

        average = average / 100;
        System.out.println("\nAverage Completion Time: " + average);
    }


}
