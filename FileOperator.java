import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileOperator{
    private String myFile;
    private Scanner fileReader;

    public FileOperator(String f){
        setFile(f);
    }

    public void setFile(String filename){
        myFile = filename;
        try {
            fileReader = new Scanner(new File(myFile));
        } catch (FileNotFoundException error) {
            System.out.println("File not found.");
        }
    }
    public ArrayList<Integer> toIntList(){
        ArrayList<Integer> arr = new ArrayList<Integer>();

        while (fileReader.hasNextInt()){
            arr.add(fileReader.nextInt());
        }

        return arr;
    }

    public ArrayList<String> toStringList(){
        ArrayList<String> arr = new ArrayList<>();

        while(fileReader.hasNextLine()){
            arr.add(fileReader.nextLine());
        }
        return arr;
    }

    public ArrayList<Double> toDoubleList(){
        ArrayList<Double> arr = new ArrayList<>();

        while(fileReader.hasNextDouble()){
            arr.add(fileReader.nextDouble());
        }
        return arr;
    }

    public String[] toStringArray(int size){
        String[] arr = new String[size];
        try {
            for (int i = 0; i < size; i++){
                arr[i] = fileReader.nextLine();
            }
            return arr;
        } catch (Exception e) {
            System.out.println("file not found");
            return arr;
        }
    }

    public int[] toIntArray(int size){
        int[] arr = new int[size];

        try {
            for (int i = 0; i < size; i++){
                arr[i] = fileReader.nextInt();
            }
            return arr;

        } catch (Exception e) {
            System.out.println("file not found");
            return arr;
        }
    }

    public double[] toDoubleArray(int size){
        double[] arr = new double[size];

        try {
            for (int i = 0; i < size; i++){
                arr[i] = fileReader.nextDouble();
            }
            return arr;
        } catch (Exception e) {
            System.out.println("file not found");
            return arr;
        }
    }
}