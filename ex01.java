public class ex01 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {90, 6, -10, 2, 70, 9, 1, 5, 22};
        bubbleSort(array);

        System.out.print("Sorted:   ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}    