package ru.sberbank.edu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CalcInfo {
    /**
     * Сумма вклада
     */
    private final Double sum;
    /**
     * Процентная ставка
     */
    private final Double rate;
    /**
     * Количество лет
     */
    private final int years;
    /**
     * Настройки
     */
    Properties prop = new Properties();
    public CalcInfo(Double sum, Double rate, int years) throws IOException {

        this.prop.load(new FileInputStream("application.properties"));

        int minSum =  Integer.parseInt(this.prop.getProperty("minSum"));

        this.sum = sum;
        this.rate = rate;
        this.years = years;

        if(this.sum < minSum){
            throw new IllegalAccessError("Минимальная сумма на момент открытия вклада " + minSum + " рублей");
        }
    }

    /**
     * Расчет суммы вклада
     * @return
     */
    public Double getFinallSum(){
        return sum*Math.pow(1+rate/100,years);
    }
}
