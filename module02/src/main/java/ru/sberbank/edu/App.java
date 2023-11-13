package ru.sberbank.edu;

import java.io.IOException;
import java.util.Scanner;

/**
 * Домашнее задание module02
 */
public class App
{
    public static void main( String[] args ) {

        Saver saver;
        char userChoose;

        Scanner scanner = new Scanner(System.in);

        String fileName = "textFile.txt";

        System.out.println("Считан файл '"+ fileName+"'");

        StatisticImpl statistic = new StatisticImpl(fileName);

        System.out.println("Введите 'F' если хотите сохранить данные в файл");
        System.out.println("Введите 'D' если хотите сохранить данные в базу данных");

        userChoose = scanner.next( ).charAt(0);

        saver = FactorySaver.getSaver(userChoose);
        try {
            saver.save(statistic.getLineCount(), statistic.getSpaceCount(), statistic.getLongestLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}