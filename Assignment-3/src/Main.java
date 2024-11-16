import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        int productCount = 0;
        File productFile = new File("assets/amazon-product-data.csv");

        RedBlackTree<String, Product> redBlackTree = new RedBlackTree<>();

            try
            {
                Scanner productData = new Scanner(productFile);

                while (productData.hasNext())
                {
                    boolean inQuotes = false;
                    int segmentCount = 0;
                    String line = productData.nextLine();
                    String[] productArray = {"", "", "", ""};

                    for(int i = 0; i < line.length(); i++)
                    {
                        if(line.charAt(i) == ',' && !inQuotes)
                        {
                            segmentCount++;
                        }
                        else if(line.charAt(i) == '\"')
                        {
                            //Include double quotes
                            productArray[segmentCount] = productArray[segmentCount]+line.charAt(i);
                            inQuotes = !inQuotes;
                        }
                        else
                        {
                            productArray[segmentCount] = productArray[segmentCount]+line.charAt(i);
                        }
                    }

                    String id = productArray[0];
                    String name = productArray[1];
                    String category = productArray[2];
                    String price = productArray[3];

                    Product currProduct = new Product(id, name, category, price);

                    redBlackTree.insert(id, currProduct);

                    if(productData.hasNext())
                    {
                        productData.nextLine();
                    }
                    else
                    {
                        break;
                    }

                    productCount++;

                }//End while

            }//End try for amazon-product-data.csv

            catch (FileNotFoundException e)
            {
                //throw new RuntimeException(e);
                System.out.println("File not found");
            }//End catch for amazon-product-data.csv

        Scanner input = new Scanner(System.in);

        System.out.println("How many products would you like to retrieve?");
        String retrievalCount = input.nextLine();
        int rc = Integer.parseInt(retrievalCount);

        for(int i = 0; i < rc; i++)
        {
            System.out.println("\nPlease input the Unique ID of the product you would like to retrieve:");
            String id = input.nextLine();
            System.out.println(redBlackTree.get(id));
        }

    }
}
