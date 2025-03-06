public class Internet {
    private Country[] countries;

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

        countries = new Country(215);
        for (int i = 0; i < 215; i++){
            countries[i] = new Country(names[i],incomes[i],internetPercents[i],populations[i],unemployment[i]);
        }
    }
}
