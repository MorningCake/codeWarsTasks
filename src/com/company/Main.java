package com.company;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        /*
        //крутая задача на взлом пароля!
        long start = System.nanoTime();
        System.out.println(StringValue.high(PassHacker.passwordCracker("04d13fd0aa6f0197cf2c999019a607c36c81eb9f"))); //tests
        long finish = System.nanoTime();
        long elapsed = (finish - start)/1000000000;
        System.out.println("Прошло времени, с: " + elapsed);*/
        System.out.println(HistogramV2.histogram(new int[] {0, 0, 0, 0, 0, 0}));
    }
}

