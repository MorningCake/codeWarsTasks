package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PassHacker {

    private static byte[] currentDigest;
    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String passwordCracker(String hash) {
        byte[] one = new byte[1];
        byte[] two = new byte[2];
        byte[] three = new byte[3];
        byte[] four = new byte[4];
        byte[] five = new byte[5];

        //one
        for (int i = 97; i <= 122; i++) {
            one[0] = (byte) i;
            String response = PassHacker.hashCheck(one, hash);
            if (response != null) {
                return response;
            }
        }
        //two
        for (int i = 97; i <= 122; i++) {
            two[0] = (byte) i;
            for (int j = 97; j <= 122; j++) {
                two[1] = (byte) j;
                String response = PassHacker.hashCheck(two, hash);
                if (response != null) {
                    return response;
                }
            }
        }
        //three
        for (int i = 97; i <= 122; i++) {
            three[0] = (byte) i;
            for (int j = 97; j <= 122; j++) {
                three[1] = (byte) j;
                for (int k = 97; k <= 122; k++) {
                    three[2] = (byte) k;
                    String response = PassHacker.hashCheck(three, hash);
                    if (response != null) {
                        return response;
                    }
                }
            }
        }
        //four
        for (int i = 97; i <= 122; i++) {
            four[0] = (byte) i;
            for (int j = 97; j <= 122; j++) {
                four[1] = (byte) j;
                for (int k = 97; k <= 122; k++) {
                    four[2] = (byte) k;
                    for (int l = 97; l <= 122; l++) {
                        four[3] = (byte) l;
                        String response = PassHacker.hashCheck(four, hash);
                        if (response != null) {
                            return response;
                        }
                    }
                }
            }
        }
        //five
        for (int i = 97; i <= 122; i++) {
            five[0] = (byte) i;
            for (int j = 97; j <= 122; j++) {
                five[1] = (byte) j;
                for (int k = 97; k <= 122; k++) {
                    five[2] = (byte) k;
                    for (int l = 97; l <= 122; l++) {
                        five[3] = (byte) l;
                        for (int m = 97; m <= 122; m++) {
                            five[4] = (byte) m;
                            String response = PassHacker.hashCheck(five, hash);
                            if (response != null) {
                                return response;
                            }
                        }
                    }
                }
            }
        }

        return "";
    }

    private static String hashCheck (byte[] utfCodes, String hash) {
        currentDigest = messageDigest.digest(utfCodes);
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < currentDigest.length; n++) {
            sb.append(Integer.toString((currentDigest[n] & 0xff) + 0x100, 16).substring(1));
        }
        if (sb.toString().equals(hash)) {
            StringBuilder password = new StringBuilder();
            for (int n = 0; n < utfCodes.length; n++) {
                password.append((char) utfCodes[n]);
            }
            return password.toString();
        } else {
            return null;
        }
    }
}
