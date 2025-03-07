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

    public String getName(){
        return this.name;
    }

    public String getIncome(){
        return this.income;
    }

    public double getInternetPercent(){
        return this.internetPercent;
    }

    public int getPopulation(){
        return this.population;
    }

    public double getUnemployment(){
        return this.unemployment;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIncome(String income){
        this.income = income;
    }

    public void setInternetPercent(double internetPercent){
        this.internetPercent = internetPercent;
    }

    public void setPopulation(int population){
        this.population = population;
    }

    public void setUnemployment(double unemployment){
        this.unemployment = unemployment;
    }
}