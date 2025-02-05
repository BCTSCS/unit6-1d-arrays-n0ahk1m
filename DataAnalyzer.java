

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

    public static int[] reverseList(int[] numbers){
        int[] newNumbers = new int[numbers.length];
        int index = 0;
        for (int i = numbers.length-1; i >= 0; i--){
            newNumbers[index] = numbers[i];
            index++;
        }

        return newNumbers;
    }

    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        System.out.println(searchList(arr,50));
        System.out.println(binarySearch(arr,50));
        int[] reversedArr = reverseList(arr);
        for (int i = 0; i < reversedArr.length; i++){
            System.out.print(reversedArr[i] + " ");
        }
    }
}