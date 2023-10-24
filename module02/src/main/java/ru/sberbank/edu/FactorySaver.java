package ru.sberbank.edu;

/**
 * @author bogdanzernovoj
 * Получение объекта Saver в зависимости от входных параметров
 */
public class FactorySaver {
    /**
     * @param userChoose способ сохранения
     * @return Saver(SaverFile or SaverDB)
     */
    public static Saver getSaver( char userChoose ){

        return switch (userChoose) {
            case 'F' -> new SaverFile();
            case 'D' -> new SaverDB();
            default -> throw new IllegalStateException("Unexpected value: " + userChoose);
        };
    }
}