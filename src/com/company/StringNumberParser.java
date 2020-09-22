package com.company;

import java.util.HashMap;
import java.util.Map;

public class StringNumberParser {

    private static Map<String, Integer> firstDigit = new HashMap<>();
    private static Map<String, Integer> secondDigit = new HashMap<>();
    private static Map<String, Integer> doubleDigitsNumbers = new HashMap<>();

    private static final String THOUSAND = "thousand";
    private static final String HUNDRED = "hundred";
    private static final String MILLION = "million";

    static {
        firstDigit.put("zero", 0);
        firstDigit.put("one", 1);
        firstDigit.put("two", 2);
        firstDigit.put("three", 3);
        firstDigit.put("four", 4);
        firstDigit.put("five", 5);
        firstDigit.put("six", 6);
        firstDigit.put("seven", 7);
        firstDigit.put("eight", 8);
        firstDigit.put("nine", 9);

        secondDigit.put("ten", 10);
        secondDigit.put("eleven", 11);
        secondDigit.put("twelve", 12);
        secondDigit.put("thirteen", 13);
        secondDigit.put("fourteen", 14);
        secondDigit.put("fifteen", 15);
        secondDigit.put("sixteen", 16);
        secondDigit.put("seventeen", 17);
        secondDigit.put("eighteen", 18);
        secondDigit.put("nineteen", 19);

        doubleDigitsNumbers.put("twenty", 20);
        doubleDigitsNumbers.put("thirty", 30);
        doubleDigitsNumbers.put("forty", 40);
        doubleDigitsNumbers.put("fifty", 50);
        doubleDigitsNumbers.put("sixty", 60);
        doubleDigitsNumbers.put("seventy", 70);
        doubleDigitsNumbers.put("eighty", 80);
        doubleDigitsNumbers.put("ninety", 90);
    }

    public static int parseInt(String numStr) {
        // 1. kill '-' 'and'
        String replaceString = numStr.replaceAll(" and", "");
        String replaceString2 = replaceString.replaceAll("-", " ");
        numStr = replaceString2;
        // 2. search a 'million'
        if (numStr.indexOf(MILLION) >= 0) {
            return 1000000;
        } else {
            // 3. search a 'thousand'
            int thousandIndex = numStr.indexOf(THOUSAND);
            int sum = 0;
            if (thousandIndex > 0) {
                String thousandStr = numStr.substring(0, thousandIndex - 1);
                String remainsStr = numStr.substring(thousandIndex + THOUSAND.length()).trim();
                sum += getThreeDigitNumber(thousandStr) * 1000;
                return sum += getThreeDigitNumber(remainsStr);
            } else {
                return getThreeDigitNumber(numStr);
            }
        }
    }

    private static int getThreeDigitNumber(String str) {
        int hundredIndex = str.indexOf(HUNDRED);
        if (hundredIndex > 0) {
            int sum = 0;
            String hundreds = str.substring(0, hundredIndex - 1);
            String decades = str.substring(hundredIndex + HUNDRED.length()).trim();
            sum += getNumberFromMaps(hundreds, firstDigit) * 100;
            return sum += getDoubleDigitNumber(decades);
        } else {
            return getDoubleDigitNumber(str);
        }
    }

    private static int getDoubleDigitNumber(String str) {
        int spaceIndex = str.indexOf(" ");
        if (spaceIndex >= 0) {
            int sum = 0;
            String secondDigitStr = str.substring(0, spaceIndex);
            String firstDigitStr = str.substring(spaceIndex + 1);
            sum += getNumberFromMaps(secondDigitStr, doubleDigitsNumbers);
            return sum += getNumberFromMaps(firstDigitStr, firstDigit);
        } else {
            return getNumberFromMaps(str, firstDigit, secondDigit, doubleDigitsNumbers);
        }
    }

    private static int getNumberFromMaps(String str, Map<String, Integer> ... maps) {
        int num = 0;
        for (Map<String, Integer> map : maps) {
            Map.Entry<String, Integer> entry = map.entrySet().stream()
                    .filter(e -> e.getKey().equals(str))
                    .findFirst().orElse(null);
            if (entry != null) {
                num = entry.getValue();
                break;
            }
        }
        return num;
    }
}
