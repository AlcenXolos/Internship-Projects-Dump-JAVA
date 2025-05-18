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
        
        System.out.println("Welcome to the SRJF - Preemptive CPU Scheduling Algorithm Program:");
        
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
        
        process= new String[numOfProcess][5]; 
        
        for(int i=1; i<=numOfProcess; i++){
            // will ask the user to list the pages
            System.out.print("Indicate the " + i + " Process number, Arrival Time, and CPU Burst Time: ");
            String userInput = reader.readLine();
            
            String[] data = userInput.split(" ");
            process[i-1][0] = data[0];
            process[i-1][1] = data[1];
            process[i-1][2] = data[2];
            // System.out.println(process[i-1][2]);
        }
        
        System.out.println();
        
        System.out.println("\tAT \tBT \tST \tCT \tTAT \tWT \tRT");
        
        // ------------------------------------------
        ArrayList<String[]> copyOfProccess = new ArrayList<String[]>(); 
        for (String[] row : process) {
            copyOfProccess.add(Arrays.copyOf(row, row.length)); // copy ung process array sa arraylist
        }
        
        ArrayList<String[]> gantt = new ArrayList<String[]>();
        int time = 0; // initialization of time
        
        
        while(!copyOfProccess.isEmpty()){
            int nextInLineIndex = -1;
            int earliestArrivalTime = Integer.MAX_VALUE; // for checkingg the earliest time of arrival
            int shortestBurstTime = Integer.MAX_VALUE; // for checkingg the shortest time of burst
            
            
            // getting the earliest arrival time
            // should have condition for shortest burst time
            
            for ( int i = 0 ; i < copyOfProccess.size(); i++) {
                int arrivalTime = Integer.parseInt(copyOfProccess.get(i)[1]); // storing of the arrival time of each item in process
                int burst = Integer.parseInt(copyOfProccess.get(i)[2]); // storing of the burst time of each item in process
                
                // ----------------------------------------------------------------
                // kuha muna arrival time, then check if lahat nasa waiting na
                // ----------------------------------------------------------------
                
                // p1 = 0 pa rin after 1 interation
                
                // for checking
                boolean alreadyInGantt = true;
                
                for(int x = 0; x < gantt.size(); x ++){
                    if(!gantt.get(x)[0].contains(copyOfProccess.get(i)[0])){
                        alreadyInGantt = false;
                        break;
                    }
                }
                
                if(arrivalTime <= time && alreadyInGantt == false){ // check if nasa gantt na siya
                    if( burst < shortestBurstTime || (burst == shortestBurstTime && arrivalTime < earliestArrivalTime) ){ // check for same burstimes and arrival time or with the shortest burst time
                        shortestBurstTime = burst;
                        earliestArrivalTime = arrivalTime;
                        nextInLineIndex = i;
                        
                    }
                    
                }
                // ------------------------------------------   
                
            }
            // System.out.println(numOfProccessArrived);

            // kung no arrival time at 0 check na lang sa earliest burst
            if(nextInLineIndex == -1){
                earliestArrivalTime = Integer.MAX_VALUE;
                for(int i = 0; i < copyOfProccess.size(); i++){
                    int arrivalTime = Integer.parseInt(copyOfProccess.get(i)[1]);
                    if(arrivalTime < earliestArrivalTime){
                        nextInLineIndex = i;
                        earliestArrivalTime = arrivalTime;
                    }
                }
            }
            
            // for (String[] y : copyOfProccess) {
                //     System.out.println(Arrays.toString(y));
                // }
                
                String[] shortestProcessBurst = copyOfProccess.get(nextInLineIndex);
                int burst = Integer.parseInt(shortestProcessBurst[2]);
                shortestProcessBurst[2] = String.valueOf(burst-1); // minus ng 1 every time
                
                //ST and CT
                if(shortestProcessBurst[3] == null){ // checking if null muna kaya one time lang maglalagay
                    shortestProcessBurst[3] = String.valueOf(time); // time for start time
                    
                }
                time += 1; // adding time 
                
                shortestProcessBurst[4] = String.valueOf(time); // time for CT
                
                // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                
                
                String[] proccessAddToGantt = new String[8]; // holder
                proccessAddToGantt[0] = shortestProcessBurst[0]; //name
                proccessAddToGantt[1] = shortestProcessBurst[1]; // at from process array
                
                for (int i = 0; i < process.length; i++) {
                    
                    if (process[i][0].equals(proccessAddToGantt[0])) {
                        proccessAddToGantt[2] = process[i][2]; // bt from process array
                        break; // Exit the loop once the correct process is found
                    }
                    
                    
                }
                
                
                proccessAddToGantt[3] = shortestProcessBurst[3]; // st
                proccessAddToGantt[4] = shortestProcessBurst[4]; //ct
                proccessAddToGantt[5] = String.valueOf(Integer.parseInt(proccessAddToGantt[4]) - Integer.parseInt(proccessAddToGantt[1])); //tat = ct - at
                proccessAddToGantt[6] = String.valueOf(Integer.parseInt(proccessAddToGantt[5]) - Integer.parseInt(proccessAddToGantt[2]));//wt = tat - bt
                proccessAddToGantt[7] = String.valueOf(Integer.parseInt(proccessAddToGantt[3]) - Integer.parseInt(proccessAddToGantt[1]));//rt = st - at
                
                
                gantt.add(proccessAddToGantt); // add proccess information to gantt
                
                if(Integer.parseInt(shortestProcessBurst[2]) == 0){
                    copyOfProccess.remove(nextInLineIndex);
                    
                }
                
                
            }
            // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            
            
            // System.out.print();
            double sumTAT = 0;
            double sumWT = 0;
            double sumRT = 0;
            
            // print the last instance of the gantt process????
            for(int i = 0; i < process.length; i++){
                for(int y = gantt.size()-1; y >= 0; y--){
                    if(process[i][0].equals(gantt.get(y)[0])){
                        System.out.print(gantt.get(y)[0] + "\t"); // name
                        System.out.print(gantt.get(y)[1] + "\t"); // arrival
                        System.out.print(gantt.get(y)[2] + "\t"); // bt
                        System.out.print(gantt.get(y)[3] + "\t"); // st
                        System.out.print(gantt.get(y)[4] + "\t"); // ct
                        System.out.print(gantt.get(y)[5] + "\t"); // tat
                        System.out.print(gantt.get(y)[6] + "\t"); // wt
                        System.out.println(gantt.get(y)[7] + "\t"); // rt
                        
                        // get summation
                        sumTAT += Integer.parseInt(gantt.get(y)[5]);
                        sumWT += Integer.parseInt(gantt.get(y)[6]);
                        sumRT += Integer.parseInt(gantt.get(y)[7]);
                        
                        break;
                    }
                }
            }
            
            // print average
            System.out.print("\t\t\t\tAverage: ");
            System.out.print(sumTAT/numOfProcess + "\t");
            System.out.print(sumWT/numOfProcess + "\t");
            System.out.print(sumRT/numOfProcess + "\t");
            
            
            
            // for(int i = 0; i < gantt.size(); i++){
                //     System.out.print(gantt.get(i)[0] + "\t");
                //     System.out.print(gantt.get(i)[1] + "\t");
                //     System.out.print(gantt.get(i)[2] + "\t");
                //     System.out.print(gantt.get(i)[3] + "\t");
                //     System.out.println(gantt.get(i)[4] + "\t");
                
                // }
                
                // for(String[] x : gantt){
                    //         System.out.println(Arrays.toString(x));
                    //     }
                    
                }
                
            }