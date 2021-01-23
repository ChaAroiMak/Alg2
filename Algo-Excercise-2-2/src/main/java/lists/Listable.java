package lists;

import data.Student;
import jdk.nashorn.internal.ir.Node;

public interface Listable<T> {
    void add(T data, Student student);
    void remove(int index);
    void remove(T data);
    void insertAt(int index, T data);
    void clear();
    void print();
    boolean isEmpty();
    int size();
    T get(int index);
    void searchNode();
    // TODO: find
    void sort();
    void sort1();
}