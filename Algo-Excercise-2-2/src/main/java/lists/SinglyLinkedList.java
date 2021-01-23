package lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import data.Student;

public class SinglyLinkedList<T> implements Listable<T> {
    LinkedList<data.Student> student = new LinkedList<data.Student>();

    ArrayList<Student> studentArrayList = new ArrayList<>();
    Node sorted;
    private Node head = null;
    private Node tail = null;
    private int value;
    private int counter;

    public int Node(int value) {
        this.value = value;
        return value;
    }

    @Override
    public void add(T data,Student student) { //add element
        studentArrayList.add(student);
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        counter++;
    }

    public void addAtStart(T data,Student student) { //adds new Node before the first element
        studentArrayList.add(student);
        Node newHead = new Node();
        newHead.data = data;
        newHead.next = head;
        head = newHead;
        counter++;
    }

    public void addAtEnd(T data, Student student) { //adds new node at the end of a list

        studentArrayList.add(student);

        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = null;
            Node tail = head;
            while (tail.next != null) {
                tail.next = newNode;
            }
        }
        counter++;
    }

    @Override
    public void print() { //print list
        //Node current will point to head
        Node current = head;

//        System.out.println("done" + current.data.toString());

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();


/*
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

 */

    }

    @Override
    public void remove(int index) {

        studentArrayList.remove(index);

        if (head == null) {  // If  list is empty nothing can be deleted
            return;
        }

        Node temp = head; // Store head node

        if (index == 0) { // If head needs to be removed the following node becomes the head
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < index - 1; i++) // Find previous node of the node to be deleted
            temp = temp.next;

        if (temp == null || temp.next == null)  // If position is more than number of nodes
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
        temp.next = next;  // Unlink the deleted node from list
    }

    @Override
    public void remove(T data) {


    }

    @Override
    public void insertAt(int index, T data) { //insert at position
        //create new node.
        Node node = new Node();
        node.data = data;
        node.next = null;


        if (this.head == null) {
            //if head is null and position is zero then exit.
            if (index != 0) {
                return;
            } else { //node set to the head.
                this.head = node;
            }
        }

        if (head != null && index == 0) {
            node.next = this.head;
            this.head = node;
            return;
        }

        Node current = this.head;
        Node previous = null;

        int i = 0;

        while (i < index) {
            previous = current;
            current = current.next;

            if (current == null) {
                break;
            }
            i++;
        }
        node.next = current;
        previous.next = node;
    }

    @Override
    public void clear() { //delete list
        studentArrayList.clear();
        head = null;
    }

    @Override
    public boolean isEmpty() { //check if list is empty
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() { //count number of elements
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    @Override
    public T get(int index) { //get one node
        if ((head == null) || (index < 0) || (index >= size())) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void searchNode() { //TODO Search for pre/surname/course/matricnumber. Check how i use compareTo
        String prename = null;
        String surname;
        String course;
        String matriculationnumber;
        int var;
        boolean test = false;
        String yes = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a property to search for the student:\n" +
                "1. Search by prename?\n" +
                "2. Search by surname\n" +
                "3. Search by course number?\n" +
                "4. Search by matriculation number?\n" +
                "\n" +
                "Please enter a number for an option: ");

        int in = scanner.nextInt();
        switch (in) {
            case 1:
                System.out.println("Please enter prename:");

                prename = scanner.next();


                for (Student student1 : studentArrayList) {
                    String preNameSearch = student1.getPrename();

                    if (prename.equals(preNameSearch)) {
                        yes = "0";
                        break;
                    }

                }

                if (yes.equals("0")) {
                    System.out.println("student is in list");
                } else {
                    System.out.println("student is not in list");
                }


                break;

               /*  boolean retval = student.contains(prename);
                 if (retval) {
                     System.out.println("student is in list");
                     return;
                 } else {
                     System.out.println("student is not in list");
                     return;
                 }*/


                 /*Node current = head;
                 while(current!= null) {
                     if(current.data == prename) {
                         System.out.println("student is in list");
                         return;
                     }
                     current = current.next;
                 }
                 System.out.println("student is not in list");

                */

                /*Node current = head;
                if(current != null){
                    if(current.data == prename) {
                        System.out.println("Student is in the list at index ");
                        break;
                    }
                }
                else {
                    System.out.println("Student not found");
                    break;

                }

                 */


            //var = prename.compareTo(String.valueOf(student));
            //System.out.println(prename.compareTo(student.toString()));
            // System.out.println(this.student.toString());
            // System.out.println(this.student.toArray());

            //System.out.println(prename.equals(student.toString()));

            //break;


            case 2:
                System.out.println("Please enter surname:");
                surname = scanner.next();
                var = surname.compareTo(String.valueOf(student));
              //  System.out.println(var);


                for (Student student1 : studentArrayList
                ) {
                    String surnameSearch = student1.getSurname();

                    if (surname.equals(surnameSearch)) {
                        yes = "0";
                        break;
                    }

                }

                if (yes.equals("0")) {
                    System.out.println("student is in list");
                } else {
                    System.out.println("student is not in list");
                }

                break;
            case 3:
                System.out.println("Please enter course number:");
                course = String.valueOf(scanner.nextInt());
                var = String.valueOf(course).compareTo(String.valueOf(student));
              //  System.out.println(var);

                for (Student student1 : studentArrayList
                ) {
                    String CourseSearch = String.valueOf(student1.getCourse());

                    if (course.equals(CourseSearch)) {
                        yes = "0";
                        break;
                    }

                }

                if (yes.equals("0")) {
                    System.out.println("student is in list");
                } else {
                    System.out.println("student is not in list");
                }

                break;
            case 4:
                System.out.println("Please enter matriculationnumber:");
                matriculationnumber = String.valueOf(scanner.nextInt());

                for (Student student1 : studentArrayList
                ) {
                    String matSearch = String.valueOf(student1.getMatriculationNumber());

                    if (matriculationnumber.equals(matSearch)) {
                        yes = "0";
                        break;
                    }

                }

                if (yes.equals("0")) {
                    System.out.println("student is in list");
                } else {
                    System.out.println("student is not in list");
                }

                break;
            default:
                System.out.println("Enter number from 1-4");
                searchNode();
        }





/*
        Student searchedOne = new Student(prename, surname, course, matriculationnumber);

        Node current = head;
        int i = 1;
        boolean flag = false;

        if(head == null) { //Checks if list is empty
            System.out.println("List is empty");
        }
        else {
            while(current != null) {
                //Compares node to be found with each node present in the list

                if(current.data == searchedOne) {
                    flag = true;
                    break;
                }
                i++;
                current = current.next;
            }
        }
        if(flag)
            System.out.println("Element is present in the list at the position : " + i);
        else
            System.out.println("Element is not present in the list");

 */


    }

    public void sort() { //insertionsort
        insertionSort(head);

    }


/*
    public void searchInt() {
        Node current = head;
        while(current!= null) {
            if(current.data == searchkey) {
                System.out.println("student is in list");
                return;
            }
            current = current.next;
        }
        System.out.println("student is not in list");
    }

 */

    @Override
    public void sort1() { //TODO implement sorting with  quicksort
    }

    public void sort1(Node start, Node end) { //TODO implement sorting with  quicksort
        if (start == end)
            return;

        // split list and partion recurse
        Node pivot_prev = paritionLast(start, end);
        sort1(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start) {
            sort1(pivot_prev.next, end);
        }

        // if pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null) {
            sort1(pivot_prev.next.next, end);
        }
    }

    Node paritionLast(Node start, Node end) {
        if (start == end ||
                start == null || end == null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.daten;

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.daten < pivot) {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.daten;
                curr.data = start.data;
                start.daten = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.daten;
        curr.daten = pivot;
        end.daten = temp;

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    void insertionSort(Node head) {
        // Initialize sorted linked list
        sorted = null;
        Node current = head;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null) {
            // Store next for next iteration
            Node next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        head = sorted;
    }

    /*public Listable<T> sort1(Node head) { //insertionsort
        Node current = head;
        Node tail = null;
        while(current != null&& tail != head )
        {
            Node next = current;
            for( ; next.next != tail;  next = next.next)
            {
                if(next.value <= next.next.value)
                {
                    int temp = next.value;
                    next.value = next.next.value;
                    next.next.value = temp;
                }
            }
            tail = next;
            current = head;
        }
        return this;

    }

     */

    /*
     * function to insert a new_node in a list. Note that
     * this function expects a pointer to head_ref as this
     * can modify the head of the input linked list
     * (similar to push())
     */
    void sortedInsert(Node newnode) {
        /* Special case for the head end */
        if (sorted == null || sorted.value >= newnode.value) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.value < newnode.value) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    public class Node {
        public int value;
        public int daten;
        T data = null;
        Node next = null;
    }

}
