package com.company;

public class DuplicateLetters {
    public static String[] dup(String[] arr){
        for (int j = 0; j < arr.length; j++) {
            char letter;
            String newStr;
            for (int i = 1; i <= 26; i++) {
                letter = (char) (96 + i);
                newStr = arr[j].replaceAll(letter + "+" + letter, String.valueOf(letter));
                arr[j] = newStr;
            }
        }
        return arr;
    }
}
