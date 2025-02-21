
public class DataRunner {
    public static void main(String[] args){
        FileOperator countriesFile = new FileOperator("countries.txt");
        FileOperator incomeFile = new FileOperator("incomes.txt");
        FileOperator internetpercentFile = new FileOperator("internetpercent.txt");
        FileOperator populationsFile = new FileOperator("populations.txt");
        FileOperator unemploymentFile = new FileOperator("unemployment.txt");

        String[] countries = countriesFile.toStringArray(215);
        String[] incomes = incomeFile.toStringArray(215);
        double[] internetPercents = internetpercentFile.toDoubleArray(215);
        int[] populations = populationsFile.toIntArray(215);
        double[] unemployment = unemploymentFile.toDoubleArray(215);

        String[] filteredCountries;
        filteredCountries = findCountriesByInternetUsage(76, internetPercents, countries);
        
    }
}
