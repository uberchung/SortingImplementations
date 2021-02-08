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

    public static void main(String[] args) throws IOException {
	// write your code here
        List<Integer> list;
        int [] array;

        array = generateNumbers(100);
        saveToFile(array);

        list = readFromFile();
        BubbleSort.sort(list);
        System.out.println(list);

        list = readFromFile();
        QuickSort.sort(list, 0, list.size()-1);
        System.out.println(list);

        list = readFromFile();
        SelectionSort.sort(list);
        System.out.println(list);

        list = readFromFile();
        HeapSort.sort(list);
        System.out.println(list);

        list = readFromFile();
        InsertionSort.sort(list);
        System.out.println(list);

        list = readFromFile();
        list = MergeSort.sort(list);
        System.out.println(list);
    }
}
