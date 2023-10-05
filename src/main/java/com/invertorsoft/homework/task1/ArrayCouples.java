package com.invertorsoft.homework.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
    }

    public static String arrayChallenge(int[] arr) {
        if (arr.length % 2 != 0) {
            return "Invalid input array";
        }

        Map<Integer, Integer> reversedPairs = new HashMap<>();
        for (int i = 0; i < arr.length; i += 2) {
            int reversedPair = arr[i + 1] * 10 + arr[i];
            reversedPairs.put(reversedPair, arr[i] * 10 + arr[i + 1]);
        }

        for (int i = 0; i < arr.length; i += 2) {
            int reversedPair = arr[i] * 10 + arr[i + 1];
            if (!reversedPairs.containsKey(reversedPair)) {
                return arr[i] + "," + arr[i + 1];
            }
        }

        return "yes";
    }
}

