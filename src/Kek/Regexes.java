package Kek;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dimbo on 14-Jan-16.
 */
public class Regexes {
    public static void main(String[] args) {
        String randomString = "Hallo my name is (312-32)  PeppedFaggot";

        regexChecker("\\w{4,15}", randomString);


    }

    public static void regexChecker(String regexPattern, String stringToCheck) {
        Pattern pattern = Pattern.compile(regexPattern);

        Matcher matcher = pattern.matcher(stringToCheck);

        while (matcher.find()) {
            if (matcher.group().length() != 0) {
                System.out.println(matcher.group().trim());
            }

            System.out.println("Start : " + matcher.start());
            System.out.println("End : " + matcher.end());
            System.out.println();
        }
    }
}
