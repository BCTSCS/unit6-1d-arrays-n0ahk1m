import java.util.ArrayList;

public class Internet {
    private Country[] countries = new Country[215];

    public Internet(){
        FileOperator countriesFile = new FileOperator("countries.txt");
        FileOperator incomeFile = new FileOperator("incomes.txt");
        FileOperator internetpercentFile = new FileOperator("internetpercent.txt");
        FileOperator populationsFile = new FileOperator("populations.txt");
        FileOperator unemploymentFile = new FileOperator("unemployment.txt");
    
        String[] names = countriesFile.toStringArray(215);
        String[] incomes = incomeFile.toStringArray(215);
        double[] internetPercents = internetpercentFile.toDoubleArray(215);
        int[] populations = populationsFile.toIntArray(215);
        double[] unemployment = unemploymentFile.toDoubleArray(215);

        for (int i = 0; i < 215; i++){
            countries[i] = new Country(names[i],incomes[i],internetPercents[i],populations[i],unemployment[i]);
        }
    }

    public ArrayList<String> findCountryByInternetUsage(double targetInternet){
        ArrayList<String> targetCountries = new ArrayList<String>();
        for (Country country : countries){
            if (country.getInternetPercent() == targetInternet){
                targetCountries.add(country.getName());
            }
        }

        return targetCountries;
    }

    public ArrayList<String> findCountryByIncomeLevel(String targetIncome){
        ArrayList<String> targetCountries = new ArrayList<String>();
        for (Country country : countries){
            if (country.getIncome().equals(targetIncome)){
                targetCountries.add(country.getName());
            }
        }

        return targetCountries;
    }

    public ArrayList<String> findCountryByPopulation(int targetPopulation){
        ArrayList<String> targetCountries = new ArrayList<String>();
        for (Country country : countries){
            if (country.getPopulation() == targetPopulation){
                targetCountries.add(country.getName());
            }
        }

        return targetCountries;
    }

    public ArrayList<String> findCountryByUnemployment(double targetUnemployment){
        ArrayList<String> targetCountries = new ArrayList<String>();
        for (Country country : countries){
            if (country.getUnemployment() == targetUnemployment){
                targetCountries.add(country.getName());
            }
        }

        return targetCountries;
    }

    public ArrayList<String> getLeastPopulatedCountries(){
        ArrayList<String> targetCountries = new ArrayList<String>();

        int minPopulation = countries[0].getPopulation();
        for (int i = 0; i < countries.length; i++){
            if (countries[i].getPopulation() < minPopulation){
                minPopulation = countries[i].getPopulation();
            }
        }

        for (int i = 0; i < countries.length; i++){
            if (countries[i].getPopulation() == minPopulation){
                targetCountries.add(countries[i].getName());
            }
        }

        return targetCountries;
    }

    public ArrayList<String> getLowUsageCountries(){
        ArrayList<String> targetCountries = new ArrayList<String>();

        double minUsage = countries[0].getInternetPercent();
        for (int i = 0; i < countries.length; i++){
            if (countries[i].getInternetPercent() < minUsage){
                minUsage = countries[i].getInternetPercent();
            }
        }

        for (int i = 0; i < countries.length; i++){
            if (countries[i].getInternetPercent() == minUsage){
                targetCountries.add(countries[i].getName());
            }
        }

        return targetCountries;
    }

    public ArrayList<Double> getPercentofIncomes(){
        ArrayList<Double> incomePercents = new ArrayList<Double>();

        int lowCount = 0;
        int lowMidCount = 0;
        int upMidCount = 0;
        int upCount = 0;
        for (Country country : countries){
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

        incomePercents.add((lowCount*1.0/countries.length)*100);
        incomePercents.add((lowMidCount*1.0/countries.length)*100);
        incomePercents.add((upMidCount*1.0/countries.length)*100);
        incomePercents.add((upCount*1.0/countries.length)*100);

        return incomePercents;
    }
}
