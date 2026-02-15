import java.util.Scanner;

public class studentManagementSystem {
    static Scanner scanner = new Scanner(System.in);
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



        String name;
        int roll;
        double marks = 0;
        int userAnswer;
        double[][] StudentMarks = new double[1][10];


        System.out.println("----Welcome to the Student Management System----");

        System.out.println("1.Store Marks \n 2. Update Marks \n 3. Average marks \n 4. Calculate grade");

        System.out.print("What would you like to do?(1-4): ");
        userAnswer = scanner.nextInt();

        switch(userAnswer){
            case 1 ->{
                storeMarks(marks);
            }


            default -> System.out.println("Invalid input");
        }
        scanner.close();
    }

    static double storeMarks(double mark){

        int roll;
        System.out.println("Enter the roll no of the student: ");
        roll = scanner.nextInt();


        System.out.println("Enter the marks of the student: ");
        mark = scanner.nextDouble();
        return mark;

    }
}
