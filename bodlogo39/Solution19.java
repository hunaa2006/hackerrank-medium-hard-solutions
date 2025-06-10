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

    public static long minimumLoss(List<Long> price) {
        TreeSet<Long> seenPrices = new TreeSet<>();
        long minLoss = Long.MAX_VALUE;
        
        for (long currentPrice : price) {
            Long higherPrice = seenPrices.higher(currentPrice);
            if (higherPrice != null) {
                long currentLoss = higherPrice - currentPrice;
                if (currentLoss < minLoss) {
                    minLoss = currentLoss;
                }
            }
            seenPrices.add(currentPrice);
        }
        
        return minLoss;
    }

}

public class Solution19 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long result = Result.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}