import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    //declaration of variables and initializing its value
    static int numOfProcess = 0;
    
    static String process[][];
    
    // buffered reader
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    // main method
    public static void main(String[] args) throws IOException {
        
        System.out.print("Welcome to the FCFS CPU Scheduling Algorithm Program:\n");
        
        boolean isValidInput = false;
        
        //validation for number of pages
        do {
            try{
                // will ask the user to input number of processes
                System.out.print("How many processes? ");
                numOfProcess = Integer.parseInt(reader.readLine());
                isValidInput = true;
            }catch (Exception e){
                //display an error message
                System.out.print("Input must be a number!\n");
                isValidInput = false;
            }
        }while(!isValidInput || numOfProcess <= 0); //will ask the user to input number of pages until it is valid
        
        process= new String[numOfProcess][3]; 
        
        for(int i=1; i<=5; i++){
            // will ask the user to list the pages
            System.out.print("Indicate the " + i + " Process number, Arrival Time, and CPU Burst Time: ");
            String userInput = reader.readLine();
            
            String[] data = userInput.split(" ");
            process[i-1][0] = data[0];
            process[i-1][1] = data[1];
            process[i-1][2] = data[2];
        }
        // System.out.println();
        // for (int i = 0; i < numOfProcess; i++) {
            //     // Print the process details
            //     System.out.println("Process " + (i + 1) + ":");
            //     System.out.println("Number: " + process[i][0]);
            //     System.out.println("Arrival Time: " + process[i][1]);
            //     System.out.println("CPU Burst Time: " + process[i][2]);
            // }
            System.out.println();
            
            int prevCT = 0; // for computation of completion time
            double CTSum = 0; // for computation of average Completion Time
            double TATSum = 0; // for computation of TAT average
            double WTSum = 0; // for computation of WTS average
            ArrayList<String> listOfAddedProcesses = new ArrayList<String>(); // list of added processes

            System.out.println("\tAT \tBT \tCT \tTAT \tWT");
            for (int i = 0; i < numOfProcess; i++) {
                int indexOfEarliestArrival = -1; // initial index of earliest arrival
                int earliestArrivalTime = Integer.MAX_VALUE; // for checkingg the earliest time of arrival
                
                for (int j = 0; j < numOfProcess; j++) {
                    int arrivalTime = Integer.parseInt(process[j][1]); // storing of the arrival time of each item in process
                    if (!listOfAddedProcesses.contains(process[j][0]) && arrivalTime < earliestArrivalTime) {
                        indexOfEarliestArrival = j;
                        earliestArrivalTime = arrivalTime;
                    }
                }
                
                System.out.print(process[indexOfEarliestArrival][0] + "\t");
                System.out.print(process[indexOfEarliestArrival][1] + "\t"); // AT
                System.out.print(process[indexOfEarliestArrival][2] + "\t"); // BT
                prevCT += Integer.parseInt(process[indexOfEarliestArrival][2]);
                System.out.print(prevCT + "\t"); //CT
                int TAT = prevCT - Integer.parseInt(process[indexOfEarliestArrival][1]);
                System.out.print(TAT + "\t"); // TAT
                int WT = TAT - Integer.parseInt(process[indexOfEarliestArrival][2]);
                System.out.println(WT);
                
                listOfAddedProcesses.add(process[indexOfEarliestArrival][0]);
                CTSum += prevCT;
                TATSum += TAT;
                WTSum += WT;
            }
            System.out.println("AVERAGE:\t\t"+(CTSum/numOfProcess)+"\t" + (TATSum/numOfProcess)+"\t" + (WTSum/numOfProcess)+"\t");
        }
    }