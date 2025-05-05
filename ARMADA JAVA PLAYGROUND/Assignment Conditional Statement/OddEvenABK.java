import java.util.Scanner;

public class OddEvenABK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        // checks if the number is divisible by two, if yes then it is an even number, if not it is an odd
        if(num % 2 == 0) {
            System.out.println( num +"is an even number");
        } else {
            System.out.println(num + " is an odd number");
        }
        sc.close();
    }    
}
