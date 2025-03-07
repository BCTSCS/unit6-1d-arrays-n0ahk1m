import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DataGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private Internet internet = new Internet();
    public static int counter = 0;

    public DataGUI() {

        setTitle("Internet Data Analyzer");
        setSize(600, 600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        resultsArea = new JTextArea(10,20);

        JButton findCountryByInternetButton = new JButton("Find Countries by Internet Usage");
        JButton findCountryByIncomeButton = new JButton("Find Countries by Income Level");
        JButton findCountryByPopulationButton = new JButton("Find Countries by Population Size");
        JButton findCountryByUnemploymentButton = new JButton("Find Countries by Unemployment Level");
        JButton getLowestCountriesButton = new JButton("Get Countries with the Least Population");
        JButton getLowUsageCountriesButton = new JButton("Get Countries with the Lowest Internet Usage");
        JButton getPercentofIncomeButton = new JButton("Get Statistical Percentage of Each Income Level");
        JButton saveScreenButton = new JButton("Save Screen");

        
        resultsArea.setEditable(false);

        add(inputField);
        add(findCountryByInternetButton);
        add(findCountryByIncomeButton);
        add(findCountryByPopulationButton);
        add(findCountryByUnemploymentButton);
        add(getLowestCountriesButton);
        add(getLowUsageCountriesButton);
        add(getPercentofIncomeButton);
        add(saveScreenButton);
        add(new JScrollPane(resultsArea));

        findCountryByInternetButton.addActionListener(e -> findByInternet());
        findCountryByIncomeButton.addActionListener(e -> findByIncome());
        findCountryByPopulationButton.addActionListener(e -> findByPopulation());
        findCountryByUnemploymentButton.addActionListener(e -> findByUnemployment());
        getLowestCountriesButton.addActionListener(e -> getLowestCountries());
        getLowUsageCountriesButton.addActionListener(e -> getLowUsageCountries());
        getPercentofIncomeButton.addActionListener(e -> getPercentofIncome());
        saveScreenButton.addActionListener(e -> saveScreen());

    }

    private void findByInternet(){
        resultsArea.setText("");
        String input = inputField.getText();
        double targetInternet = Double.parseDouble(input);

        ArrayList<String> targetCountries = internet.findCountryByInternetUsage(targetInternet);

        resultsArea.append("Countries with an Internet Usage of " + input + ":" + "\n" + "----------------------" + "\n");
        for (String country : targetCountries){
            resultsArea.append(country + "\n");
        }
    }

    private void findByIncome(){
        resultsArea.setText("");
        String targetIncome = inputField.getText();

        ArrayList<String> targetCountries = internet.findCountryByIncomeLevel(targetIncome);

        resultsArea.append("Countries that are " + targetIncome + ":" + "\n" + "----------------------" + "\n");
        for (String country : targetCountries){
            resultsArea.append(country + "\n");
        }
    }

    private void findByPopulation(){
        resultsArea.setText("");
        String input = inputField.getText();
        int targetPopulation = Integer.parseInt(input);

        ArrayList<String> targetCountries = internet.findCountryByPopulation(targetPopulation);

        resultsArea.append("Countries that have a population of " + targetPopulation + ":" + "\n" + "----------------------" + "\n");
        for (String country : targetCountries){
            resultsArea.append(country + "\n");
        }
    }

    private void findByUnemployment(){
        resultsArea.setText("");
        String input = inputField.getText();
        double targetUnemployment = Double.parseDouble(input);

        ArrayList<String> targetCountries = internet.findCountryByUnemployment(targetUnemployment);

        resultsArea.append("Countries that have an unemployment level of " + targetUnemployment + ":" + "\n" + "----------------------" + "\n");
        for (String country : targetCountries){
            resultsArea.append(country + "\n");
        }
    }
    
    private void getLowestCountries(){
        resultsArea.setText("");

        ArrayList<String> targetCountries = internet.getLeastPopulatedCountries();

        resultsArea.append("Countries with the lowest population: " + "\n" + "----------------------" + "\n");
        for (String country : targetCountries){
            resultsArea.append(country + "\n");
        }
    }

    private void getLowUsageCountries(){
        resultsArea.setText("");

        ArrayList<String> targetCountries = internet.getLowUsageCountries();

        resultsArea.append("Countries with the lowest internet usage: " + "\n" + "----------------------" + "\n");
        for (String country : targetCountries){
            resultsArea.append(country + "\n");
        }
    }

    private void getPercentofIncome(){
        resultsArea.setText("");

        ArrayList<Double> incomePercents = internet.getPercentofIncomes();

        resultsArea.append("Low Income: " + incomePercents.get(0) + "\n");
        resultsArea.append("Lower Middle Income: " + incomePercents.get(1) + "\n");
        resultsArea.append("Upper Middle Income: " + incomePercents.get(2) + "\n");
        resultsArea.append("High Income: " + incomePercents.get(3) + "\n");
    }

    public void saveScreen(){
        counter++;
        try {
            int w = resultsArea.getWidth();
            int h = resultsArea.getHeight();
            int type =BufferedImage.TYPE_INT_ARGB;
            BufferedImage sshot = new BufferedImage(w,h,type);

            Graphics2D g2d = sshot.createGraphics();
            resultsArea.paint(g2d);

            File out = new File("Search "+ counter + ".png");
            ImageIO.write(sshot,"png",out);
            g2d.dispose();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}