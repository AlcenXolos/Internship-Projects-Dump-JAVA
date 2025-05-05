
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String name = sc.nextLine();

        System.out.println("Uppercase Name: " + name.toUpperCase());

        int numOfChars = name.replace(" ", "").length();

        System.out.println("Total Characters (excluding spaces): " + numOfChars);
        String[] arrName = name.trim().split("\\s+");
        String initials = "";
        for (String str : arrName) {
            initials += str.charAt(0) + ". ";
        }
        System.out.println("Initials: " + initials);
    }
}