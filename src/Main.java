import java.io.*;
import java.util.Scanner;
/*
*   Ty Le
*   Jaroop Programming Assignment
*   Account management application that takes deposits, withdraws, and returns a balance.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        //Declare variables
        File logs = new File("log.html");
        Scanner scan = new Scanner(System.in);
        String input = null;

        String prompt = "Please enter a command(deposit, withdraw, balance, exit): ";
        Banking account1 = new Banking(logs);

        // Get input from user
        while(input != "exit") {
            System.out.println(prompt);
            input = scan.next().toLowerCase();

            switch (input) {
                case "deposit":
                    while(account1.validate(input) == 0){
                        System.out.println("Please enter an amount:");
                        input = scan.next();
                        account1.deposit(input);
                    }
                    input = null;
                    break;

                case "withdraw":
                    while(account1.validate(input) == 0)
                    {
                        System.out.println("Please enter an amount to withdraw:");
                        input = scan.next();
                        account1.withdraw(input);
                    }
                    input = null;
                    break;

                case "balance":
                    System.out.println("your balance is $" + account1.getbalance());
                    input = null;
                    break;

                case "exit":
                    return;
            }
        }
    }
}
