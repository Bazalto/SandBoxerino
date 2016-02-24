package Kek;

import java.util.Arrays;
import java.util.StringJoiner;

public class PigLatin {

    static String pigLatin(String word) {
        String resultString = "";
        char specSymbol = ' ';
        String words[] = word.split(" ");
        char[] vowels = new char[]{'a', 'e', 'o', 'i', 'u', 'y'};

        if (word.charAt(word.length() - 1) == '?') specSymbol = '?';
        label:
        for (String wurd : words) {
            String tmp;
            for (char ch : vowels) {
                if (wurd.charAt(0) == ch) {
                    resultString += wurd + "way ";
                    continue label;
                }
            }
            resultString += wurd.substring(1) + wurd.charAt(0) + "ay ";
        }
        return resultString.toUpperCase().charAt(0) +
                resultString.toLowerCase().substring(1) + specSymbol;
    }

    public static void main(String[] args) {
        System.out.println(pigLatin("go away!"));
        System.out.println(pigLatin("How are you?"));
        System.out.println(pigLatin("Are you retarded"));
        System.out.println(pigLatin("Pidoras"));

    }
}
