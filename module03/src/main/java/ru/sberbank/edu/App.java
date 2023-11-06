package ru.sberbank.edu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CustomArrayImpl array = new CustomArrayImpl();
        //System.out.println(array.isEmpty());
        array.add("test1");
        array.add(2);
        array.add("test3");
        //System.out.println(array.toString());
        //array.size();
        //System.out.println(array.size());

        //String[] items = new String[2];
        //items[0] = "test2";
        //items[1] = "2";
        //items.add("test3");

        //array.addAll(items);
        //System.out.println(array.toString());
        //System.out.println(array.size());

        System.out.println(array.get(1));
    }
}
