import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        File data = new File("log-data.csv");
        Queue<String> logData = new Queue<>();
        Stack<String> errorLog = new Stack<>();

        int amountINFO = 0;
        int amountERROR = 0;
        int amountWARN = 0;
        int amountWARNINGMemory = 0;

        try
        {
            Scanner scanner = new Scanner(data);

            while(scanner.hasNextLine()) {
                logData.enqueue(scanner.nextLine());
            }//End while

        }//End try

        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }//End catch

        for(int i = 0; i < logData.size(); i++)
        {
            String currentLine = logData.dequeue();

            if(currentLine == null)
            {
                continue;
            }

            if(currentLine.contains("ERROR"))
            {
                errorLog.push(currentLine);
                amountERROR++;
            }
            else if (currentLine.contains("INFO"))
            {
                amountINFO++;
            }
            else if((currentLine.contains("WARN")) && (currentLine.contains("Memory")))
            {
                amountWARN++;
                amountWARNINGMemory++;
            }
            else if (currentLine.contains("WARN"))
            {
                amountWARN++;
            }
            else
            {
                System.out.println(currentLine);
            }
        }//End for

        System.out.println("INFO: " + amountINFO);
        System.out.println("WARN: " + amountWARN);
        System.out.println("ERROR: " + amountERROR);
        System.out.println("Memory Warning: " + amountWARNINGMemory + "\n");
        System.out.println("Recent 100 Errors (printed in reverse order):");

        for(int i = 0; i < 100; i++)
        {
            String nextError = errorLog.pop();
            System.out.println(nextError);
        }//End for
    }
}
