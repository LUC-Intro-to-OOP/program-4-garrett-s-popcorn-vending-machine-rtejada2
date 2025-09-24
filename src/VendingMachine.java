/**
 * Garrett's popcorn vending machine

Garrett's popcorn is looking to launch a vending machine that sells their world renowned popcorn.  The vending machine will contain a total of 9 products. 
The products are listed below in the chart along with purchase price.  To select an item, the end-user will enter the product row along with the column letter.
The program should enforce that only product row numbers and column letters can be entered. The end-user will be able to continously select up to  as they would 
like until they enter a sentinel value.
   

At the conslusion of selecting all items, the program will display the total number of items purchased and the total cost.

**Hints**
- Make use of two dimensional arrays.
- Consider parallel arrays



Your program should operate similarly to the program shown in the .gif below
The .gif below show three iterations of running the program

![Alt text](https://instructorc.github.io/site/slides/java/images/ds/program_4_sample_output.gif "Program 4 Execution Example")



| Product Row | Column P               | Column N                       | Column R           |
|-------------|------------------------|-----------------------------------------------------|
| 0           | Garrett Mix ($14.99)   |  Pecan Carmel Crisp ($10.99)   | Plain ($6.99)      |
| 1           | Caramel Crisp ($16.99) |  Cashew Carmel Crisp ($9.99)   | Buttery ($8.99     |
| 2           | Cheese Corn ($12.99)   |  Almond Carmel Crisp ($11.99)  | Sweet Corn ($7.99)  


 */

import java.util.Scanner; //Import the Scanner Class
public class VendingMachine { //Start Class

    //Constants for array and column letters
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final char[] VALID_COLUMNS = {'P', 'N', 'R'};
    public static void main(String[] args) throws Exception {
        
        //Array for product names
        String[][] products = { 
        {"Garrett Mix", "Pecan Caremel Crisp", "Plain"},
        {"Caramel Crisp", "Cashew Caremel Crisp", "Buttery"},
        {"Cheese Corn", "Almond Caramel Crisp", "Sweet Corn"}
        };
        
        //Array for product prices
        double [][] prices = {
            {14.99, 10.99, 6.99},
            {16.99, 9.99, 8.99},
            {12.99, 11.99, 7.99}
        };
            
            System.out.println("Garrett's Popcorn Vending Machine");

            Scanner scanner = new Scanner(System.in);
            int totalItems = 0;
            double totalCost = 0.0;

            int row = 0; 
            while (row != -1) {

            
            // Show menu
            System.out.println("Row   Column P                  Column N                     Column R");

                for (int r = 0; r < ROWS; r++) {

                    System.out.println(r + "     "
                        + products[r][0] + "               "
                        + products[r][1] + "             "
                        + products[r][2]);
                        }

            // Ask for row
              System.out.print("Enter row (0,1,2) or -1 to EXIT: ");
                  row = scanner.nextInt();

        if (row == -1) {
          break; // leave loop
        }

            // Validate row
            if (row < 0 || row >= ROWS) {
              System.out.println("Invalid row. Try again.");
              continue; // back to top of loop
            }

          // Ask for column
          System.out.print("Enter column letter (P,N,R): ");
          char col = scanner.next().toUpperCase().charAt(0);

 

      int colIndex = -1;
      if (col == 'P') {
      colIndex = 0; 

      } else if (col == 'N') {
      colIndex = 1;

      } else if (col == 'R') {
      colIndex = 2;
      }
    

  if (colIndex == -1) {
    System.out.println("Invalid column. Try again.");
    continue; // back to top of loop
  }

  // Valid choice: show product, add to totals
  System.out.println("You selected " + products[row][colIndex] +
                     " for a price of $" + prices[row][colIndex]);

  totalItems++;
  totalCost += prices[row][colIndex];

} // end while

// Final summary
System.out.println("===== Purchase Summary =====");
System.out.println("Total items: " + totalItems);
System.out.println("Total cost: $" + totalCost);
                                    
  scanner.close();

   }//END OF MAIN
}

