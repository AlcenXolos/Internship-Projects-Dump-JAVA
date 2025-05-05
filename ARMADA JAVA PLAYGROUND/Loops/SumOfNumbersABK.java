import java.util.Scanner;

public class SumOfNumbersABK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();

        if(num < 0){
            System.out.println("Invalid number");
            sc.close();
            return;
        }

        System.out.print("The sum of natural numbers from 1 to " + num + " is: ");
        int sum = 0;

        while(num != 0) {
            sum += num;
            num--;
        }

        System.out.println(sum);
        sc.close();
    }
}
