package ru.sberbank.edu;

/**
 * @author bogdanzernovoj
 * Получение объекта Saver в зависимости от входных параметров
 */
public class FactorySaver {
    /**
     * @param userChoose
     * @return Saver(SaverFile or SaverDB)
     */
    public static Saver getSaver( char userChoose ){

        Saver saver;

        switch (userChoose){
            case 'F': saver = new SaverFile();
            break;
            case 'D': saver = new SaverDB();
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + userChoose);
        }
        return saver;
    }
}