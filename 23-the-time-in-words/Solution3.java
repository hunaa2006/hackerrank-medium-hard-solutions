import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    private static final String[] NUMBERS = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) {
            return NUMBERS[h] + " o' clock";
        } else if (m == 15) {
            return "quarter past " + NUMBERS[h];
        } else if (m == 30) {
            return "half past " + NUMBERS[h];
        } else if (m == 45) {
            return "quarter to " + NUMBERS[h + 1];
        } else if (m == 1) {
            return NUMBERS[m] + " minute past " + NUMBERS[h];
        } else if (m < 30) {
            return NUMBERS[m] + " minutes past " + NUMBERS[h];
        } else {
            return NUMBERS[60 - m] + " minutes to " + NUMBERS[h + 1];
        }
    }
}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}