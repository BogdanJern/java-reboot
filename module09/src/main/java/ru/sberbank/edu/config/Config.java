package ru.sberbank.edu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.edu.WeatherProvider;
import ru.sberbank.edu.WeatherProviderImpl;

@Configuration
@PropertySource("classpath:app.properties")
public class Config {

    @Value("${weatherProviderImpl.default.appKey}")
    private String appKey;
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public WeatherProvider weatherProvider(){
        return new WeatherProviderImpl(appKey);
    }
}
