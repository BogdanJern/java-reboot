package ru.sberbank.edu;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

/**import org.junit.Assert;
import org.junit.Test;*/
public class CALTest {
    @Test
    public void testAdd(){
        CustomArrayImpl array = new CustomArrayImpl();
        array.add("test1");
        array.add("test2");

        //Assert
        //array.add("test2");
        //array.add("test3");
        //array.add(4);
    }

}
