package ru.sberbank.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author bogdanzernovoj
 * класс собора статистики но файлу
 */
public class StatisticImpl implements Statistic {
    /**
     * file массив строк из файла
     */
    ArrayList<String> file;
    /**
     * Конструктор
     * Считывается файл и записываетя в массив строк для дальнейшей работы
     * @param fileName имя файла для считывания
     */
    public StatisticImpl( String fileName ){
        String line;
        BufferedReader reader;
        file = new ArrayList<>();
        try {
            reader = new BufferedReader( new FileReader(fileName));
            while ((line = reader.readLine()) != null ){
                file.add(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Колучить количество строк в файле
     * @return количество строк
     * @throws IOException 
     */
    public int getLineCount() throws IOException {
        int count; // счетчик строк
        count = file.size();
        return count;
    }

    /**
     * получить количество пробелов
     * @return  количество пробелов
     * @throws IOException
     */
    public int getSpaceCount() throws IOException {
        int count = 0,total;
        for (Object line : file){
            String str;
            str = line.toString();
            for ( total = 0; total < str.length(); total++) {
                if (Character.isWhitespace(str.charAt(total)))
                    count++;
            }
        }
       return count;
    }

    /**
     * Получить саму блинную строку в файле
     * @return  самая длинная строка в файле
     * @throws IOException
     */
    public String getLongestLine() throws IOException {
        String maxLine = "";
        int max = 0;
        for(Object line : file){
            if (line.toString().length() > max){
                max = line.toString().length();
                maxLine = line.toString();
            }
        }
        return maxLine;
    }
}