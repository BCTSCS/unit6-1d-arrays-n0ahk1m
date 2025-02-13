import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperator{
    public static void main(String[] args){
        String[] stringArray = toStringArray(100);
        int[] intArray = toIntArray(100);
        double[] doubleArray = toDoubleArray(100);
    }

    public static String[] toStringArray(int size){
        try {
            File f = new File("numbers.txt");
            Scanner input = new Scanner(f);

            String[] strings = new String[100];
            for (int i = 0; i < 100; i++){
                strings[i] = input.nextLine();
            }

            return strings;
        } catch (IOException e) {
            System.out.println("file not found");
        }
        
        String[] arr = {" "};
        return arr;
    }

    public static int[] toIntArray(int size){
        try {
            File f = new File("numbers.txt");
            Scanner input = new Scanner(f);

            int[] numbers = new int[100];
            for (int i = 0; i < 100; i++){
                numbers[i] = input.nextInt();
            }

            return numbers;
        } catch (IOException e) {
            System.out.println("file not found");
        }
        
        int[] arr = {1};
        return arr;
    }

    public static double[] toDoubleArray(int size){
        try {
            File f = new File("numbers.txt");
            Scanner input = new Scanner(f);

            double[] doubles = new double[100];
            for (int i = 0; i < 100; i++){
                doubles[i] = input.nextDouble();
            }

            return doubles;
        } catch (IOException e) {
            System.out.println("file not found");
        }
        
        double[] arr = {1.0};
        return arr;
    }
}