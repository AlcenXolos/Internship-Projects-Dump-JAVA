package NumberSystemConverter_Part1;

import java.util.Scanner;

public class ManualNumberCoverterABK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimalNum = sc.nextInt();

        System.out.println("=== Number System Conversions === ");
        System.out.println("Binary: " + convertDecimalToBinary(decimalNum));
        System.out.println("Octal: " + convertDecimalToOctal(decimalNum));
        System.out.println("Hexadecimal: " + convertDecimalToHexaD(decimalNum));

        sc.close();
    }

    // The coversion are read from bottom to top.
    // binary, octal, and hexadecimal are computed by dividing the decimal number by 2, 8, and 16 respectively
    // in hexadecimal, 10 = A, 11 = B, 12 = C, 13 = D, 14 = E, 15 = F

    private static String convertDecimalToBinary(int decimalNum) {
        String binaryNum = "";
        while(true) {
            if (decimalNum == 0) break;

            int remainder = decimalNum % 2;
            binaryNum += remainder;
            decimalNum /= 2;
        }
        return new StringBuilder(binaryNum).reverse().toString();
    }

    private static String convertDecimalToOctal(int decimalNum) {
        String octalNum = "";

        while(true){
            if (decimalNum == 0) break;

            int remainder = decimalNum % 8;
            octalNum += remainder;
            decimalNum /= 8;
        }

        return new StringBuilder(octalNum).reverse().toString();
    }

    private static String convertDecimalToHexaD(int decimalNum) {
        String hexaDNum = "";

        while(true){
            if(decimalNum == 0) break;
            
            int remainder = decimalNum % 16;

            if(remainder == 10) hexaDNum += "A"; 
            else if(remainder == 11) hexaDNum += "B"; 
            else if(remainder == 12) hexaDNum += "C"; 
            else if(remainder == 13) hexaDNum += "D"; 
            else if(remainder == 14) hexaDNum += "E"; 
            else if(remainder == 15) hexaDNum += "F"; 
            else hexaDNum += remainder; 

            decimalNum /= 16;
        }
        return new StringBuilder(hexaDNum).reverse().toString();
    }
}
