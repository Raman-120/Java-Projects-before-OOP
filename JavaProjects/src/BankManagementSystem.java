import java.util.Arrays;
import java.util.Scanner;

public class BankManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static double[] transactions = new double[10];
    static int transactionCount;
    public static void main(String[] args) {

        //a banking program using java (advanced console)
        /*
            Features:
            1. Create an account(name, ID, PIN)
            2. Login System
            3. Deposit, Withdraw and check Balance
            4. Transfer money
            5. Interest Calculation - simple interest calculator
            6. Transaction history
            7. Exit menu
         */

        // for experiment i will make a default pin for the isAccount true verification...
        // I preferred demo account for the proper operation of the code


        double balance = 50000;
        String defaultName = "de mo";
        String defaultPass = "hello123";
        int attempts = 0;
        String name;
        String firstName, lastName;
        String updatedUserName = "", updatedUserPassword = "";
        String pin;
        int userChoice;
        String ID;
        double amount = 0;
        String verification;
        String userAnswer = "yes";
        boolean isAccount = false;
        boolean createAccount = false;
        String isExist;


        System.out.println("----Welcome to our Banking Management System----\n");

        System.out.print("Do you have an account in our bank?(yes/no): ");
        isExist = scanner.nextLine().toLowerCase();

        while (!userAnswer.equals("no")) {
            if (isExist.equals("yes")) {
                isAccount = true;

            }
            else if (isExist.equals("no")) {

            }
            else {
                System.out.println("Invalid input!");
                System.out.println("Please re-run the program.");
                System.exit(0);
            }
            if (!isAccount) {
                System.out.print("Would you like to create a new account?(yes/no): ");
                userAnswer = scanner.nextLine().toLowerCase();

                if (userAnswer.equals("yes")) {
                    System.out.println("----You can fill the following to create your account----");
                    System.out.print("Enter your first name: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter your last name: ");
                    lastName = scanner.nextLine();
                    updatedUserName = firstName + lastName;
                    System.out.println("Your username(Bank ID) is " + updatedUserName);

                    System.out.print("Set a strong password for your account: ");
                    pin = scanner.nextLine();
                    updatedUserPassword = pin;


                    System.out.print("Please provide us one your ID (eg: Citizenship, NID, Driving License): ");
                    ID = scanner.nextLine().toUpperCase();

                    switch (ID) {
                        case "CITIZENSHIP" -> {
                            System.out.print("Enter your citizenship ID: ");
                            verification = scanner.nextLine();
                        }
                        case "NID" -> {
                            System.out.print("Enter your NID number: ");
                            verification = scanner.nextLine();
                        }
                        case "DRIVING LICENSE" -> {
                            System.out.print("Enter your Driving License number: ");
                            verification = scanner.nextLine();
                        }
                        default -> {
                            System.out.println("Sorry, The ID you have provided isn't validate in our Bank.");
                            System.exit(0);
                        }

                    }
                    System.out.println("Your information has been submitted to our server. Please wait for a few moment.");

                    System.out.println("You have successfully created a new account.");

                    isAccount = true;
                }

            } else {
                if (attempts < 5) {
                    System.out.print("Enter your Bank ID: ");
                    name = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    pin = scanner.nextLine();

                    if (name.equals(defaultName) || name.equals(updatedUserName)) {
                        if (pin.equals(defaultPass) || pin.equals(updatedUserPassword)) {
                            System.out.println("You have logged in successfully.");
                            break;
                        }
                    } else {
                        System.out.println("Incorrect username or password");
                        attempts++;
                    }
                } else {
                    System.out.println("Your account has been locked. \nPlease contact bank for further details.");
                    break;
                }
            }
        }

       do{
           System.out.println("\n 1. Check Balance \n 2. Withdraw Money \n 3. Deposit Money \n 4. Transfer Money " +
                   " \n 5. Interest Calculation \n 6. Show Transaction \n 7. Exit");
           System.out.print("What activity would you like to do?(from 1 - 7): ");
           userChoice = scanner.nextInt();

           switch (userChoice) {
               case 1 -> checkBalance(balance);
               case 2 -> {
                   balance -= withdraw(balance);
                   System.out.println("Your balance is " + balance);
               }
               case 3 -> {
                   balance += deposit();
                   System.out.println("Your new balance is " + balance);

               }
               case 4 -> {
                   balance -= TransferMoney(balance);
                   System.out.println("Your new balance is " +  balance);
               }
               case 5 -> InterestCalculator();

               case 6 ->{
                showTransaction();
               }
               case 7 -> {
                   System.out.println("Thanks for using our service!");
                   System.exit(0);
               }
               default -> System.out.println("Invalid input!");
           }

       }while(userChoice != 7);
        scanner.close();
    }

    static void checkBalance(double balance) {
        System.out.println("Your current balance is " + balance);
    }

    static double deposit() {

        double amount;

        System.out.print("Enter the amount you want to deposit: ");
        amount = scanner.nextDouble();
        transactions[transactionCount++] = amount;

        if (amount < 0) {
            System.out.println("Amount can't be in negative.");
            return 0;
        } else {
            System.out.println("You have withdrawn " + amount + " from your account.");
            return amount;
        }
    }

    static double withdraw(double balance) {
        double amount;
        System.out.print("Enter the amount you want to withdraw: ");
        amount = scanner.nextDouble();
        transactions[transactionCount++] = -amount;

        if(amount > balance){
            System.out.println("Insufficient balance!");
            return 0;
        }
        else{
            return amount;
        }
    }

    static double TransferMoney(double balance){
        double amount;
        System.out.print("Enter the amount you want to transfer: ");
        amount = scanner.nextDouble();
        transactions[transactionCount++] = -amount;

        if(amount < 0){
            System.out.println("Amount can't be in negative!");
            return 0;
        }
        else if(amount > balance){
            System.out.println("Insufficient Balance!");
            return 0;
        }
        else{
            System.out.println("You have successfully transferred " + amount+ " from your account.");
            return amount;
        }
    }

    static void InterestCalculator(){

        double principle;
        String InterestType;
        int time;
        double LoanRate = 5.25;
        double interestAmount;

        System.out.print("What do you want to create(loan/saving a/c)?:  ");
        scanner.nextLine();
        InterestType = scanner.nextLine().toLowerCase();

        if(InterestType.equals("loan")){
            System.out.print("Enter your principal: ");
            principle = scanner.nextDouble();

            System.out.print("In how many years will you pay your loan?: ");
            time = scanner.nextInt();

            interestAmount = (principle * time * LoanRate) / 100;
            System.out.println("Your yearly interest amount for the loan Rs." + principle + " is " + interestAmount +".");
            System.out.println("The interest rate is " + LoanRate);
        }
        else if(InterestType.equals("saving")){

            double userPrinciple;
            double userInterestAmount;
            double savingTime;

            System.out.print("Would you like to create an account:  ");
            String userAnswer = scanner.nextLine();

            if(userAnswer.equals("yes")){

                System.out.println("Enter the amount you want to deposit: ");
                userPrinciple = scanner.nextDouble();

                System.out.println("You have successfully created a saving account in our bank.");
                System.out.println("Your principle is " + userPrinciple + ".");

                System.out.print("Enter the # of years you want to know the interest of: ");
                savingTime = scanner.nextDouble();

                userInterestAmount = (userPrinciple * 3.50 * savingTime) / 100;

                System.out.println("You will get yearly Rs." + userInterestAmount);

            }
        }
        else{
            System.out.println("Invalid input");
        }

    }

    static void showTransaction(){
        System.out.println("Your transactions were: ");
       for(int i = 0;  i < transactionCount;i++){
           System.out.println(transactions[i]);
       }
    }
}

