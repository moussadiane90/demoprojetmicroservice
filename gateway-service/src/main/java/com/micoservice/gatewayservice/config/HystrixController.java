package com.micoservice.gatewayservice.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HystrixController {

    @GetMapping("/defaultCountries")
    public Map<String, String> countriesFallBack(){
        Map<String, String> countries=new HashMap<>();
        countries.put("ML","MALI");
        countries.put("FR","FRANCE");
        return countries;

    }
}
