package ru.sberbank.edu;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author bogdanzernovoj
 * Класс сохранения в файл
 */
public class SaverFile implements Saver{
     /**
     * @param lineCount  количество строк
     * @param spaceCount количество пробелов
     * @param line       самая длинная строка в файле
     * @throws RuntimeException ошибка сохрранения
     */
    public void save(int lineCount, int spaceCount, String line) throws RuntimeException {
        saveFile(getFileName(), lineCount, spaceCount, line);
    }

    /**
     *
     * @param fileName   Имя файла для сохранения
     * @param lineCount  количество строк
     * @param spaceCount количество пробелов
     * @param line       самая длинная строка в файле
     * @throws RuntimeException ошибка сохранения
     */
    protected void saveFile(String fileName,int lineCount, int spaceCount, String line) throws RuntimeException{
        try {
            BufferedWriter writer = new BufferedWriter( new FileWriter(fileName));
            writer.write("Количество строк: " + lineCount);
            writer.newLine();
            writer.write("Количество пробелов: " + spaceCount);
            writer.newLine();
            writer.write("Самая длинная строка: " + "'" + line + "'");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Файл " + fileName + " Успешно сохранен");
    }

    /**
     * Получение полного имени файла для сохранения
     * @return имя файла
     */
    private @NotNull String getFileName(){
        Scanner scanner = new Scanner(System.in);
        String fullName, path, name;
        System.out.println("Введите название файла для сохранения");
        name = scanner.next();
        path  = System.getProperty("user.dir");
        fullName = path + "/module02/src/main/res/" + name;
        return fullName;
    }
}