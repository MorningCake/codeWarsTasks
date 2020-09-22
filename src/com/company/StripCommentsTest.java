package com.company;

public class StripCommentsTest {
    public static String stripComments(String text, String[] commentSymbols) {
        /*int max = 0;
        for (String tag:commentSymbols) {
            int index = text.lastIndexOf(tag);
            if (index > max) {
                max = index;
            }
        }*/
        String str = null;
        
        for (String tag:commentSymbols) {
            str = text.replaceAll("[^\\S]*[" + tag + "].*?[\\n]", "\n"); //str.replaceAll("[^\\S]+" + "[$]+" + ".+[\\n]*|$",);
            text = str;
        }
        for (String tag:commentSymbols) {
            str = text.replaceAll("[^\\S]*[" + tag + "].*$", "");
            text = str;
        }
        str.replaceAll("[^\\S]*[\\n]*$","");
        return str;
    }
}
