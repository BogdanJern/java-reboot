package ru.sberbank.edu;

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

    public CalcInfo(Double sum, Double rate, int years) {
        this.sum = sum;
        this.rate = rate;
        this.years = years;

        if(this.sum < 50000.0){
            throw new IllegalAccessError("Минимальная сумма на момент открытия вклада 50 000 рублей");
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

