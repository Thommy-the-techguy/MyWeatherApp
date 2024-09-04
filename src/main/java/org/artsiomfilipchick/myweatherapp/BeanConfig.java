package org.artsiomfilipchick.myweatherapp;

import org.artsiomfilipchick.myweatherapp.interfaces.Subject;
import org.artsiomfilipchick.myweatherapp.objects.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Subject subject() {
        return new Data();
    }
}
