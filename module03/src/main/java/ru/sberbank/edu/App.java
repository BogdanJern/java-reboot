package ru.sberbank.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");
        array.add("test2");
        array.add("test3");
        array.add("test4");
        array.add("test6");
        array.add("test7");
        array.add("test8");
        array.add("test9");
        array.add("test10");
        array.add("test11");
        array.add("test12");

        array.reverse();
        int i = 0;

        for (; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}
