package lists;

import data.Student;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Listable<T> {
    LinkedList<Student> student = new LinkedList<Student>();


    private Node head = null;
    private Node tail = null;

    private class Node {
        T data = null;
        Node next = null;
        Node previous = null;
    }

    @Override
    public void add(T data,Student student) {
        Node newNode = new Node(); //Create a new node

        if(head == null) {//if list is empty, head and tail points to newNode
            head = tail = newNode;//head's previous will be null
            head.previous = null; //tail's next will be null
            tail.next = null;
        }
        else {//add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;  //newNode->previous set to tail
            newNode.previous = tail; //newNode becomes new tail
            tail = newNode; //tail's next point to null
            tail.next = null;
        }

    }

    @Override
    public void remove(int index) {
        int i = 0;

        // negative indexes are always invalid
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        try {
            for (Node current = head.next;
                 current != head;
                 current = current.next) {
                if (i == index) {
                    Node previous = current.previous;
                    Node next = current.next;

                    previous = next;
                    next = previous;
                    // maybe you need count for something else, but not for this
                    // count -= 1;
                }

                i += 1;
            }
        }
        catch (NullPointerException N) {
            System.out.println("Element not in the list");
        }

        // If control reaches here then the given index is invalid
        // throw new IndexOutOfBoundsException();
       /* if(index == 0){
            Node node = head;
            head = node.next;
        }
        else if((index > size() - 1) || (index < 0)) {
            System.out.println("Index out of bounds");
        }
        else {
            Node current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }

            Node temp = current;
            current = temp.previous;
            current.next = temp.next;
            temp = null;
        }

        */
    }

    @Override
    public void remove(T data) throws NullPointerException{
        if ( data == head) {
            head = head.next;
            data = null;
        }
        else if ( data == tail) {
            data = null;
        }
        else {
            try {
                for (Node current = head.next;
                     current != head;
                     current = current.next) {
                    if (data == current) {
                        Node previous = current.previous;
                        Node next = current.next;

                        previous = next;
                        next = previous;

                    }
                }
            }
            catch (NullPointerException N) {
                System.out.println("Element not in the list");
            }

        }

    }

    @Override
    public void insertAt(int index, T data) {
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
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public void print() {
        Node current = head;//Node current will point to head
        Node next = head.next;

        if(head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list:\n ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return ((head == null) && (tail == null));
    }

    @Override
    public int size() {
        int count = 0;
        Node current = head;

        while(current != null) {
            count++;
            current = current.next;
        }

        if(head == null) {
            System.out.println("List is empty");
        }

        System.out.println("Number of Nodes of doubly linked list: "+ count);
        System.out.println();
        return count;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void searchNode() {

    }

    //searchNode() will search a given node in the list
    public void searchNode(int value) {

        int i = 1;
        boolean flag = false;
        //Node current will point to head
        Node current = head;

        //Checks whether the list is empty
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        while(current != null) {
            //Compare value to be searched with each node in the list
            if(student.contains(value)) {
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }
        if(flag)
            System.out.println("Node is present in the list at the position : " + i);
        else
            System.out.println("Node is not present in the list");
    }

    public void sort() {


    }

    @Override
    public void sort1() {

    }



}
