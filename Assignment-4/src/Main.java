import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        File wordlist = new File("assets/wordlist.10000.txt");
        SeparateChainingHashST sc = new SeparateChainingHashST();
        LinearProbingHashST lb = new LinearProbingHashST();

        int positionCount = 1;

        try
        {
            Scanner dictionary = new Scanner(wordlist);

            while (dictionary.hasNext())
            {
                sc.put(dictionary.next(), positionCount);
                lb.put(dictionary.next(), positionCount);
                positionCount++;
            }//End while

        }//End try for wordlist.10000.txt

        catch (FileNotFoundException e)
        {
            //throw new RuntimeException(e);
            System.out.println("File not found");
        }//End catch for wordlist.10000.txt

        Scanner input = new Scanner(System.in);

        System.out.println("Please input your password:");

        String password, shortPass, errorExplanation = "";
        int strong = 0;
        boolean passed = false;

        password = input.nextLine();

        //Checking for password length:
        if(password.length() >= 8)
        {
            strong++;
        }
        else
        {
            errorExplanation = "INSUFFICIENT LENGTH: Please choose a password that uses at least 8 characters";
        }

        //Checking if word is contained in dictionary
        if(sc.get(password) == null)
        {
            strong++;
        }
        else
        {
            errorExplanation = "INSUFFICIENT COMPLEXITY: This password is contained in our dictionary of commonly used passwords";
        }

        //Checking if word is contained in dictionary (plus a random digit at the end)
        for(int i = 1; i < 10; i++)
        {
            shortPass = password.substring(0, password.length() - 1);

            if(sc.get(shortPass) == null)
            {
                strong++;
                passed = true;
                break;
            }
        }
        if(!passed)
        {
            errorExplanation = "INSUFFICIENT COMPLEXITY: This password is contained in our dictionary of commonly used passwords, we recommend using at least 2 numbers at the end of your password to ensure its complexity!";
        }

        //Prints out final password message
        if(strong == 3)
        {
            System.out.println("Your password is strong!\n");
            System.out.println("Cost of Search for Separate Chaining: " + sc.getComparisons() + " Comparisons");
            System.out.println("Cost of Search for Linear Probing: " + lb.getComparisons() + " Comparisons");
        }
        else
        {
            System.out.println("Your password is not strong enough, please note the explanation below:");
            System.out.println(errorExplanation + "\n");
            System.out.println("Cost of Search for Separate Chaining: " + sc.getComparisons() + " Comparisons");
            System.out.println("Cost of Search for Linear Probing: " + lb.getComparisons() + " Comparisons");
        }

    }
}
