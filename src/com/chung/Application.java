package com.chung;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static List<Integer> readFromFile()
    {
        List<Integer> list = new ArrayList<>();
        File file = new File("array.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException f) {
            f.printStackTrace();
            System.out.println("IOException");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void saveToFile(int[] array) throws IOException
    {
        File file = new File("array.txt");
        if (file.createNewFile())
        {
            System.out.println("File created, writing to file...");
            for (int j : array) {
                try {
                    FileWriter myWriter = new FileWriter("array.txt", true);
                    myWriter.write(j + "\n");
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An unexpected error has occurred!");
                    e.printStackTrace();
                }
            }
        } else
        {
            System.out.println("File already exists, writing to file...");
            for (int j : array) {
                try {
                    FileWriter myWriter = new FileWriter("array.txt", true);
                    myWriter.write(j + "\n");
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
    }

    public static int[] generateNumbers(int arrayLength)
    {
        Random random = new Random();
        int[] array = new int[arrayLength];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(200000);
            System.out.println(array[i]);
        }
        return array;
    }

    public static void clearFileData() throws IOException {
        File file = new File("array.txt");
        if (!file.createNewFile())
        {
            try {
                FileWriter myWriter = new FileWriter("array.txt");
                myWriter.write("");
                System.out.println("File has been cleared!");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An unexpected error has occurred!");
                e.printStackTrace();
            }

        }
    }

    public static void printMenu()
    {
        System.out.println("""
                    Please enter the corresponding value to the action you wish to perform
                    1. Generate numbers and store to a file.
                    2. Bubble Sort file with numbers.
                    3. Quick Sort file with numbers.
                    4. Selection Sort file with numbers.
                    5. Heap Sort file with numbers.
                    6. Insertion Sort file with numbers.
                    7. Merge Sort file with numbers.
                    
                    9. Clear file data.
                    0. Exit.
                    """);
    }

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scan = new Scanner(System.in);
        List<Integer> list;
        int [] array;
        boolean flag = true;

        while (flag) {
            printMenu();
            int opt = scan.nextInt();

            switch (opt) {
                case 1 -> {
                    System.out.println("How many number would you like to generate? ");
                    int numbers = scan.nextInt();
                    array = generateNumbers(numbers);
                    saveToFile(array);
                    System.out.println(numbers + " numbers were generated.");
                }

                case 2 -> {
                    double[] attempt = new double[5];
                    System.out.println("Bubble Sorting " + readFromFile().size() + " numbers");
                    for (int i = 0; i < 5; i++)
                    {
                        list = readFromFile();
                        double startTime = System.nanoTime();
                        BubbleSort.sort(list);
                        double stopTime = System.nanoTime();
                        attempt[i] = (stopTime - startTime)/1000000;
                        System.out.println("Attempt # "+ (i+1));
                        System.out.println(attempt[i]);
                    }
                }

                case 3 ->{
                    double[] attempt = new double[5];
                    System.out.println("Quick Sorting " + readFromFile().size() + " numbers");
                    for (int i = 0; i < 5; i++)
                    {
                        list = readFromFile();
                        double startTime = System.nanoTime();
                        QuickSort.sort(list, 0, list.size()-1);
                        double stopTime = System.nanoTime();
                        attempt[i] = (stopTime - startTime)/1000000;
                        System.out.println("Attempt # "+ (i+1));
                        System.out.println(attempt[i]);
                    }
                }

                case 4 ->{
                    double[] attempt = new double[5];
                    System.out.println("Selection Sorting " + readFromFile().size() + " numbers");
                    for (int i = 0; i < 5; i++)
                    {
                        list = readFromFile();
                        double startTime = System.nanoTime();
                        SelectionSort.sort(list);
                        double stopTime = System.nanoTime();
                        attempt[i] = (stopTime - startTime)/1000000;
                        System.out.println("Attempt # "+ (i+1));
                        System.out.println(attempt[i]);
                    }
                }

                case 5 ->{
                    double[] attempt = new double[5];
                    System.out.println("Heap Sorting " + readFromFile().size() + " numbers");
                    for (int i = 0; i < 5; i++)
                    {
                        list = readFromFile();
                        double startTime = System.nanoTime();
                        HeapSort.sort(list);
                        double stopTime = System.nanoTime();
                        attempt[i] = (stopTime - startTime)/1000000;
                        System.out.println("Attempt # "+ (i+1));
                        System.out.println(attempt[i]);
                    }
                }

                case 6->{
                    double[] attempt = new double[5];
                    System.out.println("Insertion Sorting " + readFromFile().size() + " numbers");
                    for (int i = 0; i < 5; i++)
                    {
                        list = readFromFile();
                        double startTime = System.nanoTime();
                        InsertionSort.sort(list);
                        double stopTime = System.nanoTime();
                        attempt[i] = (stopTime - startTime)/1000000;
                        System.out.println("Attempt # "+ (i+1));
                        System.out.println(attempt[i]);
                    }
                }

                case 7 ->{
                    double[] attempt = new double[5];
                    System.out.println("Merge Sorting " + readFromFile().size() + " numbers");
                    for (int i = 0; i < 5; i++)
                    {
                        list = readFromFile();
                        double startTime = System.nanoTime();
                        MergeSort.sort(list);
                        double stopTime = System.nanoTime();
                        attempt[i] = (stopTime - startTime)/1000000;
                        System.out.println("Attempt # "+ (i+1));
                        System.out.println(attempt[i]);
                    }
                }
                case 9 -> clearFileData();
                case 0 ->{
                    System.out.println("Exiting program...");
                    flag = false;
                }
                default -> flag = false;
            }
        }
    }
}
