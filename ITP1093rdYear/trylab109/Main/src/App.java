import java.util.Scanner;

public class App {
    static int[][] freeHoles;
    static int[][] jobs;
    static int[][] waitings;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("How many memory? ");

        int memoryCapacity = sc.nextInt();

        System.out.println("What is size of OS? ");

        int osSize = sc.nextInt();
        memoryCapacity -= osSize;

        System.out.println("How many free holes? ");
        int freeHolesSize = sc.nextInt();

        boolean isValidCapacity = true;

        int memoryOriginalSize = memoryCapacity;
        freeHoles = new int[freeHolesSize][2];
        do {
            for (int i = 0; i < freeHolesSize; i++) {
                System.out.println("What is the size of free hole " + (i + 1) + "? ");
                int holeSize = sc.nextInt();

                memoryCapacity = memoryCapacity - holeSize;
                freeHoles[i][0] = i + 1;
                freeHoles[i][1] = holeSize;
                // System.out.println(freeHoles[i][0]);
                // System.out.println(freeHoles[i][1]);
                isValidCapacity = true;
            }
            if (memoryCapacity < 0) {
                System.out.println("Error: Memory capacity");
                isValidCapacity = false;
                memoryCapacity = memoryOriginalSize;
            }
        } while (!isValidCapacity);

        System.out.println("How many jobs to be allocated");
        int jobSize = sc.nextInt();

        jobs = new int[jobSize][2];
        for (int i = 0; i < jobSize; i++) {
            System.out.println("What is the size of job " + (i + 1) + "? ");
            int job = sc.nextInt();

            jobs[i][0] = i + 1;
            jobs[i][1] = job;
            // System.out.println(freeHoles[i][0]);
            // System.out.println(freeHoles[i][1]);
            isValidCapacity = true;
        }

        System.out.println("Free Holes");
        System.out.println("OS : " + osSize + "kb");
        for (int i = 0; i < freeHolesSize; i++) {
            System.out.print("F" + freeHoles[i][0] + " : ");
            System.out.print(freeHoles[i][1] + "kb\n");
        }
        System.out.println();
        for (int i = 0; i < jobSize; i++) {
            System.out.print("J" + jobs[i][0] + " : ");
            System.out.print(jobs[i][1] + "kb\n");
        }

        System.out.println("Best Fit Allocation");
        System.out.println("OS : " + osSize + "kb");
        for (int i = 0; i < jobSize; i++) {

            waitings = new int[jobSize][2];
            int holeIndex = freeHoles[i][1];
            for (int j = 0; j < freeHolesSize; j++) {
                if (freeHoles[j][1] > jobs[i][1]) {
                    if (holeIndex > freeHoles[j][1]) {
                        holeIndex = j;
                    }
                } 
            }

        }

        for (int i = 0; i < freeHolesSize; i++) {
            System.out.print("F" + freeHoles[i][0] + " : ");
            System.out.print(freeHoles[i][1] + "kb\n");
        }
        for (int i = 0; i < freeHolesSize; i++) {
            System.out.print("F" + waitings[i][0] + " : ");
            System.out.print(waitings[i][1] + "kb\n");
        }
    }
}
