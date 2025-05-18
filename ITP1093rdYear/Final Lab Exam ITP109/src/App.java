import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int option = 1;
        boolean isValid = true;

        do {
            System.out.println("Welcome to the Disk Algorithm Program");
            System.out.println("1 : SSTF");
            System.out.println("2 : SCAN");
            System.out.println("3 : LOOK");
            System.out.print("Select your option: ");
            option = Integer.parseInt(reader.readLine());
            if (option > 0 && option < 4) {
                isValid = true;
            } else {
                isValid = false;
                System.out.println("Your Selected Option is Not Valid! Please Choose from 1 - 3 options");
            }
        } while (!isValid); // not valid input for type of algorithm

        System.out.print("What is the Start and End track? ");
        String[] trackInput = reader.readLine().split(" ");

        int starting = Integer.parseInt(trackInput[0]);
        int ending = Integer.parseInt(trackInput[1]);

        System.out.print("What is the request track sequence? ");
        String[] requestSequence = reader.readLine().split(", ");
        List<Integer> requestTracks = new ArrayList<>();
        for (String track : requestSequence) {
            requestTracks.add(Integer.parseInt(track.trim()));
        }

        System.out.print("What is the starting track pointer? ");
        int startingPointer = Integer.parseInt(reader.readLine());

        int totalCylindersMoved = 0;
        if(option == 1){
            totalCylindersMoved = sstf(requestTracks, startingPointer);
            
        }
        else if(option == 2){
            totalCylindersMoved = scan(requestTracks, startingPointer, starting, ending);

        }
        else{
            totalCylindersMoved = look(requestTracks, startingPointer);

        }

        System.out.println("The total number of cylinders moved by the head is " + totalCylindersMoved);
        reader.close();
    }

    public static int sstf(List<Integer> requestTracks, int start) {
        List<Integer> sequence = new ArrayList<>(requestTracks);
        int currentTrack = start;
        int totalMovement = 0;
        List<String> movements = new ArrayList<>();
        List<Integer> movementValues = new ArrayList<>();

        while (!sequence.isEmpty()) {
            int closestTrack = findClosest(sequence, currentTrack);
            int movement = Math.abs(currentTrack - closestTrack);
            totalMovement += movement;
            movements.add("(" + currentTrack + "-" + closestTrack + ")");
            movementValues.add(movement);
            currentTrack = closestTrack;
            sequence.remove((Integer) closestTrack);
        }

        printSolution(movements, movementValues);

        return totalMovement;
    }

    public static int findClosest(List<Integer> tracks, int current) {
        int minDistance = Integer.MAX_VALUE;
        int closestTrack = current;
        for (int track : tracks) {
            int distance = Math.abs(track - current);
            if (distance < minDistance) {
                minDistance = distance;
                closestTrack = track;
            }
        }
        return closestTrack;
    }

    public static int scan(List<Integer> requestTracks, int start, int starting, int ending) {
        List<Integer> sequence = new ArrayList<>(requestTracks);
        Collections.sort(sequence);
        int totalMovement = 0;
        int currentTrack = start;
        boolean goingUp = true;
        List<String> movements = new ArrayList<>();
        List<Integer> movementValues = new ArrayList<>();

        while (!sequence.isEmpty()) {
            Integer nextTrack;
            if (goingUp) {
                nextTrack = findNextUp(sequence, currentTrack);
            } else {
                nextTrack = findNextDown(sequence, currentTrack);
            }

            if (nextTrack == null) {
                if (goingUp) {
                    totalMovement += Math.abs(currentTrack - ending);
                    movements.add("(" + currentTrack + "-" + ending + ")");
                    movementValues.add(Math.abs(currentTrack - ending));
                    currentTrack = ending;
                } else {
                    totalMovement += Math.abs(currentTrack - starting);
                    movements.add("(" + currentTrack + "-" + starting + ")");
                    movementValues.add(Math.abs(currentTrack - starting));
                    currentTrack = starting;
                }
                goingUp = !goingUp;
            } else {
                int movement = Math.abs(currentTrack - nextTrack);
                totalMovement += movement;
                movements.add("(" + currentTrack + "-" + nextTrack + ")");
                movementValues.add(movement);
                currentTrack = nextTrack;
                sequence.remove(nextTrack);
            }
        }

        printSolution(movements, movementValues);

        return totalMovement;
    }

    public static Integer findNextUp(List<Integer> tracks, int current) {
        for (int track : tracks) {
            if (track > current) {
                return track;
            }
        }
        return null;
    }

    public static Integer findNextDown(List<Integer> tracks, int current) {
        for (int i = tracks.size() - 1; i >= 0; i--) {
            if (tracks.get(i) < current) {
                return tracks.get(i);
            }
        }
        return null;
    }

    public static int look(List<Integer> requestTracks, int start) {
        List<Integer> sequence = new ArrayList<>(requestTracks);
        Collections.sort(sequence);
        int totalMovement = 0;
        int currentTrack = start;
        boolean goingUp = true;
        List<String> movements = new ArrayList<>();
        List<Integer> movementValues = new ArrayList<>();

        while (!sequence.isEmpty()) {
            Integer nextTrack;
            if (goingUp) {
                nextTrack = findNextUp(sequence, currentTrack);
            } else {
                nextTrack = findNextDown(sequence, currentTrack);
            }

            if (nextTrack == null) {
                goingUp = !goingUp;
            } else {
                int movement = Math.abs(currentTrack - nextTrack);
                totalMovement += movement;
                movements.add("(" + currentTrack + "-" + nextTrack + ")");
                movementValues.add(movement);
                currentTrack = nextTrack;
                sequence.remove(nextTrack);
            }
        }

        printSolution(movements, movementValues);

        return totalMovement;
    }

    public static void printSolution(List<String> movements, List<Integer> movementValues) {
        String solution = String.join(" + ", movements);
        solution += "\n= ";
        for (int i = 0; i < movementValues.size(); i++) {
            if (i > 0) {
                solution += " + ";
            }
            solution += movementValues.get(i);
        }
        System.out.println("Solution:\n" + solution);
    }
}
