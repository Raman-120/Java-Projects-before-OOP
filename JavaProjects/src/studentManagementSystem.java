import java.util.Arrays;
import java.util.Scanner;

public class studentManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static double[][]studentMarks = new double[10][5];
    static int studentMarksCountRow = 0;
    static int studentMarksCountColumn = 0;
    static int[] studentRoll = new int[10];
    static int studentRollCount = 0;
    static String[] studentName= new String[10];
    static int studentNameCount = 0;
    public static void main(String[] args){

        // a simple student management system in java

        /*
        Features:
        1.Add students (name, roll, marks)
        2.Store marks in a 2d array
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
        boolean userRun = true;
        String[] subjects = {"English", "Nepali", "Math", "Digital Logics", "CFA"};


        System.out.println("----Welcome to the Student Management System----");
        while(userRun){
            System.out.println("\n 1. Store Marks \n 2. Update Marks \n 3. Average marks \n 4. Calculate grade \n 5. Show Marks");

            System.out.print("What would you like to do?(1-5): ");
            userAnswer = scanner.nextInt();

            switch(userAnswer){
                case 1 ->{
                    storeMarks(marks);
                }
                case 3 ->{
                    average();
                }
                case 5 ->showMarks();

                default -> System.out.println("Invalid input");
            }

        }
        scanner.close();
    }


    static void storeMarks(double mark) {

        int roll;
        System.out.println("Enter the roll no of the student: ");
        roll = scanner.nextInt();
        studentRoll[studentRollCount++] = roll;


        System.out.print("Enter the name of the student: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        studentName[studentNameCount++] = name;

        int i;
        for (i = 0; i < 5; i++) {
            System.out.println("Enter the marks of the student: ");
            System.out.println();
            mark = scanner.nextDouble();
            studentMarks[studentMarksCountRow][i] = mark;
        }

        studentMarksCountRow++;
    }

    static double average(){

        boolean isFound = true;
        double average = 0;
        double sum = 0;
        String name;
        System.out.println("Enter the name of the student: ");
        scanner.nextLine();
        name = scanner.nextLine();

        for(int i = 0; i < studentNameCount; i++){
            if(studentName[i].equals(name)){
                System.out.println("Student ID has found.");
                for(double[] mark : studentMarks){
                   for(double marks : mark){
                       sum = sum + marks;
                   }
                }
            }
            else{
                System.out.println("Student ID isn't registered.");
                isFound = false;
            }

        }
        if(isFound){
            average = sum / 5;
            System.out.println("The average is " + average);
            return average;
        }
        else{
            return 0;
        }
    }

    static void showMarks(){
        for(int i = 0; i < studentRollCount; i++){
            System.out.print(studentRoll[i] + " " +  studentName[i] + " "  + Arrays.toString(studentMarks[i]) + " \n");

        }
    }
}
