public class combinedOperatorsABK {
    public static void main(String[] args) {
        /*
         * This Java program initializes two integer variables `a` with a value of 5 and
         * `b` with a
         * value of 10. It then checks if both `a` and `b` are greater than 0 using the
         * logical AND
         * operator `&&`. If both conditions are true, it performs the following
         * operations:
         */
        int a = 5, b = 10;

        if (a > 0 && b > 0) {
            a = a + b;
            b = a * 2;
        } else {
            System.out.println("Either a or b is not positive.");
        }

        System.out.println("The value of A is " + a);
        System.out.println("The value of B is " + b);
    }
}
