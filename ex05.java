public class ex05 {
    public static void main(String[] args) {
       float[] scores = {90.5f, 20, 50, 75, 80, 85, 69, 0, 80, 40, 70};
        mergeSort(scores, 0, scores.length - 1);
        
        System.out.print("Sorted:  ");
        printFloatArray(scores);
        System.out.println();
    }
    
     public static void printFloatArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
    }
    public static void mergeSort(float[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    public static void merge(float[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        float[] leftArray = new float[n1];
        float[] rightArray = new float[n2];
        
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
