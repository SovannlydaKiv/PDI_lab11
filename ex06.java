import java.util.ArrayList;

public class ex06 {
     static class Car {
        String vin;
        String model;
        int year;
        double price;
        String engineType;
        
        public Car(String vin, String model, int year, double price, String engineType) {
            this.vin = vin;
            this.model = model;
            this.year = year;
            this.price = price;
            this.engineType = engineType;
        }
        
        @Override
        public String toString() {
            return String.format("%-15s %-15s %d $%-10.2f %s", 
                vin, model, year, price, engineType);
        }
    }
    
    public static void main(String[] args) {
        selectionSort();
    }
    
    public static void selectionSort() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("VIN004", "Ford Mustang", 2021, 35000, "Gas"));
        cars.add(new Car("VIN002", "Audi A4", 2022, 40000, "Gas"));
        cars.add(new Car("VIN0012", "Nissan Altima", 2020, 24000, "Gas"));
        cars.add(new Car("VIN010", "Lexus ES", 2023, 48000, "Hybrid"));
        
        System.out.println("\nBefore Sorting:");
        System.out.println("VIN             Model           Year  Price      Engine");
        System.out.println("---------------------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car);
        }

        selectionSortCars(cars);
        
        System.out.println("\nAfter Sorting (by Price - Descending):");
        System.out.println("VIN             Model           Year  Price      Engine");
        System.out.println("---------------------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
    
    public static void selectionSortCars(ArrayList<Car> cars) {
        int n = cars.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (cars.get(j).price > cars.get(maxIndex).price) {
                    maxIndex = j;
                }
            }
            Car temp = cars.get(i);
            cars.set(i, cars.get(maxIndex));
            cars.set(maxIndex, temp);
        }
    }
}
