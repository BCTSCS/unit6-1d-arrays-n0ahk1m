public class Country {
    private String name;
    private String income; 
    private double internetPercent;
    private int population;
    private double unemployment;

    public Country(String name, String income, double internetPercent, int population, double unemployment){
        this.name = name;
        this.income = income; 
        this.internetPercent = internetPercent;
        this.population = population;
        this.unemployment = unemployment;
    }
}