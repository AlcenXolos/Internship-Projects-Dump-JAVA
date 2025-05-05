import java.util.Scanner;

public class LargestNumberFinderABK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int largestNum = Integer.MIN_VALUE,
            num;

        while (true) {
            System.out.print("Enter a number (-1 to stop): ");
            num = sc.nextInt();

            if (num == -1)
                break;

            if (num > largestNum)
                largestNum = num;
        }

        sc.close();

        System.out.println("The largest number entered is: " + largestNum);
        
    }
}
