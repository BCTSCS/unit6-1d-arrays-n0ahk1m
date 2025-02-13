import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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

    public static void main(String[] args){
    }

    public String[] toStringArray(int size){
        String[] arr = new String[100];
        try {
            for (int i = 0; i < 100; i++){
                arr[i] = fileReader.nextLine();
            }
            return arr;
        } catch (IOException e) {
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

        } catch (IOException e) {
            System.out.println("file not found");
            return arr;
        }
    }

    public double[] toDoubleArray(int size){
        double[] arr = new double[100];

        try {
            for (int i = 0; i < 100; i++){
                arr[i] = fileReader.nextDouble();
            }
            return arr;
        } catch (IOException e) {
            System.out.println("file not found");
            return arr;
        }
    }
}