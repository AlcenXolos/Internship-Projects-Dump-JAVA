import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Welcome to the Bankers Algorithm Program:");
        
        System.out.print("How many resources? ");
        int resources = Integer.parseInt(br.readLine());
        
        String[] resourceValues = new String[resources];
        System.out.print("Values for each resource: ");
        String input = br.readLine();
        resourceValues = input.split(" ");
        
        System.out.print("How many processes? ");
        int numOfProcess = Integer.parseInt(br.readLine());
        
        String[][] allocations = new String[numOfProcess][resources];
        String[][] max = new String[numOfProcess][resources];
        for(int i = 0; i < numOfProcess; i++){
            String[] tempAllocation;
            String[] tempMax;
            System.out.print("Values of P" + (i+1) + " allocation: "); // 0 1 0
            String allocationInput = br.readLine();
            tempAllocation = allocationInput.split(" ");
            for(int j = 0; j < tempAllocation.length; j++){
                allocations[i][j] = tempAllocation[j];
            }
            
            System.out.print("Values of P" + (i+1) + " max: ");
            String maxInput = br.readLine();
            tempMax = maxInput.split(" ");
            for(int j = 0; j < tempMax.length; j++){
                max[i][j] = tempMax[j];
            }
        }
        
        int[] summation = new int[resources];
        for(int row = 0; row < resources; row++){
            int sum = 0;
            for(int col = 0; col < numOfProcess; col++){
                sum += Integer.parseInt(allocations[col][row]); 
            }
            summation[row] = sum;
        }
        
        int[][] need = new int[numOfProcess][resources];
        for(int i = 0; i < numOfProcess; i++){
            for(int j = 0; j < resources; j++){
                need[i][j] = Integer.parseInt(max[i][j]) - Integer.parseInt(allocations[i][j]);
            }
        }
        
        int[] currAvailableWork = new int[resources];
        for(int i = 0; i < resources; i++){
            currAvailableWork[i] =  Integer.parseInt(resourceValues[i]) - summation[i];
        }

        int[] intialAvailableWork = new int[resources];
        for(int i = 0; i < resources; i++){
            intialAvailableWork[i] = currAvailableWork[i];
        }
        
        int[][] availableWork = new int[numOfProcess][resources+1];
        int[] safeSeq = new int[numOfProcess];
        boolean[] finished = new boolean[numOfProcess];
        int finishedCount = 0;
        
        while (finishedCount < numOfProcess) {
            boolean progressMade = false;
        
            for (int i = 0; i < numOfProcess; i++) {
                if (!finished[i]) {
                    boolean isValid = true;
                    for (int j = 0; j < resources; j++) {
                        if (need[i][j] > currAvailableWork[j]) {
                            isValid = false;
                            break;
                        }
                    }
        
                    if (isValid) {
                        for (int k = 0; k < resources; k++) {
                            currAvailableWork[k] += Integer.parseInt(allocations[i][k]);
                        }
                        finished[i] = true;
                        safeSeq[finishedCount] = i;
                        progressMade = true;
                        
                        // Update availableWork
                        for (int k = 0; k < resources; k++) {
                            availableWork[i][k] = currAvailableWork[k];
                            availableWork[i][k+1] =finishedCount;
                        }
                        finishedCount++;
                    }
                }
            }
        
            if (!progressMade) {
                break; 
            }
        }

        System.out.println("Bankers Algorithm Output:");

        System.out.println("Available Resources Instances: ");
        for(String x : resourceValues){
            System.out.println(x);
        }

        System.out.printf("%-5s%-20s%-15s%-18s%-18s%-20s\n", "Process  ", "Allocation", "Max", "Need", "Available", "Safe Sequence");
        for (int i = 0; i < numOfProcess; i++) {
            System.out.printf("P%-9d", i + 1);
            for (int j = 0; j < resources; j++) {
                System.out.print(allocations[i][j] + " ");
            }
            System.out.print("           ");
            for (int j = 0; j < resources; j++) {
                System.out.print(max[i][j] + " ");
            }
            System.out.print("         ");
            for (int j = 0; j < resources; j++) {
                System.out.print(need[i][j] + " ");
            }
            System.out.print("         ");
            if (i < finishedCount) {
                for (int j = 0; j < resources; j++) {
                    System.out.print(availableWork[i][j] + " ");
                }
                System.out.print("           ");
                System.out.print((availableWork[i][resources] + 1));
                
            } 
         
            System.out.println();
        }
        
        // Print TOTALS
        System.out.printf("%-5s", "TOTAL");
        for (int i = 0; i < resources; i++) {
            System.out.print(summation[i] + " ");
        }
        System.out.print("\t\t\t\t\t\t\t");
        for (int i = 0; i < resources; i++) {
            System.out.print(intialAvailableWork[i] + " ");
        }
        System.out.println();
        
        // Print process sequence
        System.out.print("Process Sequence: ");
        for (int i = 0; i < finishedCount; i++) {
            System.out.print("P" + (safeSeq[i] + 1) + " ");
        }
        System.out.println();
    }
}
