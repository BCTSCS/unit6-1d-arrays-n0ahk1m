import java.awt.*;
import javax.swing.*;


public class DataGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultsArea;
    private Internet internet;

    private FileOperator countriesFile = new FileOperator("countries.txt");
    private FileOperator incomeFile = new FileOperator("incomes.txt");
    private FileOperator internetpercentFile = new FileOperator("internetpercent.txt");
    private FileOperator populationsFile = new FileOperator("populations.txt");
    private FileOperator unemploymentFile = new FileOperator("unemployment.txt");
    
    private String[] countries = countriesFile.toStringArray(215);
    private String[] incomes = incomeFile.toStringArray(215);
    private double[] internetPercents = internetpercentFile.toDoubleArray(215);
    private int[] populations = populationsFile.toIntArray(215);
    private double[] unemployment = unemploymentFile.toDoubleArray(215);

    public DataGUI() {
        internet = new Internet();
        setTitle("Internet Data Analyzer");
        setSize(600, 600);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        resultsArea = new JTextArea(10,20);

        JButton findCountryByInternetButton = new JButton("Find Country by Internet Usage");
        JButton findCountryByIncomeButton = new JButton("Find Country by Income Level");
        JButton findCountryByPopulationButton = new JButton("Find Country by Population Size");
        JButton findCountryByUnemploymentButton = new JButton("Find Country by Unemployment");
        JButton getMinInternetButton = new JButton("Get Country with lowest Internet Usage");
        
        resultsArea.setEditable(false);

        add(inputField);
        add(findCountryByInternetButton);
        add(findCountryByIncomeButton);
        add(findCountryByPopulationButton);
        add(findCountryByUnemploymentButton);
        add(getMinInternetButton);
        add(new JScrollPane(resultsArea));

        findCountryByInternetButton.addActionListener(e -> findByInternet());
        findCountryByIncomeButton.addActionListener(e -> findByIncome());
        findCountryByPopulationButton.addActionListener(e -> findByPopulation());
        findCountryByUnemploymentButton.addActionListener(e -> findByUnemployment());
        getMinInternetButton.addActionListener(e -> getMinInternet());
    }

    private void findByInternet(){
        String input = inputField.getText();
        double value = Double.parseDouble(input);

        String country = DataAnalyzer.findCountryByInternetUsage(value, internetPercents, countries);
        resultsArea.setText("Country by Specified Usage of " + inputField.getText() + ":" + "\n" + country);
    }

    private void findByIncome(){
        String input = inputField.getText();

        String country = DataAnalyzer.findCountryByIncomeLevel(input, incomes, countries);
        resultsArea.setText("Country by Specified Income Level of " + inputField.getText() + ":" + "\n" + country);
    }

    private void findByPopulation(){
        String input = inputField.getText();
        int value = Integer.parseInt(input);

        String country = DataAnalyzer.findCountryByPopulation(value, populations, countries);
        resultsArea.setText("Country by Specified Population of " + inputField.getText() + ":" + "\n" + country);
    }

    private void findByUnemployment(){
        String input = inputField.getText();
        double value = Double.parseDouble(input);

        String country = DataAnalyzer.findCountryByUnemployment(value, unemployment, countries);
        resultsArea.setText("Country by Specified Unemployment of " + inputField.getText() + ":" + "\n" + country);
    }

    private void getMinInternet(){
        String country = DataAnalyzer.getMinInternetCountry(countries, internetPercents);
        resultsArea.setText("Country with lowest internet usage:" + "\n" + country);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}
    