package M1DArray;

public class Main {
    public static void main(String[] args) {
        int arr[] = {5, 10, 15, 20, 25}, 
            sum = 0;
        
        for (int element : arr) {
            sum += element;
        }

        System.out.println("Sum of elements: " + sum);
    }
}
