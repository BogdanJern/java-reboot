package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
            //@Value("${minSum}") int minSum,
            Model model) throws IOException {

        Properties prop = new Properties();
        prop.load(new FileInputStream("application.properties"));

        int minSum =  Integer.parseInt(prop.getProperty("minSum"));

        try {
            CalcInfo calcInfo = new CalcInfo(Double.parseDouble(sum),
                    Double.parseDouble(percentage),
                    Integer.parseInt(years));
            model.addAttribute("sum", calcInfo.getFinallSum());
            return "result.html";
        } catch (NumberFormatException e) {
            model.addAttribute("minSum", minSum);
            return "resultType.html";
        } catch (IllegalAccessError e) {
            return "error.html";
        }
    }
}