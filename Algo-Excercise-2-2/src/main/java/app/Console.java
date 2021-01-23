package app;

import data.Student;
import lists.DoublyLinkedList;
import lists.SinglyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Console {

    static final Scanner in = new Scanner(System.in);
    static SinglyLinkedList singly = new SinglyLinkedList();
    static DoublyLinkedList doubly = new DoublyLinkedList();

    static   LinkedList<Student> students = new LinkedList<data.Student>();


    static public int readIntegerFromStdIn(String text) {
        boolean test = true;
        while (test) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.print(text + " ");
                int num = in.nextInt();
                test = false;
                return num;
            } catch (Exception ex) {
                System.out.println("Wrong Input. Please enter a number from 0 to 7.");
            }
        }
        return -1;
    }

    static public String readStringFromStdIn(String text) {
        boolean test = true;

        while (test) {
            try {
                System.out.print(text + " ");
                // TODO: Read text from Stdin
                Scanner scan = new Scanner(System.in);
                // System.out.println(text);
                String text1 = scan.nextLine();
                test = false;
                return text1;
            } catch (Exception ex) {
                System.out.println("Wrong Input. Please enter text.");
            }
        }

        return " ";
    }


    public static String neueAusgabe() {

        System.out.println("Console-Application: Exercise-3 " + "<" + "Vorname" + "> " + " <" + "Nachname"  + "> " + " <" + "Matrikelnummer" + ">\n" +
                "1. Add Student to the end of this list.\n" +
                "2. Inserts the Student at the specified position in this list.\n"+
                "3. Inserts the Student at the beginning of this list.\n"+
                "4. Appends the Student to the end of this list.\n"+
                "5. Returns the Student at the specified position in this list.\n"+
                "6. Print all students to console from list.\n"+
                "7. Returns the number of Students in this list.\n"+
                "8. Removes the Student at the specified position in this list.\n"+
                "9. Removes all of the Students from this list.\n"+
                "10. Search for student(s) by different characteristics.\n" +
                "11. Sort list by different properties.\n" +
                "0. Exit\n"+
                "\n"+
                "Please enter a number for an option:\n");


        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        do {
            switch (num) {
                case 0:
                    Exit exit = new Exit();
                    exit.Exit();
                    break;
                case 1:
                    Console.untermenu(1,1);
                    //  singly.addAtEnd(Console.untermenu(1));
                    neueAusgabe();
                case 2:
                    Console.untermenu(2,1);
                    //  singly.add(Console.untermenu(2));
                    neueAusgabe();
                case 3:
                    Console.untermenu(3,1);
                    //  singly.addAtStart(Console.untermenu(3));
                    neueAusgabe();
                    break;
                case 4:
                    Console.untermenu(4,1);
                    // singly.addAtEnd(Console.untermenu());
                    neueAusgabe();
                    break;
                case 5:
                    System.out.println("At which index?");
                    int index = in.nextInt();
                    System.out.println(singly.get(index));
                    neueAusgabe();
                    break;
                case 6:
                    singly.print();
                    neueAusgabe();
                    break;
                case 7:
                    System.out.println(singly.size());
                    neueAusgabe();
                    break;
                case 8:
                    System.out.println("At which index?");
                    index = in.nextInt();
                    singly.remove(index);
                    neueAusgabe();
                    break;
                case 9:
                    singly.clear();
                    neueAusgabe();
                    break;
                case 10:
                    singly.searchNode();
                    neueAusgabe();
                    break;
                case 11:
                    //TODO IMPLEMENT SORTS

                    System.out.println("Select a sorting method for sorting:\n"+
                            "1. Insertionsort?\n" +
                            "2. other Sort\n" +
                            "\n" +
                            "Please entera number for an option:\n");

                    index = in.nextInt();
                    switch(index) {
                        case 1: singly.sort();
                            break;
                        //case 2: singly.sort1(Node head);
                        // break;
                        default: System.out.println("Please select option");
                            neueAusgabe();
                            break;
                    }

                    break;
                default:
                    System.out.println("Enter number from 0-11");
                    neueAusgabe();
                    break;
            }
        } while (num != 0);

        return " ";
    }

    public static String DOUBLYAusgabe() {

        System.out.println("Console-Application: Exercise-3 " + "<" + "Vorname" + "> " + " <" + "Nachname"  + "> " + " <" + "Matrikelnummer" + ">\n" +
                "1. Add Student to the end of this list.\n" +
                "2. Inserts the Student at the specified position in this list.\n"+
                "3. Inserts the Student at the beginning of this list.\n"+
                "4. Appends the Student to the end of this list.\n"+
                "5. Returns the Student at the specified position in this list.\n"+
                "6. Print all students to console from list.\n"+
                "7. Returns the number of Students in this list.\n"+
                "8. Removes the Student at the specified position in this list.\n"+
                "9. Removes all of the Students from this list.\n"+
                "10. Search for student(s) by different characteristics.\n" +
                "11. Sort list by different properties.\n" +
                "0. Exit\n"+
                "\n"+
                "Please enter a number for an option:\n");


        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        do {
            switch (num) {
                case 0:
                    Exit exit = new Exit();
                    exit.Exit();
                    break;
                case 1:
                    Console.untermenu(1,2);
                    // Console.untermenu();
                    // doubly.add(Console.untermenu());
                    DOUBLYAusgabe();
                case 2:
                    Console.untermenu(2,2);
                    //  doubly.add(Console.untermenu());
                    DOUBLYAusgabe();
                case 3:
                    Console.untermenu(3,2);
                    //  doubly.add(Console.untermenu());
                    DOUBLYAusgabe();
                    break;
                case 4:
                    Console.untermenu(4,2);
                    //  doubly.add(Console.untermenu());
                    DOUBLYAusgabe();
                    break;
                case 5:
                    System.out.println("At which index?");
                    int index = in.nextInt();
                    doubly.get(index);
                    DOUBLYAusgabe();
                    break;
                case 6:
                    doubly.print();
                    DOUBLYAusgabe();
                    break;
                case 7:
                    doubly.size();
                    DOUBLYAusgabe();
                    break;
                case 8:
                    System.out.println("At which index?");
                    index = in.nextInt();
                    doubly.remove(index);
                    DOUBLYAusgabe();
                    break;
                case 9:
                    doubly.clear();
                    DOUBLYAusgabe();
                    break;
                case 10:
                    doubly.searchNode();
                    DOUBLYAusgabe();
                    break;
                case 11:
                    //TODO IMPLEEMNT SORTS
                    break;
                default:
                    System.out.println("Enter number from 0-11");
                    DOUBLYAusgabe();
                    break;
            }
        } while (num != 0);

        return " ";
    }

    public static String untermenu(int check,int singleOrDouble) {

        String vorname = " ";
        String nachname = " ";
        String matrikelnummer = " ";
        String coursenumber = " ";
        int matrikelnummer1 = 0;

        System.out.println("Please enter prename:");
        String vorname1 = Console.readStringFromStdIn(vorname);

        System.out.println("Please enter surname:");
        String nachname1 = Console.readStringFromStdIn(nachname);

        System.out.println("Please enter course number:");
        //Course coursenumber1 = Console.readStringFromStdIn(coursenumber);
        int coursenumber1 = Integer.parseInt(Console.readStringFromStdIn(coursenumber));

        System.out.println("Please enter matriculation number:");
        matrikelnummer1 = Integer.parseInt(Console.readStringFromStdIn(matrikelnummer));

        Student student = new Student(vorname1, nachname1, coursenumber1, matrikelnummer1);

        if (check==1 && singleOrDouble ==1) {
                      singly.addAtEnd(student,student);

        } else if (check==2 && singleOrDouble ==1) {

            singly.add(student,student);
        } else if (check==3 && singleOrDouble ==1) {

            singly.addAtStart(student,student);
        } else if (check==4 && singleOrDouble ==1){

                 singly.addAtEnd(student,student);
        }

        //double change the methods after implementing it
        if (check==1 && singleOrDouble ==2) {
            doubly.add(student,student);

        } else if (check==2 && singleOrDouble ==2) {

           // doubly.add(student);
        } else if (check==3 && singleOrDouble ==2) {

         //   doubly.add(student);
        } else if (check==4 && singleOrDouble ==2){

           // doubly.add(student);
        }




        return String.valueOf(student);


    }
}