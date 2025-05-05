package StringProcessing;
public class Main {
    public static void main(String[] args) {
        final int ITERATIONS = 100_000;
        String word = "Java";

        // Trying for String
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < ITERATIONS; i++) {
            str += word;
        }
        long endTime = System.currentTimeMillis();
        long stringTime = endTime - startTime;
        System.out.println("Appending 100,000 times using String took: " + stringTime + "ms");

        // Trying forStringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) {
            sb.append(word);
        }
        endTime = System.currentTimeMillis();
        long builderTime = endTime - startTime;
        System.out.println("Appending 100,000 times using StringBuilder took: " + builderTime + "ms");

        // Trying for StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) {
            sbf.append(word);
        }
        endTime = System.currentTimeMillis();
        long bufferTime = endTime - startTime;
        System.out.println("Appending 100,000 times using StringBuffer took: " + bufferTime + "ms");

        String fastest = "String";
        long minTime = stringTime;

        if (builderTime < minTime) {
            fastest = "StringBuilder";
            minTime = builderTime;
        }
        if (bufferTime < minTime) {
            fastest = "StringBuffer";
            minTime = bufferTime;
        }

        System.out.println("Fastest method: " + fastest);
    }
}
