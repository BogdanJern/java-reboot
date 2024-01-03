package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/finance", consumes = MediaType.ALL_VALUE)
public class ViewController{
    @GetMapping()
    public String finance(){
        return "finance.html";
    }

    @PostMapping
    public String result(
            @RequestParam(value = "sum", required = true) String sum,
            @RequestParam(value = "percentage", required = true) String percentage,
            @RequestParam(value = "years", required = true) String years,
            @Value("${minSum}") int minLimi ) {

        try {
            CalcInfo calcInfo = new CalcInfo(Double.parseDouble(sum),
                    Double.parseDouble(percentage),
                    Integer.parseInt(years));
            return "";
        } catch (NumberFormatException e) {
            return "";
        } catch (IllegalAccessError e) {
            return "";
        }
    }
}