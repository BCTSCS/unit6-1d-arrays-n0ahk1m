import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataAnalyzer{

    public static int searchList(int target, int[] numbers){

        return -1;
    }

    // Linear search
    public static int searchList(int[] numbers, int target){
        int index = 0;
        while (index <= numbers.length-1){
            if (numbers[index] == target){
                return index;
            }
            index++;
        }

        return -1;
    }

    // Binary search
    public static int binarySearch(int[] numbers, int target){
        int minIndex = 1;
        int maxIndex = numbers.length;
        while (minIndex <= maxIndex){
            int middleIndex = (int)Math.floor((minIndex+maxIndex)/2);
            if (target == numbers[middleIndex]){
                return middleIndex;
            }
            else {
                if (target > numbers[middleIndex]){
                    minIndex++;
                }
                else {
                    maxIndex--;
                }
            }
        }
        return -1;
    }

    // Reverse list
    public static int[] reverseList(int[] numbers){
        int[] newNumbers = new int[numbers.length];
        int index = 0;
        for (int i = numbers.length-1; i >= 0; i--){
            newNumbers[index] = numbers[i];
            index++;
        }

        return newNumbers;
    }

    // public int[] toIntArray(int size){
    //     int[] arr = new int[size];
    //     for (int i = 0; i < size; i++){
    //         arr[i] = FileReader.nextInt();
    //     }
    //     return arr;
    // }

    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        System.out.println(searchList(arr,50));
        System.out.println(binarySearch(arr,50));
        int[] reversedArr = reverseList(arr);
        for (int i = 0; i < reversedArr.length; i++){
            System.out.print(reversedArr[i] + " ");
        }

        System.out.println();

        try{
            File f = new File("numbers.txt");
            Scanner input = new Scanner(f);

            int[] numbers = new int[100];
            for (int i = 0; i < 100; i++){
                numbers[i] = input.nextInt();
            }
            System.out.println(searchList(numbers,52));
            System.out.println(binarySearch(numbers,0));
            int[] reversedNumber = reverseList(numbers);
            for (int i = 0; i < reversedNumber.length; i++){
                System.out.print(reversedNumber[i] + " ");
            }
        }
        catch(IOException e){
            System.out.println("file not found");
        }
    }
}