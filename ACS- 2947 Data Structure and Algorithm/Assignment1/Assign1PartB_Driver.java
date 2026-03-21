/**
 * ACS-2947 Assingment - 1
 * Daljeet Singh 3169763
 */

import java.util.Scanner;

public class Assign1PartB_Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);           //creates scanner to get user's input
        Account a = new Account();                          //creates the account

        //creates the loop to carryout whole process
        while(true){                         //continue the loop until its true
            //---------start try and catch------------
            try{
                System.out.println("Make Selection:");
                System.out.println("1. Buy shares");
                System.out.println("2. Sell shaers");
                System.out.println("3. Quit");
                int choice = scanner.nextInt(); 

                switch (choice){
                    case 1:
                        System.out.print("Enter number of shares to buy: ");
                        int numShares = scanner.nextInt();                  
                        if(numShares < 0) throw new IllegalArgumentException("Number of shares must be greater than 0");        //throw an IllegalArgumentException if user type number lower than zero

                        System.out.print("Enter purchase price per share: ");
                        int pricePerShare = scanner.nextInt();
                        if(pricePerShare < 0) throw new IllegalArgumentException("Price per share must be greater than 0");     //throw an IllegalArgumentException if user give number lower than zero

                        a.buyShares(numShares, pricePerShare);
                        System.out.println("Total shares: " + a.getTotalShares());              //shows the user's shares 
                        System.out.println("Total shares value: $" + a.getTotalValues());       //show the total value of shares user have
                        break;

                    case 2:
                        System.out.print("Enter number of shares to sell: ");
                        int nShares = scanner.nextInt();
                        if(nShares < 0) throw new IllegalArgumentException("Number of shares must be greater than 0");          //throw exception if user's provide invalid numebr

                        System.out.print("Enter the selling price per share: ");
                        int pricePerShare2 = scanner.nextInt();
                        if(pricePerShare2 < 0) throw new IllegalArgumentException("Price per share should be greater than 0");      //throw exception if user provide invalid number

                        a.sellShares(nShares, pricePerShare2);
                        System.out.println("Total shares: " + a.getTotalShares());              //shows the user's shares
                        System.out.println("Total sahres value: $" + a.getTotalValues());        //show the total value of shares user have
                        break;

                    case 3:
                        System.out.println("*** End of Program ***");                   //end the program
                        scanner.close();                                                  //close the scanner
                        return;

                    default: 
                        System.out.println("Invalid choice. Select between 1 to 3 as given above");         //default value if user choose another value than given options
                        break;
                }

            }catch(IllegalArgumentException e){
                System.out.println("Error " + e.getMessage());                  //try to catch the IllegalArgumentException
            }catch(Exception e){
                System.out.println("An error occurred: " + e.getMessage());         //try to the any Exception
            }
            System.out.println("----------------------------------------------");

            //-------------------end of the while loop---------------------
        }
    }
}