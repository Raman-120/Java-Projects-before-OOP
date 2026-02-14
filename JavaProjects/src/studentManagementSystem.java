import java.util.Scanner;

public class studentManagementSystem {
    public static void main(String[] args){
        // a simple student management system in java

        /*
        Features:
        1.Add students (name, roll, marks)
        2.Store marks in 2D array
        3.Calculate average, grade
        4.Search student by roll
        5.Update marks
        6.Rank students
        7.Menu-driven system
         */

        Scanner scanner = new Scanner(System.in);

        String name;
        int roll;
        double marks;
        int userAnswer;


        System.out.println("----Welcome to the Student Management System----");

        System.out.println(" 1.Store Marks \n 2. Update Marks \n 3. Average marks \n 4. Calculate grade");

        System.out.print("What would you like to do?(1-4): ");
        userAnswer = scanner.nextInt();


        scanner.close();
    }
}
