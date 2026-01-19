public class ex03 {
    public static void sortSelection(String name[]){
        for (int i = 0; i < name.length - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < name.length; j++) {
                if (name[j].compareToIgnoreCase(name[minIndex]) < 0) {
                    minIndex = j;
                }
            }
        swap(name, i, minIndex);
        } 
    }
    static void swap (String[] arr, int i, int j) {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
    public static void main(String[] args) {
        String name[] = {"Dara", "Sok", "Sokha", "Daro", "Panha", "Pisey"};
        sortSelection(name);
        for (String n : name) {
            System.out.println(n);
        }
    }   
}
