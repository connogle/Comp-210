package assn05;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
        /*
        Part 1 - Write some tests to convince yourself that your code for Part 1 is working
         */
    /*    SimpleEmergencyRoom room1 = new SimpleEmergencyRoom();
        fillER(room1);
        while (room1.size() > 0) {
            room1.dequeue();
        }
*/



       /*
        Part 2 - Write some tests to convince yourself that your code for Part 2 is working
         */
        /*MaxBinHeapER room2 = new MaxBinHeapER<>();
        fillER(room2);
        while (room2.size() > 0) {
            if (room2.size() <= 100) {
                System.out.println(room2.getMaxPriority());
            }
            room2.dequeue();
        } */




        /*
        Part 3
         *//*
        MaxBinHeapER transfer = new MaxBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        } */

        double[] arr = compareRuntimes();
        for (double num : arr) {
            System.out.println(num);
        }
    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }

    public static double[] compareRuntimes() {
        // Array which you will populate as part of Part 4
        double[] results = new double[4];

        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (1) Here
        SimpleEmergencyRoom room1 = new SimpleEmergencyRoom();
        fillER(room1);
        double begin1 = System.nanoTime();
        while (room1.size() > 0) {
            room1.dequeue();
        }
        double end1 = System.nanoTime();
        double timeDiff1 = end1-begin1;
        results[0] = timeDiff1;
        results[1] = timeDiff1/100000;

        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        // Code for (2) Here
        MaxBinHeapER room2 = new MaxBinHeapER<>();
        fillER(room2);
        double begin2 = System.nanoTime();
        while (room2.size() > 0) {
            room2.dequeue();
        }
        double end2 = System.nanoTime();
        double timeDiff2 = end2-begin2;
        results[2] = timeDiff2;
        results[3] = timeDiff2/100000;

        return results;
    }



}
