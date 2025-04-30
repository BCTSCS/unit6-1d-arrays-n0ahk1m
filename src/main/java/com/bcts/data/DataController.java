package com.bcts.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {
    
    @Autowired
    private Internet service;

    @GetMapping("/")
    public String home(Model model){
        List<Country> countries = service.getCountries();
        model.addAttribute("allCountries", countries);
        return "index";
    }

    @GetMapping("/countries")
    public String countries(Model model){
        List<Country> countries = service.getCountries();
        model.addAttribute("allCountries", countries);
        return "countries";
    }

    @GetMapping("/countries/compare")
    public String compare(Model model){
        model.addAttribute("filteredCountries", List.of());
        return "compare";
    }

    @GetMapping("/countries/leastPopulated")
    public String leastPopulatedCountry(Model model){
        List<Country> leastPopulatedCountry = service.getLeastPopulatedCountries();
        Country leastPopulated = leastPopulatedCountry.get(0);
        model.addAttribute("leastPopulated", leastPopulated);
        model.addAttribute("filteredCountries", List.of());
        return "compare";
    }

    @GetMapping("/countries/lowUsage")
    public String lowestInternetUsage(Model model){
        List<Country> lowestUsageCountries = service.getLowUsageCountries();
        Country lowestUsageCountry = lowestUsageCountries.get(0);
        model.addAttribute("lowUsage", lowestUsageCountry);
        model.addAttribute("filteredCountries", List.of());
        return "compare";
    }

    @GetMapping("/countries/filterByInternetUsage")
    public String filterByInternetUsage(@RequestParam("internetUsage") double internetUsage, Model model){
        List<Country> filteredCountries = service.findCountryByInternetUsage(internetUsage);
        model.addAttribute("filteredCountries",filteredCountries);
        return "compare";
    }
}
