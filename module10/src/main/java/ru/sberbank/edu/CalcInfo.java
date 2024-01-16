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
    /**
     * Минимальная сумма
     */
    int minSum;
    public CalcInfo(Double sum, Double rate, int years, int minSum) {

        this.sum = sum;
        this.rate = rate;
        this.years = years;
        this.minSum = minSum;

        if(this.sum < this.minSum){
            throw new IllegalAccessError("Минимальная сумма на момент открытия вклада " + this.minSum + " рублей");
        }
    }

    /**
     * Расчет суммы вклада
     * @return итоговая сумма
     */
    public Double getFinalSum(){
        return sum*Math.pow(1+rate/100,years);
    }
}
