package ru.sberbank.edu;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StatisticImplTest {
    @Test
    public void testGetLineCount() {
        String path, fullName;
        path  = System.getProperty("user.dir");
        fullName = path + "/src/test/res/testReadLineCount.txt";
        StatisticImpl statistic = new StatisticImpl(fullName);
        try {
            Assert.assertSame("Количество строк <> 3", statistic.getLineCount(), 3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Assert.assertNotSame("Количество строк = 3", statistic.getLineCount(), 4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testGetSpaceCount() {
        String path, fullName;
        path  = System.getProperty("user.dir");
        fullName = path + "/src/test/res/testReadSpaceCount.txt";
        StatisticImpl statistic = new StatisticImpl(fullName);
        try {
            Assert.assertSame("Количество строк <> 10", statistic.getSpaceCount(), 10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Assert.assertNotSame("Количество строк <> 10", statistic.getSpaceCount(), 11);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetLongestLine() {
        String path, fullName;
        path  = System.getProperty("user.dir");
        fullName = path + "/src/test/res/testReadLongestLine.txt";
        StatisticImpl statistic = new StatisticImpl(fullName);
        try {
            //Assert.assertSame("Неверное определение самой длинной строки", statistic.getLongestLine(), "Самая длинная строка");
            Assert.assertEquals("Неверное определение самой длинной строки", statistic.getLongestLine(), "Самая длинная строка");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Assert.assertNotEquals("Неверное определение самой длинной строки", statistic.getLongestLine(), "Короткая строка");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
