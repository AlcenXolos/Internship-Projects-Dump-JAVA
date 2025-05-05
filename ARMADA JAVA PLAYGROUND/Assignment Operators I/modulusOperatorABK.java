public class modulusOperatorABK {
    public static void main(String[] args) {
        // This Java program demonstrates the use of the modulus operator (%).
        int num1 = 9, num2 = 23, num3 = 3;

        if(num2 % num1 == 0) {
            System.out.println(num1 + " is a factor of " + num2);
        } else {
            System.out.println(num1 + " is not a factor of " + num2 + " and the remainder is " + num2 % num1);
        }

        if(num1 % num3 == 0) {
            System.out.println(num3 + " is a factor of " + num1);
        } else {
            System.out.println(num3 + " is not a factor of " + num1 + " and the remainder is " + num1 % num3);

        }
    }
}
