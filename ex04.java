import java.util.Random;

public class ex04 {
    public static void main(String[] args) {
        int[] array = new int[25];
        Random random = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        
        int[] descArray = array.clone();
        insertionSortDescending(descArray);
        System.out.print("Descending: ");
        printArray(descArray);
        
        int[] ascArray = array.clone();
        insertionSortAscending(ascArray);
        System.out.print("Ascending:  ");
        printArray(ascArray);
        System.out.println();
    }
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }
    
    public static void insertionSortAscending(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int num = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > num) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = num;
        }
    }
    
    public static void insertionSortDescending(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int num = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < num) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = num;
        }
    }

}
