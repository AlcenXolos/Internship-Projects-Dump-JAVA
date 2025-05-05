package AnalyzingAndFormattingAParagraph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a paragraph: ");
        String paragraph = sc.nextLine();

        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        int wordCount = paragraph.split(" ").length;

        String modifiedParagraph = paragraph.replaceAll("Java", "Python");

        System.out.println("Word Count: " + wordCount);
        System.out.println("Modified Paragraph: " + modifiedParagraph);
    }
}
