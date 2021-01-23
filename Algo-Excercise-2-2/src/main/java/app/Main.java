package app;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import data.Listtype;
import data.Student;
import lists.DoublyLinkedList;
import lists.Listable;
import lists.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        // testListType(new SinglyLinkedList<Student>());
        // System.out.println();
        // testListType(new DoublyLinkedList<Student>());

        LinkedList<Student> student = new LinkedList<Student>();

        Listtype listtype;

        Scanner in = new Scanner(System.in);
        System.out.println("Which list do you want to use?\n" +
                "0 Singly Linked List\n" +
                "1 Doubly Linked List");
        int num = in.nextInt();

        if(num == 0) {
            listtype = Listtype.singly;
        } else if(num == 1) {
            listtype = Listtype.doubly;
        }else {
            throw new IllegalArgumentException("No Listtype");
        }


        Console console = new Console();

        switch (num) {

            case 0:
                System.out.println("\nYou selected SinglyLinkedList:\n");
                console.neueAusgabe();
                // new SinglyLinkedList<Student>();
                break;
            case 1:
                System.out.println("\nYou selected DoublyLinkedList:\n");
                console.DOUBLYAusgabe();
                //  new DoublyLinkedList<Student>();
                break;
            default: System.out.println("Type in '0' or '1'");
                new Main();
                break;
        }


    }

   /* private static void testListType(Listable<Student> list) {
        System.out.println(list.getClass().getSimpleName());
        Student s1 = new Student("Ted", "Mosby", 78, 78);
        Student s2 = new Student("Donald", "Duck", 67, 76);
        Student s3 = new Student("Sheldon", "Cooper", 89, 89);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.print();
        System.out.println("IsEmpty: " + list.isEmpty());
        System.out.println("Size: " + list.size());
        System.out.println("Get element at index 0: "+ list.get(0));
        System.out.println("Get element at index 1: "+ list.get(1));
        System.out.println("Get element at index 2: "+ list.get(2));
        System.out.println("Get element at index -1:"+ list.get(-1));
        System.out.println("Get element at index 3: "+ list.get(3));
        list.remove(s3);
        list.remove(0);
        list.clear();
        list.insertAt(0, s1);
        list.insertAt(1,s2);
        // list.searchNode();
        System.out.println();
    }*/



}
