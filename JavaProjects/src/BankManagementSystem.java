import java.util.Scanner;

public class BankManagementSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //a banking program using java (advanced console)
        /*
            Features:
            1. Create an account(name, ID, PIN)
            2. Login System
            3. Deposit, Withdraw and check Balance
            4. Transfer money
            5. Interest Calculation
            6. Transaction history(array)
            7. Exit menu
         */

        // for experiment i will make a default pin for the isAccount true verification...


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
           System.out.println("\n 1. Check Balance \n 2. Withdraw Money \n 3. Deposit Money \n 4. Transfer Money \n 5. Exit");
           System.out.print("What activity would you like to do?: ");
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
               case 5 -> {
                   System.out.println("Thanks for using our service!");
                   System.exit(0);
               }
               default -> System.out.println("Invalid input!");
           }

       }while(userChoice != 5);
        scanner.close();
    }

    static void checkBalance(double balance) {
        System.out.println("Your current balance is " + balance);
    }

    static double deposit() {

        double amount;

        System.out.print("Enter the amount you want to deposit: ");
        amount = scanner.nextDouble();

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
}

