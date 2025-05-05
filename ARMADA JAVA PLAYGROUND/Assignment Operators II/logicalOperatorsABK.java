public class logicalOperatorsABK {
    public static void main(String[] args) {
        // This is for logical not task
        boolean a = true;
        boolean b = false;

        System.out.println("Logical NOT Operator");
        System.out.println("!a = " + !a);
        System.out.println("!b = " + !b);

        // This is for the Loan Eligibility Check task
        int creditScore = 700;
        int annualIncome = 60000;
        System.out.println("==========================================================");
        System.out.println("\nLoan Eligibility Check");
        // use of and operator. Both conditions must be true for the statement to be true
        if (creditScore > 700 && annualIncome > 50000) {
            System.out.println("You are eligible for the loan.");
        } else {
            System.out.println("You are not eligible for the loan.");
        }

        // use of or operator. if either one is true then the statement is true
        if (creditScore > 700 || annualIncome > 50000) {
            System.out.println("You meet at least one eligibility criterion.");
        } else {
            System.out.println("You do not meet any eligibility criteria.");
        }

        // use of not operator . if the condition is false then the statement is true, and vice versa
        if (!(creditScore > 700 && annualIncome > 50000)) {
            System.out.println("You do NOT qualify based on both conditions.");
        } else {
            System.out.println("You qualify based on both conditions.");
        }
    }
}
