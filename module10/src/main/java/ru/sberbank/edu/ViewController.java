package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/finance", consumes = MediaType.ALL_VALUE)
public class ViewController{
    /**
     * Основная страница
     * @return возвращаемая страница
     */
    @GetMapping()
    public String finance(){
        return "finance.html";
    }

    /**
     * Получение результата расчета
     * @param sum сумма вклада
     * @param percentage процент по вкладу
     * @param years количество лет
     * @param minSum минимальная сумма
     * @param model модель
     * @return Возвращаемая страница
     */
    @PostMapping
    public String result(
            @RequestParam(value = "sum", required = true) String sum,
            @RequestParam(value = "percentage", required = true) String percentage,
            @RequestParam(value = "years", required = true) String years,
            @Value("${minSum}") int minSum,
            Model model) {

        try {
            CalcInfo calcInfo = new CalcInfo(Double.parseDouble(sum),
                    Double.parseDouble(percentage),
                    Integer.parseInt(years),
                    minSum);
            model.addAttribute("sum", calcInfo.getFinalSum());
            return "result.html";
            } catch (NumberFormatException e) {
                return "resultType.html";
            }catch (IllegalAccessError e){
                model.addAttribute("minSum", minSum);
                return "error.html";
            }
    }
}