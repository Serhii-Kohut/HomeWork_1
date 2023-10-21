package com.invertorsoft.homework.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Task conditions in README
public class ArrayCouples {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter an array of positive integers separated by spaces:");

        String input = reader.readLine();
        String[] inputArray = input.split(" ");

        int[] arr = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            arr[i] = Integer.parseInt(inputArray[i]);
        }

        String result = arrayChallenge(arr);
        System.out.println("Output: " + result);

        reader.close();
/*        int[] arr1 = {5, 4, 6, 7, 7, 6, 4, 5};
        System.out.println("Input " + Arrays.toString(arr1) + ". Output - " + arrayChallenge(arr1) + ". Output should be - yes"); // Current output: yes
        System.out.println("--------------------------------------------");
        int[] arr2 = {2, 1, 1, 2, 3, 3};
        System.out.println("Input " + Arrays.toString(arr2) + ". Output - " + arrayChallenge(arr2) + ". Output should be - 3,3"); //Current output: 3,3
        System.out.println("--------------------------------------------");
        int[] arr3 = {2, 1, 1, 2, 3, 3, 3, 3};
        System.out.println("Input " + Arrays.toString(arr3) + ". Output - " + arrayChallenge(arr3) + ". Output should be - yes"); //Current output: yes
        System.out.println("--------------------------------------------");
        int[] arr4 = {6, 2, 2, 6, 5, 14, 14, 1};
        System.out.println("Input " + Arrays.toString(arr4) + ". Output - " + arrayChallenge(arr4) + ". Output should be - 5,14,14,1"); //Current output: 5,14,14,1
        System.out.println("--------------------------------------------");
        int[] arr5 = {4, 5, 1, 4, 5, 4, 4, 1};
        System.out.println("Input " + Arrays.toString(arr5) + ". Output - " + arrayChallenge(arr5) + ". Output should be - yes"); //Current output: yes
        System.out.println("--------------------------------------------");*/
    }

    public static String arrayChallenge(int[] arr) {
        if (arr.length % 2 != 0) {
            return "Invalid input array";
        }

        Map<String, Integer> pairs = new HashMap<>();
        List<String> incorrectPairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i += 2) {
            int num1 = arr[i];
            int num2 = arr[i + 1];
            String pair = num1 + "," + num2;
            String reversedPair = num2 + "," + num1;

            if (pairs.containsKey(reversedPair) && pairs.get(reversedPair) > 0) {
                pairs.put(reversedPair, pairs.get(reversedPair) - 1);
            } else {
                pairs.put(pair, pairs.getOrDefault(pair, 0) + 1);
            }
        }

        for (String pair : pairs.keySet()) {
            int count = pairs.get(pair);
            for (int i = 0; i < count; i++) {
                incorrectPairs.add(pair);
            }
        }

        if (incorrectPairs.isEmpty()) {
            return "yes";
        } else {
            return String.join(",", incorrectPairs);
        }
    }
}

