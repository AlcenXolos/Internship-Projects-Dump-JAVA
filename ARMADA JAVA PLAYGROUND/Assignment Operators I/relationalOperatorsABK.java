public class relationalOperatorsABK {
    public static void main(String[] args) {
        // This Java program demonstrates the use of relational operators.
        int x = 21, y = 10;

        System.out.println("Comparing x = " + x + " and y = " + y);
        System.out.println("x == y: " + (x == y)); 
        System.out.println("x != y: " + (x != y));  
        System.out.println("x > y: " + (x > y)); 
        System.out.println("x < y: " + (x < y));
        System.out.println("x >= y: " + (x >= y));
        System.out.println("x <= y: " + (x <= y));

        if(x >= 12 || x <= 31) {
            System.out.println("x is between 12 and 31");
        } else {
            System.out.println("x is not between 12 and 31");
        }
    }
}
