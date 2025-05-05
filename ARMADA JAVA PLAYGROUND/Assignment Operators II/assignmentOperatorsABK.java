public class assignmentOperatorsABK {
    public static void main(String[] args) {
        /*
         * The program starts with an integer variable x initialized to 10.
         * It then uses the assignment operators to perform various operations on x,
         * such as addition, subtraction, multiplication, division, and finding the
         * remainder.
         * The results of these operations are printed to the console.
         */
        int x = 10;

        System.out.println("Adding 5 to x: " + (x += 5));
        System.out.println("Subtracting 3 from x: " + (x -= 3));
        System.out.println("Multiplting x by 2: " + (x *= 2));
        System.out.println("Dividing x by 4: " + (x /= 4));
        System.out.println("Finding remainer when x divided by 3: " + (x %= 3));

        // Bonus Task:
        double price = 100;

        System.out.println("Initial Price: $" + price);

        price *= 0.8;
        System.out.println("Price after 20% discount: $" + price);

        price *= 1.1;
        System.out.println("Final Price after 10% tax: $" + price);

    }
}
