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
        3.Calculate average
        4.Search through an array
        5.Update marks
        6.Menu-driven system
         */



        String name;
        int roll;
        double marks = 0;
        int userAnswer;
        boolean userRun = true;

        System.out.println("----Welcome to the Student Management System----");
        do{
            System.out.println("\n 1. Store Marks \n 2. Update Marks \n 3. Average marks \n 4. Show Marks \n 5. Exit");

            System.out.print("What would you like to do?(1-6): ");
            userAnswer = scanner.nextInt();

            switch(userAnswer){
                case 1 ->{
                    storeMarks(marks);
                }
                case 2 -> updateMarks();

                case 3 ->{
                    average();
                }
                case 4 ->{
                    searchStudent();
                }
                case 5 ->showMarks();

                case 6 -> {
                    System.out.println("Thank you for using our service.");
                    System.exit(0);
                }

                default -> System.out.println("Invalid input");
            }

        }while(userAnswer != 6);
        scanner.close();
    }


    static void storeMarks(double mark) {

        int subject;
        System.out.println("Enter the number of subject: ");
        subject = scanner.nextInt();

        int roll;
        System.out.print("Enter the roll no of the student: ");
        roll = scanner.nextInt();
        studentRoll[studentRollCount++] = roll;


        System.out.print("Enter the name of the student: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        studentName[studentNameCount++] = name;

        int i;
        for (i = 0; i < subject; i++) {
            System.out.println("Enter the marks of the student: ");
            System.out.println();
            mark = scanner.nextDouble();
            studentMarks[studentMarksCountRow][i] = mark;
        }

        studentMarksCountRow++;
    }

    static void average(){

        boolean isFound = false;
        double average = 0;
        double sum = 0;
        String name;

        System.out.print("Enter the name of the student: ");
        scanner.nextLine();
        name = scanner.nextLine();

        for(int i = 0; i < studentNameCount; i++){
            if(studentName[i].equals(name)){
                System.out.println("Student ID has found.");
                isFound = true;
                double[] mark = studentMarks[i];
                   for(double marks : mark){
                       sum = sum + marks;
                   }

                average = sum / mark.length;
                System.out.println("The average is " + average);
            }


        }
        if(!isFound){
            System.out.println("Student ID isn't registered.");
        }


    }

    static void searchStudent(){
        int i = 0;
        String name;
        System.out.print("Enter the name of the student: ");
        name = scanner.nextLine();

        for(i = 0;  i < studentNameCount; i++){
            if(studentName[i].equals(name)){
                System.out.println("Name found at index " + i);
            }
        }
    }

    static void updateMarks(){

        int j = 0;
        boolean isFound = false;
        double marks;
        String name;
        System.out.print("Enter the name of the student: ");
        scanner.nextLine();
        name = scanner.nextLine();

        for(int i = 0; i < studentNameCount; i++ ){
            if(studentName[i].equals(name)){
                isFound = true;
                System.out.println("Student ID has found.");
                for(j = 0;  j < studentMarks[i].length; j++){
                    System.out.println("Enter the updated marks here: ");
                    marks = scanner.nextDouble();
                    studentMarks[i][j] = marks;

                }
                System.out.println("Marks has been successfully updated.");
                break;
            }

        }
        if(!isFound){
            System.out.println("Students hasn't found!");
        }

    }

    static void showMarks(){
        for(int i = 0; i < studentRollCount; i++){
            System.out.print(studentRoll[i] + " " +  studentName[i] + " "  + Arrays.toString(studentMarks[i]) + " \n");

        }
    }
}
