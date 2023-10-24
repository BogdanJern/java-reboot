package ru.sberbank.edu;

/**
 * @author bogdanzernovoj
 * Класс сохранения в БД
 */
public class SaverDB implements Saver{
    /**
     * @param lineCount  количество строк
     * @param spaceCount количество пробелов
     * @param line       самая длинная строка в файле
     * @throws RuntimeException ошибка сохранения
     */
    public void save(int lineCount, int spaceCount, String line) throws RuntimeException {
        System.out.println("Сохранение в базу данных в данный момент недоступно");
    }
}