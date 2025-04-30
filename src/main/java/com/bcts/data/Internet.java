package com.bcts.data;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Business Class
@Service
public class Internet {
    @Autowired
    private DataRepository dataRepository;

    public List<Country> getCountries(){
        List<Country> countries = dataRepository.findAll();
        return countries;
    } 

    public List<Country> findCountryByInternetUsage(double targetInternet){
        List<Country> allCountries = dataRepository.findAll();
        List<Country> targetCountries = new ArrayList<>();

        for (Country country : allCountries){
            if (country.getInternetPercent() == targetInternet){
                targetCountries.add(country);
            }
        }

        return targetCountries;
    }

    public List<Country> findCountryByIncomeLevel(String targetIncome){
        List<Country> allCountries = dataRepository.findAll();
        List<Country> targetCountries = new ArrayList<>();

        for (Country country : allCountries){
            if (country.getIncome().equals(targetIncome)){
                targetCountries.add(country);
            }
        }

        return targetCountries;
    }

    public List<Country> findCountryByPopulation(int targetPopulation){
        List<Country> allCountries = dataRepository.findAll();
        List<Country> targetCountries = new ArrayList<>();

        for (Country country : allCountries){
            if (country.getPopulation() == targetPopulation){
                targetCountries.add(country);
            }
        }

        return targetCountries;
    }

    public List<Country> findCountryByUnemployment(double targetUnemployment){
        List<Country> allCountries = dataRepository.findAll();
        List<Country> targetCountries = new ArrayList<>();

        for (Country country : allCountries){
            if (country.getUnemployment() == targetUnemployment){
                targetCountries.add(country);
            }
        }

        return targetCountries;
    }

    public List<Country> getLeastPopulatedCountries(){
        List<Country> allCountries = dataRepository.findAll();
        List<Country> targetCountries = new ArrayList<>();

        int minPopulation = allCountries.get(0).getPopulation();
        for (int i = 0; i < allCountries.size(); i++){
            if (allCountries.get(i).getPopulation() < minPopulation){
                minPopulation = allCountries.get(i).getPopulation();
            }
        }

        for (int i = 0; i < allCountries.size(); i++){
            if (allCountries.get(i).getPopulation() == minPopulation){
                targetCountries.add(allCountries.get(i));
            }
        }

        return targetCountries;
    }

    public List<Country> getLowUsageCountries(){
        List<Country> allCountries = dataRepository.findAll();
        List<Country> targetCountries = new ArrayList<>();

        double minUsage = allCountries.get(0).getInternetPercent();
        for (int i = 0; i < allCountries.size(); i++){
            if (allCountries.get(i).getInternetPercent() < minUsage){
                minUsage = allCountries.get(i).getInternetPercent();
            }
        }

        for (int i = 0; i < allCountries.size(); i++){
            if (allCountries.get(i).getInternetPercent() == minUsage){
                targetCountries.add(allCountries.get(i));
            }
        }

        return targetCountries;
    }

    public ArrayList<Double> getPercentofIncomes(){
        List<Country> allCountries = dataRepository.findAll();
        ArrayList<Double> incomePercents = new ArrayList<>();

        int lowCount = 0;
        int lowMidCount = 0;
        int upMidCount = 0;
        int upCount = 0;
        for (Country country : allCountries){
            if (country.getIncome().equals("Low Income")){
                lowCount++;
            }
            if (country.getIncome().equals("Lower Middle Income")){
                lowMidCount++;
            }
            if (country.getIncome().equals("Upper Middle Income")){
                upMidCount++;
            }
            if (country.getIncome().equals("High Income")){
                upCount++;
            }
        }

        incomePercents.add((lowCount*1.0/allCountries.size())*100);
        incomePercents.add((lowMidCount*1.0/allCountries.size())*100);
        incomePercents.add((upMidCount*1.0/allCountries.size())*100);
        incomePercents.add((upCount*1.0/allCountries.size())*100);

        return incomePercents;
    }
}
