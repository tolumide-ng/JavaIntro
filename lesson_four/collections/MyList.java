package lesson_four.collections;

import java.util.Collection;
import java.util.ArrayList;


public class MyList {
    private Collection<String> items;


    public MyList() {
        this.items = new ArrayList<>();
    }

    public static void main(String[] args) {
        MyList list = new MyList();

        System.out.println("my list is: " + list.items);
    }
}