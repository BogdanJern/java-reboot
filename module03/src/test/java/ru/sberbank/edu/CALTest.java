package ru.sberbank.edu;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**import org.junit.Assert;
import org.junit.Test;*/
public class CALTest {
    @Test
    public void testAdd(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");

        Assert.assertSame("Неверный размер массива",2, array.size());
        Assert.assertSame("Ошибка добавления элемента",array.get(1),"test1");
    }
    @Test
    public void testSize(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");
        Assert.assertSame("Неверный размер массива",2, array.size());
    }
    @Test
    public void testIsEmpty(){
        CustomArrayImpl array = new CustomArrayImpl();
        Assert.assertSame("Ошибка определения пустоты массива", true, array.isEmpty());
        array.add("test0");
        Assert.assertNotSame("Ошибка определения пустоты массива", true, array.isEmpty());
    }

    @Test
    public void testAddAllArray(){
        CustomArrayImpl array = new CustomArrayImpl();
        CustomArrayImpl array2ADD = new CustomArrayImpl();

        array.add("test0");

        array2ADD.add("test1");
        array2ADD.add("test2");

        array.addAll(array2ADD.toArray());

        Assert.assertSame("Неверный размер массива",3, array.size());
        Assert.assertSame("Ошибка добавления элемента",array.get(1),"test1");
        Assert.assertSame("Ошибка добавления элемета",array.get(2),"test2");
    }

    @Test
    public void testAddAllCollection(){

        CustomArrayImpl array = new CustomArrayImpl();
        ArrayList<String> array2ADD = new ArrayList<>();

        array.add("test0");

        array2ADD.add("test1");
        array2ADD.add("test2");

        array.addAll(array2ADD);

        Assert.assertSame("Неверный размер массива",3, array.size());
        Assert.assertSame("Ошибка добавления элемента",array.get(1),"test1");
        Assert.assertSame("Ошибка добавления элемета",array.get(2),"test2");

    }

    @Test
    public void testAddAllByIndex(){
        CustomArrayImpl array = new CustomArrayImpl();
        CustomArrayImpl array2ADD = new CustomArrayImpl();

        array.add("test0");
        array.add("test3");

        array2ADD.add("test1");
        array2ADD.add("test2");

        array.addAll(1,array2ADD.toArray());

        Assert.assertSame("Неверный размер массива",4, array.size());
        Assert.assertSame("Ошибка добавления элемента",array.get(1),"test1");
        Assert.assertSame("Ошибка добавления элемета",array.get(3),"test3");
    }

    @Test
    public void testGet(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");
        array.add("test2");
        array.add("test3");
        Assert.assertSame("Ошибка добавления элемента",array.get(1),"test1");
        Assert.assertSame("Ошибка добавления элемета",array.get(3),"test3");
    }

    @Test
    public void testSet(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");
        array.add("test2");
        array.add("test3");

        Assert.assertSame("Ошибка добавления элемента",array.get(1),"test1");
        array.set(1, "newTest1");
        Assert.assertSame("Ошибка добавления элемента",array.get(1),"newTest1");

        Assert.assertSame("Ошибка добавления элемета",array.get(3),"test3");
        array.set(3, "newTest3");
        Assert.assertSame("Ошибка добавления элемента",array.get(3),"newTest3");
    }

    @Test
    public void testRemove(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");
        array.add("test2");
        array.add("test3");

        Assert.assertSame("Неверный размер массива",4, array.size());
        Assert.assertSame("Ошибка добавления элемента",array.get(2),"test2");
        array.remove(2);
        Assert.assertSame("Неверный размер массива",3, array.size());
        Assert.assertSame("Ошибка добавления элемента",array.get(2),"test3");
    }
    @Test
    public void testRemoveByData(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");
        array.add("test2");
        array.add("test3");

        Assert.assertSame("Неверный размер массива",4, array.size());
        Assert.assertSame("Ошибка добавления элемента",array.get(2),"test2");
        array.remove("test2");
        Assert.assertSame("Неверный размер массива",3, array.size());
        Assert.assertSame("Ошибка добавления элемента",array.get(2),"test3");
    }

    @Test
    public void testContains(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");
        array.add("test2");
        array.add("test3");

        Assert.assertTrue(array.contains("test2"));
        Assert.assertTrue(array.contains("test3"));
        Assert.assertFalse(array.contains("test4"));
    }

    @Test
    public void testIndexOf(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test0");
        array.add("test1");
        array.add("test2");
        array.add("test3");

        array.indexOf("test2");

        Assert.assertSame("Ошибка определения номера элемента",array.indexOf("test2"),2);
        Assert.assertSame("Ошибка определения номера элемента",array.indexOf("test4"),-1);
    }

    @Test
    public void testEnsureCapacity(){
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

        Assert.assertSame("Ошибка увеличения массива",array.getCapacity(),15);
    }

    @Test
    public void testReverse(){
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

        Assert.assertSame("Ошибка определения номера элемента",array.indexOf("test2"),2);
        Assert.assertSame("Ошибка определения номера элемента",array.indexOf("test1"),1);
        array.reverse();

        Assert.assertNotSame("Ошибка определения номера элемента",array.indexOf("test1"),1);
        Assert.assertNotSame("Ошибка определения номера элемента",array.indexOf("test2"),2);
        Assert.assertSame("Ошибка определения номера элемента",array.indexOf("test1"),8);
        Assert.assertSame("Ошибка определения номера элемента",array.indexOf("test2"),7);

    }

}
