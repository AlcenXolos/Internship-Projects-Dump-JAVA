import java.util.*;

public class MidtermLab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many pages? ");
        int numPages = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("List of the " + numPages + " pages: ");
        String[] pages = scanner.nextLine().split("\\s+"); // splits the input each whitespaces
        
        System.out.print("Enter the page sequence: ");
        String[] sequence = scanner.nextLine().split(", "); // splits the input each comma 
        
        System.out.print("How many frames? ");
        int numFrames = scanner.nextInt();
        
        System.out.println("\nFIFO Output:");
        
        // FIFO Page Replacement Algorithm
        int pageFaults = 0; // initial value of faults
      
        Queue<String> frameQueue = new LinkedList<>(); // queue for checknig
        List<String[]> frameList = new ArrayList<>(); // frame for displaying
        List<Boolean> faultList = new ArrayList<>(); // list of faults
        
        for (int i = 0; i < sequence.length; i++) { // checks each page in the sequemce
            String page = sequence[i];
            if (!frameQueue.contains(page)) { // check if the page is already in queue
                if (frameQueue.size() == numFrames) {
                    frameQueue.poll(); // removes the head of the queue
                }
                frameQueue.offer(page); // adds page to the queue
                pageFaults++; // increment page faults
                faultList.add(true);
            } else {
                faultList.add(false);
            }
            frameList.add(frameQueue.toArray(new String[0])); // add the queue structure to the frame list
        }
        
        // Print the FIFO output table
        for (int i = 0; i < sequence.length; i++) {
            for (int j = 0; j < numFrames; j++) {
                if (j < frameList.get(i).length) {
                    System.out.print(frameList.get(i)[j] + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            // Print page fault indicator
            System.out.println(faultList.get(i) ? "*" : "");
        }
        
      // displays the success and fault rate
        double successRate = (double) (sequence.length - pageFaults) / sequence.length;
        double faultRate = (double) pageFaults / sequence.length;
        System.out.println("\nPage Success = " + (sequence.length - pageFaults) + "/" + sequence.length + " = " + String.format("%.2f", successRate * 100) + "%");
        System.out.println("Page Fault = " + pageFaults + "/" + sequence.length + " = " + String.format("%.2f", faultRate * 100) + "%");
    }
}