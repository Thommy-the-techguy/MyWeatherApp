package org.artsiomfilipchick.myweatherapp.controller;

import org.artsiomfilipchick.myweatherapp.interfaces.Subject;
import org.artsiomfilipchick.myweatherapp.objects.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Controller
public class DataReaderController {
    private final RestTemplate restTemplate;
    private final Data data;

    @Autowired
    public DataReaderController(RestTemplate restTemplate, Subject data) {
        this.restTemplate = restTemplate;
        this.data = (Data) data;
    }

    @PostMapping("/collect")
    public String readDataFromAPI() {
        String uri = "https://api.open-meteo.com/v1/forecast?latitude=53.9&longitude=27.5667&hourly=temperature_2m";
        data.setHourly(Objects.requireNonNull(restTemplate.getForObject(uri, Data.class)).getHourly());

        return "redirect:/";
    }
}
