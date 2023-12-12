package ru.sberbank.edu;
import org.junit.Test;

public class SaverFileTest {
    @Test
    public void TestSave( ){
        SaverFile saver = new SaverFile();
        String path, fullName;
        path  = System.getProperty("user.dir");
        fullName = path + "/src/test/res/" + "testWrite.txt";
        saver.saveFile( fullName,2,3,"Тестовая строка");
    }
}