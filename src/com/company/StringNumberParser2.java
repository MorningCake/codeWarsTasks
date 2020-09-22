package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringNumberParser2 {
    private static Map<String, Integer> numbers = new HashMap<>();
    
    static {
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);
        numbers.put("twenty", 20);
        numbers.put("thirty", 30);
        numbers.put("forty", 40);
        numbers.put("fifty", 50);
        numbers.put("sixty", 60);
        numbers.put("seventy", 70);
        numbers.put("eighty", 80);
        numbers.put("ninety", 90);
        numbers.put("hundred", 100);
        numbers.put("thousand", 1000);
        numbers.put("million", 1000000);
    }

    public static int parseInt(String numStr) {

        numStr = numStr.replaceAll(" and", "").replaceAll("-", " ").trim();

        if (numStr.indexOf("million") >= 0) {
            return 1000000;
        } else {
            Integer[] nums = Arrays.stream(numStr.split(" "))
                    .map(s -> Integer.valueOf(numbers.getOrDefault(s, 0)))
                    .toArray(Integer[]::new);

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 100) {
                    nums[i] *= nums[i-1];
                    nums[i-1] = 0;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1000) {
                    int temp = 0;
                    for (int j = 0; j < i; j++) {
                        temp += nums[j];
                        nums[j] = 0;
                    }
                    nums[i] *= temp;
                }
            }
            return Arrays.stream(nums).mapToInt(n -> n.intValue()).sum();
        }
    }

}
